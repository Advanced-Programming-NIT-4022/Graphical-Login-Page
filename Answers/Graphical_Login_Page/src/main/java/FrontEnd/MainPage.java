// write package name :
package FrontEnd;

// import needed things :

import BackEnd.UserHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// start of main page class :
public class MainPage {
    // constructor :
    MainPage() {
        // set the main frame :
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.setBounds(500, 200, 500, 350);

        // set a panel that we can add our buttons to it :
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        // set login button :
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                new LoginPage();
            }
        });

        // set register button :
        JButton register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                new RegisterPage();
            }
        });

        // add buttons to panel :
        panel.add(login);
        panel.add(register);

        // add panel to the main frame :
        mainFrame.add(panel);

        // set main frame visible :
        mainFrame.setVisible(true);

    }

    // set main method to run main page :
    public static void main(String[] args) {
        new MainPage();
    }

}
