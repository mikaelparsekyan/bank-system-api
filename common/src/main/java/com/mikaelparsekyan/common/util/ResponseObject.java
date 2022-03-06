package com.mikaelparsekyan.common.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseObject implements Serializable {
    private final Object data;
    
    private final String message;

    public static ResponseObject build(Object data, String message) {
        return new ResponseObject(data, message);
    }

    public static ResponseObject build(String message) {
        return new ResponseObject(null, message);
    }
}
