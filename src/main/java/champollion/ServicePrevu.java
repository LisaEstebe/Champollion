package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    private int CM;
    private int TD;
    private int TP;
    private UE ue;
   
    public ServicePrevu(UE ue, int CM,int TD,int TP){
        this.CM = CM;
        this.TD = TD;
        this.TP = TP;
        this.ue = ue;
    }
    
    public int getCM(){
        return CM;
    }
    
    public void setCM(){
        this.CM=CM;
    }

    public int getTD(){
        return TD;
    }
    
    public void setTD(){
        this.TD=TD;
    }
    
    public int getTP(){
        return TP;
    }
    
    public void setTP(){
        this.TP=TP;
    }
    
    public UE getUe(){
        return ue;
    }
    
    public void setUe(){
        this.ue=ue;
    }
}
