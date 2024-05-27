package org.example;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public String email ;
    public EmailValidator(String email){
        if (email.isEmpty()){
            this.email = "null" ;
        }else {
            Pattern pattern = Pattern.compile("^[a-zA-Z]{5,}(?=.*[.]).*[^.]@[a-zA-Z]+(?=.*[.\\-_]).?(?=.*[a-zA-Z0-9]).{2,}$");
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                this.email = matcher.group();
            } else {
                JOptionPane.showMessageDialog(null, "The email in question is not valid");
            }
        }
    }
}

