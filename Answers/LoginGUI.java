package Answers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class LoginGUI
{
    public void UI()
    {
        JFrame myApp = new JFrame("Login or Registration page");
        myApp.setSize(400,500);
        myApp.setDefaultCloseOperation(myApp.EXIT_ON_CLOSE);
        myApp.setLocationRelativeTo(null); // باعث میشه بیاد در مرکز صفحه نمایشی قرار بگیره
        myApp.setLayout(new GridLayout(10,1,0,10));
        Container container = myApp.getContentPane();
        container.setBackground(Color.white);


        JLabel userNameLabel = new JLabel("Username : ");
        myApp.add(userNameLabel);

        JTextField userName = new JTextField();
        userName.setBorder(null);
        userName.setBackground(Color.decode("#F3F8FA"));
        myApp.add(userName);

        JLabel passwordLabel = new JLabel("Password : ");
        myApp.add(passwordLabel);

        JTextField Password = new JTextField();
        Password.setBorder(null);
        Password.setBackground(Color.decode("#F3F8FA"));
        myApp.add(Password);

        JLabel emailLabel = new JLabel("Email(only for registration) : ");
        myApp.add(emailLabel);

        JTextField email = new JTextField();
        email.setBorder(null);
        email.setBackground(Color.decode("#F3F8FA"));
        myApp.add(email);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#1847A1"));
        loginButton.setForeground(Color.decode("#FFFFFF"));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                loginButton.setBackground(Color.decode("#F3F8FA"));
                loginButton.setForeground(Color.decode("#1847A1"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                loginButton.setBackground(Color.decode("#1847A1"));
                loginButton.setForeground(Color.decode("#FFFFFF"));
            }
        });


        JButton registrationButton =  new JButton("Register");
        registrationButton.setBackground(Color.decode("#1847A1"));
        registrationButton.setForeground(Color.decode("#FFFFFF"));
        registrationButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                registrationButton.setBackground(Color.decode("#F3F8FA"));
                registrationButton.setForeground(Color.decode("#1847A1"));
            }

            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                registrationButton.setBackground(Color.decode("#1847A1"));
                registrationButton.setForeground(Color.decode("#FFFFFF"));
            }
        });

        JLabel alertLabel = new JLabel();
        myApp.add(registrationButton);

        registrationButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String usernameSTR = userName.getText();
                String passwordSTR = Password.getText();
                String emailSTR = email.getText();

                for (int i = 0 ; i <1 ; i++)
                {
                    if (usernameSTR.isEmpty() && passwordSTR.isEmpty() && emailSTR.isEmpty())
                    {
                        alertLabel.setText("You have entered nothing!");
                        break;
                    }

                    else if (usernameSTR.isEmpty() && emailSTR.isEmpty())
                    {
                        alertLabel.setText("You have not entered the username and email!");
                        break;
                    }
                    else if (passwordSTR.isEmpty() && emailSTR.isEmpty())
                    {
                        alertLabel.setText("You have not entered the password and email!");
                        break;
                    }
                    else if (usernameSTR.isEmpty() && passwordSTR.isEmpty())
                    {
                        alertLabel.setText("You have not entered the username and password!");
                        break;
                    }
                    else if (usernameSTR.isEmpty())
                    {
                        alertLabel.setText("You have not entered the username!");
                        break;
                    }
                    else if (passwordSTR.isEmpty())
                    {
                        alertLabel.setText("You have not entered the password!");
                        break;
                    }
                    else if (emailSTR.isEmpty())
                    {
                        alertLabel.setText("You have not entered the email!");
                        break;
                    }

                    PasswordUtils passwordUtilsObj = new PasswordUtils();

                    if (!Objects.equals(passwordUtilsObj.PasswordDifficulty(passwordSTR), "Password is Strong."))
                    {
                        alertLabel.setText(passwordUtilsObj.PasswordDifficulty(passwordSTR));
                        break;
                    }

                    EmailValidator emailValidatorObj = new EmailValidator();

                    if (!emailValidatorObj.isEmailValid(emailSTR))
                    {
                        alertLabel.setText("You have entered a incorrect email!");
                        break;
                    }

                    HashingPassword hashingPasswordObj = new HashingPassword();
                    String hashedPasswordSTR = hashingPasswordObj.hashingPassword(passwordSTR);

                    Users usersObj = new Users();
                    if (Objects.equals(usersObj.registerUser(usernameSTR, hashedPasswordSTR, emailSTR), "This username is taken!"))
                    {
                        alertLabel.setText("This username is taken!");
                        break;
                    }
                    else
                    {
                        usersObj.registerUser(usernameSTR,hashedPasswordSTR,emailSTR);
                        alertLabel.setText("Registration successful:)");
                        break;
                    }
                }

            }
        });

        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String usernameSTR = userName.getText();
                String passwordSTR = Password.getText();

                for (int i = 0 ; i <1 ; i++)
                {
                    if (usernameSTR.isEmpty() && passwordSTR.isEmpty())
                    {
                        alertLabel.setText("You have entered nothing!");
                        break;
                    }
                    else if (usernameSTR.isEmpty())
                    {
                        alertLabel.setText("You have not entered the username!");
                        break;
                    }
                    else if (passwordSTR.isEmpty())
                    {
                        alertLabel.setText("You have not entered the password!");
                        break;
                    }

                    HashingPassword hashingPasswordObj = new HashingPassword();
                    String hashedPasswordSTR = hashingPasswordObj.hashingPassword(passwordSTR);

                    Users usersObj = new Users();
                    if (Objects.equals(usersObj.loginUser(usernameSTR, hashedPasswordSTR), "username or password is incorrect!"))
                    {
                        alertLabel.setText("username or password is incorrect!");
                        break;
                    }
                    else
                    {
                        alertLabel.setText(usersObj.loginUser(usernameSTR, hashedPasswordSTR));
                        break;
                    }
                }
            }
        });


        myApp.add(loginButton);
        myApp.add(alertLabel);

        myApp.setVisible(true);
    }
}
