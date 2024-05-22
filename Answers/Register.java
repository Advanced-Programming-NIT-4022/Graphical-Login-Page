import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Register
{
    JLabel label0 , label1 , label2 , label3 , label4;
    JButton login , register;
    JTextField username , email;
    JPasswordField password;
    JCheckBox check;

    Register()
    {
        JFrame Register = new JFrame("Register");
        Register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label0 = new JLabel("REGISTER");
        label0.setFont(new Font("serif", Font.BOLD, 25));
        label0.setBounds(130,10,150, 50);;
        Register.add(label0);

        register = new JButton("Register");
        register.setBounds(135, 250, 100, 30);
        Register.add(register);

        label1 = new JLabel();
        label1.setText("Already have an account?");
        label1.setBounds(70, 275, 200, 50);
        Register.add(label1);

        login = new JButton("Login");
        login.setBounds(220, 291, 85, 20);
        Register.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Register.dispose();
                new Login();
            }
        });

        label2 = new JLabel("Email:");
        label2.setFont(new Font("Verdana",Font.PLAIN,12));
        label2.setBounds(80, 80, 100, 30);
        Register.add(label2);

        email = new JTextField();
        email.setBounds(150,85, 162, 25);
        Register.add(email);

        label3 = new JLabel("Username:");
        label3.setFont(new Font("Verdana",Font.PLAIN,12));
        label3.setBounds(79, 130, 100, 30);
        Register.add(label3);

        username = new JTextField();
        username.setBounds(150, 135, 162, 25);
        Register.add(username);

        label4 = new JLabel("Password:");
        label4.setFont(new Font("Verdana",Font.PLAIN,12));
        label4.setBounds(80, 180, 100, 30);
        Register.add(label4);

        password = new JPasswordField();
        password.setBounds(150, 185, 162, 25);
        Register.add(password);

        check = new JCheckBox("Show Password");
        check.setBounds(145, 210, 150, 30);
        Register.add(check);

        check.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged (ItemEvent e)
            {
                if(e.getStateChange()==1)
                {
                    password.setEchoChar((char)0);
                }
                else
                {
                    password.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
                }
            }
        });

        Register.setSize(400, 400);
        Register.setLayout(null);
        Register.setVisible(true);
    }
}
