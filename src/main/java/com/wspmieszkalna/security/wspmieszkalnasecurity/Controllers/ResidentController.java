package com.wspmieszkalna.security.wspmieszkalnasecurity.Controllers;

import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Resident;
import com.wspmieszkalna.security.wspmieszkalnasecurity.service.CustomResidentsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.programirex.pokemonidzapi.dto.user.GetUserDto;
import pl.programirex.pokemonidzapi.dto.user.LoginDto;
import pl.programirex.pokemonidzapi.dto.user.RegisterDto;
import pl.programirex.pokemonidzapi.entity.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/user")
public class ResidentController {
    @Autowired
    CustomResidentsDetailsService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public ResponseEntity login(@Valid @RequestBody String login, String password, BindingResult result) {
        Resident logged = new Resident();
        if (!result.hasErrors()) {
            logged = userService.login(login,password);
        }
        if (logged == null) {
            return new ResponseEntity<>("Nie udało się zalogować!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(logged, HttpStatus.OK);
    }
}
