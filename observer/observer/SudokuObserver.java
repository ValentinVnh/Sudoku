package observer.observer;

public interface SudokuObserver {
    void update(int row, int col, int value);
}
