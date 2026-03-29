import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PontoonGame game = new PontoonGame();
            game.setVisible(true);
        });
    }
}
