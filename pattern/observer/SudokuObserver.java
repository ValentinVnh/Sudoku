package pattern.observer;

import pattern.modele.SudokuModel;
import pattern.vue.SudokuView;

public interface SudokuObserver {
    /**
     * Met à jour la cellule
     * @param row ligne
     * @param col colonne
     * @param value valeur
     * @param sudokuView vue
     */
    void update(int row, int col, int value, SudokuView sudokuView);
}
