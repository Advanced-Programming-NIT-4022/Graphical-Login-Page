// write package name :
package FrontEnd;

// import needed things :
import BackEnd.User;
import BackEnd.UserHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// start of login page class :
public class LoginPage{
    // constructor :
    LoginPage(){
        UserHandler app = new UserHandler();
        // set the login frame :
        JFrame loginFrame = new JFrame();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new GridLayout(2,1));
        loginFrame.setBounds(500,200,500,350);

        // set upper panel for (userName text field) and (password text field) :
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout());

        // set (userName text field) and (password text field) :
        JTextField userName = new JTextField(30);
        userName.setText("userName");
        JTextField password = new JTextField(30);
        password.setText("password");

        // add text fields to the upper panel :
        upperPanel.add(userName);
        upperPanel.add(password);

        // add upper panel to the login frame :
        loginFrame.add(upperPanel);

        // set lower panel for (login button) and (back button) :
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout());

        // set login button :
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(app.loginUser(userName.getText(), app.passwordToHash(app.passwordToHash(password.getText())))){
                    JOptionPane.showMessageDialog(null,"You logged in successfully.");
                    loginFrame.dispose();
                } else{
                    JOptionPane.showMessageDialog(null,"userName or password is invalid.");
                }
            }
        });

        // set back button :
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                new MainPage();
            }
        });

        // add (login button) and (back button) to the lower panel :
        lowerPanel.add(login);
        lowerPanel.add(back);

        // add lower panel to the login frame :
        loginFrame.add(lowerPanel);

        // set login frame visible :
        loginFrame.setVisible(true);
    }
}
