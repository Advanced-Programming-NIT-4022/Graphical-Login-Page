import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {
    public LoginGUI() {
        JFrame f1 = new JFrame("Register");
        JButton b = new JButton("Register");
        JButton b1 = new JButton("Log in");
        b.setBounds(180, 150, 100, 40);
        b1.setBounds(180, 220, 100, 40);
        f1.add(b);
        f1.add(b1);

        JLabel l2 = new JLabel("Dont have account? REGISTER");
        l2.setBounds(150, 130, 200, 20);
        f1.add(l2);

        JLabel l1 = new JLabel("Already have account? LOG IN");
        l1.setBounds(150, 200, 200, 20);
        f1.add(l1);
        f1.setSize(480, 480);
        f1.setLayout(null);
        f1.setVisible(true);


    }

//    public static void main(String[] args) {
//        LoginGUI login = new LoginGUI();
//    }
}
