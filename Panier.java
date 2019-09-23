import java.util.*;
/**
 *
 * @author roudet
 */
public class Panier extends Observable {
    private ArrayList<Orange> fruits;
    private int cont_max;   //nb maximum d'oranges que peut contenir le panier
	
    public Panier(int max){
	if(max >= 0)
	   cont_max = max;
	else           //contenance max negative, on prend l'oppose
	   cont_max = -max;    

	fruits = new ArrayList<Orange>(max);   //panier vide
    }
    
    public ArrayList<Orange> getFruits() {
        return fruits;
    }
    
    public int getContenance(){
        return getFruits().size();
    }
    
    public int getContMax(){
	return cont_max;
    }

    public void setContMax(int cont){
	cont_max = cont;
    }
    
    public boolean estVide(){
        return getFruits().isEmpty();
    }
    
    public boolean estPlein(){
        return getFruits().size() == cont_max;
    }

    public boolean ajoute(Orange o){
        if(o == null)
            return false;
        if(!estPlein()){
            getFruits().add(o);  //methode de l'ArrayList
	    return true;
        }
        else 
            return false;
    }

    public boolean retire() {
        if(!estVide()){
            getFruits().remove(getFruits().size()-1);
	    return true;
	}
        else 
	   return false;
    }

    public double getPrix(){
	double total=0;
	for(int i = 0 ; i < getFruits().size() ; i++)
            total += getFruits().get(i).getPrix();
	return total;
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

	Panier p = new Panier(0);
	if(! (p.estPlein() && p.estVide()))
	   return;
	System.out.println("Contenance max du panier p (initialise à max=0) : " + p.getContMax() + ", et contenu : " + p.getContenance() );
	boolean testa = p.ajoute(o3);
	if(! (p.estPlein() && p.estVide()))
	   return;
	System.out.println("Contenu du panier p (initialise à max=0) apres 1 ajout : " + p.getContenance() );

        Panier p2 = new Panier(2);
	System.out.println("Contenance max du panier p2 (initialise à max=2) : " + p2.getContMax() + ", et contenu : " + p2.getContenance() );
        p2.ajoute(o1);
        p2.ajoute(o2);
        System.out.println("Contenu du panier p2 (initialise à max=2) apres 2 ajouts : " + p2.getContenance());
	if(! p2.estPlein())
	   return;
        testa = p2.ajoute(o3);
	if(! p2.estPlein())
	   return;
	System.out.println("Contenu du panier p2 (initialise à max=2) apres 3 ajouts : " + p2.getContenance());

	Panier pneg = new Panier(-2);   //contenance max negative !
	if(! pneg.estVide())
	   return;
	System.out.println("contenance max du panier pneg (initialise à max = -2) : " + pneg.getContMax() + ", et contenu : "  + pneg.getContenance() );
	pneg.ajoute(o1);
        System.out.println("Contenu du panier pneg (initialise à max = -2) apres 1 ajout : " + pneg.getContenance());
	if(! pneg.estPlein())
	   return;

	System.out.println("Fin ! ");
   }
}
