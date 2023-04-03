package pattern.commande;

public interface SudokuUndoCommand extends SudokuCommand {

    void execute();

    void undo();
}
