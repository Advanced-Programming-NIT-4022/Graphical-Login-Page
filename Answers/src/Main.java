import javax.swing.JFrame;

public class Main {
    static LoginGUI login;

    public static void main(String[] args) {
        // file exist or not
        UserStore.createFile();

        // handle gui
        login = new LoginGUI();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);
        login.setSize(700, 230);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}