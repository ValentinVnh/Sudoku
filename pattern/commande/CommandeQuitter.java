package pattern.commande;

public class CommandeQuitter extends CommandeGenerale {
    @Override
    public void executer() {
        System.out.println("Quitter");
    }
}