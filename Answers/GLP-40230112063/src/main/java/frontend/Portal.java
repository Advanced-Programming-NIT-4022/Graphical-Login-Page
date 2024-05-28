package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Portal {
    public Portal() {
        // creating frame
        JFrame frame = new JFrame("Portal Pass");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout()); // Using BorderLayout

        // panel
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBackground(new Color(240, 248, 255)); // Light blue background

        // Format the date and time for the label
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss");

        // creating label
        JLabel dateTime = new JLabel();
        dateTime.setFont(new Font("Serif", Font.PLAIN, 18));
        dateTime.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Timer to update the date and time label
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                dateTime.setText(now.format(formatter));
            }
        });

        timer.start(); // Start the timer

        JLabel welcome = new JLabel("Welcome to the Portal Pass");
        welcome.setFont(new Font("Serif", Font.BOLD, 24));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding

        panel1.add(Box.createVerticalGlue());
        panel1.add(dateTime);
        panel1.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        panel1.add(welcome);
        panel1.add(Box.createVerticalGlue());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel2.setBackground(new Color(240, 248, 255)); // Matching background

        JButton signIn = new JButton("Sign in");
        signIn.setFont(new Font("Serif", Font.PLAIN, 18));
        signIn.setFocusPainted(false);
        signIn.setPreferredSize(new Dimension(120, 40));
        signIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }


            @Override
            public void mouseEntered(MouseEvent e) {
                signIn.setBackground(new Color(46, 90, 90));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signIn.setBackground(new Button().getBackground());
            }
        });

        JButton signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Serif", Font.PLAIN, 18));
        signUp.setFocusPainted(false);
        signUp.setPreferredSize(new Dimension(120, 40));
        signUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                signUp.setBackground(new Color(46, 90, 90));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUp.setBackground(new Button().getBackground());
            }
        });
        panel2.add(signIn);
        panel2.add(signUp);

        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Portal();
    }

}
