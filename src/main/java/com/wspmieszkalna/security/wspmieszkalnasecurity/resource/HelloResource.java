package com.wspmieszkalna.security.wspmieszkalnasecurity.resource;


import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Resident;
import com.wspmieszkalna.security.wspmieszkalnasecurity.service.CustomResidentsDetailsService;
import com.wspmieszkalna.security.wspmieszkalnasecurity.service.SecurityService;
import com.wspmieszkalna.security.wspmieszkalnasecurity.validators.ResidentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloResource {

    @Autowired
    private CustomResidentsDetailsService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private ResidentValidator residentValidator;

    @GetMapping("/main")
    public String mainHello(){
        return "Main page";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/main")
    public String securedHello()
    {
        return "main";
    }

    //Main Page
    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("message","test");
        return "index";
    }

    //region Register and Login
    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("residentForm", new Resident());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("residentForm") Resident residentForm, BindingResult bindingResult) {
        residentValidator.validate(residentForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(residentForm);
        securityService.autoLogin(residentForm.getLogin(), residentForm.getPasswordConfirm());
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    //endregion
}
