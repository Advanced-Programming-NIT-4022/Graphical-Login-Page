import org.w3c.dom.ls.LSSerializerFilter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class GUI implements signupPanel, loginPanel {

    Database db;
    Validator vld;
    JFrame menu;
    JFrame signup;
    JFrame login;
    ArrayList<String> list;
    boolean e_f, p_f, u_f;
    public GUI(){

        menu = new JFrame();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(500,600);
        menu.setResizable(true);
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
                if(login.isSelected()){
                    loginPanel();
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
    String message;
    @Override
    public void signUpPanel() {
        vld = new Validator();

        db = new Database("jdbc:mysql://localhost:3306/users_swing","Amir13810325**","root","user_repo");
        this.e_f = false;
        this.u_f = false;
        this.p_f = false;
        list = new ArrayList<>();
        menu.setVisible(false);
        signup = new JFrame("Sign up");
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
        JLabel p_level = new JLabel();
        textFieldsPanel.setLayout(null);
        buttonsPanel.setLayout(null);
        JButton signUp = new JButton("Sign up");
        JButton back = new JButton("Back");

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
        p_level.setBounds(350,150, 100, 30);
        // visibility
        email.setVisible(true);
        username.setVisible(true);
        password.setVisible(true);
        e_label.setVisible(true);
        p_label.setVisible(true);
        u_label.setVisible(true);
        p_level.setVisible(true);
        // adding actions
        // adding text fields & labels to panel
        textFieldsPanel.add(email);
        textFieldsPanel.add(username);
        textFieldsPanel.add(password);
        textFieldsPanel.add(e_label);
        textFieldsPanel.add(u_label);
        textFieldsPanel.add(p_label);
        textFieldsPanel.add(p_level);
        // add actions to text fields

        email.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()))
                    signUp.setEnabled(true);
                else
                    signUp.setEnabled(false);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()))
                    signUp.setEnabled(true);
                else
                    signUp.setEnabled(false);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()))
                    signUp.setEnabled(true);
                else
                    signUp.setEnabled(false);
            }
        });

        password.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (vld.passwordValidator(password.getText()) && vld.emailValidator(email.getText())){
                    signUp.setEnabled(true);
                    p_level.setText(vld.passwordStrengthLevel(password.getText()));
                    set_color(password.getText());
                }
                else {
                    signUp.setEnabled(false);
                    p_level.setText("Wrong email.");
                    set_color(password.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(vld.passwordValidator(password.getText()) && vld.emailValidator(email.getText())){
                    signUp.setEnabled(true);
                    p_level.setText(vld.passwordStrengthLevel(password.getText()));
                    set_color(password.getText());
                }
                else {
                    signUp.setEnabled(false);
                    p_level.setText("Wrong email.");
                    set_color(password.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(vld.passwordValidator(password.getText()) && vld.emailValidator(email.getText())) {
                    signUp.setEnabled(true);
                    p_level.setText(vld.passwordStrengthLevel(password.getText()));
                    set_color(password.getText());
                }
                else {
                    signUp.setEnabled(false);
                    p_level.setText("Wrong format.");
                    set_color(password.getText());
                }
            }

            public void set_color(String pass){
                if(vld.passwordValidator(pass))
                {
                    String level = vld.passwordStrengthLevel(pass);
                    if(level.equals("Wrong Format"))
                        p_level.setForeground(Color.red);
                    else if(level.equals("easy"))
                        p_level.setForeground(Color.green);
                    else if(level.equals("intermediate"))
                        p_level.setForeground(Color.ORANGE);
                    else if(level.equals("medium"))
                        p_level.setForeground(Color.orange);
                    else if(level.equals("hard"))
                        p_level.setForeground(Color.red);
                    else if(level.equals("Very hard"))
                        p_level.setForeground(Color.RED);
                    else
                        p_label.setForeground(Color.black);
                }
                else
                    p_level.setForeground(Color.BLACK);

            }
        });
        // buttons

        back.setBounds(50, 125,100,30);
        signUp.setBounds(250, 125, 100, 30);
        // button visibility
        back.setVisible(true);
        signUp.setVisible(true);
        // button's action
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signup.setVisible(false);
                menu.setVisible(true);
            }
        });
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(db.searchInTable("email",email.getText()) || db.searchInTable("username",username.getText())) {
                    JOptionPane.showMessageDialog(signup, "The email/Username is available in repository.");
                    username.setText("");
                    password.setText("");
                    email.setText("");
                }
                else{
                    list.add(username.getText());
                    list.add(vld.hashingPassword(password.getText()));
                    list.add(email.getText().toLowerCase());
                    message = db.insertToTable(list);

                    if(message.equals("Username exists.")){
                        JOptionPane.showMessageDialog(signup,message);
                        username.setText("");
                        password.setText("");
                        email.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(signup,message);
                        signup.setVisible(false);
                        menu.setVisible(true);
                    }


                }
            }
        });
        // add buttons to panel
        buttonsPanel.add(back);
        buttonsPanel.add(signUp);
        // panels visibility
        textFieldsPanel.setVisible(true);
        buttonsPanel.setVisible(true);
        signup.add(textFieldsPanel);
        signup.add(buttonsPanel);
        signup.setLayout(myLayout);
        //signup.setResizable(true);
        signup.setVisible(true);
    }


    @Override
    public void loginPanel() {
        vld = new Validator();
        db = new Database("jdbc:mysql://localhost:3306/users_swing","Amir13810325**","root","user_repo");
        login = new JFrame();
        menu.setVisible(false);
        login.setSize(500, 600);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel buttons, fields;
        buttons = new JPanel();
        buttons.setSize(500, 300);
        fields = new JPanel();
        fields.setSize(500, 300);
        GridLayout myLayout = new GridLayout(2, 1);
        // buttons
        JButton loginButton = new JButton("Login");
        JButton backButton  = new JButton("Back");
        // buttons position
        buttons.setLayout(null);
        buttons.add(backButton);
        buttons.add(loginButton);
        loginButton.setBounds(75,130,100, 40);
        backButton.setBounds(325, 130, 100, 40);
        // buttons visibility
        loginButton.setVisible(true);
        backButton.setVisible(true);
        // add buttons actions
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                menu.setVisible(true);
            }
        });
        // fields
        fields.setLayout(null);
        JTextField email;
        JTextField username;
        JPasswordField pass;
        JLabel e_label, u_label, p_label;
        email = new JTextField(100);
        username = new JTextField(100);
        pass = new JPasswordField(100);
        e_label = new JLabel("Email");

        p_label = new JLabel("Password");
        email.setBounds(150,50,190,30);
        pass.setBounds(150, 100, 190, 30);
        e_label.setBounds(70,50,50,30);
        p_label.setBounds(70, 100, 100,30);
        email.setVisible(true);
        pass.setVisible(true);
        username.setVisible(true);
        p_label.setVisible(true);
        e_label.setVisible(true);
        // add validators to fields
        email.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()))
                    loginButton.setEnabled(true);
                else
                    loginButton.setEnabled(false);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()))
                    loginButton.setEnabled(true);
                else
                    loginButton.setEnabled(false);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()))
                    loginButton.setEnabled(true);
                else
                    loginButton.setEnabled(false);
            }
        });

        username.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()) && db.searchInTable("username", username.getText()))
                    loginButton.setEnabled(true);
                else
                    loginButton.setEnabled(false);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()) && db.searchInTable("username", username.getText()))
                    loginButton.setEnabled(true);
                else
                    loginButton.setEnabled(false);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()) && db.searchInTable("username", username.getText()))
                    loginButton.setEnabled(true);
                else
                    loginButton.setEnabled(false);
            }
        });

        // login button action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(db.searchInTable("email", email.getText().toLowerCase())){
                    if(vld.hashingPassword(new String(pass.getPassword())).equals(db.findPassword(email.getText()))){
                        JOptionPane.showMessageDialog(login, "Welcome to your panel");
                        login.setVisible(false);
                        menu.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(login, "This password don't match");
                        pass.setText("");
                        email.setText("");
                    }

                }else{
                    JOptionPane.showMessageDialog(login, "This email not found in repository.");
                    pass.setText("");
                    email.setText("");
                }
            }
        });

        // add components to panel
        fields.add(email);
        fields.add(username);
        fields.add(pass);
        fields.add(e_label);
        fields.add(p_label);
        // adding panel
        fields.setVisible(true);
        login.add(fields);
        login.add(buttons);
        login.setLayout(myLayout);
        login.setVisible(true);
    }
}


/*

email.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()))
                    e_f = true;
                else{
                    e_f = false;
                }
                signUp.setEnabled(p_f && e_f && u_f);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()))
                    e_f = true;
                else
                    e_f = false;
                signUp.setEnabled(p_f && e_f && u_f);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(vld.emailValidator(email.getText()))
                    e_f = true;
                else
                    e_f = false;
                signUp.setEnabled(p_f && e_f && u_f);
            }
        });
        username.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                u_f = true;
                signUp.setEnabled(p_f && e_f && u_f);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                u_f = true;
                signUp.setEnabled(p_f && e_f && u_f);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                signUp.setEnabled(p_f && e_f && u_f);
            }
        });
password.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(vld.passwordValidator(password.getText())) {
                    updateLabel();
                    p_f = true;
                }
                else if(vld.passwordStrengthLevel(password.getText()).contains("wrong") && )
                    p_f = false;
                signUp.setEnabled(p_f && e_f && u_f);

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(vld.passwordValidator(password.getText())) {
                    updateLabel();
                    p_f = true;
                }else
                   p_f = false;
               signUp.setEnabled(p_f && e_f && u_f);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(vld.passwordValidator(password.getText())) {
                    updateLabel();
                    p_f = true;
                }else
                    p_f = false;
                signUp.setEnabled(p_f && e_f && u_f);
            }

            public void updateLabel(){
                String text = password.getText();
                String level = vld.passwordStrengthLevel(text);
                p_level.setText(level);
                labelColor(level);
            }
            public void labelColor(String text){
                if(text.equals("easy")){
                    p_level.setForeground(Color.GREEN);
                }
                else if(text.equals("intermediate")){
                    p_level.setForeground(Color.GREEN);
                }
                else if(text.equals("medium")){
                    p_level.setForeground(Color.ORANGE);
                }
                else if(text.equals("hard")){
                    p_level.setForeground(Color.orange);
                }
                else if(text.equals("Very hard")){
                    p_level.setForeground(Color.RED);
                }
            }

        });


 */