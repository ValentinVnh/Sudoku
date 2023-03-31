package pattern.controller;

import pattern.SudokuStrategie;
import pattern.commande.Commande;
import pattern.commande.CommandeAnnulable;
import pattern.modele.ModelSudoku;
import pattern.vue.VueSudoku;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ControllerSudoku {

    private final Map<String, Commande> commandes;

    private final Stack<String> historique;
    private final ModelSudoku modelSudoku;

    public ControllerSudoku(String filename, VueSudoku vueSudoku) {
        modelSudoku = new ModelSudoku(filename, vueSudoku);
        commandes = new HashMap<>();
        historique = new Stack<>();
    }

    public void solve(SudokuStrategie strategy) {
        modelSudoku.setSudokuStrategy(strategy);
        modelSudoku.solve();
    }

    public void setCommandes(String nom, Commande commande) {
        commandes.put(nom, commande);
    }

    public void executeCommande(String nom) {
        commandes.get(nom).executer();
        historique.push(nom);
    }

    public void undoCommande(String nom) {
        if(commandes.get(nom) instanceof CommandeAnnulable){
            ((CommandeAnnulable) commandes.get(nom)).undo();
            historique.pop();
        }
    }

    public void joueurPartie() {
        modelSudoku.plateauActuelle();
    }

    public void plateauBase() {
        modelSudoku.plateauBase();
    }
}
