import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_Window {
    JFrame frame;
    JPanel panel;
    JButton RegisterButton;
    JLabel UsernameLabel;
    JLabel PasswordLabel;
    JLabel EmailLabel;

    JPasswordField PasswordField;
    JTextField UserNameField;
    JTextField EmailField;

    Register_Window(){
        frame = new JFrame("Login page");
        panel = new JPanel();
        RegisterButton = new JButton("Sign up");
        UsernameLabel = new JLabel("Username : ");
        PasswordLabel = new JLabel("Password : ");
        PasswordField = new JPasswordField(20);
        UserNameField = new JTextField(20);
        EmailLabel = new JLabel("Email : ");
        EmailField = new JTextField(20);

        panel.add(UsernameLabel);
        panel.add(UserNameField);
        panel.add(PasswordLabel);
        panel.add(PasswordField);
        panel.add(EmailLabel);
        panel.add(EmailField);
        panel.add(RegisterButton);

        frame.add(panel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400 , 400);
        frame.pack();
        frame.setVisible(true);

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = UserNameField.getText();
                String password = String.valueOf(PasswordField.getPassword());
                String email = EmailField.getText();

                if (!PasswordUtils.isStrongPassword(password)) {
                    JOptionPane.showMessageDialog(frame, "Password is not strong enough. Please try again.");
                    return;
                }

                if (!EmailValidator.EmailValid(email)) {
                    JOptionPane.showMessageDialog(frame, "Email is not valid. Please try again.");
                    return;
                }


                if (UserStore.isUsernameTaken(username)) {
                    JOptionPane.showMessageDialog(frame, "Username is already taken. Please choose another one.");
                    return;
                }

                if (UserStore.isEmailRegistered(email)) {
                    JOptionPane.showMessageDialog(frame, "Email is already registered. Please use another one.");
                    return;
                }

                User newUser = new User(username, password, email);
                UserStore.saveUser(newUser);
                JOptionPane.showMessageDialog(frame, "Registration successful! You can now log in.");
            }
        });

    }

    public static void main(String[] args) {
        new Register_Window();
    }
}
