// write package name :
package GUI;

// import needed things :

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// start of main page class :
public class LoginPage {
    // constructor :
    LoginPage() {
        // set the login frame :
        JFrame loginFrame = new JFrame();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setTitle("Login page");
        loginFrame.setLayout(new GridLayout(1, 1));
        loginFrame.setSize(500, 350);
        loginFrame.setLocationRelativeTo(null); // this method centers the frame in monitor when we give it null argument

        // set a panel that we can add our buttons to it :
        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridBagLayout());

        // set sign in button :
        JButton signIn = new JButton("Sign in");
        signIn.setFont(new Font("Arial", Font.PLAIN, 25));
        GridBagConstraints SignInGrid = new GridBagConstraints();
        SignInGrid.gridx = 0;
        SignInGrid.gridy = 0;
        SignInGrid.insets = new Insets(5, 0, 5, 0);
        signIn.setPreferredSize(new Dimension(200, 60));
        signIn.setFocusable(false);
        signIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginFrame.dispose();
                new SignInPage();
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

        // set sign up button :
        JButton signUp = new JButton("Sign up");
        signUp.setFont(new Font("Arial", Font.PLAIN, 25));
        GridBagConstraints SignUpGrid = new GridBagConstraints();
        SignUpGrid.gridx = 0;
        SignUpGrid.gridy = 1;
        SignUpGrid.insets = new Insets(5, 0, 5, 0);
        signUp.setPreferredSize(new Dimension(200, 60));
        signUp.setFocusable(false);
        signUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginFrame.dispose();
                new SignUpPage();
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

        // add buttons to panel :
        panel.add(signIn, SignInGrid);
        panel.add(signUp, SignUpGrid);

        // add panel to the login frame :
        loginFrame.add(panel);

        // set login frame visible :
        loginFrame.setVisible(true);

    }

}
