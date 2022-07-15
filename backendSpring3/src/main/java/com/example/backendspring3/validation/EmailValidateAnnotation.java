package com.example.backendspring3.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailValidateAnnotation implements ConstraintValidator<EmailValidator,String> {

    private static final String REGEX_EMAIL="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value==null||value.isEmpty()){
            return false;
        }

        return patternMatches(value, REGEX_EMAIL);
    }

    private static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
