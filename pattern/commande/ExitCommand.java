package pattern.commande;

public class ExitCommand implements SudokuCommand{

    /**
     * Met fin au programme
     */
    @Override
    public void execute() {
        System.exit(0);
    }
}
