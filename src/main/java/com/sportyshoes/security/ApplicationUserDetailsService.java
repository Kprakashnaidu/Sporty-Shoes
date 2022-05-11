package com.sportyshoes.security;

import com.sportyshoes.entity.UserEntity;
import com.sportyshoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userService.findByEmail(email)
                .orElseThrow(() ->new UsernameNotFoundException("User with email '"+ email+ "' not found."));
        return new ApplicationUserDetails(user);
    }
}
