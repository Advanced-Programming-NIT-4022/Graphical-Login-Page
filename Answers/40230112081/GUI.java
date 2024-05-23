import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements signupPanel {

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

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(signup.isSelected()){
                    signUpPanel();
                }
            }
        });
        // visibility
        buttonPanel.setVisible(true);
        optionsPanel.setVisible(true);
        menu.add(optionsPanel);
        menu.add(buttonPanel);
        // menu layout
        menu.setLayout(myLayout);
        menu.setVisible(true);
    }

    @Override
    public void signUpPanel() {
        menu.setVisible(false);
        JFrame signup = new JFrame("Sign up");
        signup.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        signup.setSize(500, 600);
        GridLayout myLayout = new GridLayout(2,1);
        JPanel textFieldsPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        textFieldsPanel.setSize(500, 300);
        buttonsPanel.setSize(500, 300);
        JLabel e_label = new JLabel("Email");
        JLabel u_label = new JLabel("Username");
        JLabel p_label = new JLabel("Password");
        textFieldsPanel.setLayout(null);
        buttonsPanel.setLayout(null);

        // text fields panel
        JTextField email = new JTextField(100);
        JTextField username = new JTextField(100);
        JTextField password = new JTextField(100);
        // position
        email.setBounds(150,50,190,30);
        username.setBounds(150, 100, 190, 30);
        password.setBounds(150, 150, 190, 30);
        e_label.setBounds(70,50,50,30);
        u_label.setBounds(70, 100, 100,30);
        p_label.setBounds(70, 150, 100,30);
        // visibility
        email.setVisible(true);
        username.setVisible(true);
        password.setVisible(true);
        e_label.setVisible(true);
        p_label.setVisible(true);
        u_label.setVisible(true);
        // adding text fields & labels to panel
        textFieldsPanel.add(email);
        textFieldsPanel.add(username);
        textFieldsPanel.add(password);
        textFieldsPanel.add(e_label);
        textFieldsPanel.add(u_label);
        textFieldsPanel.add(p_label);
        // buttons
        JButton signUp = new JButton("Sign up");
        JButton back = new JButton("Back");

        back.setBounds(50, 125,100,30);
        signUp.setBounds(350, 125, 100, 30);
        // button visibility
        back.setVisible(true);
        signUp.setVisible(true);


        // add buttons to panel
        buttonsPanel.add(back);
        buttonsPanel.add(signUp);
        // panels visibility
        textFieldsPanel.setVisible(true);
        buttonsPanel.setVisible(true);

        signup.add(textFieldsPanel);
        signup.add(buttonsPanel);
        signup.setLayout(myLayout);
        signup.setVisible(true);
    }
}
