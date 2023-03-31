package pattern.controller;

import pattern.SudokuStrategie;
import pattern.commande.Commande;
import pattern.commande.CommandeGenerale;
import pattern.modele.ModelSudoku;
import pattern.vue.VueSudoku;

import java.util.HashMap;
import java.util.Map;

public class ControllerSudoku {

    private final Map<String, Commande> commandes;
    private final ModelSudoku modelSudoku;

    public ControllerSudoku(String filename, VueSudoku vueSudoku) {
        modelSudoku = new ModelSudoku(filename, vueSudoku);
        commandes = new HashMap<>();
    }

    public void solve(SudokuStrategie strategy) {
        modelSudoku.setSudokuStrategy(strategy);
        modelSudoku.solve();
    }

    public void setCommandes(String nom, CommandeGenerale commande) {
        commandes.put(nom, commande);
    }

    public void executeCommande(String nom) {
        commandes.get(nom).executer();
    }

    public void undoCommande(String nom) {
        commandes.get(nom).undo();
    }

    public void joueurPartie() {
        modelSudoku.joueurPartie();
    }
}
