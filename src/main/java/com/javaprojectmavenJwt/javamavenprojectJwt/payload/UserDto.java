package com.javaprojectmavenJwt.javamavenprojectJwt.payload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter

public class UserDto {

    private  long id;
    private  String name;
    private  String email;
    private  String  password;

}
