package com.calculator.controller;

import com.calculator.controller.dto.CalculatorDto;
import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculator")
    public ResponseEntity<?> calculate(@RequestBody CalculatorDto calc) {

        Double number1 = calc.getNumber1();
        Double number2 = calc.getNumber2();
        String operator = calc.getOperator();

        if (!operator.equals("+") &&
                !operator.equals("-") &&
                !operator.equals("*" ) &&
                !operator.equals("/" )) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Operador inválido!");
        } else {
            return new ResponseEntity<>(calculatorService.chooseCal(number1, number2, operator), HttpStatus.OK);
        }
    }

}




