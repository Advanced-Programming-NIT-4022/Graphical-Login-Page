import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guirunner {
    public void welcomegui() {
        JFrame wf=new JFrame("welcome");
        wf.setSize(300,300);
        wf.setResizable(false);
        wf.setLayout(new FlowLayout());
        JLabel wl=new JLabel("welcome!",JLabel.CENTER);
        wl.setForeground(Color.GREEN);
        wf.add(wl);
        wf.setVisible(true);
    }
    public void runner() {
        Passlevel pvl=new Passlevel();
        User uo=new User();
        Emailtest emobj=new Emailtest();
        JFrame ff=new JFrame("choose a way to login");
        JPanel fp=new JPanel();
        fp.setBackground(Color.cyan);
        fp.setLayout(new FlowLayout());
        ff.setResizable(false);
        JButton reg=new JButton("register");
        JButton log=new JButton("login");
        reg.setBackground(Color.green);
        log.setBackground(Color.orange);
        fp.add(reg);
        fp.add(log);
        ff.add(fp);
        ff.setSize(400,400);
        ff.setVisible(true);
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame freg=new JFrame("register");
                freg.setSize(300,300);
                freg.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                freg.setLocationRelativeTo(null);
                JPanel p=new JPanel();
                p.setBackground(Color.green);
                p.setLayout(new GridBagLayout());
                JLabel labu=new JLabel("enter a user name");
                GridBagConstraints lu=new GridBagConstraints();
                lu.gridx=0;
                lu.gridy=0;
                JTextField txtu=new JTextField(16);
                GridBagConstraints tu=new GridBagConstraints();
                tu.gridx=1;
                tu.gridy=0;
                p.add(labu,lu);
                p.add(txtu,tu);
                JLabel labem=new JLabel("enter an email");
                GridBagConstraints lem=new GridBagConstraints();
                lem.gridx=0;
                lem.gridy=1;
                JTextField txtem=new JTextField(16);
                GridBagConstraints tem=new GridBagConstraints();
                tem.gridx=1;
                tem.gridy=1;
                p.add(labem,lem);
                p.add(txtem,tem);
                JLabel labp=new JLabel("enter a password");
                GridBagConstraints lp=new GridBagConstraints();
                lp.gridx=0;
                lp.gridy=2;
                JPasswordField txtp=new JPasswordField(16);
                GridBagConstraints tp=new GridBagConstraints();
                tp.gridx=1;
                tp.gridy=2;
                p.add(labp,lp);
                p.add(txtp,tp);
                JPanel bp=new JPanel();
                bp.setBackground(Color.green);
                JButton b=new JButton("login");
                b.setBackground(Color.yellow);
                bp.add(b);
                freg.setLayout(new GridLayout(2,1));
                freg.add(p);
                freg.add(bp);
                freg.setVisible(true);
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String uname=txtu.getText();
                        String email=txtem.getText();
                        char[] passw=txtp.getPassword();
                        String pasr=String.valueOf(passw);
                        int pslv=pvl.paslvl(pasr);
                        String hashedp= pvl.hashmaker(pasr);
                        if (emobj.Evalid(email)==false) {
                            System.out.println("email is invalid! try again!");
                            txtem.setText("");
                        } else if (uo.checktheinfo(uname,hashedp,email)) {
                            System.out.println("this user already exists!");
                        } else {
                            System.out.println("password level: "+pslv);
                            uo.regist(uname,hashedp,email);
                            welcomegui();
                        }
                    }
                });
            }
        });
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame flog = new JFrame("login");
                flog.setSize(300, 300);
                flog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                flog.setLocationRelativeTo(null);
                JPanel p2 = new JPanel();
                p2.setBackground(Color.orange);
                p2.setLayout(new GridBagLayout());
                JLabel labu2 = new JLabel("enter a user name");
                GridBagConstraints lu2 = new GridBagConstraints();
                lu2.gridx = 0;
                lu2.gridy = 0;
                JTextField txtu2 = new JTextField(16);
                GridBagConstraints tu2 = new GridBagConstraints();
                tu2.gridx = 1;
                tu2.gridy = 0;
                p2.add(labu2, lu2);
                p2.add(txtu2, tu2);
                JLabel labem2 = new JLabel("enter an email");
                GridBagConstraints lem2 = new GridBagConstraints();
                lem2.gridx = 0;
                lem2.gridy = 1;
                JTextField txtem2 = new JTextField(16);
                GridBagConstraints tem2 = new GridBagConstraints();
                tem2.gridx = 1;
                tem2.gridy = 1;
                p2.add(labem2, lem2);
                p2.add(txtem2, tem2);
                JLabel labp = new JLabel("enter a password");
                GridBagConstraints lp = new GridBagConstraints();
                lp.gridx = 0;
                lp.gridy = 2;
                JPasswordField txtp2 = new JPasswordField(16);
                GridBagConstraints tp2 = new GridBagConstraints();
                tp2.gridx = 1;
                tp2.gridy = 2;
                p2.add(labp, lp);
                p2.add(txtp2, tp2);
                JPanel bp2 = new JPanel();
                bp2.setBackground(Color.orange);
                JButton b2 = new JButton("login");
                b2.setBackground(Color.yellow);
                bp2.add(b2);
                flog.setLayout(new GridLayout(2, 1));
                flog.add(p2);
                flog.add(bp2);
                flog.setVisible(true);
                b2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String unamea = txtu2.getText();
                        String emaila = txtem2.getText();
                        char[] passwa = txtp2.getPassword();
                        String pasra = String.valueOf(passwa);
                        int pslva = pvl.paslvl(pasra);
                        String hashedpa = pvl.hashmaker(pasra);
                        if (emobj.Evalid(emaila) == false) {
                            System.out.println("email is invalid! try again!");
                            txtem2.setText("");
                        } else if (uo.checktheinfo(unamea, hashedpa, emaila)==false) {
                            System.out.println("this user doesnt exist!");
                        } else {
                            System.out.println("password level: " + pslva);
                            uo.regist(unamea, hashedpa, emaila);
                            welcomegui();
                        }
                    }
                });
            }
        });
    }
}