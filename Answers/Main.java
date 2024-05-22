import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Main
{
    JLabel label1 , label2;
    JButton register , login;

    Main()
    {
        JFrame frame = new JFrame("Java Swing Login GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2 , 2));
        panel.setBounds(40,0,300,400);
        panel.setBackground(Color.LIGHT_GRAY);*/

        label1 = new JLabel();
        label1.setText("Register");
        label1.setBounds(25, 50, 100, 100);
        frame.add(label1);

        register= new JButton("Click here");
        register.setBounds(150, 75, 150, 50);
        frame.add(register);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                new Register();
            }
        });
        
        label2 = new JLabel();
        label2.setText("Login");
        label2.setBounds(30, 200, 100, 100);
        frame.add(label2);

        login = new JButton("Click here");
        login.setBounds(150,225,150,50);
        frame.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                new Login(); 
            }
        });

        frame.setLayout(new FlowLayout());
        frame.setSize(400, 400);        
        frame.setLayout(null);
        frame.setVisible(true);
    }

        //working with JPanel is harder than i imagined so i will just use JFrame instead.
    public static void main(String[] args)
    {
        new Main();
    }
}
