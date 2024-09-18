package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class scenario {

	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("asterix",8);
		Romain minus= new Romain("minus",6);
		asterix.parler("Bonjour à tous ");
		minus.parler("UNE GAU.... UN GAUGAU....");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);

	}

}
