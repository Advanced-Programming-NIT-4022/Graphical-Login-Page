public record User(String username, String hashedPassword, String email) {
    public boolean validateUser(String password) {
        return PasswordUtils.hashPassword(password).equals(hashedPassword);
    }
}
