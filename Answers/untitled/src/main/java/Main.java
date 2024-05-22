public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginGUI gui = new LoginGUI();
            gui.setVisible(true);
        });
    }
}
