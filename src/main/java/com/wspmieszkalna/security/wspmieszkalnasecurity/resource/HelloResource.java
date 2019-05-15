package com.wspmieszkalna.security.wspmieszkalnasecurity.resource;


import org.springframework.core.Ordered;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloResource {

    @GetMapping("/main")
    public String mainHello(){
        return "Main page";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/main")
    public String securedHello()
    {
        return "index.html";
    }

    //Main Page
    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("message","test");
        return "index";
    }

}
