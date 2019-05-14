package com.wspmieszkalna.security.wspmieszkalnasecurity.resource;


import org.springframework.core.Ordered;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController

public class HelloResource extends WebMvcConfigurerAdapter {

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public View index(Model model)  {
        return new RedirectView("main.html");
    }
}
