package com.mauthjwt.commun.util.liste;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListUtil {
	
	/**
	 * Permet de savoir si une liste est vide ou non.
	 * Dans le cas où liste est nulle, la méthode retourne true
	 * (La liste est considére comme vide).
	 * @param c Liste à tester
	 * @return true : est vide, false : n'est pas vide. 
	 */
	public static boolean isEmpty(Collection c) {
		if(c == null){ return true;}
		return c.isEmpty();
	}
	
	/**
	 * Permet de savoir si une liste n'est pas vide.
	 * @param c Liste à tester
	 * @return true : n'est pasvide, false : est vide. 
	 */
	public static boolean isNotEmpty(Collection c) {
		return !isEmpty(c);
	}
	
	/**
	 * Permet de savoir si la liste ne contient qu'une seule ligne ou non
	 * @param liste liste à tester
	 * @return true : la liste n'a qu'une seule ligne, false : la liste n'a pas qu'une seule ligne.
	 */
	public static boolean hasOnlyOneLine(List liste) {
		if(liste == null){ return false;}
		return liste.size() == 1;
	}
	
	/**
	 * Supprime les doublons d'une liste donnée
	 * 
	 * @param col
	 * @return
	 */
	public static<T> Set<T> removeDuplicateItems(Collection<T> col){
		if(col==null){
			return null;
		}
		Set<T> setCol = new HashSet<T>();
		Iterator<T> itCol = col.iterator();
		while(itCol.hasNext()){
			T obj = itCol.next();
			if(!setCol.contains(obj)){
				setCol.add(obj);
			}
		}
		return setCol;
	}
	
}