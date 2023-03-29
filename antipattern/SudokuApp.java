package antipattern;

public class SudokuApp {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku("sudoku1.txt");
        SudokuSolver solver = new SudokuSolver();
        solver.solve(sudoku);
    }
}
