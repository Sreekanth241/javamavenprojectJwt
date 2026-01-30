package com.javaprojectmavenJwt.javamavenprojectJwt.payload;

import lombok.Getter;

@Getter
public class JwtAurhResponse {
    private  String token;
    private  String tokenType="Bearer";

    public JwtAurhResponse(String token){
        this.token=token;
    }
}
