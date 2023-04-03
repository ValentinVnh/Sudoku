package pattern.commande;

import pattern.modele.SudokuModel;

public class SetValueCommand implements SudokuUndoCommand {

    SudokuModel model;
    int row;
    int col;
    int newValue;
    int oldValue;

    /**
     * Modifie la valeur d'une case du modèle
     * @param model le modèle à modifier
     * @param row ligne
     * @param col colonne
     * @param newValue nouvelle valeur
     */
    public SetValueCommand(SudokuModel model, int row, int col, int newValue) {
        this.model = model;
        this.row = row;
        this.col = col;
        this.newValue = newValue;
        this.oldValue = model.getValueAt(row, col);
    }

    /**
     * Exécute la commande
     */
    @Override
    public void execute() {
        oldValue = model.getValueAt(row, col);
        model.setValueAt(row, col, newValue);
    }

    /**
     * Annule la commande
     */
    @Override
    public void undo() {
        model.setValueAt(row, col, oldValue);
    }
}
