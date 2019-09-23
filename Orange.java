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
	if(prix < 0)
	    this.prix = -prix;
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Espagne";  //Espagne par défaut
	else
            this.origine = origine;   
    }

    public double getPrix(){
	return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String country){
	this.origine=origine;
    }

    @Override
    public String toString(){
        return "Orange de " + origine + " coutant " + prix + " euros";
    }

    public static void main (String[] args){
        Orange o1 = new Orange(0.50,"France");
        Orange o2 = new Orange(0.60,"Italie");
        Orange o3 = new Orange(-0.40,"Espagne");
	Orange o4 = new Orange();

	System.out.println(o1);
	System.out.println(o2);
	System.out.println(o3);
	System.out.println(o4);
	System.out.println(o4.getOrigine());
   }
}
