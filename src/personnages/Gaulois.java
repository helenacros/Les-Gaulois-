package personnages;

import gestionVillage.Equipement;
import gestionMusee.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int nbtrophees;
	private Equipement[] trophees= new Equipement[100];
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		Equipement[] trophs=romain.recevoirCoup((force / 3)*effetPotion);
		for (int i=0; trophs != null && i<trophs.length; i++ , nbtrophees++) {
				this.trophees[nbtrophees]=trophs[i];
		}
		
	}

//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
//	
//	}
	
	public void boirePotion(int forcePotion,Gaulois gaulois) {
		effetPotion=effetPotion+forcePotion;
		gaulois.parler("Merci druide, je sens que ma force est "+forcePotion+" fois décuplée");
	}
	
	
	 public void faireUneDonnation(Musee musee) {
	        if (nbtrophees > 0) {
	            System.out.println("Le gaulois " + nom + " : « Je donne au musée tous mes trophées :");
	            for (int i = 0; i < nbtrophees; i++) {
	                if (trophees[i] != null) {
	                    System.out.println("- " + trophees[i]);
	                    musee.donnerTrophee(this, trophees[i]);
	                }
	            }
	            nbtrophees = 0;
	        } else {
	            System.out.println("Le gaulois " + nom + " n'a pas de trophées à donner.");
	        }
	    }
	
	public static void main(String[] args) {
		Gaulois asterix=new Gaulois("Asterix",8);
		asterix.prendreParole();
		asterix.parler("Je bois de la potion");
		asterix.boirePotion(2,asterix);
		System.out.println(asterix);
		Romain minus=new Romain("minus",6);
		asterix.frapper(minus);
		
	}

	
}
