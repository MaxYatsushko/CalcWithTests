package com.example.calcwithtest2.controller;

import com.example.calcwithtest2.service.CalcService;
import com.example.calcwithtest2.service.CalcServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalcController {

    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping
    public String Hello() {
        return "Привет, это калькулятор";
    }
    @GetMapping("/plus")
    public ResponseEntity<String> plus(int num1, int num2) {
        return calcService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public ResponseEntity<String> minus(int num1, int num2) {
        return calcService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public ResponseEntity<String> multiply(int num1, int num2) {
        return calcService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divide(int num1, int num2) {
        return calcService.divide(num1, num2);
    }

}
