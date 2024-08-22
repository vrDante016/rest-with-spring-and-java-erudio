package com.erudio.rest_with_spring_and_java_erudio.controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
    method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
       if(!isAsnumeric(numberOne) || !isAsnumeric(numberTwo)){
           throw new UnsupportedOperationException("Please set a numeric value");
       }
       return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double div(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!isAsnumeric(numberOne) || !isAsnumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    @RequestMapping(value = "/vezes/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double vezes(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!isAsnumeric(numberOne) || !isAsnumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!isAsnumeric(numberOne) || !isAsnumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }


    private Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(isAsnumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isAsnumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
