import java.util.List;

public interface IPersonne {
    List<Employe> getAllEmploye();
    List<Directeur> getAllDirecteur();
    void addPersonne(Personne personne);
    void deleteByMatricule(String matricule) throws MatriculeNotFoundException;
    void updatePersonne(Personne personne);
}
