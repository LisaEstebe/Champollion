/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author Lisa
 */
public class Intervention {
    private final Date debut;
    private final int duree;
    private final UE ue;
    private final Salle salle;
    private final TypeIntervention type;
    private final boolean annulee=false;
    

    public Intervention (Salle salle, UE ue, Date debut, int duree, TypeIntervention type){
        this.debut=debut;
        this.duree=duree;
        this.ue=ue;
        this.salle=salle;
        this.type=type;
    }
   
    
    public int getDuree() {
        return duree;
    }
    
    public TypeIntervention getType(){
        return type;
    }
    
    /*public void setBoolean(boolean a){
        this.annulee = a;
    }*/
    
}
