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

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                registerActionlistener();
            }
        });
    }

    private void registerActionlistener() {
        JFrame f2 = new JFrame("Register");

        JLabel l5 = new JLabel("username: ");
        l5.setBounds(96, 95, 70, 20);
        f2.add(l5);

        JTextField tf3 = new JTextField();
        tf3.setBounds(170, 97, 200, 20);
        f2.add(tf3);

        JLabel l1 = new JLabel("Gmail:");
        l1.setBounds(120, 120, 50, 20);
        f2.add(l1);

        JTextField tf1 = new JTextField();
        tf1.setBounds(170, 122, 200,20);
        f2.add(tf1);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(97, 145, 70, 20);
        f2.add(l2);

        JTextField tf2 = new JTextField();
        tf2.setBounds(170, 147, 200, 20);
        f2.add(tf2);

        JButton b = new JButton("Validate password");
        b.setBounds(170, 200, 150, 30);
        f2.add(b);

        JLabel l3 = new JLabel("validation: no input");
        l3.setBounds(180, 350, 200, 30);
        f2.add(l3);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = tf2.getText();
                String validation = PasswordUtils.validation(password);
                l3.setText("validation: " + validation);

            }
        });

        JButton b1 = new JButton("Register");
        b1.setBounds(170, 231, 150, 30);
        f2.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(EmailValidator.validation(tf1.getText())){
                    if(!EmailValidator.found(tf1.getText())){
                        if(!EmailValidator.usernamefound(tf3.getText())){
                            JFrame f3 = new JFrame("Welcome");
                            JLabel l4 = new JLabel("Your registered successful");
                            l4.setBounds(140, 200, 200, 20);
                            f3.add(l4);
                            f3.setSize(480, 480);
                            f3.setLayout(null);
                            f2.setVisible(false);
                            f3.setVisible(true);
                            PasswordUtils.hashing(tf3.getText(), tf2.getText(), tf1.getText());
                        } else {
                            l3.setText("username was used");
                        }
                    } else {
                        l3.setText("email was registered");
                    }
                } else {
                    l3.setText("Invalid Email");
                }
            }
        });

        f2.setSize(480, 480);
        f2.setLayout(null);
        f2.setVisible(true);


    }

    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
    }
}
