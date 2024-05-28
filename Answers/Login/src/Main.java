import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class Main {
    public static void main(String[] args) {
        FileWorking.copyFileOnUser();
        JFrame frame1 = new JFrame("project");
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("insert your gmail");
        label1.setBounds(225,0,150,30);
        JTextField textField1 =new JTextField("");
        textField1.setBounds(75,0,150,30);
        JLabel label2 = new JLabel("insert password");
        label2.setBounds(225,60,150,30);
        JTextField textField2 = new JTextField("");
        textField2.setBounds(75,60,150,30);
        JButton button1 = new JButton("sign in");
        button1.setBounds(80,250,100,20);
        JButton button2 = new JButton("log in");
        button2.setBounds(190,250,100,20);
        frame1.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                JFrame resframe = new JFrame("result");

                JLabel reslable =new JLabel("");
                reslable.setBounds(130,130,150,30);
                resframe.setSize(400,400);
                resframe.setVisible(true);
                if((Signin.signin(textField1.getText(),textField2.getText())==0)&&(Users.checkGmailFormat(textField1.getText()))&&(Password.checkPassPower(textField2.getText()))){
                    reslable.setText("User created");
                    resframe.add(reslable);
                    JButton finish = new JButton("finish");
                    finish.setBounds(122,160,100,30);
                    resframe.add(finish);
                    finish.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            resframe.setVisible(false);
                            FileWorking.copyUserOnFile();
                            System.exit(0);
                        }
                    });
                    resframe.setLayout(null);
                }
                else{
                    frame1.setVisible(false);
                    reslable.setText("User do not created");
                    reslable.setBounds(130,130,150,30);
                    resframe.add(reslable);
                    resframe.setLayout(null);
                    resframe.setVisible(true);
                    JButton finish = new JButton("finish");
                    finish.setBounds(135,160,100,30);
                    resframe.add(finish);
                    finish.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            resframe.setVisible(false);
                            FileWorking.copyUserOnFile();
                            System.exit(0);
                        }
                    });
                    resframe.setLayout(null);
                    resframe.setVisible(true);
                }

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                JFrame resframe = new JFrame("result");
                resframe.setVisible(true);
                JLabel reslable1 =new JLabel("");
                reslable1.setBounds(140,130,150,30);
                resframe.setSize(400,400);
                try {
                    if((Users.checkUsers(textField1.getText())!=-1)&&(Login.login(textField1.getText(),GFG2.toHexString(GFG2.getSHA(textField2.getText())))== 0)){
                            reslable1.setText("you are in");
                            resframe.add(reslable1);
                            JButton finish = new JButton("finish");
                            finish.setBounds(125,160,100,30);
                            resframe.add(finish);
                            resframe.setLayout(null);
                            resframe.setVisible(true);
                            finish.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    resframe.setVisible(false);
                                    FileWorking.copyUserOnFile();
                                    System.exit(0);
                                }
                            });
                    }
                    else {
                        frame1.setVisible(false);
                        reslable1.setText("you are not in");
                        resframe.setLayout(null);
                        reslable1.setBounds(132,130,150,30);
                        resframe.add(reslable1);
                        JButton finish = new JButton("finish");
                        finish.setBounds(124, 160, 100, 30);
                        resframe.add(finish);
                        finish.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                resframe.setVisible(false);
                                FileWorking.copyUserOnFile();
                                System.exit(0);
                            }
                        });
                    }
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
            });
        frame1.add(button2);
        frame1.add(label1);
        frame1.add(textField1);
        frame1.add(label2);
        frame1.add(textField2);
        frame1.setSize(400,400);
        frame1.setLayout(null);
        frame1.setVisible(true);


    }
}