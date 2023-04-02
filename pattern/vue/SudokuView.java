package pattern.vue;

import pattern.SudokuSolver;
import pattern.controller.SudokuController;
import pattern.modele.SudokuModel;

import java.util.Scanner;

public class SudokuView {

    private final SudokuController sudokuController;

    public SudokuView(String filename) {
        sudokuController = new SudokuController(filename, this);
    }

    public void display(SudokuModel sudokuModel) {
        for (int row = 0; row < sudokuModel.getBoardSize(); row++) {
            if (row % sudokuModel.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < sudokuModel.getBoardSize(); col++) {
                if (col % sudokuModel.getBlockSize() == 0) {
                    System.out.print("| ");
                }
                int value = sudokuModel.getValueAt(row, col);
                if (value == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Sudoku game!");
        System.out.println("Please enter the board size:");
    }

    /*
    Cette méthode utilise un objet Scanner pour lire les entrées de l'utilisateur à partir de la console.
    Elle demande d'abord le numéro de ligne et ensuite le numéro de colonne, en soustrayant 1 de chaque
    numéro pour convertir l'indexage en 0-based. Elle renvoie un tableau d'entiers contenant les coordonnées
    saisies par l'utilisateur.
     */

    public int[] askUserForCoords() {
        Scanner scanner = new Scanner(System.in);
        int[] coords = new int[2];
        System.out.println("Enter row number (1-9):");
        coords[0] = Integer.parseInt(scanner.nextLine()) - 1; // Convert to 0-based indexing
        System.out.println("Enter column number (1-9):");
        coords[1] = Integer.parseInt(scanner.nextLine()) - 1; // Convert to 0-based indexing
        return coords;
    }

    /*
    Cette méthode affiche un message demandant à l'utilisateur d'entrer une valeur entre 1 et 9, puis lit l'entrée
    utilisateur à partir de la console à l'aide de la classe Scanner. Elle renvoie la valeur saisie sous forme d'un entier.
     */
    public int askUserForValue() {
        System.out.print("Enter value (1-9): ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayVictoryMessage() {
        System.out.println("Congratulations, you won the game!");
    }

    public void displayErrorValueMessage() {
        System.out.println("Invalid value, please try again.");
    }

    public void solve(SudokuSolver strategy) {
        sudokuController.solve(strategy);
    }


    public int askTest() {
        System.out.print("1 - Placer\n2 - Annuler\n3 - Terminer partie\n-> ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void affichageJoueur() {
        displayWelcomeMessage();
        if (!sudokuController.stopGame()) {
            switch (askTest()) {
                case 1 -> sudokuController.handleUserInput(askUserForCoords(), askUserForValue());
                case 2 -> sudokuController.undoCommande();
                case 3 -> displayVictoryMessage();
            }
        }
    }

}
