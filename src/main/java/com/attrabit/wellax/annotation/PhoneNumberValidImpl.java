package com.attrabit.wellax.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class PhoneNumberValidImpl implements ConstraintValidator<PhoneNumberValid, String> {

    @Override
    public void initialize(PhoneNumberValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s) || StringUtils.isEmpty(s.trim())) {
            return false;
        }
        return (s.startsWith("01") && (s.length() == 11)) || (s.startsWith("+8801") && (s.length() == 14));
    }
}
