package pattern.vue;

import pattern.SudokuSolver;
import pattern.controller.SudokuController;

import java.util.Scanner;

public class SudokuView {

    private final SudokuController sudokuController;

    public SudokuView() throws InterruptedException {
        sudokuController = new SudokuController(this);
        sudokuController.displayStrategy();
    }

    /**
     * Affiche la grille du sudoku
     */
    public void display() {
        for (int row = 0; row < sudokuController.getBoardSize(); row++) {
            if (row % sudokuController.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < sudokuController.getBoardSize(); col++) {
                if (col % sudokuController.getBlockSize() == 0) {
                    System.out.print("| ");
                }
                int value = sudokuController.getValueAt(row, col);
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
    }

    /**
     * Affiche un quand le sudoku est résolu par l'utilisateur
     */
    public void displayVictoryMessage() {
        System.out.println("Congratulations, you won the game!");
    }


    /**
     * Utilise un objet Scanner pour lire les entrées de l'utilisateur à partir de la console.
     * Elle demande d'abord le numéro de ligne et ensuite le numéro de colonne, en soustrayant 1 de chaque
     * numéro pour convertir l'indexage en 0-based. Elle renvoie un tableau d'entiers contenant les coordonnées
     * saisies par l'utilisateur.
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

    /**
     * Affiche un message demandant à l'utilisateur d'entrer une valeur entre 1 et 9, puis lit l'entrée
     * utilisateur à partir de la console à l'aide de la classe Scanner. Elle renvoie la valeur saisie sous forme d'un entier.
     */
    public int askUserForValue() {
        System.out.print("Enter value (1-9): ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Affiche un message demandant à l'utilisateur de choisir la difficulté
     * @return la difficulté choisie
     */
    public String askLevel() {
        System.out.println("The available difficulties are \"Hard\", \"Medium\", \"Low\" \n->");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    /**
     * Affiche un message demandant à l'utilisateur de choisir une stratégie
     * @return la stratégie choisie
     */
    public String askStrategy() {
        System.out.print("Available strategies are \"Solve\", \"Play\" \n-> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    /**
     * Affiche un message demandant à l'utilisateur de choisir une commande
     * @return la commande choisie
     */
    public String askCommand() {
        System.out.print("Available actions are \"Place\", \"Undo\", \"Exit\" \n-> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    /**
     * Résout le sudoku avec la stratégie choisie
     * @param strategy la stratégie choisie
     */
    public void solve(SudokuSolver strategy) {
        sudokuController.solve(strategy);
    }

}
