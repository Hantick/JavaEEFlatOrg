package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomResidentDetails implements UserDetails {
    private Resident resident;
    public CustomResidentDetails(Resident resident){
        this.resident=resident;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return   resident.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return resident.getPassword();
    }

    @Override
    public String getUsername() {
        return resident.getLogin();
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
