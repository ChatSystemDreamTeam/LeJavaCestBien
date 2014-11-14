package perso;

import perso.Publication;

/**
 * Created by djemaa on 07/11/14.
 */
public interface IChercheur {
    public void ajouterPublication (Publication p);
    public String listerPublications();
}
