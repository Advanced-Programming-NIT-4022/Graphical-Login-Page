public class EmailValidator {
    public static boolean isValidEmailAddress(String email) {
        String emailPattern = "^[^(\\s&.=_'-+,<>)][^(\\s&=_'-+,<>)]{4,28}" +
                "[^(\\s&.=_'-+,<>)]@[^(\\s&.=_'-+,<>)][^(\\s&=_'-+,<>)]+";
        return email.matches(emailPattern);
    }
}
