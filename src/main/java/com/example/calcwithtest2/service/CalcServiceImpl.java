package com.example.calcwithtest2.service;

import com.example.calcwithtest2.exception.WrongArgumentException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

    public ResponseEntity<String> plus(Integer num1, Integer num2) {
        int result = num1 + num2;
        String strResult = String.format("%s + %s = %s", num1, num2, result);
        return ResponseEntity.ok(strResult);
    }

    public ResponseEntity<String> minus(Integer num1, Integer num2) {
        int result = num1 - num2;
        String strResult = String.format("%s - %s = %s", num1, num2, result);
        return ResponseEntity.ok(strResult);
    }

    public ResponseEntity<String> multiply(Integer num1, Integer num2) {
        int result = num1 * num2;
        String strResult = String.format("%s * %s = %s", num1, num2, result);
        return ResponseEntity.ok(strResult);
    }

    public ResponseEntity<String> divide(Integer num1, Integer num2) {
        if(num2 == 0)
            throw new WrongArgumentException("На 0 делить нельзя");
        double result = (double) num1 / num2;

        String strResult = String.format("%s / %s = %.2f", num1, num2, result);
        return ResponseEntity.ok(strResult);
    }
}
