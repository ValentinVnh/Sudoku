package pattern.controller;

import pattern.BacktrackingSolver;
import pattern.SudokuSolver;
import pattern.commande.ExitCommand;
import pattern.commande.SetValueCommand;
import pattern.commande.SudokuCommand;
import pattern.commande.SudokuUndoCommand;
import pattern.modele.SudokuModel;
import pattern.vue.SudokuView;

import java.util.Stack;

import static java.lang.Thread.sleep;

public class SudokuController {

    private final Stack<SudokuCommand> historique;
    private final SudokuModel sudokuModel;
    private final SudokuView sudokuView;

    /**
     * Constructeur
     * @param sudokuView vue
     */
    public SudokuController(SudokuView sudokuView) {
        this.sudokuView = sudokuView;
        this.sudokuModel = new SudokuModel(displayLevel(), sudokuView);
        this.historique = new Stack<>();

    }

    /**
     * Résout le sudoku
     * @param strategy stratégie de résolution
     */
    public void solve(SudokuSolver strategy) {
        sudokuModel.setSudokuStrategy(strategy);
        sudokuModel.solve();
    }

    /**
     * Annule la dernière commande
     */
    public void undoCommande() {
        if (!historique.empty()) {
            if (historique.get(0) instanceof SudokuUndoCommand) {
                ((SudokuUndoCommand) historique.lastElement()).undo();
                historique.pop();
            }
        } else {
            System.out.println("Undo impossible");
        }
    }

    /**
     * Gère l'entrée utilisateur pour le choix de la nouvelle valeur à l'emplacement souhaité
     * @param rowCol coordonnées de la case
     * @param value nouvelle valeur
     */
    public void handleUserInput(int[] rowCol, int value) {
        SudokuCommand command = new SetValueCommand(sudokuModel, rowCol[0], rowCol[1], value);
        command.execute();
        historique.push(command);
    }

    /**
     * Commande pour quitter le jeu / mettre fin au programme
     */
    public void exitGame() {
        SudokuCommand command = new ExitCommand();
        command.execute();
    }

    /**
     * Vérifie si la partie est terminée
     * @return true si la partie est terminée, false sinon
     */
    public boolean isGameFinished() {
        return sudokuModel.isGameFinished();
    }

    /**
     * Retourne la taille du sudoku
     * @return taille du sudoku
     */
    public int getBoardSize() {
        return sudokuModel.getBoardSize();
    }

    /**
     * Retourne la taille d'un bloc
     * @return taille d'un bloc
     */
    public int getBlockSize() {
        return sudokuModel.getBlockSize();
    }

    /**
     * Retourne la valeur d'une case
     * @param row ligne
     * @param col colonne
     * @return valeur de la case
     */
    public int getValueAt(int row, int col) {
        return sudokuModel.getValueAt(row, col);
    }

    /**
     * Demande à l'utilisateur quelle stratégie il souhaite utiliser
     */
    public void displayStrategy() throws InterruptedException {
        sudokuView.displayWelcomeMessage();
        sudokuView.display();
        switch (sudokuView.askStrategy()) {
            case "solve" -> solve(new BacktrackingSolver());
            case "play" -> displayPlayer();
            default -> {
                System.out.println("invalid choice, rebooting in 3 seconds");
                for (int i = 3; i >= 1; i--) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
                displayStrategy();
            }
        }
    }

    /**
     * Demande à l'utilisateur quel niveau de difficulté il souhaite
     * @return le fichier correspondant au niveau de difficulté
     */
    public String displayLevel(){
        String level = "";
        switch (sudokuView.askLevel()){
            case "hard" -> level = "sudoku3.txt";
            case "medium" -> level = "sudoku2.txt";
            case "low" -> level = "sudoku1.txt";
            default -> level = "sudoku1.txt";
        }
        return level;
    }

    /**
     * Utilisation du pattern commance pour gérer les commandes de l'utilisateur
     */
    public void displayPlayer() {
        while (!isGameFinished()) {
            switch (sudokuView.askCommand()) {
                case "place" -> handleUserInput(sudokuView.askUserForCoords(), sudokuView.askUserForValue());
                case "undo" -> undoCommande();
                case "exit" -> exitGame();
                default -> System.out.println("Choix invalide");
            }
        }
        sudokuView.displayVictoryMessage();
    }
}
