import java.util.Scanner;

public class TicTacToes {

    private LinkedList board;  // The board represented by a linked list
    private String currentPlayer;  // Keeps track of current player ('X' or 'O')

    // Constructor to initialize the game
    public TicTacToes() {
        this.board = new LinkedList();
        
        // Initialize the board with empty values ("" represents empty cells)
        for (int i = 1; i <= 9; i++) {
            board.insertAtEnd("");  // Initialize each position on the board as empty
        }

        this.currentPlayer = "X";  // 'X' starts the game
    }

    // Method to switch players
    public void switchPlayer() {
        if (this.currentPlayer.equals("X")) {
            this.currentPlayer = "O";
        } else {
            this.currentPlayer = "X";
        }
    }

    // Method to play the game
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!board.isBoardFull() && !gameWon) {
            board.displayBoard();
            System.out.println("Player " + this.currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            // Validate move and update board
            if (move >= 1 && move <= 9 && board.getPositionValue(move).equals("")) {
                board.updatePosition(move, this.currentPlayer);
                gameWon = board.checkWinCondition();

                if (!gameWon) {
                    if (board.isBoardFull()) {
                        // If the board is full after the last move and no win, declare draw
                        break;
                    } else {
                        switchPlayer();  // Switch players if the game isn't won or drawn
                    }
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        board.displayBoard();

        if (gameWon) {
            System.out.println("Player " + this.currentPlayer + " wins!");
        } else if (board.isBoardFull()) {
            System.out.println("It's a draw!");
        }
    }

    public static void main(String[] args) {
        TicTacToes game = new TicTacToes();
        game.playGame();
    }
}
