package com.sheryians.major.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.User;
import com.sheryians.major.model.CustomUserDetails;
import com.sheryians.major.repository.UserRepository;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository  userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<User> user= userRepo.findUserByEmail(email);
       user.orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
       return user.map(CustomUserDetails::new).get();

     
    }


}
