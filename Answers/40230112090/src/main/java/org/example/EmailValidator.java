package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public String email ;
    public EmailValidator(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z]{5,}[0-9]*@[a-zA-Z0-9]+\\.[a-z.]+[a-zA-Z]{2,4}$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()){
            this.email = matcher.group() ;
        }
    }
}
