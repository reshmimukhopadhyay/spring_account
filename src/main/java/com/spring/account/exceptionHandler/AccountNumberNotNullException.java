package com.spring.account.exceptionHandler;

public class AccountNumberNotNullException extends RuntimeException{
    public AccountNumberNotNullException(String msg){
        super(msg);
    }
}
