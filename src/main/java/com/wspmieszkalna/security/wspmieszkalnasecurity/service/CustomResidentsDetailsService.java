package com.wspmieszkalna.security.wspmieszkalnasecurity.service;

import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.CustomResidentDetails;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Resident;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories.ResidentsRepository;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories.RolesRepository;
import dto.LoginDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
@Service
public class CustomResidentsDetailsService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(CustomResidentsDetailsService.class);

    @Autowired
    private ResidentsRepository residentsRepository;
    @Autowired
    private RolesRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Resident> optionalResidents = residentsRepository.findResidentByLogin(login);
        if(optionalResidents.isPresent() == false)
            throw new UsernameNotFoundException(login);
        log.info("loadUserByUsername() : {}", login);
        return optionalResidents
                .map(CustomResidentDetails::new).get();
    }
    public Resident login(LoginDto loginDto) {
       Optional<Resident> user2 = residentsRepository.findResidentByLogin(loginDto.getLogin());
       Resident user=user2.get();
        if(user == null)
            return null;
        if(user.getPassword().equals(loginDto.getPassword()))
            return user;
        return null;
    }
    public void save(Resident user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        residentsRepository.save(user);
    }
    public Optional<Resident> findByLogin(String login) {
        return residentsRepository.findResidentByLogin(login);
    }
}
