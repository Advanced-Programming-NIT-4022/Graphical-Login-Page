// write package name :
package GUI;

// import needed things :

import BackEnd.StringToHash;
import BackEnd.UserHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// start of sign in page class :
public class SignInPage {
    // constructor :
    SignInPage() {
        // set the login frame :
        JFrame signInFrame = new JFrame();
        signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signInFrame.setTitle("Sign in page");
        signInFrame.setLayout(new GridLayout(2, 1));
        signInFrame.setSize(500, 350);
        signInFrame.setLocationRelativeTo(null); // this method centers the frame in monitor when we give it null argument

        // set upper panel for text fields and labels :
        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(Color.lightGray);
        upperPanel.setLayout(new GridBagLayout());

        // set userName text field :
        JTextField userName = new JTextField(25);
        GridBagConstraints userNameGrid = new GridBagConstraints();
        userNameGrid.gridx = 1;
        userNameGrid.gridy = 0;
        userNameGrid.insets = new Insets(5, 5, 5, 5);
        userName.setPreferredSize(new Dimension(30, 35));
        userName.setFont(new Font("Arial", Font.PLAIN, 15));

        // set userName label :
        JLabel userNameLabel = new JLabel("UserName");
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        GridBagConstraints userNameLabelGrid = new GridBagConstraints();
        userNameLabelGrid.gridx = 0;
        userNameLabelGrid.gridy = 0;
        userNameLabelGrid.insets = new Insets(5, 0, 5, 0);

        // set password text field :
        JTextField password = new JTextField(25);
        GridBagConstraints passwordGrid = new GridBagConstraints();
        passwordGrid.gridx = 1;
        passwordGrid.gridy = 1;
        passwordGrid.insets = new Insets(5, 5, 5, 5);
        password.setPreferredSize(new Dimension(30, 35));
        password.setFont(new Font("Arial", Font.PLAIN, 15));

        // set password label :
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        GridBagConstraints passwordLabelGrid = new GridBagConstraints();
        passwordLabelGrid.gridx = 0;
        passwordLabelGrid.gridy = 1;
        passwordLabelGrid.insets = new Insets(5, 0, 5, 0);

        // add text fields and labels to the upper panel :
        upperPanel.add(userNameLabel, userNameLabelGrid);
        upperPanel.add(passwordLabel, passwordLabelGrid);
        upperPanel.add(userName, userNameGrid);
        upperPanel.add(password, passwordGrid);
        // add upper panel to the login frame :
        signInFrame.add(upperPanel);

        // set lower panel for (login button) and (cancel button) :
        JPanel lowerPanel = new JPanel();
        lowerPanel.setBackground(Color.lightGray);
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // set sign in button :
        JButton signIn = new JButton("Sign in");
        GridBagConstraints signInGrid = new GridBagConstraints();
        signInGrid.gridx = 0;
        signInGrid.gridy = 0;
        signInGrid.insets = new Insets(0, 5, 0, 5);
        signIn.setPreferredSize(new Dimension(180, 65));
        signIn.setFont(new Font("Arial", Font.PLAIN, 25));
        signIn.setFocusable(false);
        signIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (new UserHandler().loginUser(userName.getText(), new StringToHash().ToHash(password.getText()))) {
                    JOptionPane.showMessageDialog(null, "You signed in successfully.");
                    signInFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "UserName or password is invalid.");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                signIn.setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signIn.setBackground(new JButton().getBackground());
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
        cancel.setPreferredSize(new Dimension(180, 65));
        cancel.setFont(new Font("Arial", Font.PLAIN, 25));
        cancel.setFocusable(false);
        cancel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                signInFrame.dispose();
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

        // add (login button) and (cancel button) to the lower panel :
        lowerPanel.add(signIn, signInGrid);
        lowerPanel.add(cancel, cancelGrid);

        // add lower panel to the login frame :
        signInFrame.add(lowerPanel);

        // set login frame visible :
        signInFrame.setVisible(true);
    }
}
