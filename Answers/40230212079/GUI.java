import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
public class GUI {
    JFrame frame1, frame2;
    JButton button1, button2, button3, button4, button5;
    JLabel label1, label2, label3, label4, label5, label6;
    JTextField textfield1, textfield2, textfield3, textfield4,textfield5;

    public GUI (){
        frame1 = new JFrame ("sign in or sign up");
        ImageIcon objImage = new ImageIcon("logo.png.png");
        frame1.setIconImage(objImage.getImage());
        frame1.setBackground(Color.LIGHT_GRAY );
        label1 = new  JLabel ("do not have account : ");
        label2 = new JLabel ("have account : ");
        button1 = new JButton ("click here for register");
        button2 = new JButton ("click here for log in");
        frame1.setSize(550, 400);
        label1.setBounds(50, 100, 200, 50);
        label2.setBounds(50, 200, 200, 50);
        button1.setBounds(300, 100, 200, 50);
        button2.setBounds(300, 200, 200, 50);
        frame1.add(label1);
        frame1.add(label2);
        frame1.add(button1);
        frame1.add(button2);
        label1.setForeground(new Color(70,130,180) );
        label2.setForeground(new Color(70,130,180));
        button1.setForeground(new Color(70, 130, 180) );
        button2.setForeground(new Color(70, 130, 180)  );
        button1.setBackground(new Color(224, 255, 255) );
        button2.setBackground(new Color(224, 255, 255) );
        frame1.setLayout(null);
        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
        frame1.setVisible(true);
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
                frame1.setVisible(false);
                new Login();
            }
        });
    }
}
