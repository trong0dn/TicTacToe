import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements TicTacToeView {

    private JButton[][] buttons;
    private TicTacToeModel model;

    public TicTacToeFrame() {
        super("Tic Tac Toe!");
        this.setLayout(new GridLayout(TicTacToeModel.SIZE,TicTacToeModel.SIZE));
        model = new TicTacToeModel();
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

    @Override
    public void handleTicTacToeOutcome() {
        if (model.getStatus().equals(TicTacToeModel.Status.X_WON)) {
            JOptionPane.showMessageDialog(this, "X_WON", "Gameover", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (model.getStatus().equals(TicTacToeModel.Status.O_WON)) {
            JOptionPane.showMessageDialog(this, "O_WON", "Gameover", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (model.getStatus().equals(TicTacToeModel.Status.TIE)){
            JOptionPane.showMessageDialog(this, "TIE", "Gameover", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
