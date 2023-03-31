package pattern.observer;

import pattern.modele.ModelSudoku;
import pattern.vue.VueSudoku;

public class CaseObserver implements SudokuObserver {

    @Override
    public void update(int row, int col, int value, VueSudoku vueSudoku, ModelSudoku modelSudoku) {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
        vueSudoku.display(modelSudoku);
    }
}
