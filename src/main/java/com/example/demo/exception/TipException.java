package com.example.demo.exception;

/**
 * Created by zhong on 2018/5/21.
 */
public class TipException extends RuntimeException{
    public TipException() {
    }

    public TipException(String message) {
        super(message);
    }
}
