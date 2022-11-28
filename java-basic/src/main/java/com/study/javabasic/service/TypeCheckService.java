package com.study.javabasic.service;


import org.springframework.stereotype.Service;

@Service
public class TypeCheckService {

    private void printLengthByType() {
        boolean isPrimitiveBoolean = true;
        byte primitiveByte = 1;
        short primitiveShort = 1;
        int primitiveInt = 1;
        long primitiveLong = 1;
        float primitiveFloat = 1;
        double primitiveDouble = 1;
        char primitiveChar = '1';
        String referenceString = "1";

        System.out.println(referenceString.getBytes());

    }
}
