package champollion;

import static java.lang.Math.round;
import java.util.LinkedList;
import java.util.List;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    private final List<ServicePrevu> myServicePrevu = new LinkedList<>();
    private final List<Intervention> myInterventions = new LinkedList<>();
    
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        float compteur=0;
        for (ServicePrevu s : myServicePrevu){
            compteur += s.getCM()*1.5;
            compteur += s.getTD();
            compteur += s.getTP()*0.75;
        }
        return round(compteur);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        float compteur=0;
        for (ServicePrevu s : myServicePrevu){
            if (s.getUe()==ue){
                compteur += s.getCM()*1.5;
                compteur += s.getTD();
                compteur += s.getTP()*0.75;
            }  
        }
        return round(compteur);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        myServicePrevu.add(new ServicePrevu(ue, volumeCM, volumeTD, volumeTP));
        
    }
    
    public void ajouteIntervention(Intervention i){
        myInterventions.add(i);
    }

}
