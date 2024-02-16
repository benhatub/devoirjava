import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main implements IPersonne {
    private List<Employe> employes = new ArrayList<>();
    private List<Directeur> directeurs = new ArrayList<>();

    // Méthode pour ajouter un employé
    @Override
    public void addPersonne(Personne personne) {
        if (personne instanceof Employe) {
            employes.add((Employe) personne);
        } else if (personne instanceof Directeur) {
            directeurs.add((Directeur) personne);
        }
    }

    // Méthode pour supprimer par matricule
    @Override
    public void deleteByMatricule(String matricule) throws MatriculeNotFoundException {
        boolean isRemoved = directeurs.removeIf(directeur -> directeur.getMatricule().equals(matricule));
        if (!isRemoved) {
            throw new MatriculeNotFoundException("Matricule non trouvé");
        }
    }

    // Méthode pour afficher tous les employés
    @Override
    public List<Employe> getAllEmploye() {
        return employes;
    }

    // Méthode pour afficher tous les directeurs
    @Override
    public List<Directeur> getAllDirecteur() {
        return directeurs;
    }

    // Méthode pour mettre à jour une personne
    @Override
    public void updatePersonne(Personne personne) {
        // Implementer la mise à jour ici
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        // Menu
        while (true) {
            System.out.println("1. Ajouter Employé");
            System.out.println("2. Ajouter Directeur");
            System.out.println("3. Afficher tous les Employés");
            System.out.println("4. Afficher tous les Directeurs");
            System.out.println("5. Supprimer par Matricule");
            System.out.println("6. Quitter");

            System.out.print("Choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    // Ajouter Employé
                    System.out.print("Entrez l'ID de l'employé : ");
                    int employeId = scanner.nextInt();
                    System.out.print("Entrez le nom de l'employé : ");
                    String employeNom = scanner.next();
                    System.out.print("Entrez le prénom de l'employé : ");
                    String employePrenom = scanner.next();
                    System.out.print("Entrez l'adresse de l'employé : ");
                    String employeAdresse = scanner.next();
                    System.out.print("Entrez le salaire de l'employé : ");
                    double employeSalaire = scanner.nextDouble();

                    // Créer une liste de zones pour l'employé (à adapter selon vos besoins)
                    ArrayList<String> employeZones = new ArrayList<>();
                    employeZones.add("PA");
                    employeZones.add("Mbao");

                    Employe employe = new Employe(employeId, employeNom, employePrenom, employeAdresse, employeSalaire, employeZones);
                    main.addPersonne(employe);
                    break;


                case 2:
                    // Ajouter Directeur
                    System.out.print("Entrez l'ID du directeur : ");
                    int directeurId = scanner.nextInt();
                    System.out.print("Entrez le nom du directeur : ");
                    String directeurNom = scanner.next();
                    System.out.print("Entrez le prénom du directeur : ");
                    String directeurPrenom = scanner.next();
                    System.out.print("Entrez l'adresse du directeur : ");
                    String directeurAdresse = scanner.next();

                    Directeur directeur = new Directeur(directeurId, directeurNom, directeurPrenom, directeurAdresse);
                    main.addPersonne(directeur);
                    break;

                case 3:
                    // Afficher tous les Employés
                    List<Employe> employes = main.getAllEmploye();
                    for (Employe e : employes) {
                        e.afficherDetails();
                    }
                    break;
                case 4:
                    // Afficher tous les Directeurs
                    List<Directeur> directeurs = main.getAllDirecteur();
                    for (Directeur d : directeurs) {
                        d.afficherDetails();
                    }
                    break;
                case 5:
                    // Supprimer par Matricule
                    System.out.print("Entrez le matricule à supprimer : ");
                    String matricule = scanner.next();
                    try {
                        main.deleteByMatricule(matricule);
                        System.out.println("Suppression réussie.");
                    } catch (MatriculeNotFoundException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Programme terminé.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}
