import java.util.Scanner;

public class TicTacToe {

    // Display the game board
    public static void displayBoard(String[] board) {
        System.out.println("""
             %s | %s | %s
            ---|---|---
             %s | %s | %s
            ---|---|---
             %s | %s | %s
            """.formatted(
                board[0], board[1], board[2],
                board[3], board[4], board[5],
                board[6], board[7], board[8]
            ));
    }

    // Check for a win
    public static boolean checkWinner(String[] board, String player) {
        int[][] winCombinations = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] combo : winCombinations) {
            if (board[combo[0]].equals(player) &&
                board[combo[1]].equals(player) &&
                board[combo[2]].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Check for a draw
    public static boolean checkDraw(String[] board) {
        for (String cell : board) {
            if (cell.equals(" ")) {
                return false;
            }
        }
        return true;
    }

    // Main game loop
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        String[] board = {" ", " ", " ", " ", " ", " ", " ", " ", " "}; // Empty board
        String currentPlayer = "X"; // Player X goes first

        System.out.println("Welcome to Tic Tac Toe!");
        displayBoard(board);

        while (true) {
            try {
                // Player move
                System.out.print("Player " + currentPlayer + ", choose your position (1-9): ");
                int position = scanner.nextInt() - 1;

                if (position < 0 || position > 8 || !board[position].equals(" ")) {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }

                // Update board
                board[position] = currentPlayer;
                displayBoard(board);

                // Check for winner or draw
                if (checkWinner(board, currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (checkDraw(board)) {
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch player
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";

            } catch (Exception e) {
                System.out.println("Please enter a valid number between 1 and 9.");
                scanner.next(); // Clear invalid input
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}
/*The Tic Tac Toe algorithm implemented in the given code is a console-based representation of the game, which involves two players alternating their moves until one of them wins or the game ends in a draw. The game board is represented as a one-dimensional array with nine positions, corresponding to the 3x3 grid of the game. Each position on the board can either be empty, marked with an "X," or marked with an "O."

The program begins by initializing an empty board and setting the first player as "X." A game loop then facilitates the gameplay by displaying the current state of the board, prompting the player for their move, and validating the input. Input validation ensures that the player selects a position within the valid range (1–9) and that the chosen position is not already occupied. Invalid moves are rejected with an appropriate message, and the player is prompted to try again.

Once a valid move is made, the board is updated, and the program checks for a winning condition or a draw. Winning conditions are pre-defined combinations of three positions that align horizontally, vertically, or diagonally. The program iterates through these combinations to check if the current player has occupied all three positions in any of them. If a winning combination is detected, the game announces the winner and terminates. If no winner is found and the board is completely filled, the game ends in a draw.

If neither a win nor a draw occurs, the program switches the turn to the other player, alternating between "X" and "O." The game loop continues until one of the termination conditions is met. Input errors, such as entering non-numeric values, are handled using exception handling to prevent the program from crashing and allow the player to retry.

This implementation captures the basic mechanics of Tic Tac Toe and provides a simple yet effective way for two players to compete in the game. */