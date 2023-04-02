package pattern.commande;

import pattern.modele.SudokuModel;

public class SetValueCommand implements SudokuCommand {

    SudokuModel model;
    int row;
    int col;
    int newValue;
    int oldValue;

    public SetValueCommand(SudokuModel model, int row, int col, int newValue) {
        this.model = model;
        this.row = row;
        this.col = col;
        this.newValue = newValue;
    }

    @Override
    public void execute() {
        oldValue = model.getValueAt(row, col);
        model.setValueAt(row, col, newValue);
    }

    @Override
    public void undo() {
        model.setValueAt(row, col, oldValue);
    }
}
