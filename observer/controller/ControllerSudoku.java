package observer.controller;

import observer.SudokuSolver;
import observer.modele.ModelSudoku;
import observer.observer.CaseObserver;
import observer.observer.SudokuObserver;

public class ControllerSudoku {

    // La vue fait appel au contrôler
    // Le contrôler appel le modèle
    // Gestion du solver (méthode pour déclencher la résolution)

    ModelSudoku sudoku;
    SudokuSolver solver = new SudokuSolver();
    SudokuObserver observer = new CaseObserver();

    public ControllerSudoku(String filename) {
        sudoku = new ModelSudoku(filename);
        sudoku.addObserver(observer);
    }
    public void solve() {
        solver.solve(sudoku);
    }
}
