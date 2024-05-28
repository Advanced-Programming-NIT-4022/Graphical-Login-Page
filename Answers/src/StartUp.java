import javax.swing.*;

public class StartUp extends JFrame {
    private JPasswordField password;
    public StartUp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setTitle("GUI");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        password=new JPasswordField();
        this.add(password);
        this.setVisible(true);
    }
}
