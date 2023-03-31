package pattern.observer;

import pattern.modele.ModelSudoku;
import pattern.vue.VueSudoku;

public interface SudokuObserver {
    void update(int row, int col, int value, VueSudoku vueSudoku, ModelSudoku modelSudoku);
}
