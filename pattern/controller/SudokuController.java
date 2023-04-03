package pattern.controller;

import pattern.BacktrackingSolver;
import pattern.SudokuSolver;
import pattern.commande.ExitCommand;
import pattern.commande.SetValueUndoCommand;
import pattern.commande.SudokuCommand;
import pattern.commande.SudokuUndoCommand;
import pattern.modele.SudokuModel;
import pattern.vue.SudokuView;

import java.util.Stack;

public class SudokuController {

    private final Stack<SudokuCommand> historique;
    private final SudokuModel sudokuModel;
    private final SudokuView sudokuView;

    public SudokuController(String filename, SudokuView sudokuView) {
        this.sudokuModel = new SudokuModel(filename, sudokuView);
        this.historique = new Stack<>();
        this.sudokuView = sudokuView;
    }

    public void solve(SudokuSolver strategy) {
        sudokuModel.setSudokuStrategy(strategy);
        sudokuModel.solve();
    }


    public void undoCommande() {
        if (historique.get(0) instanceof SudokuUndoCommand) {
            ((SudokuUndoCommand) historique.lastElement()).undo();
            historique.pop();
        }
    }

    public void handleUserInput(int[] rowCol, int value) {
        SudokuCommand command = new SetValueUndoCommand(sudokuModel, rowCol[0], rowCol[1], value);
        command.execute();
        historique.push(command);
    }

    public void exitGame() {
        SudokuCommand command = new ExitCommand();
        command.execute();
    }

    public boolean stopGame() {
        return sudokuModel.isGameFinished();
    }

    public int getBoardSize() {
        return sudokuModel.getBoardSize();
    }

    public int getBlockSize() {
        return sudokuModel.getBlockSize();
    }

    public int getValueAt(int row, int col) {
        return sudokuModel.getValueAt(row, col);
    }


    public void displayStrategy() {
        sudokuView.displayWelcomeMessage();
        sudokuView.display();
        switch (sudokuView.askStrategy()) {
            case 1 -> solve(new BacktrackingSolver());
            case 2 -> displayPlayer();
        }
    }

    public void displayPlayer() {
        while (!stopGame()) {
            switch (sudokuView.askCommand()) {
                case 1 -> handleUserInput(sudokuView.askUserForCoords(), sudokuView.askUserForValue());
                case 2 -> undoCommande();
                case 3 -> exitGame();
            }
        }
        sudokuView.displayVictoryMessage();
    }
}
