package com.javaprojectmavenJwt.javamavenprojectJwt.exception;

import com.javaprojectmavenJwt.javamavenprojectJwt.Entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TaskNotFound extends RuntimeException{
    private  String  message;

    public TaskNotFound(String message){
        super(message);
        this.message=message;
    }

}

