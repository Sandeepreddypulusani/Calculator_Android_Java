package com.example.sandeep_pulusani_orange_calculator;

public class CalculatorModel {

    double firstNumber = 0.0;
    double secondNumber = 0.0;
    double result = 0.0;

    String operator ="";

    boolean firstNumberSet = false;
    boolean secondNumberSet = false;
    boolean operatorSet = false;

    public void setFirstNumber(double num)
    {
        firstNumber = num;
        firstNumberSet = true;
    }

    public void setSecondNumber(double num)
    {
        secondNumber = num;
        secondNumberSet = true;
    }

    public double getResult()
    {
        computeResult();
        return result;
    }

    public void computeResult()
    {
        if (firstNumberSet && secondNumberSet && operatorSet) {
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;

                case "-":
                    result = firstNumber - secondNumber;
                    break;


                case "*":
                case "X2":
                    result = firstNumber * secondNumber;
                    break;


                case "/":
                    result = firstNumber / secondNumber;
                    break;


                case "%":

                    result = (firstNumber + secondNumber) / 100;
                    break;

                case "+/-":

                    result = -(firstNumber + secondNumber);
                    break;


            }
        }
        else
        {

        }
    }
    public void setOperator(String op)
    {
        operator = op;
        operatorSet = true;
    }

    public void clear()
    {

         firstNumber = 0.0;
         secondNumber = 0.0;
         result = 0.0;

         operator ="";

         firstNumberSet = false;
         secondNumberSet = false;
         operatorSet = false;

    }
}
