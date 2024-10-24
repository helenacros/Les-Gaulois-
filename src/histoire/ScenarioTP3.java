package histoire;

import gestionVillage.Equipement;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;
//import villagegaulois.Musee;

public class ScenarioTP3 {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion(druide);
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		
		druide.booster(obelix,druide);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix,druide);
		asterix.parler("Bonjour");
		
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0);
		
//		Partie a decommenter
		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}