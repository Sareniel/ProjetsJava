package personnages;

public class Village {
	private String nom;
	private Chef chef;
	
	
	int nbVillageois = 0;
	Gaulois villageois[];
	
	public Village(String nom, int nbVillageoisMax  ) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMax];
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Chef getChef() {
		return chef;
	}


	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void ajouterHabitant(Gaulois habitant) {
		villageois[nbVillageois] = habitant;
		nbVillageois = nbVillageois + 1;
		
	}
	
	public Gaulois trouverHabitant(int index_hab) {
		Gaulois habitant = villageois[index_hab];
		return habitant;
	}
	
	public void afficherHabitant() {
		String nomChef = chef.getNom();
		System.out.println("Le village du grand chef" + nomChef + "est habité par les légendaires");
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois habitant = villageois[i];
			String nomHab = habitant.getNom();
			System.out.println(nomHab);	
		}
	}
	
	public static void main(String[] args) {
		
		Village village = new Village("Village des irreductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);//
		//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30//
		//at personnages.Village.trouverHabitant(Village.java:44)//
		//at personnages.Village.main(Village.java:51) //
		
		Chef abraracourcix = new Chef(" Abraracourcix ",6,village);
		Gaulois asterix = new Gaulois("Asterix",8);
		Gaulois obelix = new Gaulois("Obélix",12);
		/*Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois);
		On a pas ajouté de gaulois comme habitant donc pas de gaulois, ce qui retourne "null"
		"null" */
		village.setChef(abraracourcix); 
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		
		village.afficherHabitant();
		
		
		
	}
	

	
	
}
