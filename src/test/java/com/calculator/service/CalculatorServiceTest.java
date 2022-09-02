package com.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class CalculatorServiceTest {

    @InjectMocks
    @Spy
    private CalculatorService calculatorService;

    Double number1 = 10D;
    Double number2 = 5D;

    @Test
    void alineTeste() {
        // preparação do teste: inicializamos as variáveis ou mockamos.
        Double expected = 15D;

        // execução do que queremos testar.
        Double result = number1 + number2;

        // Validação do resultado obtido com o resultado esperado.
        assertEquals(expected, result);

    }

    @Test
    void sumTest() {
        Double expected = 15D;

        Double result = calculatorService.sum(number1, number2);

        assertEquals(expected, result);
    }

    @Test
    void subtractionTest() {
        Double expected = 5D;

        Double result = calculatorService.subtraction(number1, number2);

        assertEquals(expected, result);
    }

    @Test
    void multiplicationTest() {
        Double expected = 50D;

        Double result = calculatorService.multiplication(number1, number2);

        assertEquals(expected, result);

    }

    @Test
    void divisionTest() {
        Double expected = 2D;

        Double result = calculatorService.division(number1, number2);

        assertEquals(expected, result);
    }

    @Test
    void subtractionTestNegativeValues() {
        Double number1 = -10D;
        Double number2 = -7D;
        Double expected = -3D;

        Double result = calculatorService.subtraction(number1, number2);

        assertEquals(expected, result);
    }

    @Test
    void chooseCalTestSum() {
        // preparação
        Double expected = 15D;
        String operator = "+";

        // execução
        Double result = calculatorService.chooseCal(number1, number2, operator);

        // verificação
        assertEquals(expected, result);

        verify(calculatorService, times(1)).sum(anyDouble(), anyDouble());

    }

    @Test
    void chooseCalTestSubtraction() {
        // preparação
        Double expected = 5D;
        String operator = "-";

        // execução
        Double result = calculatorService.chooseCal(number1, number2, operator);

        // verificação
        assertEquals(expected, result);
    }

    @Test
    void chooseCalTestMultiplication() {
        // preparação
        Double expected = 50D;
        String operator = "*";

        // execução
        Double result = calculatorService.chooseCal(number1, number2, operator);

        // verificação
        assertEquals(expected, result);
    }

    @Test
    void chooseCalTestDivision() {
        // preparação
        Double expected = 2D;
        String operator = "/";

        // execução
        Double result = calculatorService.chooseCal(number1, number2, operator);

        // verificação
        assertEquals(expected, result);
    }

    @Test
    void chooseCalTestWrongOperator() {
        Double expected = 0.0;
        String operator = ";";

        Double result = calculatorService.chooseCal(number1, number2, operator);

        assertEquals(expected, result);

        verify(calculatorService, never()).sum(anyDouble(), anyDouble());
    }


}
