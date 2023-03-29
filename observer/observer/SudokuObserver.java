package observer.observer;

import observer.vue.VueSudoku;

public interface SudokuObserver {
    void update(int row, int col, int value, VueSudoku vueSudoku);
}
