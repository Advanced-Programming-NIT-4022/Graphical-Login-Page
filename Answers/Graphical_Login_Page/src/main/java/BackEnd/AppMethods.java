package BackEnd;

public interface AppMethods {
    public void checkFilesExistence();
    public void saveChangesToFile();
    public void updateUserArrayListFromFile();
    public void registerNewUser(String userName, String password, String email);
    public boolean loginUser(String userName, String password);
    public String passwordToHash(String password);
    public int getPasswordComplexity(String password);
    public boolean checkUserPassword(String userName, String hashedPassword);
    public boolean checkUserNameExistence(String userName);
    public boolean checkEmailValidation(String email);
}
