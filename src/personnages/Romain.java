package personnages;

public class Romain {

	private String texte;
	private String nom;
	private int force;
	private int NbEquipements = 0;
	Equipement equipements[];

	public Romain(String nom, int force) {
		assert force >= 0;
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
	}
	
	public int getForce() {
		return force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void sEquiper(Equipement equipement){

		switch (equipement){
		case CASQUE:
			if (NbEquipements == 2){
				System.out.println("Le romain " + nom + " est déjà bien équipé");
			}
			else {
				if (equipements[0] == Equipement.CASQUE){
					System.out.println("Le romain " + nom + " a déjà un casque");
				}
				else {
					equipements[0] = Equipement.CASQUE;
					System.out.println("Le romain " + nom + " prends un casque");
					NbEquipements += 1;
				}
			}
			break;

		case BOUCLIER:
			if (NbEquipements == 2){
				System.out.println("Le romain " + nom + " est déjà bien équipé");
			}
			else {
				if (equipements[1] == Equipement.BOUCLIER){
					System.out.println("Le romain " + nom + " a déjà un bouclier");
				}
				else {
					equipements[1] = Equipement.BOUCLIER;
					System.out.println("Le romain " + nom + " prends un bouclier");
					NbEquipements += 1;
				}
			}
			break;
		}

	}
	public Equipement[] recevoirCoup(int forceCoup) 
	{
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == 0) {
			parler("Aïe");
			
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((NbEquipements != 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
					for (int i = 0; i < NbEquipements;i++) {
						if ((equipements[i] != null &&
								equipements[i].equals(Equipement.BOUCLIER))) {
							resistanceEquipement += 8;
						} else {
							System.out.println("Equipement casque");
							resistanceEquipement += 5;
						}
					}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[NbEquipements];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < NbEquipements; i++) {

			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
						equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public static void main(String[] args) {
		System.out.println("Les équipements disponnibles pour les romains sont");
		for (Equipement equipement : Equipement.values()) {
			System.out.println(equipement);
		}



		Gaulois asterix = new Gaulois ("Astérix", 8) ;
		Romain antivirus = new Romain("Antivirus",6);
		System.out.println(antivirus.getNom());
		System.out.println(antivirus);
		antivirus.prendreParole();
		antivirus.parler("Je suis Antivirus");
		antivirus.sEquiper(Equipement.CASQUE);
		antivirus.sEquiper(Equipement.CASQUE);
		antivirus.sEquiper(Equipement.BOUCLIER);
		antivirus.sEquiper(Equipement.BOUCLIER);

		antivirus.recevoirCoup(3);

	}
}