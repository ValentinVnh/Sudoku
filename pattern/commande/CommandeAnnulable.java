package pattern.commande;

public interface CommandeAnnulable extends Commande {

    void undo();
}
