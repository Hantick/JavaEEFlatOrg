package com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomFlatDetails implements UserDetails {
    private Flat flat;
    public CustomFlatDetails(Flat flat){
        this.flat=flat;
    }
//to nie usery
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return   flat.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return flat.getFlat_password();
    }

    @Override
    public String getUsername() {
        return Flat.getName();
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
