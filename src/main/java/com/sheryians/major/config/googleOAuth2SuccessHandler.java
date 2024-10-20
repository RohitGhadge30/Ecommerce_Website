package com.sheryians.major.config;

import java.io.IOException;


import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import com.sheryians.major.model.Role;
import com.sheryians.major.model.User;
import com.sheryians.major.repository.RoleRepository;
import com.sheryians.major.repository.UserRepository;

@Component
public class googleOAuth2SuccessHandler implements AuthenticationSuccessHandler{

    @Autowired
    RoleRepository roleRepo;

    @Autowired
    UserRepository userRepo;

    private RedirectStrategy redirectstrategy =new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException
    {
        
        OAuth2AuthenticationToken token =(OAuth2AuthenticationToken) authentication;
        String email =token.getPrincipal().getAttributes().get("email").toString();
        if(userRepo.findUserByEmail(email).isPresent()){

        }
        else{
            User user=new User();
            user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
            user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
            user.setEmail(email);
            List<Role> roles=new ArrayList<>();
            roles.add(roleRepo.findById(2).get());
            user.setRoles(roles);
            userRepo.save(user);
        }


        redirectstrategy.sendRedirect(httpServletRequest, httpServletResponse, "/");
    }



}
