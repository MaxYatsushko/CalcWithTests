package com.example.calcwithtest2.service;

import com.example.calcwithtest2.exception.WrongArgumentException;
import org.springframework.http.ResponseEntity;

public interface CalcService {

    public ResponseEntity<String> plus(Integer num1, Integer num2);
    public ResponseEntity<String> minus(Integer num1, Integer num2);
    public ResponseEntity<String> multiply(Integer num1, Integer num2);
    public ResponseEntity<String> divide(Integer num1, Integer num2);
}
