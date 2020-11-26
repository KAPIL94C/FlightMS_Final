package com.capgemini.DealDate.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String msg){
        super(msg);
    }

}
