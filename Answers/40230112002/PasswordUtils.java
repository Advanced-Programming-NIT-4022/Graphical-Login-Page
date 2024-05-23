public class PasswordUtils {
    //Contains utility methods for password strength evaluation and hashing

    public static boolean isStrongPassword(String password) {
        // Check if password meets the specified criteria
        boolean containsLower = false;
        boolean containsUpper = false;
        boolean containsDigit = false;
        boolean containsSpecial = false;
        boolean isLongEnough = password.length() >= 8;

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                containsLower = true;
            } else if (Character.isUpperCase(ch)) {
                containsUpper = true;
            } else if (Character.isDigit(ch)) {
                containsDigit = true;
            } else if (isSpecialCharacter(ch)) {
                containsSpecial = true;
            }
        }

        return containsLower && containsUpper && containsDigit && containsSpecial && isLongEnough;
    }

    public static boolean isSpecialCharacter(char ch) {
        // Define special characters
        String specialCharacters = "@-_.";

        return specialCharacters.contains(Character.toString(ch));
    }
}
