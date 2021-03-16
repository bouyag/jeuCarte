package com.atexo.entities;

import com.atexo.enumerations.COULEUR;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Azzeddine
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carte {

	private COULEUR couleur;
	private String ordre;

	@Override
	public String toString() {
		return this.getCouleur() + " -> " + this.getOrdre();
	}

}
