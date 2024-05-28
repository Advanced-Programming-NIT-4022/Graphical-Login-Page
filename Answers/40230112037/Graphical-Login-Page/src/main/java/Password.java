import org.apache.commons.codec.digest.DigestUtils;

public class Password {
    private String hashedPassword;

    Password() {
    }

    Password(String password) {
        hashPassword(password);
    }

    static Password passwordByHash(String hashedPassword) {
        Password password = null;
        if (validateHashedPassword(hashedPassword)) {
            password = new Password();
            password.hashedPassword = hashedPassword;
        }
        return password;
    }

    static boolean validateHashedPassword(String hashedPassword) {
        return hashedPassword.matches("^[a-fA-F0-9]{64}$");
    }

    void hashPassword(String password) {
        hashedPassword = DigestUtils.sha256Hex(password);
    }

    String getHashedPassword() {
        return hashedPassword;
    }

    boolean verifyPassword(String password) {
        return hashedPassword.equals(DigestUtils.sha256Hex(password));
    }
    // Todo : password level

    @Override
    public String toString() {
        return hashedPassword;
    }
}