package Histoire;

import personnages.*;


public class Scenario {




	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ("Astérix", 8) ;
		Gaulois obelix = new Gaulois ("Obélix", 25) ;
		Romain minus = new Romain("Minus",6);
		Druide panoramix = new Druide("Panoramix",5,10);	
		panoramix.parler("Je vais préparer une petite potion");
		int potion = panoramix.preparerPotion();
		panoramix.booster(potion,asterix);
		panoramix.booster(potion,obelix);
		obelix.parler("par Bélénos ce n'est pas juste");
		asterix.parler("Merci Druide je sens que ma force est " +potion+ " fois décuplée");
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UN GAUGAU");
		asterix.frapper(minus);
		
	}

}
