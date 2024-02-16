public class Directeur extends Personne {
    private String matricule;

    // Constructeur
    public Directeur(int id, String nom, String prenom, String adresse) {
        super(id, nom, prenom, adresse);
        this.matricule = genererMatricule();
    }

    // Méthode pour générer la matricule
    private String genererMatricule() {
        char premiereLettrePrenom = prenom.charAt(0);
        String tailleNom = String.valueOf(nom.length());

        return premiereLettrePrenom + "000" + tailleNom;
    }

    // Getters et Setters
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    // Méthode pour afficher les détails du directeur
    @Override
    public void afficherDetails() {
        super.afficherDetails();
        System.out.println("Matricule: " + matricule);
    }
}
