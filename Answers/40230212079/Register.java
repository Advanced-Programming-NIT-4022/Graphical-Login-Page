import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.*;
public class Register {
    String str;
    int GmailValid;
    int  UsernameValid;
    int  PasswordValid;
    String Username , Gmail , Password;
    JFrame frame1, frame2;
    JButton button1, button2, button3,button4;
    JLabel label1, label2, label3 , label4 , label5 , label6, label7;
    JTextField textfield1, textfield2, textfield3 ;
    JPasswordField password;
    JCheckBox checkbox;
    public Register(){
        frame1 = new JFrame("register");
        ImageIcon objImage = new ImageIcon("logo.png.png");
        frame1.setIconImage(objImage.getImage());
        label1 = new  JLabel("Username : ");
        label2 = new  JLabel("Password : ");
        label3 = new  JLabel("Gmail : ");
        textfield1 = new JTextField();
        password = new JPasswordField() ;
        checkbox = new JCheckBox("Show Password") ;
        textfield3 = new JTextField();
        button1 = new JButton("check username");
        button2 = new JButton("check Password");
        button3 = new JButton("check Gmail");
        button4 = new JButton("register");
        frame1.setSize(1000, 700);
        label1.setBounds(50, 100, 75, 50);
        label2.setBounds(50, 150, 75, 50);
        label3.setBounds(50, 350, 75, 50);
        textfield1.setBounds(300, 100, 200, 50);
        password.setBounds(300, 150, 200, 50);
        checkbox.setBounds(500, 150, 150, 40);
        textfield3.setBounds(300, 350, 200, 50);
        button1.setBounds(750, 100, 150, 50);
        button2.setBounds(750, 150, 150, 50);
        button3.setBounds(750, 350, 150, 50);
        button4.setBounds(650, 550, 250, 50);
        label1.setForeground(new Color(70,130,180) );
        label2.setForeground(new Color(70,130,180));
        label3.setForeground(new Color(70,130,180) );
        button1.setForeground(new Color(70, 130, 180) );
        button2.setForeground(new Color(70, 130, 180)  );
        button3.setForeground(new Color(70, 130, 180) );
        button4.setForeground(new Color(218, 112, 214)  );
        button1.setBackground(new Color(224, 255, 255) );
        button2.setBackground(new Color(224, 255, 255) );
        button3.setBackground(new Color(224, 255, 255) );
        button4.setBackground(new Color(230, 230, 250) );
        button4.setFont(new Font("serif", Font.BOLD, 35));
        frame1.add(label1);
        frame1.add(label2);
        frame1.add(label3);
        frame1.add(button1);
        frame1.add(button2);
        frame1.add(button3);
        frame1.add(button4);
        frame1.add(textfield1);
        frame1.add(password);
        frame1.add(checkbox);
        frame1.add(textfield3);
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
                Username = textfield1.getText();
                UsernameValid objUsernameValid = new  UsernameValid();
                UsernameValid = objUsernameValid.usernamevalid(Username);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Password = new String(password.getPassword());
                PasswordValid objPasswordValid = new PasswordValid();
                PasswordValid = objPasswordValid.passwordvalid(Password);
                if(PasswordValid>0){
                    label7 = new  JLabel(" the level of your password is :  "+ PasswordValid+" and it is correct .");
                    label7.setBounds(50, 200, 700, 100);
                    label7.setFont(new Font("serif", Font.BOLD, 25));
                    label7.setForeground(new Color(255, 69, 0) );
                    frame1.add(label7);
                    frame1.setSize(1010,710);
                    frame1.setLayout(null);
                    frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
                    frame1.setVisible(true);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gmail = textfield3.getText();
                GmailValid objGmailValid = new GmailValid();
                GmailValid = objGmailValid.gmailvalid(Gmail);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PasswordValid>=1 && GmailValid==1 && UsernameValid==1){
                    User objuser = new User(Username, Gmail, Password);
                    UserStore objuserstore = new UserStore();
                    objuserstore.SaveInformation(objuser);
                    frame1.setVisible(false);
                    frame2 = new JFrame();
                    ImageIcon objImage = new ImageIcon("logo.png.png");
                    frame2.setIconImage(objImage.getImage());
                    frame2.setSize(500, 400);
                    label6 = new  JLabel("WELCOME !!! ");
                    label6.setBounds(150, 125, 300, 100);
                    label6.setFont(new Font("serif", Font.BOLD, 25));
                    label6.setForeground(new Color(70, 130, 180) );
                    frame2.add(label6);
                    frame2.setLayout(null);
                    frame2.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
                    frame2.setVisible(true);
                }
                else{
                    label4 = new JLabel("wrong entry");
                    label4.setBounds(50, 400, 300, 100);
                    label4.setFont(new Font("serif", Font.BOLD, 30));
                    label4.setForeground(new Color(255, 69, 0) );
                    frame1.add(label4);
                    if(PasswordValid==0){
                        str="your Password is wrong , Try again :)";
                    }
                    else if(PasswordValid==0 && GmailValid==0){
                        str="Gmail and Password is wrong , Try again :)";
                    }
                    else if(PasswordValid==0 && UsernameValid==0){
                        str="Username and Password is wrong , Try again :)";
                    }
                    else if(PasswordValid==0 && GmailValid==0 && UsernameValid==0){
                        str="Gmail and Password and username is wrong , Try again :)";
                    }
                    else if(GmailValid==0){
                        str="your Gmail is wrong , Try again :)";
                    }
                    else if(GmailValid==0 && UsernameValid==0){
                        str="your Gmail and username is wrong";
                    }
                    else if(UsernameValid==0){
                        str="your Username is wrong , Try again :)";
                    }
                    label5 = new  JLabel(" ");
                    label5 = new  JLabel(str);
                    label5.setFont(new Font("serif", Font.BOLD, 25));
                    label5.setBounds(50, 550, 600, 150);
                    label5.setForeground(new Color(255, 69, 0) );
                    frame1.add(label5);
                    frame1.setSize(1015,715);
                    frame1.setLayout(null);
                    frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
                    frame1.setVisible(true);
                }
            }
        });

    }
}
