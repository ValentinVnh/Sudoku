package pattern.commande;

public interface SudokuUndoCommand extends SudokuCommand {

    /**
     * Exécute la commande
     */
    void execute();

    /**
     * Annule la commande
     */
    void undo();
}
