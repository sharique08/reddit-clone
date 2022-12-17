package com.example.springredditclone.service;

import com.example.springredditclone.dto.RegisterRequest;
import com.example.springredditclone.model.User;
import com.example.springredditclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    public void signup(RegisterRequest registerRequest){
         User user = new User();
         user.setUsername(registerRequest.username);
         user.setEmail(registerRequest.getEmail());
         user.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));
         user.setCreated(Instant.now());
         user.setEnabled(false);

         userRepository.save(user);
    }
}
