package com.wspmieszkalna.security.wspmieszkalnasecurity.resource;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {

    @GetMapping("/main")
    public String mainHello(){
        return "Main page";
    }

   // @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/main")
    public String securedHello()
    {
        return "Hello secured wrod!";
    }
}
