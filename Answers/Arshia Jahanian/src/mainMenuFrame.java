import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenuFrame extends JFrame {
    private signUpFrame signUpFrame;
    private loginFrame loginFrame;

    public mainMenuFrame(){
        signUpFrame = new signUpFrame();
        loginFrame = new loginFrame();
        setSize(new Dimension(300, 200));
        JButton backButton = new JButton("Back");
        backButton.setSize(90, 50);
        JButton signupButton = new JButton("Sign Up");
        signupButton.setSize(90, 50);
        JButton loginButton = new JButton("Login");
        loginButton.setSize(90, 50);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loginFrame.setVisible(true);
                setVisible(false);

                loginFrame.backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        setVisible(true);
                        loginFrame.setVisible(false);
                    }
                });
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                signUpFrame.setVisible(true);
                setVisible(false);
                signUpFrame.backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        signUpFrame.setVisible(false);
                        setVisible(true);
                    }
                });
            }

        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(backButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(signupButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        add(loginButton, gbc);

        setVisible(true);
    }


}
