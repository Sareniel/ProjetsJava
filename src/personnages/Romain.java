package personnages;

public class Romain {

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
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		int forceInit = force;
		assert force > 0;
		force -= forceCoup;
		assert forceInit > force;

		if (force > 0) {
			parler("Aïe");
		} 
		else {
			parler("J'abandonne...");
		}
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