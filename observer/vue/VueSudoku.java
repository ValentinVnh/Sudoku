package observer.vue;

import observer.modele.ModelSudoku;

import java.util.Scanner;

public class VueSudoku{
    private final ModelSudoku modelSudoku;

    public VueSudoku(ModelSudoku modelSudoku) {
        this.modelSudoku = modelSudoku;
    }

    public void display() {
        for (int row = 0; row < modelSudoku.getBoardSize(); row++) {
            if (row % modelSudoku.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < modelSudoku.getBoardSize(); col++) {
                if (col % modelSudoku.getBlockSize() == 0) {
                    System.out.print("| ");
                }
                int value = modelSudoku.getValueAt(row, col);
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

}
