import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    Entry entry = new Entry();
    Storage storage = new Storage();
    String userNAME;
    String emailADDRESS;
    String passWORD;
    JPanel panelUp;
    JPanel panelIn;
    JButton signUp;
    JButton signIn;
    JButton insert1;
    JButton insert2;
    JButton cancel1;
    JButton cancel2;
    JTextField tUserName;
    JTextField tEmail;
    JTextField tPassword;
    JTextField t2UserName;
    JTextField t2Password;
    JLabel errorUp;
    JLabel errorIn;
    JFrame welcome;
    public void panelUpEnabled(boolean answear) {
        panelUp.setVisible(answear);
        tUserName.setEnabled(answear);
        tEmail.setEnabled(answear);
        tPassword.setEnabled(answear);
        insert1.setEnabled(answear);
        insert1.setVisible(answear);
        cancel1.setEnabled(answear);
        cancel1.setVisible(answear);
    }
    public void panelInEnabled(boolean answear) {
        panelIn.setVisible(answear);
        t2UserName.setEnabled(answear);
        t2Password.setEnabled(answear);
        insert2.setEnabled(answear);
        insert2.setVisible(answear);
        cancel2.setEnabled(answear);
        cancel2.setVisible(answear);
    }
    GUI() {
        signUp = new JButton("Sign Up");
        signUp.setBounds(150,100,200,100);
        signUp.setFocusable(false);
        ImageIcon signUpIcon = new ImageIcon("signUp.png");
        signUp.setIcon(signUpIcon);
        signUp.setBackground(Color.white);
        signUp.addActionListener(this);

        signIn = new JButton("Sign In");
        signIn.setBounds(450,100,200,100);
        signIn.setFocusable(false);
        ImageIcon signInIcon = new ImageIcon("signIn.png");
        signIn.setIcon(signInIcon);
        signIn.setBackground(Color.white);
        signIn.addActionListener(this);

        panelUp = new JPanel();
        panelUp.setBackground(Color.lightGray);
        panelUp.setBounds(250,300,300,250);
        panelUp.setLayout(new BoxLayout(panelUp,BoxLayout.PAGE_AXIS));
        JLabel nameUp = new JLabel("Username :");
        JLabel emailUp = new JLabel("Email address :");
        JLabel passwordUp = new JLabel("Password :");
        errorUp = new JLabel();
        tUserName = new JTextField();
        tEmail = new JTextField();
        tPassword = new JTextField();
        insert1 = new JButton("Insert");
        insert1.setBounds(250,550,80,50);
        insert1.addActionListener(this);
        insert1.setVisible(false);
        cancel1 = new JButton("Cancel");
        cancel1.setBounds(470,550,80,50);
        cancel1.addActionListener(this);
        cancel1.setVisible(false);
        panelUp.add(nameUp);
        panelUp.add(tUserName);
        panelUp.add(emailUp);
        panelUp.add(tEmail);
        panelUp.add(passwordUp);
        panelUp.add(tPassword);
        panelUp.add(errorUp);
        panelUpEnabled(false);
        panelUp.setVisible(false);

        panelIn = new JPanel();
        panelIn.setBackground(Color.lightGray);
        panelIn.setBounds(250,300,300,250);
        panelIn.setLayout(new BoxLayout(panelIn,BoxLayout.PAGE_AXIS));
        JLabel nameIn = new JLabel("Username :");
        JLabel passwordIn = new JLabel("Password :");
        errorIn = new JLabel();
        t2UserName = new JTextField();
        t2Password = new JTextField();
        insert2 = new JButton("Insert");
        insert2.setBounds(250,550,80,50);
        insert2.addActionListener(this);
        insert2.setVisible(false);
        cancel2 = new JButton("Cancel");
        cancel2.setBounds(470,550,80,50);
        cancel2.addActionListener(this);
        cancel2.setVisible(false);
        panelIn.add(nameIn);
        panelIn.add(t2UserName);
        panelIn.add(passwordIn);
        panelIn.add(t2Password);
        panelIn.add(errorIn);
        panelInEnabled(false);
        panelIn.setVisible(false);

        JLabel welCome = new JLabel("Welcome");
        welCome.setBounds(300,25,100,50);
        welcome = new JFrame("welcome");
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setLayout(null);
        welcome.setSize(800,100);
        welcome.setVisible(false);
        welcome.setResizable(false);
        welcome.add(welCome);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800,800);
        this.setVisible(true);
        this.setResizable(false);
        this.add(signUp);
        this.add(signIn);
        this.add(panelUp);
        this.add(panelIn);
        this.add(insert1);
        this.add(insert2);
        this.add(cancel1);
        this.add(cancel2);
    }
    public boolean getInfo() {
        boolean answear = true;
        do {
            try {
                userNAME = tUserName.getText();
            } catch (Exception e) {
                System.out.println("error : failed to get name");
            }
            if (userNAME.isEmpty() || userNAME.contains(" ") || entry.tem.name_email.containsKey(userNAME)) {
                answear = false;
                errorUp.setText("Username not acceptable");
                break;
            }
            try {
                emailADDRESS = tEmail.getText();
            } catch (Exception e) {
                System.out.println("error : failed to get email");
            }
            if (!entry.checkEmail(emailADDRESS) || entry.tem.name_email.containsValue(emailADDRESS)) {
                answear = false;
                errorUp.setText("Email address not acceptable");
                break;
            }
            try {
                passWORD = tPassword.getText();
            } catch (Exception e) {
                System.out.println("error : failed to get password");
            }
            if (passWORD.isEmpty() || !entry.checkPassword(passWORD)) {
                answear = false;
                errorUp.setText("Password not acceptable");
                break;
            }
            break;
        }while (true);
        return answear;
    }
    public boolean checkInfo() {
        boolean answear = true;
        do {
            try {
                userNAME = t2UserName.getText();
            } catch (Exception e) {
                System.out.println("error : failed to get name");
            }
            if (!entry.tem.name_password.containsKey(userNAME)) {
                answear = false;
                errorIn.setText("Username does not exist");
                break;
            }
            try {
                passWORD = t2Password.getText();
            } catch (Exception e) {
                System.out.println("error : failed to get password");
            }
            if (!entry.checkPassword(passWORD) || !entry.tem.name_password.get(userNAME).equals(entry.passwordEncoder(passWORD))) {
                answear = false;
                errorIn.setText("Incorrect password");
                break;
            }
            break;
        }while (true);
        return answear;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUp) {
            panelUpEnabled(true);
            signIn.setEnabled(false);
            signUp.setEnabled(false);
        } else if (e.getSource() == signIn) {
            panelInEnabled(true);
            signIn.setEnabled(false);
            signUp.setEnabled(false);
        } else if (e.getSource() == cancel1) {
            panelUpEnabled(false);
            signIn.setEnabled(true);
            signUp.setEnabled(true);
            tUserName.setText("");
            tEmail.setText("");
            tPassword.setText("");
            errorUp.setText("");
        } else if (e.getSource() == cancel2) {
            panelInEnabled(false);
            signIn.setEnabled(true);
            signUp.setEnabled(true);
            t2UserName.setText("");
            t2Password.setText("");
            errorIn.setText("");
        } else if (e.getSource() == insert1) {
            if (getInfo()) {
                storage.fileEntry(userNAME,emailADDRESS,entry.passwordEncoder(passWORD));
                panelUpEnabled(false);
                signIn.setEnabled(true);
                signUp.setEnabled(true);
                JOptionPane.showMessageDialog(null,"You've signed up successfully.\nPassword strength : level " + entry.evaluatePassword(passWORD),"Attention",JOptionPane.PLAIN_MESSAGE);
                tUserName.setText("");
                tEmail.setText("");
                tPassword.setText("");
            }
        } else if (e.getSource() == insert2) {
            if (checkInfo()) {
                welcome.setVisible(true);
                t2UserName.setText("");
                t2Password.setText("");
            this.setVisible(false);
            }
        }
    }
}
