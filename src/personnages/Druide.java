package personnages;
import java.util.Random;

public class Druide { 
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion=1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) { 
		this.nom = nom; 
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � " + effetPotionMax + ".");
	}
	
	public String getNom() { 
		return nom; 
	}
	
	public void parler(String texte) { 
		System.out.println(prendreParole() + "� " + texte + "�");
	} 
	
	private String prendreParole() { 
		return "Le druide " + nom + " : "; 
	}
	
	public void booster(Gaulois gaulois,Druide druide) {
		if (gaulois.getNom()=="Obelix") {
			druide.parler("Non, Obelix!... Tu n'auras pas de potion magique !");
		}
		else {
			gaulois.boirePotion(forcePotion,gaulois);
		}
	}
	
	public void preparerPotion(Druide druide) {
		Random random=new Random();
		forcePotion = random.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
		if (forcePotion>7) {
			druide.parler("J'ai preparer une super potion de force "+forcePotion);
		}
		else {
			druide.parler("Je n'ai pas trouve tous les ingredients, ma pation est seulement de force "+forcePotion);
		}
		
	}
	
	public static void main(String[] args) {
		Druide panoramix=new Druide("Panoramix",5,10);
		panoramix.preparerPotion(panoramix);
		
	}
	
	

}