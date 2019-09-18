package com.belphegor.lifeprograminstitute.config;


import com.belphegor.lifeprograminstitute.dao.UserDAO;
import com.belphegor.lifeprograminstitute.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BelphegorAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserDAO userDAO;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user = userDAO.selectByUserName(username);

        if(user == null){
            throw new BadCredentialsException("username not found");
        }

        if(!password.equals(user.getPassword())){
            throw new BadCredentialsException("wrong password.");
        }

        Collection<? extends GrantedAuthority> authorities = null;
        return new UsernamePasswordAuthenticationToken(user,password,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
