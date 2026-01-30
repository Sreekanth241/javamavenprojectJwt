package com.javaprojectmavenJwt.javamavenprojectJwt.ServiceImpl;

import com.javaprojectmavenJwt.javamavenprojectJwt.Entity.Users;
import com.javaprojectmavenJwt.javamavenprojectJwt.payload.UserDto;
import com.javaprojectmavenJwt.javamavenprojectJwt.repository.UserRepository;
import com.javaprojectmavenJwt.javamavenprojectJwt.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {
    @Autowired
    private UserRepository userRepository;

     @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto creareUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Users users=userDtoToEntity(userDto);
        Users savedUser= userRepository.save(users);
        return entityToUserDto(savedUser);
    }
    private  Users userDtoToEntity(UserDto userDto){
        Users users=new Users();
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        return users;
    }

    private UserDto entityToUserDto(Users saveUser){
        UserDto userDto=new UserDto();
        userDto.setId(saveUser.getId());
        userDto.setEmail(saveUser.getEmail());
        userDto.setPassword(saveUser.getPassword());
        userDto.setName(saveUser.getName());
        return userDto;
    }
}
