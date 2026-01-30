package com.javaprojectmavenJwt.javamavenprojectJwt.controller;


import com.javaprojectmavenJwt.javamavenprojectJwt.Security.JwtTokenProvider;
import com.javaprojectmavenJwt.javamavenprojectJwt.payload.JwtAurhResponse;
import com.javaprojectmavenJwt.javamavenprojectJwt.payload.LoginDto;
import com.javaprojectmavenJwt.javamavenprojectJwt.payload.UserDto;
import com.javaprojectmavenJwt.javamavenprojectJwt.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AurthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new  ResponseEntity<>(userService.creareUser(userDto),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAurhResponse> loginUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token= jwtTokenProvider.generateToken(authentication);
        return   ResponseEntity.ok(new JwtAurhResponse(token));

    }
}

