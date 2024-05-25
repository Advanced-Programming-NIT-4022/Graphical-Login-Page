package org.example;

import javax.swing.*;
import java.util.regex.Pattern;

public class Registeration extends JFrame {
    Pattern emailPattern = Pattern.compile("^.*@[a-z]*[A-Z]*\\.com$");
    Pattern criteriaA = Pattern.compile("[a-z]*[A-Z]*[0-9]*");
    Pattern criteriaB = Pattern.compile("[a-z]+[A-Z]+");
    Pattern criteriaC = Pattern.compile("[a-z]+[A-Z]+[0-9]+");
    Pattern criteriaD = Pattern.compile("[!@#$%^&*_\\-.()]*");
    Pattern criteriaE = Pattern.compile(".{8,}");

}
