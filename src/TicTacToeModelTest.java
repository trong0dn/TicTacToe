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
}