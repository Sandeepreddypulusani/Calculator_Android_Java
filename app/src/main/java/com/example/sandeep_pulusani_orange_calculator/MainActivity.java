package com.example.sandeep_pulusani_orange_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    boolean acceptingDigits = true;
    boolean startNewNumber = true;

    CalculatorModel calculatorModel = new CalculatorModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view)
    {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        TextView textView = findViewById(R.id.textView);
        String currentNumber = textView.getText().toString();
Log.i("someThing", buttonText);

switch (buttonText)
{
    case "C":

calculatorModel.clear();
currentNumber = "0";
startNewNumber = true;

break;

    case "0":
    case "1":
    case "2":
    case "3":
    case "4":
    case "5":
    case "6":
    case "7":
    case "8":
    case "9":
    case ".":


        /*  first 2 if statements execute when the button is pressed for the first time */
        if(startNewNumber)
        {
            /* the below if statement to check the dot position */
            if(buttonText.equals("."))
            {
                currentNumber = "0";
            }
            else
            {
                currentNumber = buttonText;
            }


            startNewNumber = false;
        }

        else {
            /* below if statement is used to check for multiple dots */
            if (buttonText.equals(".") && currentNumber.contains(".")) {

            } else {
                currentNumber = currentNumber + buttonText;
            }
        }
        break;
    case "+":
    case "-":
    case "*":
    case "/":

if(calculatorModel.firstNumberSet && calculatorModel.operatorSet && !startNewNumber)
{
    double secondNumber = Double.parseDouble(currentNumber);
    calculatorModel.setSecondNumber(secondNumber);
    String result = resultToString(calculatorModel.getResult());
    currentNumber = result;
}
       double firstNumber = Double.parseDouble(currentNumber);
       calculatorModel.setFirstNumber(firstNumber);

       calculatorModel.setOperator(buttonText);
       startNewNumber = true;
       break;


    case "=":

        if (calculatorModel.firstNumberSet) {
            double secondNumber = Double.parseDouble(currentNumber);
            calculatorModel.setSecondNumber(secondNumber);

            String result = resultToString(calculatorModel.getResult());
            currentNumber = result;
            startNewNumber = true;

        }
        break;

    case "X2":

        double sc = Double.parseDouble(currentNumber);
        calculatorModel.setFirstNumber(sc);
        calculatorModel.setSecondNumber(sc);


        calculatorModel.setOperator(buttonText);

        String result = resultToString(calculatorModel.getResult());
        currentNumber = result;
        startNewNumber = true;
        break;

    case "%":
    case "+/-":

        double scc = Double.parseDouble(currentNumber);
        calculatorModel.setFirstNumber(scc);
        calculatorModel.setSecondNumber(0);


        calculatorModel.setOperator(buttonText);

        String res = resultToString(calculatorModel.getResult());
        currentNumber = res;
        startNewNumber = true;
        break;







}

        textView.setText(currentNumber);

    }

public String resultToString(double num)
{
int numInt = (int) num;
if (num == numInt)
{
    return Integer.toString(numInt);
}
else
{
return Double.toString(num);
}
}



}
