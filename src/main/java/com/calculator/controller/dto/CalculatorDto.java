package com.calculator.controller.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CalculatorDto {

    private Double number1;
    private Double number2;
    private String operator;
}