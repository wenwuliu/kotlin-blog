package com.belphegor.lifeprograminstitute.config;

import com.belphegor.lifeprograminstitute.dao.UserDAO;
import com.belphegor.lifeprograminstitute.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BelphegorUserDetailService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userDAO.selectByUserName(username);
        }catch (Exception e){
            throw new UsernameNotFoundException("user search failed");
        }
        if(user == null){
            throw new UsernameNotFoundException("no user found");
        }else {
            try {
                return new BelphegorUserDetails(user);
            }catch (Exception e){
                throw new UsernameNotFoundException("user role search failed");
            }
        }
    }
}
