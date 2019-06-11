package com.wspmieszkalna.security.wspmieszkalnasecurity.Controllers;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Flat;
import com.wspmieszkalna.security.wspmieszkalnasecurity.service.FlatService;
import dto.RegisterFlatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/flat")
public class FlatController {
    @Autowired
    FlatService flatService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    @ResponseBody
    public ResponseEntity register(@Valid @RequestBody RegisterFlatDto flatDto, BindingResult result) {
        Flat registered = new Flat();
        if (!result.hasErrors()) {
            registered = flatService.addFlat(flatDto);
        }
        if (registered == null || registered.getId() == 0) {
            return new ResponseEntity<>("Wystąpił błąd podczas tworzenia mieszkania", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(registered, HttpStatus.OK);
    }
}

