package com.belphegor.lifeprograminstitute.config;

import com.belphegor.lifeprograminstitute.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class BelphegorUserDetails extends User implements UserDetails {

    private List<String> roles;

    BelphegorUserDetails(User user){
        setUserId(user.getUserId());
        setPassword(user.getPassword());
        setBirthday(user.getBirthday());
        setUserName(user.getUserName());
        setHeight(user.getHeight());
        setWeight(user.getWeight());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(roles == null || roles.size()  < 1){
            return AuthorityUtils.commaSeparatedStringToAuthorityList("");
        }
        StringBuilder commaBuilder = new StringBuilder();
        commaBuilder.append("");
        return AuthorityUtils.commaSeparatedStringToAuthorityList(commaBuilder.toString());
    }

    @Override
    public String getPassword(){
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
