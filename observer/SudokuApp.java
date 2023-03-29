package observer;

import observer.modele.ModelSudoku;
import observer.observer.CaseObserver;
import observer.observer.SudokuObserver;

public class SudokuApp {
    public static void main(String[] args) {

        SudokuObserver observer = new CaseObserver();
        ModelSudoku sudoku = new ModelSudoku("sudoku1.txt");
        SudokuSolver solver = new SudokuSolver();

        sudoku.addObserver(observer);
        solver.solve(sudoku);
    }
}
