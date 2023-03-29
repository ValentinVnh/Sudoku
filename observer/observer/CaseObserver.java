package observer.observer;

import observer.vue.VueSudoku;

public class CaseObserver implements SudokuObserver {

    @Override
    public void update(int row, int col, int value, VueSudoku vueSudoku) {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
        vueSudoku.display();
    }
}
