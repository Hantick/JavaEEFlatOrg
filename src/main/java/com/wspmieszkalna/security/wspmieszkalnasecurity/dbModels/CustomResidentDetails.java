package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomResidentDetails extends Residents implements UserDetails {

    public CustomResidentDetails(final Residents residents){
        super(residents);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> list = getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getLogin();
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
