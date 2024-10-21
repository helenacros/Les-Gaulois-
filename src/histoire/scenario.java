package histoire;

//import gestionVillage.Equipement;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;
//import villagegaulois.Musee;

public class scenario {

	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Asterix",8);
		Romain minus= new Romain("Minus",6);
		Gaulois obelix=new Gaulois("Obelix",25);
		
		Druide panoramix=new Druide("Panoramix",5,10);
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion(panoramix);
		
		panoramix.booster(obelix,panoramix);
		
		
		obelix.parler("Par Belenos, ce n'est pas juste !");
		
		panoramix.booster(asterix,panoramix);
		asterix.parler("Bonjour");
		minus.parler("UNE GAU.... UN GAUGAU....");
			
		asterix.frapper(minus);
		
//		do {
//			asterix.frapper(minus);
//		} while (minus.getForce() > 0);
//		milexcus.parler("UN GAU... UN GAUGAU...");
//		do {
//			asterix.frapper(milexcus);
//		} while (milexcus.getForce() > 0);
//	
	}

}
