package observer;

import antipattern.Sudoku;
import observer.modele.ModelSudoku;
import observer.observer.CaseObserver;
import observer.observer.SudokuObserver;
import observer.vue.VueSudoku;

public class SudokuApp {
    public static void main(String[] args) {
        ModelSudoku sudoku = new ModelSudoku("sudoku1.txt");
        SudokuSolver solver = new SudokuSolver();
        solver.solve(sudoku);

        SudokuObserver observer = new CaseObserver();
        sudoku.addObserver(observer);
    }
}
