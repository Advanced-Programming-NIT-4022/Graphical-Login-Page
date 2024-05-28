import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoginGUI extends JFrame{
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JTextField emailField;
  private JLabel message;
  private UserStore userStore;

  public LoginGUI()
  {

    setTitle("Login and Registration");
    setSize(400, 300);    userStore = new UserStore();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    JPanel panel = new JPanel(new GridLayout(7, 1));
    usernameField = new JTextField();
    passwordField = new JPasswordField();
    emailField = new JTextField();
    message = new JLabel();
    JButton login = new JButton("Login");
    JButton register = new JButton("Register");
    
    panel.add(new JLabel("Username:"));
    panel.add(usernameField);
    panel.add(new JLabel("Password:"));
    panel.add(passwordField);
    panel.add(new JLabel("Email:"));
    panel.add(emailField);
    panel.add(message);
    panel.add(login);
    panel.add(register);
    add(panel);

    login.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if(UserStore.login(username, password))
        {
          message.setText("Login successful");
        }
        else
        {
          message.setText("Invalid username or password.");
        }
      }
    });
    register.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();
      if(!EmailValidator.isValid(email))
      {
        message.setText("Invalid Email format!");
        return;
      }
      int passwordStrength = PasswordUtils.isStrong(password);
      if (passwordStrength < 3) {
          message.setText("Weak password. Strength level: " + passwordStrength);
          return;
      }

      User user = new User(username, password, email);
        if(UserStore.register(user))
        {
          message.setText("Register successful!");
        }
        else
        {
          message.setText("User exists!");
        }
      
    }
    });
  }
}
