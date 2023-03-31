package pattern.commande;

import pattern.vue.VueSudoku;

public class CommandePlacer extends CommandeGenerale {
    @Override
    public void executer() {
        System.out.println("Placement");
    }

    @Override
    public void undo() {
        System.out.println("Annulation placement");
    }
}
