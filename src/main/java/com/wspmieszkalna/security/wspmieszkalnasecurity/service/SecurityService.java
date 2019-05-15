package com.wspmieszkalna.security.wspmieszkalnasecurity.service;

import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.CustomResidentDetails;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories.ResidentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityService{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomResidentsDetailsService customResidentsDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof CustomResidentDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

    public void autoLogin(String login, String password) {
        UserDetails userDetails = customResidentsDetailsService.loadUserByUsername(login);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", login));
        }
    }
}