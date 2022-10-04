package fr.istic.prg1.tp3;

import java.util.*;

/**
 * @author Mickaël Foursov <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2022-09-23
 * 
 *        Partie I
 * 
 *        Lecture, au clavier, d'une suite d'entiers terminée par -1
 * 
 *        Cette suite peut comporter des valeurs doubles.
 * 
 *        Construction et affichage d'un tableau contenant les entiers distincts
 *        triés par valeur croissante.
 * 
 *        Exemple. En entrée : 3 8 1 4 3 2 1 3 -1 ==> En sortie : 1 2 3 4 8
 */

public class InsertionInteger {

	private static final int SIZE_MAX = 10;
	private static final int END_MARKER = -1;
	/**
	 * nombre d’entiers présents dans t, 0 <= size <= SIZE_MAX
	 */
	private int size;
	private int[] array;

	/**
	 * @return copie de la partie remplie du tableau
	 */
	public int[] toArray() {
		int i = 0;
		int[] copy_array = new int[size];
		while(i < size && array[i] != -1){
			copy_array[i] = array[i];
			i++;
		}
		return copy_array;
	}

	/**
	 * array est rempli, par ordre croissant, en utilisant la fonction insert, avec
	 * les valeurs lues par scanner.
	 * 
	 * @param scanner
	 */
	public void createArray(Scanner scanner) {
		while (scanner.hasNext()){
			int nextNumber = scanner.nextInt();
			System.out.println(nextNumber);
			if(nextNumber < 0){System.out.println("Arret scanner"); return;}
			insert(nextNumber);
		}
	}

	/**
	 * Si value n'appartient pas à array[0..size-1] et size < SIZE_MAX, size est
	 * incrémenté de 1, value est inséré dans array et les entiers array[0..size]
	 * sont triés par ordre croissant. Sinon array est inchangé.
	 * 
	 * Exemple :
	 * 
	 * pour x = 5, size = 3, array[0] = 1, array[1] = 6, array[2] = 8
	 * 
	 * insertion délivre true, size = 4,
	 * 
	 * array[0] = 1, array[1] = 5, array[2] = 6, array[3] = 8
	 * 
	 * @param value valeur à insérer
	 * 
	 * @pre les valeurs de array[0..size-1] sont triées par ordre croissant
	 * 
	 * @return false si value appartient à array[0..size-1] ou si array est
	 *         complètement rempli; true si value n’appartient pas à
	 *         array[0..size-1]
	 */
	public boolean insert(int value) {
		if(size==0) {
			size++;
			array = new int[size];
			array[0] = value;
			System.out.println("insertion de " + value + " dans l'array: " + Arrays.toString(array));
			return true;
		}
		if(size >= SIZE_MAX) return false;
		int[] clone = insertClone(value);
		if(clone[0]!=-1) { //Vérification de la validité de la valeur de value au vu de l'insertion.
			size++;
			array = clone;
			return true;
		}
		System.out.println("insertion de " + value + " dans l'array: " + Arrays.toString(array));
		return false;
	}

	/**
	 * @param value la valeur a inserer dans le clone du tableau array
	 * @return clone, qui est le tableau array augmenter de la valeur value
	 * @note si le premier element de clone est -1, l'insertion est considere comme invalide
	 */
	int[] insertClone(int value){
		int[] clone = new int[size+1];
		int j = 0;
		for(int i = 0; i < size; ++i){
			if(array[i] == value){
				clone[0] = -1; //On considérera que si la premiere valeur de clone est -1, l'insertion est invalide.
				break;
			}
			if (array[i] > value && i==j) {
				System.out.printf("compteur i : %d, compteur j: %d \n",i,j);
				clone[j] = value;
				j++;
			}
			 clone[j] = array[i];
			j++;
		}
		if (clone[clone.length-1] == 0) clone[clone.length-1] = value;
		System.out.println("insertion de " + value + " dans clone: " + Arrays.toString(clone));
		return clone;
	}

	@Override
	public String toString() {
		return null;
	}
}
