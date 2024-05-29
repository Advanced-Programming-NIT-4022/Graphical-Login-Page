import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Login {
    JFrame frame1, frame2;
    JButton button1, button2, button3,button4;
    JLabel label1, label2, label3 , label4 , label5 , label6, label7;
    JTextField textfield1, textfield2, textfield3 ;
    JPasswordField password;
    JCheckBox checkbox;
    public Login (){
        frame1 = new JFrame("login");
        ImageIcon objImage = new ImageIcon("logo.png.png");
        frame1.setIconImage(objImage.getImage());
        label1 = new  JLabel("Username : ");
        label2 = new  JLabel("Password : ");
        label3 = new  JLabel("if you can not remember : ");
        button1 = new JButton("register");
        button2 = new JButton("login");
        textfield1 = new JTextField();
        password = new JPasswordField();
        checkbox = new JCheckBox("Show Password");
        frame1.setSize(800, 600);
        label1.setBounds(50, 100, 75, 50);
        label2.setBounds(50, 200, 75, 50);
        label3.setBounds(50, 300, 200, 50);
        textfield1.setBounds(300, 100, 200, 50);
        password.setBounds(300, 200, 200, 50);
        checkbox.setBounds(300, 250, 200, 40);
        button1.setBounds(300, 300, 100, 50);
        button2.setBounds(600, 500, 150, 50);
        label1.setForeground(new Color(70,130,180) );
        label2.setForeground(new Color(70,130,180));
        label3.setForeground(new Color(70,130,180));
        button1.setForeground(new Color(70,130,180));
        button2.setBackground(new Color(230, 230, 250) );
        button2.setFont(new Font("serif", Font.BOLD, 35));
        frame1.add(label1);
        frame1.add(label2);
        frame1.add(label3);
        frame1.add(button1);
        frame1.add(button2);
        frame1.add(textfield1);
        frame1.add(password);
        frame1.add(checkbox);
        frame1.setLayout(null);
        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e)
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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                new Register();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label4 = new JLabel() ;
                UserStore read = new UserStore();
                switch(read.Read(label1.getText(),password.getPassword().toString())) {
                    case 0: {
                        label4.setText("Your password and your username not found ");
                        label4.setBounds(50, 500, 350, 50);
                        frame1.add(label4);
                        frame1.setSize(810, 610);
                        frame1.setLayout(null);
                        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
                        frame1.setVisible(true);
                    }
                    case 1: {
                        label4.setText("Your password not found ");
                        label4.setBounds(50, 500, 350, 50);
                        frame1.add(label4);
                        frame1.setSize(810, 610);
                        frame1.setLayout(null);
                        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
                        frame1.setVisible(true);
                    }
                    case 2: {
                        frame1.setVisible(false);
                        frame2 = new JFrame();
                        ImageIcon objImage = new ImageIcon("logo.png.png");
                        frame2.setIconImage(objImage.getImage());
                        frame2.setSize(500, 400);
                        label6 = new JLabel("WELCOME !!! ");
                        label6.setBounds(150, 125, 300, 100);
                        label6.setFont(new Font("serif", Font.BOLD, 25));
                        label6.setForeground(new Color(70, 130, 180));
                        frame2.add(label6);
                        frame2.setLayout(null);
                        frame2.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
                        frame2.setVisible(true);
                    }
                }
            }
        });


    }
}
