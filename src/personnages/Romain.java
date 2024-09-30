package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;

	public Romain(String nom, int force) { 
		if (force<0) {
			throw new IllegalArgumentException("Invalid force: " + force);
		}
		this.nom = nom; 
		this.force = force; 
		equipements=new Equipement[2];
	}

	public void parler(String texte) {
		System.out.println(prendreParole()+"�" + texte + "�");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : "; 
	}
	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte =texte+ "\n Mais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
					if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					System.out.println("Equipement bouclier");
					resistanceEquipement += 8;
				} 
				else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}

			}
			texte = texte+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup=forceCoup - resistanceEquipement;
		return forceCoup;
		}
	
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
			return equipementEjecte;
		}

	
//	public void recevoirCoup(int forceCoup) {
//		if (force<0) {
//			throw new IllegalArgumentException("Invalid force: " + force);
//		}
//		int forceDebut=force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} else { 
//			parler("J'abandonne..."); }
//		assert (forceDebut>force);
//	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement]=equipement;
		nbEquipement++;
		System.out.println("Le soldat " +nom+" avec un "+equipement);
	}
	
	
	public void sEquiper(Equipement equipement) {	
		switch(nbEquipement) {
			
			case 0 :
				ajouterEquipement(equipement);
				break;
			
			case 1 :
				if (equipements[0]==equipement) {
					System.out.println("Le soldat "+nom+" possède deja un "+equipement);
				}
				else {
					ajouterEquipement(equipement);
				}
				break;
				
			case 2 :
				System.out.println("Le soldat "+nom+" est deja bien protégé !");
				break;	
			default :
				System.out.println(" erreur fin execution ");
				break;
		}
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition il a un minimum de force 
		if (force < 0) {
			throw new IllegalArgumentException("Invalid force: " + force);
		}
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
//		 if (force > 0) {
//			 parler("Aïe");
//		 } 
//		 else {
//			 equipementEjecte = ejecterEquipement();
//			 parler("J'abandonne...");
//		 }
		if (force==0) {
			parler("Aïe");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");

		}
		// post condition la force a diminuée
		if (force<oldForce ) {
			throw new IllegalArgumentException("Invalid force: " + force +" par rapport à old force : "+oldForce);
		}
		return equipementEjecte;
	}

	
	public static void main(String[] args) {
		Romain minus=new Romain("Minus",6);
		minus.prendreParole();
		minus.parler("foutu gaulois");
		minus.recevoirCoup(4);
		System.out.println(minus);
		
		for (Equipement equipement : Equipement.values()){
			System.out.println("-"+ equipement);
		}
				
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}

}
