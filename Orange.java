/**
 *
 * @author roudet
 */
public class Orange {
    private double prix;
    private String origine;
	
    public Orange() 
    {
        this.prix = 0.5;
        this.origine="Espagne";
    }
    
    public Orange(double prix, String origine) 
    {
	if(origine.equals("")){
            this.prix=prix;
            this.origine="Espagne";  //Espagne par défaut
        }  
	else{
            this.prix=prix;
            this.origine=origine;  
        }   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }
 
    public void setOrigine(String country){
	this.origine=origine;
    }
}
