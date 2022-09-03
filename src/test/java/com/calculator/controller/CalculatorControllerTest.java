package com.calculator.controller;

import com.calculator.controller.dto.CalculatorDto;
import com.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class CalculatorControllerTest {

    @InjectMocks
    CalculatorController calculatorController;

    @Mock
    CalculatorService calculatorService;

    Double number1 = 10D;
    Double number2 = 5D;

    @Test
    void calculateTestOperatorSum() {
        ResponseEntity<?> expected = new ResponseEntity<Double>(15D, HttpStatus.OK);

        CalculatorDto calculatorDto = CalculatorDto.builder().operator("+").number1(number1).number2(number2).build();
        when(calculatorService.chooseCal(number1, number2, "+")).thenReturn(15D);
        ResponseEntity<?> result = calculatorController.calculate(calculatorDto);

        assertEquals(expected, result);
        verify(calculatorService,times(1)).chooseCal(number1, number2, "+");
    }

    @Test
    void calculateTestOperatorSubtraction() {
        ResponseEntity<?> expected = new ResponseEntity<Double>( 5D, HttpStatus.OK);

        CalculatorDto calculatorDto = CalculatorDto.builder().operator("-").number1(number1).number2(number2).build();
        when(calculatorService.chooseCal(number1, number2,"-")).thenReturn(5D);
        ResponseEntity<?> result = calculatorController.calculate(calculatorDto);

        assertEquals(expected, result);
        verify(calculatorService,times(1)).chooseCal(number1, number2, "-");
    }

    @Test
    void calculateTestOperatorMultiplication() {
        ResponseEntity<?> expected = new ResponseEntity<Double>(50D, HttpStatus.OK);

        CalculatorDto calculatorDto = CalculatorDto.builder().operator("*").number1(number1).number2(number2).build();
        when(calculatorService.chooseCal(number1, number2, "*")).thenReturn(50D);
        ResponseEntity<?> result = calculatorController.calculate(calculatorDto);

        assertEquals(expected, result);
        verify(calculatorService,times(1)).chooseCal(number1, number2, "*");
    }

    @Test
    void calculateTestOperatorDivision() {
        ResponseEntity<?> expected = new ResponseEntity<Double>(5D, HttpStatus.OK);

        CalculatorDto calculatorDto = CalculatorDto.builder().operator("/").number1(number1).number2(number2).build();
        when(calculatorService.chooseCal(number1, number2, "/")).thenReturn(5D);
        ResponseEntity<?> result = calculatorController.calculate(calculatorDto);

        assertEquals(expected, result);
        verify(calculatorService,times(1)).chooseCal(number1, number2, "/" );
    }

    @Test
    void calculateTestWrongOperator() {
        ResponseEntity<?> expected = new ResponseEntity<>("Operador inválido!", HttpStatus.BAD_REQUEST);

        CalculatorDto calculatorDto = CalculatorDto.builder().operator(";").number1(number1).number2(number2).build();
        ResponseEntity<?> result = calculatorController.calculate(calculatorDto);

        assertEquals(expected, result);
        verify(calculatorService,times(0)).chooseCal(number1, number2, "/" );
    }
}
