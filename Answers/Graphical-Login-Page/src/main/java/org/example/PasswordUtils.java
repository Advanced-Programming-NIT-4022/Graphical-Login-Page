package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
        private final String level1 = ".*[a-z].*";
        private final String level2 = ".*[A-Z].*";
        private final String level3 = ".*[0-9].*";
        private final String level4 = ".*[\\.-\\_@]+.*";
        private final String level5 = "^.{8,}$";
        public String getLevel1() {
        return level1;
    }
        public String getLevel2() {
        return level2;
    }
        public String getLevel3() {
        return level3;
    }
        public String getLevel4() {
        return level4;
    }
        public String getLevel5() {
        return level5;
    }
    public int checker(String password) {
        int level = 0;
        Pattern pattern1 = Pattern.compile(getLevel1());
        Matcher matcher1 = pattern1.matcher(password);
        boolean check1 = matcher1.find();
        Pattern pattern2 = Pattern.compile(getLevel2());
        Matcher matcher2 = pattern2.matcher(password);
        boolean check2 = matcher2.find();
        Pattern pattern3 = Pattern.compile(getLevel3());
        Matcher matcher3 = pattern3.matcher(password);
        boolean check3 = matcher3.find();
        Pattern pattern4 = Pattern.compile(getLevel4());
        Matcher matcher4 = pattern4.matcher(password);
        boolean check4 = matcher4.find();
        Pattern pattern5 = Pattern.compile(getLevel5());
        Matcher matcher5 = pattern5.matcher(password);
        boolean check5 = matcher5.find();
        if (check1 || check2 || check3)
            level ++;
        if (check2 && check1)
            level ++;
        if (check2 && check1 && check3)
            level ++;
        if (check4)
            level ++;
        if (check5)
            level ++;
        return  level;
    }
}