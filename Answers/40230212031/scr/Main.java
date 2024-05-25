public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the login application!");
        UserStore userStore = new UserStore();
        new LoginGUI(userStore);
    }
}
