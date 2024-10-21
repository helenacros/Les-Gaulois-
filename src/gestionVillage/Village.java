package gestionVillage;

import personnages.Gaulois;

public class Village { 
	
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	public Village(String nom, int nbVillageoisMax) { 
		this.nom = nom;
		villageois= new Gaulois[nbVillageoisMax];
	}

	public String getNom() { 
		return nom; 
	}
	
	public void setChef(Chef chef) {
		this.chef=chef;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if( nbVillageois<villageois.length) {
			villageois[nbVillageois]=gaulois;
			nbVillageois++;
		}
		else {
			System.out.println("trop de gaulois");
		}
	}
	
	public Gaulois trouverHabitant(int num) {
		return villageois[num-1];
	}
	
	public String getChef() {
		return chef.getNom();
	}
	

	public void afficherVillageois(Village village) {
		System.out.println("Dans le village de "+village.getChef()+"vivent les legendaires gaulois :");
		for (int i=0;i<nbVillageois;i++) {
			System.out.println("-"+villageois[i].getNom());
		}
		
	}
	
	
	public static void main(String[] args) {
		Village village=new Village("Village des irreductibles",30);

		//		Gaulois gaulois = village.trouverHabitant(30);
//		Index 30 out of bounds for length 30
//		car les indices commencent à 0 donc le dernier indice du tableau est 29 donc 30 ne peut pas marcher 
		
		Chef abra=new Chef("Abraracourcix",6,village);
		village.setChef(abra);
		
		Gaulois asterix=new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		
		Gaulois obelix=new Gaulois("Obelix",8);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois(village);

//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Gaulois [nom=Asterix, force=8, effetPotion=1]
//		ca me donne les infos sur asterix car cela revient a demander l'element zero du tablea, donc le premier element 
		
	}
	
	
}	
	