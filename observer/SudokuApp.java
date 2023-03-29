package observer;

import observer.controller.ControllerSudoku;
import observer.modele.ModelSudoku;
import observer.observer.CaseObserver;
import observer.observer.SudokuObserver;

public class SudokuApp {
    public static void main(String[] args) {
        ControllerSudoku controller = new ControllerSudoku("sudoku1.txt");
        controller.solve();
    }
}
