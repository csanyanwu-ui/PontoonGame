import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    private int value;
    private boolean clicked = false;

    public GameButton(int value) {
        this.value = value;
        setText(String.valueOf(value));
        setFont(new Font("Arial", Font.BOLD, 20));
        setFocusPainted(false);
        setOpaque(true);            // allow background to show
        setBorderPainted(true);     // keep button borders
    }

    public int getValue() {
        return value;
    }

    public void markClicked(boolean playerOneTurn) {
        clicked = true;
        setEnabled(false);
        setOpaque(true);
        setBorderPainted(true);
        setBackground(playerOneTurn ? Color.RED : Color.BLUE);
        setForeground(Color.WHITE); // makes numbers visible
    }

    public void reset(int newValue) {
        this.value = newValue;
        setText(String.valueOf(newValue));
        setBackground(null);
        setForeground(Color.BLACK);
        setEnabled(true);
        clicked = false;
    }
}
