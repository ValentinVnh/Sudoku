package pattern;

import pattern.modele.SudokuModel;

public interface SudokuSolver {

    /**
     * Résout le sudoku
     * @param sudoku sudoku
     * @return true si le sudoku a été résolu, false sinon
     */
    boolean solve(SudokuModel sudoku);
}
