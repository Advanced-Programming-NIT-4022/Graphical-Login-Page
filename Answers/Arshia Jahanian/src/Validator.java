public interface Validator {
    String passwordLevel(String password);
    boolean emailValidator(String email);
    String hashingPassword(String password);

}
