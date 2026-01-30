package com.javaprojectmavenJwt.javamavenprojectJwt.Security;

import com.javaprojectmavenJwt.javamavenprojectJwt.exception.APIException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Component
public class JwtTokenProvider {
    
    private final SecretKey secretKey = Keys.hmacShaKeyFor("JWTsecretKeyJWTsecretKeyJWTsecretKeyJWTsecretKey".getBytes());

    public String generateToken(Authentication authentication) {
        String email = authentication.getName();
        Date currentDate = new Date();
        Date expireDate= new Date(currentDate.getTime()+3600000);

        String  token= Jwts.builder()
                .setSubject(email)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(secretKey)
                .compact();
        return token;

    }
    public  String  getEmailFromToken(String  token){
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            throw  new APIException("Token issue :"+e.getMessage());
        }
    }
}
