package com.ecart.ecartFullProject.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class resourceNotFoundException extends RuntimeException{

    public resourceNotFoundException(String message){
        super(message);
    }
}
