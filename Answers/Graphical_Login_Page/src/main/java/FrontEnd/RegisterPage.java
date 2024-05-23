// write package name :
package FrontEnd;

// import needed things :
import BackEnd.UserHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// start of register page class :
public class RegisterPage{
    // constructor :
    RegisterPage(){
        UserHandler app = new UserHandler();
        // set the register frame :
        JFrame registerFrame = new JFrame();
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setLayout(new GridLayout(2,1));
        registerFrame.setBounds(500,200,500,350);

        // set upper panel for (email text field) and (userName text field) and (password text field) :
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout());

        // set (email text field) and (userName text field) and (password text field) :
        JTextField email = new JTextField(30);
        email.setText("email");
        JTextField userName = new JTextField(30);
        userName.setText("userName");
        JTextField password = new JTextField(30);
        password.setText("password");

        // add text fields to the upper panel :
        upperPanel.add(email);
        upperPanel.add(userName);
        upperPanel.add(password);

        // add upper panel to the register frame :
        registerFrame.add(upperPanel);

        // set lower panel for (register button) and (back button) :
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new FlowLayout());

        // set register button :
        JButton register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!app.checkEmailValidation(email.getText())){
                    JOptionPane.showMessageDialog(null,"Email is invalid.");
                } else if (app.checkUserNameExistence(userName.getText())) {
                    JOptionPane.showMessageDialog(null,"userName already taken.");
                } else if (app.getPasswordComplexity(password.getText())<3) {
                    JOptionPane.showMessageDialog(null,"Password is week.");
                } else {
                    app.registerNewUser(userName.getText(),app.passwordToHash(password.getText()),email.getText());
                    JOptionPane.showMessageDialog(null,"You registered successfully.");
                    registerFrame.dispose();
                }
            }
        });

        // set back button :
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame.dispose();
                new MainPage();
            }
        });

        // add (register button) and (back button) to the lower panel :
        lowerPanel.add(register);
        lowerPanel.add(back);

        // add lower panel to the register frame :
        registerFrame.add(lowerPanel);

        // set register frame visible :
        registerFrame.setVisible(true);

    }
}

