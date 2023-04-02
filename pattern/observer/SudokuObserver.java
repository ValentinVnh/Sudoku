package pattern.observer;

import pattern.modele.SudokuModel;
import pattern.vue.SudokuView;

public interface SudokuObserver {
    void update(int row, int col, int value, SudokuView sudokuView, SudokuModel sudokuModel);
}
