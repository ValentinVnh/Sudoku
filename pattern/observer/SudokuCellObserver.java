package pattern.observer;

import pattern.modele.SudokuModel;
import pattern.vue.SudokuView;

public class SudokuCellObserver implements SudokuObserver {

    @Override
    public void update(int row, int col, int value, SudokuView sudokuView) {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
        sudokuView.display();
    }
}
