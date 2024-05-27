import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setResizable(false);
        login.setSize(700, 230);
        login.setVisible(true);
    }
}