package com.example.calcwithtest2.service;

import com.example.calcwithtest2.exception.WrongArgumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = {CalcServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class CalcServiceTest {

    @Autowired
    private CalcService calcService;

    public static Stream<Arguments> plusParams(){
        return Stream.of(
                Arguments.of(3, 1, ResponseEntity.ok("3 + 1 = 4")),
                Arguments.of(5, 2, ResponseEntity.ok("5 + 2 = 7")),
                Arguments.of(9, 2, ResponseEntity.ok("9 + 2 = 11")),
                Arguments.of(10, 3, ResponseEntity.ok("10 + 3 = 13"))
        );
    }

    public static Stream<Arguments> minusParams(){
        return Stream.of(
                Arguments.of(3, 1, ResponseEntity.ok("3 - 1 = 2")),
                Arguments.of(5, 2, ResponseEntity.ok("5 - 2 = 3")),
                Arguments.of(9, 2, ResponseEntity.ok("9 - 2 = 7")),
                Arguments.of(10, 3, ResponseEntity.ok("10 - 3 = 7"))
        );
    }

    public static Stream<Arguments> divideParams(){
        return Stream.of(
                Arguments.of(3, 1, ResponseEntity.ok("3 / 1 = 3,00")),
                Arguments.of(5, 2, ResponseEntity.ok("5 / 2 = 2,50")),
                Arguments.of(9, 2, ResponseEntity.ok("9 / 2 = 4,50")),
                Arguments.of(10, 3, ResponseEntity.ok("10 / 3 = 3,33"))
        );
    }

    public static Stream<Arguments> multiplyParams(){
        return Stream.of(
                Arguments.of(3, 1, ResponseEntity.ok("3 * 1 = 3")),
                Arguments.of(5, 2, ResponseEntity.ok("5 * 2 = 10")),
                Arguments.of(9, 2, ResponseEntity.ok("9 * 2 = 18")),
                Arguments.of(10, 3, ResponseEntity.ok("10 * 3 = 30"))
        );
    }

    @ParameterizedTest
    @MethodSource("plusParams")
    void plus_success(Integer num1, Integer num2, ResponseEntity<String> expectedResult) {
        assertEquals(calcService.plus(num1, num2), expectedResult);
    }

    @ParameterizedTest
    @MethodSource("minusParams")
    void minus_success(Integer num1, Integer num2, ResponseEntity<String> expectedResult){
        assertEquals(calcService.minus(num1, num2), expectedResult);
    }

    @ParameterizedTest
    @MethodSource("multiplyParams")
    void multiply_success(Integer num1, Integer num2, ResponseEntity<String> expectedResult){
        assertEquals(calcService.multiply(num1, num2), expectedResult);
    }

    @ParameterizedTest
    @MethodSource("divideParams")
    void divide_success(Integer num1, Integer num2, ResponseEntity<String> expectedResult){
        assertEquals(calcService.divide(num1, num2), expectedResult);
    }

    @Test
    void divide_with_division_by_zero(){

        //подготовка входных данных
        Integer num1 = 5, num2 = 0;

        //подготовка ожидаемого результата
        Exception exception = assertThrows(WrongArgumentException.class, () -> calcService.divide(num1, num2));
        String expectedResult = "На 0 делить нельзя";

        //начало теста
        assertEquals(expectedResult, exception.getMessage());
    }
}