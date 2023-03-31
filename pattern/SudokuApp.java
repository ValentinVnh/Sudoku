package pattern;

import pattern.vue.VueSudoku;

public class SudokuApp {
    public static void main(String[] args) {
        VueSudoku vueSudoku = new VueSudoku("sudoku1.txt");
        vueSudoku.affichageJoueur();

        //vueSudoku.solve(new SudokuSolver());
    }
}
