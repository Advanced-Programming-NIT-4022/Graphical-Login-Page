public class Main {
    public static void main(String[] args) {
        UserStore userStore = new UserStore();
        new LoginGUI(userStore);
    }
}
