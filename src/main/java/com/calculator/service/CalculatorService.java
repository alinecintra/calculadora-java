package com.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Double chooseCal(Double number1, Double number2, String operator) {

        double result = 0.0;

        switch (operator) {
            case "+":
                result = sum(number1, number2);
                break;
            case "-":
                result = subtraction(number1, number2);
                break;
            case "*":
                result = multiplication(number1, number2);
                break;
            case "/":
                result = division(number1, number2);
                break;
            default:
                break;
        }
        return result;
    }

    public double sum(Double number1, Double number2) {
        return number1 + number2;
    }

    public double subtraction(Double number1, Double number2) {
        return number1 - number2;
    }

    public double multiplication(Double number1, Double number2) {
        return number1 * number2;
    }

    public double division(Double number1, Double number2) {
        return number1 / number2;
    }
}





