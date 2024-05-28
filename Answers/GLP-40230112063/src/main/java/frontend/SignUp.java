package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class SignUp {

    SignUp() {
        // Creating new frame
        JFrame frame = new JFrame("Sign in Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);  // Adjusted size
        frame.setLayout(new BorderLayout());

        // Creating panel1 with BoxLayout (Y_AXIS) for displaying date/time and prompt
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBackground(new Color(230, 230, 250));  // Light lavender background color

        // Format the date and time for the label
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss");

        // Creating label for date/time
        JLabel dateTime = new JLabel();
        dateTime.setFont(new Font("Serif", Font.BOLD, 20));  // Updated font and size
        dateTime.setForeground(new Color(72, 61, 139));  // Dark slate blue color
        dateTime.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Timer to update the date and time label
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                dateTime.setText(now.format(formatter));
            }
        });
        timer.start();

        // Creating label for the prompt
        JLabel prompt = new JLabel("Enter your Username and Password to Sign In");
        prompt.setFont(new Font("Arial", Font.BOLD, 24));  // Updated font and size
        prompt.setForeground(new Color(0, 100, 0));  // Dark green color
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        prompt.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Padding

        // Adding components to panel1
        panel1.add(Box.createVerticalGlue());
        panel1.add(dateTime);
        panel1.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        panel1.add(prompt);
        panel1.add(Box.createVerticalGlue());

        // Creating panel2 with GridBagLayout for the form
        JPanel panel2 = new JPanel(new GridBagLayout());
        panel2.setBackground(new Color(255, 239, 213));  // Light peach background color
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Creating and adding components to panel2
        JLabel userNameLabel = new JLabel("Username: ");
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        userNameLabel.setForeground(new Color(105, 105, 105));  // Dim gray color

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setForeground(new Color(105, 105, 105));  // Dim gray color

        JTextField usernameTextField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel2.add(userNameLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(usernameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel2.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(passwordField, gbc);

        // Creating Sign In button
        JButton signInButton = new JButton("Sign In");
        signInButton.setFont(new Font("Arial", Font.BOLD, 18));
        signInButton.setBackground(new Color(72, 209, 204));  // Medium turquoise color
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel2.add(signInButton, gbc);

        // Creating a wrapper panel with BorderLayout to center the form
        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(panel2, BorderLayout.CENTER);
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40)); // Padding around the form

        // Adding panels to the frame
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(wrapperPanel, BorderLayout.CENTER);

        // Making the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }
}


//Summary:
//VerticalGlue: Creates flexible space that helps center the components vertically.
//RigidArea: Creates a fixed amount of space between components.
//BoxLayout.Y_AXIS: Ensures components are laid out vertically from top to bottom.
//Effect: The combination of these elements results in a vertically centered and well-spaced arrangement of dateTime and welcome labels within panel1.