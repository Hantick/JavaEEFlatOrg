package com.wspmieszkalna.security.wspmieszkalnasecurity.service;

import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Flat;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Resident;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories.FlatsRepository;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.repositories.ResidentsRepository;
import dto.RegisterFlatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class FlatService {
    @Autowired
    private FlatsRepository flatsRepository;
    @Autowired
    private ResidentsRepository residentsRepository;
    @Transactional
    public Flat addFlat(RegisterFlatDto flatDto){
        Optional emptyOptional = Optional.empty();
        if(flatDto.getResidentId()==0)
            return null;
        Optional<Resident> owner = residentsRepository.findById(flatDto.getResidentId());
        if(owner==emptyOptional)
            return null;
        Flat flatByName = flatsRepository.findByName(flatDto.getName());
        if(flatByName != null)
            return null;
        Flat flat = new Flat(flatDto.getName(),flatDto.getPassword(),flatDto.getStreet(),flatDto.getNumber(),flatDto.getCity(), owner.get()); // i tutaj wlasciciel
        try{
            flatsRepository.save(flat);
        }
        catch(Exception e)
        {
            return null;
        }
        return flat;
    }
}
