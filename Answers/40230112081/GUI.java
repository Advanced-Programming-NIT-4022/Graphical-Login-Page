import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    Database db;
    Validator vld;
    JFrame menu;
    public GUI(){
        vld = new Validator();
        db = new Database("jdbc:mysql://localhost:3306/users_swing","Amir13810325**","root","user_repo");
        menu = new JFrame();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(500,600);
        GridLayout myLayout = new GridLayout(2,1);
        JPanel optionsPanel = new JPanel();
        optionsPanel.setSize(500, 300);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setSize(500, 300);
        // Radio buttons
        // options panel
        JRadioButton login, signup;
        login = new JRadioButton("Login");
        signup = new JRadioButton("Sign-up");
        ButtonGroup bg = new ButtonGroup();
        bg.add(login);
        bg.add(signup);

        // option panels layout
        optionsPanel.setLayout(null);
        signup.setBounds(200, 50, 100, 50);
        login.setBounds(200,100,100,50);
        // visibility
        signup.setVisible(true);
        login.setVisible(true);
        // add to panel
        optionsPanel.add(login);
        optionsPanel.add(signup);
        // button panels buttons
        JButton exitButton = new JButton("Exit");
        JButton nextButton = new JButton("Next");

        //button panel layout
        buttonPanel.setLayout(null);
        exitButton.setBounds(100, 100, 100,50);
        nextButton.setBounds(300, 100, 100, 50);
        //visibility
        exitButton.setVisible(true);
        nextButton.setVisible(true);
        // add to panel
        buttonPanel.add(exitButton);
        buttonPanel.add(nextButton);
        // add action to buttons
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.setVisible(true);
        optionsPanel.setVisible(true);
        menu.add(optionsPanel);
        menu.add(buttonPanel);
        // menu layout
        menu.setLayout(myLayout);
        menu.setVisible(true);
    }
}
