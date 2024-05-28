import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUp extends JFrame {
    JTextField username;
    JLabel title,message,passwordlbl,usernamelbl;
    JTextField password;
    JButton butt;
    public signUp(){
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

        JTextField email=new JTextField("email");
        email.setBounds(260,300,200,40);

        JLabel lblemail=new JLabel("Email");
        lblemail.setBounds(200,300,100,40);
        password.setBounds(260,250,200,40);


        username=new JTextField("");
        username.setBounds(260,200,200,40);;

        butt=new JButton("sign up");
        butt.setBounds(260,400,100,50);
        this.add(password);
        this.add(passwordlbl);
        this.add(usernamelbl);
        this.add(username);
        this.add(butt);
        this.add(email);
        this.add(lblemail);

        this.setVisible(true);
        butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!EmailValidator.emailValidation(email.getText())){
                    JOptionPane.showMessageDialog(null,"enter a valid email");
                }
                else{
                   if(PasswordUtils.Strength(password.getText())==1){
                       JOptionPane.showMessageDialog(null,"weak");
                   }
                    if(PasswordUtils.Strength(password.getText())==2){
                        JOptionPane.showMessageDialog(null,"not so weak");
                    }
                    if(PasswordUtils.Strength(password.getText())==3){
                        JOptionPane.showMessageDialog(null,"medium");
                    }
                    if(PasswordUtils.Strength(password.getText())==4){
                        JOptionPane.showMessageDialog(null,"strong");
                    }
                }
            }
        });
    }
}
