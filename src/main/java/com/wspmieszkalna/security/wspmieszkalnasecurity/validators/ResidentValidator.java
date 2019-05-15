package com.wspmieszkalna.security.wspmieszkalnasecurity.validators;

import com.wspmieszkalna.security.wspmieszkalnasecurity.dbModels.Resident;
import com.wspmieszkalna.security.wspmieszkalnasecurity.service.CustomResidentsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ResidentValidator implements Validator {
    @Autowired
    private CustomResidentsDetailsService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Resident.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Resident user = (Resident) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        if (user.getLogin().length() < 6 || user.getLogin().length() > 32) {
            errors.rejectValue("login", "Size.residentForm.login");
        }
        if (userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.residentForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone_number", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.residentForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.residentForm.passwordConfirm");
        }
    }
}
