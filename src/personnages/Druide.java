package personnages;
import java.util.Random;



public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	public String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	public int preparerPotion() {
		Random forcePotion = new Random();
		int potion = forcePotion.nextInt(effetPotionMin, effetPotionMax);
		if (potion > 7 ) {
			this.parler("j'ai préparé une super potion elle a une force de "+potion);
		}	
		else {
			this.parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + potion);
		}
		return potion; 
	}

	public void booster(int potion,Gaulois gaulois) {

		if(gaulois.getNom() == "Obélix"){
			this.parler(" Non, Obélix !... Tu n’auras pas de potion magique !");
		}
		else {
			gaulois.boirePotion(potion);
		}

	}


	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();



	}


}