package com.erudio.rest_with_spring_and_java_erudio.entities;

import java.io.Serializable;

public class TestAndConverterNumbers implements Serializable {
    private static final long serialVersionUID = 1L;

    public TestAndConverterNumbers(){}

    public Double converterNumber(String strNumber){
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll("," , ".");
        if(isAsNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }
    public boolean isAsNumeric(String strNumber){
        if(strNumber == null) return false;
        String number = strNumber.replaceAll("," , ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
