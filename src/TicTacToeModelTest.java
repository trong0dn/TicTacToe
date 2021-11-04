import static org.junit.Assert.*;

public class TicTacToeModelTest {

    TicTacToeModel ticTacToeModel;

    @org.junit.Before
    public void setUp() throws Exception {
        ticTacToeModel = new TicTacToeModel();
    }

    @org.junit.Test
    public void getStatusForInitialTicTacToe() {
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterFirstMove() {
        ticTacToeModel.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterSecondMove() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterThirdMove() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterPlayingSameMoveTwice() {
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusXWinningFirstColumn() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(0,2);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusXWinningSecondColumn() {
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(1,2);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusXWinningThirdColumn() {
        ticTacToeModel.play(2,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusOWinningFirstColumn() {
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(0,0);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatus0WinningSecondColumn() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(2,0);
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(1,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatus0WinningThirdColumn() {
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(2,0);
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusXWinningForwardDiagonal() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(2,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(1,0);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusXWinningBackwardDiagonal() {
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(0,1);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatus0WinningForwardDiagonal() {
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(2,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatus0WinningBackwardDiagonal() {
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(0,0);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusXWinningFirstRow() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,0);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusXWinningSecondRow() {
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(2,1);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusXWinningThirdRow() {
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatusOWinningFirstRow() {
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(0,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatus0WinningSecondRow() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(2,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,1);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void getStatus0WinningThirdRow() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }
}