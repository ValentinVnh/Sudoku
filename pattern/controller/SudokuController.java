package pattern.controller;

import pattern.SudokuSolver;
import pattern.commande.SetValueCommand;
import pattern.commande.SudokuCommand;
import pattern.modele.SudokuModel;
import pattern.vue.SudokuView;

import java.util.Stack;

public class SudokuController {

    private final Stack<SudokuCommand> historique;
    private final SudokuModel sudokuModel;

    public SudokuController(String filename, SudokuView sudokuView) {
        sudokuModel = new SudokuModel(filename, sudokuView);
        historique = new Stack<>();
    }

    public void solve(SudokuSolver strategy) {
        sudokuModel.setSudokuStrategy(strategy);
        sudokuModel.solve();
    }


    public void undoCommande() {
        historique.get(historique.size()-1).undo();
        historique.pop();

    }
    public void handleUserInput(int[] rowCol, int value) {
        SudokuCommand command =  new SetValueCommand(sudokuModel, rowCol[0], rowCol[1], value);
        command.execute();
        historique.push(command);
    }

    public boolean stopGame() {
        return sudokuModel.isGameFinished();
    }
}
