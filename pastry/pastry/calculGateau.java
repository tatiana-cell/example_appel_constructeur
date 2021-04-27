package pastry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class calculGateau {

	public static void main(String[] args) {
		GATEAU g1=new GATEAU("choco",2);
		g1.addIngridient("chocolat",200.00);
		g1.addIngridient("beurre",250.00);
		g1.addIngridient("farine",150.00);
		g1.afficherList();
		CLIENT client=new CLIENT("Dupont");
		GATEAU g2=new GATEAU("citron",1,client);
        g2.addIngridient("citron", 1);
        g2.addIngridient("farine",200.00);
        g2.addIngridient("sucre", 80.0);
        g2.afficherList();
      
	}
	
	

}
class GATEAU  {
	private String nom_gateau;
	private HashMap<String,Double>ingridients;
	private int nombre_gateaux;
	private CLIENT client;
	
	
	public GATEAU(String nom_gateau,int nombre_gateaux)
	{
		this.nom_gateau=nom_gateau;
		ingridients=new HashMap<String, Double>();
		this.nombre_gateaux=nombre_gateaux;
	}
	public GATEAU(String nom_gateau,int nombre_gateaux,CLIENT client)
	{
		//pour ne pas réecrire 3 lignes du code -- 36,37,38 -- on appele le constructeur:
		this(nom_gateau, nombre_gateaux);
		this.client=client;
		System.out.println("***** gateau au "+nom_gateau+" reservé pour le client "+client.getNom()+" *************");
	}
	
	public void addIngridient(String nom_ingrd, double quantite) {
		if(!ingridients.containsKey(nom_ingrd))
		{ingridients.put(nom_ingrd, quantite);}
		else System.out.println("Cet ingridient déjà dans la liste");
	}
	
	
	public void afficherList()
	{
		 System.out.println("les ingridients de recette de gateau au "+nom_gateau+" pour "+nombre_gateaux+" gateau:");
		Set<String>keys=ingridients.keySet();
		Iterator<String> iter=keys.iterator();
		while(iter.hasNext())
		{
			String ingrd= iter.next();
			double quantite=ingridients.get(ingrd)*nombre_gateaux;
			System.out.println(ingrd+":"+quantite);
		}
	}
	
}
