// write package name :
package GUI;

// import needed things :

import BackEnd.EmailValidator;
import BackEnd.PasswordValidator;
import BackEnd.StringToHash;
import BackEnd.UserHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// start of sign up page class :
public class SignUpPage {
    // constructor :
    SignUpPage() {
        // set the register frame :
        JFrame signUpFrame = new JFrame();
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.setTitle("Sign up page");
        signUpFrame.setLayout(new GridLayout(2, 1));
        signUpFrame.setSize(500, 350);
        signUpFrame.setLocationRelativeTo(null); // this method centers the frame in monitor when we give it null argument

        // set upper panel for text fields and labels :
        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(Color.lightGray);
        upperPanel.setLayout(new GridBagLayout());

        // set email text field :
        JTextField email = new JTextField(25);
        GridBagConstraints emailGrid = new GridBagConstraints();
        emailGrid.gridx = 1;
        emailGrid.gridy = 0;
        emailGrid.insets = new Insets(5, 5, 5, 5);
        email.setPreferredSize(new Dimension(30, 35));
        email.setFont(new Font("Arial", Font.PLAIN, 15));

        // set email label :
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        GridBagConstraints emailLabelGrid = new GridBagConstraints();
        emailLabelGrid.gridx = 0;
        emailLabelGrid.gridy = 0;
        emailLabelGrid.insets = new Insets(5, 0, 5, 0);

        // set userName text field :
        JTextField userName = new JTextField(25);
        GridBagConstraints userNameGrid = new GridBagConstraints();
        userNameGrid.gridx = 1;
        userNameGrid.gridy = 1;
        userNameGrid.insets = new Insets(5, 5, 5, 5);
        userName.setPreferredSize(new Dimension(30, 35));
        userName.setFont(new Font("Arial", Font.PLAIN, 15));

        // set userName label :
        JLabel userNameLabel = new JLabel("UserName");
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        GridBagConstraints userNameLabelGrid = new GridBagConstraints();
        userNameLabelGrid.gridx = 0;
        userNameLabelGrid.gridy = 1;
        userNameLabelGrid.insets = new Insets(5, 0, 5, 0);

        // set password text field :
        JTextField password = new JTextField(25);
        GridBagConstraints passwordGrid = new GridBagConstraints();
        passwordGrid.gridx = 1;
        passwordGrid.gridy = 2;
        passwordGrid.insets = new Insets(5, 5, 5, 5);
        password.setPreferredSize(new Dimension(30, 35));
        password.setFont(new Font("Arial", Font.PLAIN, 15));

        // set password label :
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        GridBagConstraints passwordLabelGrid = new GridBagConstraints();
        passwordLabelGrid.gridx = 0;
        passwordLabelGrid.gridy = 2;
        passwordLabelGrid.insets = new Insets(5, 0, 5, 0);

        // add text fields and labels to the upper panel :
        upperPanel.add(emailLabel, emailLabelGrid);
        upperPanel.add(userNameLabel, userNameLabelGrid);
        upperPanel.add(passwordLabel, passwordLabelGrid);
        upperPanel.add(email, emailGrid);
        upperPanel.add(userName, userNameGrid);
        upperPanel.add(password, passwordGrid);

        // add upper panel to the signUp frame :
        signUpFrame.add(upperPanel);

        // set lower panel for (sign up button) and (cancel button) :
        JPanel lowerPanel = new JPanel();
        lowerPanel.setBackground(Color.lightGray);
        lowerPanel.setLayout(new GridBagLayout());

        // set sign up button :
        JButton signUp = new JButton("Sign up");
        GridBagConstraints signUpGrid = new GridBagConstraints();
        signUpGrid.gridx = 0;
        signUpGrid.gridy = 0;
        signUpGrid.insets = new Insets(0, 5, 0, 5);
        Dimension signUpDimension = new Dimension(180, 65);
        signUp.setPreferredSize(signUpDimension);
        signUp.setFont(new Font("Arial", Font.PLAIN, 25));
        signUp.setFocusable(false);
        signUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!new EmailValidator().emailValidation(email.getText())) {
                    JOptionPane.showMessageDialog(null, "Email is invalid.");
                } else if (new UserHandler().checkUserNameExistence(userName.getText())) {
                    JOptionPane.showMessageDialog(null, "UserName already taken.");
                } else if (new PasswordValidator().getPasswordComplexity(password.getText()) < 60) {
                    JOptionPane.showMessageDialog(null, "Password is weak.");
                } else {
                    new UserHandler().registerNewUser(userName.getText(), new StringToHash().ToHash(password.getText()), email.getText());
                    JOptionPane.showMessageDialog(null, "You signed successfully.");
                    signUpFrame.dispose();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                signUp.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUp.setBackground(new JButton().getBackground());
            }

            @Override
            public void mousePressed(MouseEvent e) {/*nothing*/}

            @Override
            public void mouseReleased(MouseEvent e) {/*nothing*/}
        });

        // set cancel button :
        JButton cancel = new JButton("Cancel");
        GridBagConstraints cancelGrid = new GridBagConstraints();
        cancelGrid.gridx = 1;
        cancelGrid.gridy = 0;
        cancelGrid.insets = new Insets(0, 5, 0, 5);
        Dimension backDimension = new Dimension(180, 65);
        cancel.setPreferredSize(backDimension);
        cancel.setFont(new Font("Arial", Font.PLAIN, 25));
        cancel.setFocusable(false);
        cancel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                signUpFrame.dispose();
                new LoginPage();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                cancel.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel.setBackground(new JButton().getBackground());
            }

            @Override
            public void mousePressed(MouseEvent e) {/*nothing*/}

            @Override
            public void mouseReleased(MouseEvent e) {/*nothing*/}
        });

        // add (sign up button) and (cancel button) to the lower panel :
        lowerPanel.add(signUp, signUpGrid);
        lowerPanel.add(cancel, cancelGrid);

        // add lower panel to the signUp frame :
        signUpFrame.add(lowerPanel);

        // set sign up frame visible :
        signUpFrame.setVisible(true);

    }
}

