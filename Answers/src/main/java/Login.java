import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login {

    public void loginPanel() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setSize(500, 500);
        loginFrame.setLayout(null);

        Color pinkie = new Color(249, 127, 204);
        Color redie = new Color(213,77,77);
        Color bluie = new Color(38,137,186);
        Color meloBlue = new Color (202,226,240);

        ImageIcon background = new ImageIcon("C:\\Users\\yekta\\Downloads\\Telegram Desktop\\IMG_6693.jpg");

        JPanel backgroundPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        backgroundPanel.setSize(loginFrame.getWidth(), loginFrame.getHeight());

        JLabel usernameLabel = new JLabel("Username : ");
        usernameLabel.setBounds(110, 131, 300, 30);
        usernameLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        usernameLabel.setForeground(Color.white);

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(230,138,105,20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setBounds(110,181,350,30);
        passwordLabel.setFont(new Font("Georgia", Font.BOLD, 14));

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(230,188,105,20);

        JButton loginButton = new JButton("Submit");
        loginButton.setBounds(230,238,105,20);
        loginButton.setForeground(bluie);
        loginButton.setFont(new Font("Georgia", Font.BOLD, 10));

        JLabel notFindLabel = new JLabel("");
        notFindLabel.setForeground(meloBlue);
        notFindLabel.setBounds(110,235,350,30);
        notFindLabel.setFont(new Font("Georgia", Font.BOLD, 10));

        JLabel notFindLabel2 = new JLabel("");
        notFindLabel2.setForeground(meloBlue);
        notFindLabel2.setBounds(110,250,350,30);
        notFindLabel2.setFont(new Font("Georgia", Font.BOLD, 10));

        JButton RegisterButton = new JButton("Registration");
        RegisterButton.setBounds(230,405,105,20);
        RegisterButton.setForeground(bluie);
        RegisterButton.setFont(new Font("Georgia", Font.BOLD, 10));

        JLabel registerLabel = new JLabel("New here?");
        registerLabel.setForeground(meloBlue);
        registerLabel.setBounds(110,400,350,30);
        registerLabel.setFont(new Font("Georgia", Font.BOLD, 14));

        backgroundPanel.add(usernameLabel);
        backgroundPanel.add(usernameField);
        backgroundPanel.add(passwordLabel);
        backgroundPanel.add(passwordField);
        backgroundPanel.add(loginButton);
        backgroundPanel.add(RegisterButton);
        backgroundPanel.add(registerLabel);
        backgroundPanel.add(notFindLabel);
        backgroundPanel.add(notFindLabel2);

        loginFrame.add(backgroundPanel);

        //frame jadid :

        JFrame loginDoneFrame = new JFrame("Logined");
        loginDoneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginDoneFrame.setSize(400, 250);
        loginDoneFrame.setLayout(null);

        ImageIcon backgroundDone = new ImageIcon("C:\\Users\\yekta\\Downloads\\Telegram Desktop\\IMG_6693.jpg");

        JPanel backgroundPanelDone = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanelDone.setLayout(null);
        backgroundPanelDone.setSize(loginDoneFrame.getWidth(), loginDoneFrame.getHeight());

        JLabel loginDoneLabel = new JLabel("You have successfully Login!");
        loginDoneLabel.setBounds(80,95,300,20);
        loginDoneLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        loginDoneLabel.setForeground(Color.WHITE);

        backgroundPanelDone.add(loginDoneLabel);
        loginDoneFrame.getContentPane().add(backgroundPanelDone);

        loginFrame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserStore.readFile();
                boolean find=false;
                for (User uu : UserStore.myUsers){
                    try {
                        if (Objects.equals(usernameField.getText(), uu.user) && Objects.equals(UserStore.hashingPass(String.valueOf(passwordField.getPassword())), uu.password)){
                            System.out.println("okay");
                            find = true;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                if (find){
                    loginFrame.setVisible(false);
                    loginDoneFrame.setVisible(true);
                }
                if (!find){
                    notFindLabel.setText("Invalid credential.");
                    notFindLabel2.setText("Please try again.");
                }
            }
        });

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == RegisterButton){
                    loginFrame.setVisible(false);
                    Register register = new Register();
                    register.registerPanel();
                }
            }
        });
    }
}
