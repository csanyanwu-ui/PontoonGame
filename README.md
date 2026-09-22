# Pontoon Game

A two-player number game with a Java Swing interface. Players take turns picking numbered tiles from a 5×5 grid, and every pick adds to a running total. **The player who pushes the total over 25 loses.**

## How to Play

1. The board is a 5×5 grid of tiles, each with a random value from **1 to 8**.
2. **Player 1** goes first, and then players take turns.
3. On your turn, click any tile you like. Its value is added to the shared **total**.
   - Player 1's picks turn **red**.
   - Player 2's picks turn **blue**.
   - A tile can only be picked once.
4. If your pick makes the total go **above 25**, you lose and the game ends.
5. Click **New Game** at any time to reset the total and deal a fresh random board.

The status bar at the top shows the current total and whose turn it is.

### Strategy tip
Keep an eye on what's left on the board. When the total gets close to 25, a low tile can save you, and leaving your opponent with only high tiles can force them over.

## Requirements

- Java **8 or later** (JDK). The code uses lambdas, so Java 8 is the minimum.

## Getting Started

Clone the repository and go into the project folder:

```bash
git clone https://github.com/csanyanwu-ui/PontoonGame.git
cd PontoonGame
```

Compile and run:

```bash
javac *.java
java Main
```

A window titled **"Pontoon Game"** will open.

## Project Structure

| File | Description |
|------|-------------|
| `Main.java` | Entry point. Starts the game window on the Swing event thread. |
| `PontoonGame.java` | The main window (`JFrame`). Builds the grid and status bar, and handles turns, the running total, the win/lose check and resetting. |
| `GameButton.java` | A custom `JButton` for each tile. Stores the tile's value, colours it by player when clicked, and resets it for a new game. |

## Built With

- **Java**
- **Swing** (`javax.swing`) for the GUI
- **AWT** (`java.awt`) for layouts and colours

## Possible Future Improvements

- A single-player mode with a computer opponent
- Configurable grid size, tile range and target total
- A score tracker that carries across rounds
- Custom player names
