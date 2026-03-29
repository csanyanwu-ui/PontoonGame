import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PontoonGame extends JFrame {
    private GameButton[][] buttons = new GameButton[5][5];
    private JButton newGameButton;
    private JLabel statusLabel;
    private int total = 0;
    private boolean playerOneTurn = true;
    private Random random = new Random();

    public PontoonGame() {
        setTitle("Pontoon Game");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        newGameButton = new JButton("New Game");
        statusLabel = new JLabel("Total: 0 | Player 1's turn", SwingConstants.CENTER);
        topPanel.add(newGameButton, BorderLayout.WEST);
        topPanel.add(statusLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Grid
        JPanel gridPanel = new JPanel(new GridLayout(5, 5));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int value = random.nextInt(8) + 1; // 1–8
                GameButton button = new GameButton(value);
                buttons[i][j] = button;

                button.addActionListener(e -> handleClick(button));
                gridPanel.add(button);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        // New game button
        newGameButton.addActionListener(e -> resetGame());
    }

    private void resetGame() {
        total = 0;
        playerOneTurn = true;
        statusLabel.setText("Total: 0 | Player 1's turn");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int value = random.nextInt(8) + 1;
                buttons[i][j].reset(value);
            }
        }
    }

    private void handleClick(GameButton button) {
        int value = button.getValue();
        total += value;
        button.markClicked(playerOneTurn);

        if (total > 25) {
            String loser = playerOneTurn ? "Player 1" : "Player 2";
            statusLabel.setText(loser + " loses! (Total = " + total + ")");
            disableAllButtons();
            return;
        }

        playerOneTurn = !playerOneTurn;
        String currentPlayer = playerOneTurn ? "Player 1" : "Player 2";
        statusLabel.setText("Total: " + total + " | " + currentPlayer + "'s turn");
    }

    private void disableAllButtons() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}

