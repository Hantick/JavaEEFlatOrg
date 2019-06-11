package com.wspmieszkalna.security.wspmieszkalnasecurity.service;

package com.wspmieszkalna.security.wspmieszkalnasecurity.service;

import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.CustomFlatDetails;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Flat;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories.FlatsRepository;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories.ResidentsRepository;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories.RolesRepository;
import dto.LoginDto;
import dto.RegisterFlatDto;
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
public class CustomFlatsDetailsService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(CustomFlatsDetailsService.class);

    @Autowired
    private FlatsRepository flatsRepository;
    @Autowired
    private ResidentsRepository residentsRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Flat> optionalFlats = flatsRepository.findFlatByName(name);
        if(optionalFlats.isPresent() == false)
            throw new UsernameNotFoundException(name);
        log.info("loadFlatByName() : {}", name);
        return optionalFlats
                .map(CustomFlatDetails::new).get();
    }
    public Flat saveFlat(RegisterFlatDto flatDto){
        Optional emptyOptional = Optional.empty();
        Optional<Flat> flatByName = flatsRepository.findFlatByName(flatDto.getFlat_name());
        if(flatByName != emptyOptional)
            return null;
        Flat user = new Flat(flatDto.getFlat_name(),flatDto.getFlat_password(),flatDto.getFlat_street(),flatDto.getFlat_number(),flatDto.getFlat_city()); // i tutaj wlasciciel
        try{
            flatsRepository.save(user);
        }
        catch(Exception e)
        {
            return null;
        }
        return user;
    }
    public void save(Flat flat) {
        flat.setFlat_password(bCryptPasswordEncoder.encode(flat.getFlat_password()));
        //flat.setResidents(new HashSet<>(flatsRepository.findAll()));
        flatsRepository.save(flat);
    }
}
