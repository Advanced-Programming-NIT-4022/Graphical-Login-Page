import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class StartUp extends JFrame {
    private JPasswordField password;
    JMenu login,register;
    JTextField username;
    JLabel title,message,passwordlbl,usernamelbl;
    JButton butt;
    public StartUp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setTitle("GUI");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        password=new JPasswordField();



        passwordlbl=new JLabel("Password");
        passwordlbl.setBounds(200,250,100,40);

        usernamelbl=new JLabel("Username");
        usernamelbl.setBounds(200,200,100,40);

        password.setBounds(260,250,200,40);


        username=new JTextField("");
        username.setBounds(260,200,200,40);;

        butt=new JButton("sign in");
        butt.setBounds(260,300,100,50);



        JButton butt2=new JButton("sign up");
        butt2.setBounds(350,300,100,50);
        this.add(butt2);
        this.add(password);
        this.add(passwordlbl);
        this.add(usernamelbl);
        this.add(username);
        this.add(butt);



        this.setVisible(true);
        butt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartUp.super.dispose();
                new signUp();
            }
        });
        butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            User user=new User();
                try {

                   if(user.searchuser(username.getText(),PasswordUtils.hashing(password.getText()))){
                       JOptionPane.showMessageDialog(null, "welcome!");
                   }else{
                       JOptionPane.showMessageDialog(null, "not found!");
                   }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
