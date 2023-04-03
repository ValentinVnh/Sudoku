package pattern.commande;

public class ExitCommand implements SudokuCommand{

    @Override
    public void execute() {
        System.exit(0);
    }
}
