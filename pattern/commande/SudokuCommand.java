package pattern.commande;

public interface SudokuCommand {

    void execute();

    void undo();
}