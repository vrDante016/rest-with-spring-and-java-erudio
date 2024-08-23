package com.erudio.rest_with_spring_and_java_erudio.controller;

import com.erudio.rest_with_spring_and_java_erudio.Exceptions.UnsupportedMathOperationException;
import com.erudio.rest_with_spring_and_java_erudio.entities.TestAndConverterNumbers;
import org.springframework.expression.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MathController {

    TestAndConverterNumbers testAndConverterNumbers = new TestAndConverterNumbers();
    //quando for utilizar a divisão, colocar %25 na chamada no navegador, isso fará com que você consiga fazer o calculo de divisão
    @RequestMapping(value = "/calculate/{numberOne}/{operation}/{numberTwo}",
    method = RequestMethod.GET)
    public Double calculate(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "operation") String operation,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
            Double _numberOne = validateNumber(numberOne);
            Double _numberTwo = validateNumber(numberTwo);
            switch (operation) {
                case"*" : {
                    return _numberOne * _numberTwo;
                }
                case "+" : {
                    return _numberOne + _numberTwo;
                }
                case "-" : {
                    return _numberOne - _numberTwo;
                }
                case "%" : {
                    if(_numberTwo == 0 ) {
                        throw new UnsupportedMathOperationException("Impossible division to zero");
                    }
                    return _numberOne / _numberTwo;
                }
                default: {
                    throw new UnsupportedMathOperationException("Please set a operation math (% , - , * , +)");
                }

            }


    }



     private Double validateNumber(String strNumber){
        if(!testAndConverterNumbers.isAsNumeric(strNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return testAndConverterNumbers.converterNumber(strNumber);

    }
}
