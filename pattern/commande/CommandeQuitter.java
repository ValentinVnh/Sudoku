package pattern.commande;

public class CommandeQuitter implements Commande {
    @Override
    public void executer() {
        System.out.println("Quitter");
    }
}