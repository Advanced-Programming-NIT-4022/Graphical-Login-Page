public class PasswordUtils {
    public static int evaluatePasswordStrength(String password) {
        int strength = 0;
        if (password.matches(".*[a-zA-Z0-9].*")) {
            strength++;
        }
        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*")) {
            strength++;
        }
        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*")) {
            strength++;
        }
        if (password.matches(".*[@-_.].*")) {
            strength++;
        }

        if (password.length() > 8) {
            strength++;
        }

        return strength;
    }

    public static boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (c == '@' || c == '-' || c == '_' || c == '.') {
                hasSpecialChar = true;
            }
        }

        return hasLowercase && hasUppercase && hasNumber && hasSpecialChar;
    }
}



