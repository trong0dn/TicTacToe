import static org.junit.Assert.*;

public class TicTacToeModelTest {

    TicTacToeModel ticTacToeModel;

    @org.junit.Before
    public void setUp() {
        ticTacToeModel = new TicTacToeModel();
    }

    @org.junit.Test
    public void testGetStatusForInitialTicTacToe() {
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusAfterFirstMove() {
        ticTacToeModel.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusAfterSecondMove() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(1,1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusAfterThirdMove() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusAfterFourthMove() {
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(0,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusAfterPlayingSameMoveTwice() {
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.UNDECIDED, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusXWinningFirstColumn() {
        ticTacToeModel.play(0,0);       // X |   |
        ticTacToeModel.play(1,1);       // X | O |
        ticTacToeModel.play(0,1);       // X |   | O
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(0,2);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusXWinningSecondColumn() {
        ticTacToeModel.play(1,0);       //   | X |
        ticTacToeModel.play(0,1);       // O | X |
        ticTacToeModel.play(1,1);       //   | X | O
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(1,2);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusXWinningThirdColumn() {
        ticTacToeModel.play(2,0);       //   |   | X
        ticTacToeModel.play(1,1);       //   | O | X
        ticTacToeModel.play(2,1);       //   | O | X
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusOWinningFirstColumn() {
        ticTacToeModel.play(1,1);       // O |   |
        ticTacToeModel.play(0,1);       // O | X | X
        ticTacToeModel.play(2,1);       // O |   | X
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(0,0);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatus0WinningSecondColumn() {
        ticTacToeModel.play(0,0);       // X | O | X
        ticTacToeModel.play(1,1);       //   | O |
        ticTacToeModel.play(2,0);       //   | O | X
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(1,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatus0WinningThirdColumn() {
        ticTacToeModel.play(1,1);       // X |   | O
        ticTacToeModel.play(2,0);       //   | X | O
        ticTacToeModel.play(0,0);       //   | X | O
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusXWinningBackwardDiagonal() {
        ticTacToeModel.play(0,0);       // X |   | O
        ticTacToeModel.play(2,0);       //   | X |
        ticTacToeModel.play(1,1);       // O |   | X
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusXWinningForwardDiagonal() {
        ticTacToeModel.play(0,2);       //   | O | X
        ticTacToeModel.play(2,1);       //   | X |
        ticTacToeModel.play(1,1);       // X | O |
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(2,0);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatus0WinningBackwardDiagonal() {
        ticTacToeModel.play(1,0);       // O | X | X
        ticTacToeModel.play(0,0);       //   | O |
        ticTacToeModel.play(2,0);       // X |   | O
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatus0WinningForwardDiagonal() {
        ticTacToeModel.play(0,1);       //   |   | O
        ticTacToeModel.play(0,2);       // X | O | X
        ticTacToeModel.play(2,1);       // O | X |
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(2,0);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusXWinningFirstRow() {
        ticTacToeModel.play(0,0);       // X | X | X
        ticTacToeModel.play(1,1);       //   | O |
        ticTacToeModel.play(1,0);       //   |   | O
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,0);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusXWinningSecondRow() {
        ticTacToeModel.play(0,1);       //   | O |
        ticTacToeModel.play(2,2);       // X | X | X
        ticTacToeModel.play(1,1);       //   |   | O
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(2,1);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusXWinningThirdRow() {
        ticTacToeModel.play(0,2);       //   | O |
        ticTacToeModel.play(1,1);       //   | O |
        ticTacToeModel.play(1,2);       // X | X | X
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.X_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusOWinningFirstRow() {
        ticTacToeModel.play(1,1);       // O | O | O
        ticTacToeModel.play(0,0);       //   | X | X
        ticTacToeModel.play(2,1);       //   |   | X
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(0,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatus0WinningSecondRow() {
        ticTacToeModel.play(0,0);       // X |   | X
        ticTacToeModel.play(0,1);       // O | O | O
        ticTacToeModel.play(2,0);       //   |   | X
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,1);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatus0WinningThirdRow() {
        ticTacToeModel.play(0,0);       // X | X |
        ticTacToeModel.play(0,2);       //   | X |
        ticTacToeModel.play(1,1);       // O | O | O
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(2,2);
        assertEquals(TicTacToeModel.Status.O_WON, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusTie1() {
        ticTacToeModel.play(0,0);       // X | O | X
        ticTacToeModel.play(1,0);       // O | X | X
        ticTacToeModel.play(2,0);       // O | X | O
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(1,1);
        assertEquals(TicTacToeModel.Status.TIE, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusTie2() {
        ticTacToeModel.play(0,0);       // X | O | X
        ticTacToeModel.play(1,1);       // X | O | X
        ticTacToeModel.play(0,1);       // O | X | O
        ticTacToeModel.play(0,2);
        ticTacToeModel.play(2,0);
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,1);
        assertEquals(TicTacToeModel.Status.TIE, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusTie3() {
        ticTacToeModel.play(2,2);       // O | X | O
        ticTacToeModel.play(1,2);       // O | X | X
        ticTacToeModel.play(1,1);       // X | O | X
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(2,0);
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(0,2);
        assertEquals(TicTacToeModel.Status.TIE, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusTie4() {
        ticTacToeModel.play(1,2);       // X | O | O
        ticTacToeModel.play(2,0);       // O | X | X
        ticTacToeModel.play(1,1);       // X | X | O
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(0,0);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(1,0);
        ticTacToeModel.play(0,2);
        assertEquals(TicTacToeModel.Status.TIE, ticTacToeModel.getStatus());
    }

    @org.junit.Test
    public void testGetStatusTie5() {
        ticTacToeModel.play(1,0);       // O | X | X
        ticTacToeModel.play(0,0);       // X | O | O
        ticTacToeModel.play(0,2);       // X | O | X
        ticTacToeModel.play(1,2);
        ticTacToeModel.play(2,2);
        ticTacToeModel.play(1,1);
        ticTacToeModel.play(0,1);
        ticTacToeModel.play(2,1);
        ticTacToeModel.play(2,0);
        assertEquals(TicTacToeModel.Status.TIE, ticTacToeModel.getStatus());
    }
}