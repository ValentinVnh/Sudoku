package observer.observer;

public class CaseObserver implements SudokuObserver {

    @Override
    public void update(int row, int col, int value) {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
        display(); //TODO: à déplacer
    }
}
