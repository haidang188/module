package com.haidang.calculator.model;

public class Calculator {
    public static double calculate(double firstOperand, double secondOperand, String operator) throws Exception {

        switch (operator) {
            case "addition":
                return firstOperand + secondOperand;

            case "subtraction":
                return firstOperand - secondOperand;

            case "multiplication":
                return firstOperand * secondOperand;

            case "division":
                if (secondOperand == 0) {
                    throw new Exception("Cannot divide by zero!");
                }
                return firstOperand / secondOperand;

            default:
                throw new Exception("Invalid operator!");
        }
    }
}
