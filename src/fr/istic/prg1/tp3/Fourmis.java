package fr.istic.prg1.tp3;

/**
 * @author Nathan Fernandes Barbey Robin (Mickaël Foursov <foursov@univ-rennes1.fr>)
 * @version 5.0
 * @since 2022-09-23
 * 
 */

public class Fourmis {

	/**
	 * @param s un terme de la suite des fourmis
	 * @pre s.length() > 0
	 * @return le terme suivant de la suite des fourmis
	 */
	public static String next(String s) {
		char[] chaine = s.toCharArray();
		int count = 1;
		String ant = "";
		for(int i=1; i<chaine.length; i++) {
			if(chaine[i]==chaine[i-1]) {
				count++;
			}
			else {
				ant = ant.concat(String.valueOf(count).concat(String.valueOf(chaine[i-1])));
				System.out.println("oui: " + ant);
				count = 1;
			}
		}
		ant = ant.concat(String.valueOf(count).concat(String.valueOf(chaine[chaine.length-1])));
		return ant;
	}
}