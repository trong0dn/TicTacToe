import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {

    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private int fullBoard;
    private Status status;
    private List<TicTacToeView> views;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();
        fullBoard = 0;
    }

    public void addTicTacToeView(TicTacToeView view) {
        views.add(view);
    }

    public void removeTicTacToeView(TicTacToeView view) {
        views.remove(view);
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {return status;}

    private void updateStatus() {
        fullBoard++;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (status == Status.UNDECIDED) {
                    // Checks for winner by rows
                    if (grid[i][0] == grid[i][SIZE - 2] && grid[i][0] == grid[i][SIZE - 1]) {
                        if (grid[i][0] == 'X') {
                            status = Status.X_WON;
                            System.out.println("X_WON");
                        } else if (grid[i][0] == 'O') {
                            status = Status.O_WON;
                            System.out.println("O_WON");
                        }
                    }
                    // Check for winner by columns
                    else if (grid[0][j] == grid[SIZE - 2][j] && grid[0][j] == grid[SIZE - 1][j]) {
                        if (grid[0][j] == 'X') {
                            status = Status.X_WON;
                            System.out.println("X_WON");
                        } else if (grid[0][j] == 'O') {
                            status = Status.O_WON;
                            System.out.println("O_WON");
                        }
                    }
                }
            }
        }
        if (status == Status.UNDECIDED) {
            // Check for winner by diagonals
            if (grid[0][0] == grid[SIZE - 2][SIZE - 2] && grid[0][0] == grid[SIZE - 1][SIZE - 1]) {
                if (grid[0][0] == 'X') {
                    status = Status.X_WON;
                    System.out.println("X_WON");
                } else if (grid[0][0] == 'O') {
                    status = Status.O_WON;
                    System.out.println("O_WON");
                }
            }
            if (grid[SIZE - 1][0] == grid[SIZE - 2][SIZE - 2] && grid[SIZE - 1][0] == grid[0][SIZE - 1]) {
                if (grid[SIZE - 1][0] == 'X') {
                    status = Status.X_WON;
                    System.out.println("X_WON");
                } else if (grid[SIZE - 1][0] == 'O') {
                    status = Status.O_WON;
                    System.out.println("O_WON");
                }
            }
            // Check for ties
            if (fullBoard == SIZE * SIZE) {
                status = Status.TIE;
                System.out.println("TIE");
            }
        }
    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        updateStatus();
        for (TicTacToeView view: views) {
            view.handleTicTacToeStatusUpdate(new TicTacToeEvent(this, status, x, y));
        }
        changeTurn();
    }
}

