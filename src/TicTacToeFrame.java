import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements TicTacToeView {

    private JButton[][] buttons;

    public TicTacToeFrame() {
        super("Tic Tac Toe!");
        this.setLayout(new GridLayout(TicTacToeModel.SIZE,TicTacToeModel.SIZE));
        TicTacToeModel model = new TicTacToeModel();

        model.addTicTacToeView(this);

        //TicTacToeController ticTacToeController = new TicTacToeController(model);

        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];
        for (int i = 0; i < TicTacToeModel.SIZE; i++) {
            for (int j = 0; j < TicTacToeModel.SIZE; j++) {
                JButton button = new JButton(" ");
                //button.setActionCommand(i + " " + j);
                buttons[i][j] = button;
                int x = i;
                int y = j;
                button.addActionListener(e -> model.play(x, y));
                this.add(button);
            }
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);
        this.setVisible(true);
    }

    @Override
    public void handleTicTacToeStatusUpdate(TicTacToeEvent e) {
        TicTacToeModel ticTacToeModel = (TicTacToeModel) e.getSource();
        String label = ticTacToeModel.getTurn() ? "X" : "0";
        buttons[e.getX()][e.getY()].setText(label);
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
