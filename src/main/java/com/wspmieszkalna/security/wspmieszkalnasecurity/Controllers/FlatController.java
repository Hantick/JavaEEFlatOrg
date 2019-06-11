package com.wspmieszkalna.security.wspmieszkalnasecurity.Controllers;
import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Flat;
import com.wspmieszkalna.security.wspmieszkalnasecurity.service.FlatService;
import dto.LoginFlatDto;
import dto.ProductsDto;
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

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addResident")
    @ResponseBody
    public ResponseEntity addResident(@Valid @RequestBody LoginFlatDto loginflatDto, BindingResult result) {
        Flat flat = new Flat();
        if (!result.hasErrors()) {
            flat = flatService.addResidentToFlat(loginflatDto);
        }
        if (flat == null || flat.getId() == 0) {
            return new ResponseEntity<>("Wystąpił błąd podczas logowania do mieszkania", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(flat, HttpStatus.OK);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/addProducts")
    @ResponseBody
    public ResponseEntity setProducts(@Valid @RequestBody ProductsDto productsDto, BindingResult result) {
        Flat flat = new Flat();
        if (!result.hasErrors()) {
            flat = flatService.setProducts(productsDto);
        }
        if (flat == null || flat.getId() == 0) {
            return new ResponseEntity<>("Wystąpił błąd podczas logowania do mieszkania", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(flat, HttpStatus.OK);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/getProducts")
    @ResponseBody
    public ResponseEntity getProducts(@Valid @RequestBody ProductsDto productsDto, BindingResult result) {
        String products=null;
        if (!result.hasErrors()) {
            products = flatService.getProducts(productsDto.getName());
        }
        if (products.equals(null)) {
            return new ResponseEntity<>("Nie ma listy!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

