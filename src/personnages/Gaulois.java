package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbtrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
				Equipement[] tropheesGaulois = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesGaulois != null && i < tropheesGaulois.length; i++,
				nbtrophees++) {
			this.trophees[nbtrophees] = tropheesGaulois[i];
		}
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
				+ ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int potion) {
		this.effetPotion = potion;
		this.parler("Merci Druide, je sens que ma force est " +potion+ " fois décuplée.");

	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ("Astérix", 8) ;
		Romain antivirus = new Romain("Antivirus",4);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		int potion = 3;
		asterix.prendreParole();
		asterix.boirePotion(potion);
		asterix.parler("Je suis Astérix");
		asterix.frapper(antivirus);

	}
}



