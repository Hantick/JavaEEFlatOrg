package com.wspmieszkalna.security.wspmieszkalnasecurity.service;

import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.CustomResidentDetails;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Residents;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.ResidentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomResidentsDetailsService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(CustomResidentsDetailsService.class);
    @Autowired
    private ResidentsRepository residentsRepository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Residents> optionalResidents = residentsRepository.findByLogin(login);
        if(optionalResidents.isPresent() == false)
            throw new UsernameNotFoundException("Username not found@");
        log.info("loadUserByUsername() : {}", login);
        return optionalResidents
                .map(CustomResidentDetails::new).get();
    }
}
