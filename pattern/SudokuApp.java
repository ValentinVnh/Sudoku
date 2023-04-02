package pattern;

import pattern.vue.SudokuView;

public class SudokuApp {
    public static void main(String[] args) {
        SudokuView sudokuView = new SudokuView("sudoku1.txt");
        sudokuView.affichageJoueur();

        //vueSudoku.solve(new SudokuSolver());
    }
}
