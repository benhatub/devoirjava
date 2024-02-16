import java.util.ArrayList;

public class Employe extends Personne {
    private double salaire;
    private ArrayList<String> zone;

    // Constructeur
    public Employe(int id, String nom, String prenom, String adresse, double salaire, ArrayList<String> zone) {
        super(id, nom, prenom, adresse);
        this.salaire = salaire;
        this.zone = zone;
    }

    // Getters et Setters
    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public ArrayList<String> getZone() {
        return zone;
    }

    public void setZone(ArrayList<String> zone) {
        this.zone = zone;
    }

    // Méthode pour afficher les détails de l'employé
    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Salaire: " + salaire);
        System.out.println("Zone: " + zone);
    }
}
