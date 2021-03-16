package com.atexo.enumerations;

/**
 * 
 * @author Azzeddine
 *
 */

public enum COULEUR {
	
	COEUR, CARREAU, PIQUE, TREFLE;
	
	private static COULEUR[] list = COULEUR.values();

    public static COULEUR getCouleur(int i) {
        return list[i];
    }

    public static int listGetLastIndex() {
        return list.length - 1;
    }

}
