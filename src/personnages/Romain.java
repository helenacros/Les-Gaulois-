package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement=0;

	public Romain(String nom, int force) { 
		assert (force>=0);
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
	
	public void recevoirCoup(int forceCoup) {
		assert (force>=0);
		int forceDebut=force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else { 
			parler("J'abandonne..."); }
		assert (forceDebut>force);
	}
	
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement]=equipement;
		nbEquipement++;
		System.out.println("Le soldat "+nom+"avec un "+equipement);
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
		}
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
