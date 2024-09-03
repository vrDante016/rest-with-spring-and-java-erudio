package com.erudio.rest_with_spring_and_java_erudio.exception;

import java.io.Serializable;
import java.util.Date;

public class Exceptions implements Serializable {

    private static final long serialVerisonUID = 1L;

    private Date timeStamp;
    private String message;
    private String details;

    public Exceptions(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
