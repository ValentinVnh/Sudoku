package pattern.commande;

public class CommandePlacer implements CommandeAnnulable {
    @Override
    public void executer() {
        System.out.println("Placement");
    }

    @Override
    public void undo() {
        System.out.println("Annulation placement");
    }
}
