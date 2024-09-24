package personnages;
public class Romain {
	private String nom;
	private int force;


	public Romain(String nom, int force) { 
		assert (force>=0);
		this.nom = nom; 
		this.force = force; 
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
	

	public static void main(String[] args) {
		Romain minus=new Romain("Minus",6);
		minus.prendreParole();
		minus.parler("foutu gaulois");
		minus.recevoirCoup(4);
		System.out.println(minus);
	}
	
	
	
	
	
}
