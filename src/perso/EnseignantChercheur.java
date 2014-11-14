package perso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by djemaa on 07/11/14.
 */
public class EnseignantChercheur extends Enseignant implements IChercheur
{
    private ArrayList<Publication> publications;

    public EnseignantChercheur(String nom, int age, int heures)
    {
        super(nom,age,heures);
        this.publications = new ArrayList<Publication>();
    }

    @Override
    public String listerPublications() {
        return publications.toString();
    }

    @Override
    public void ajouterPublication(Publication p) {
        publications.add(p);
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+publications;
    }
}
