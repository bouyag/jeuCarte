package com.atexo.entities;

import java.util.ArrayList;
import java.util.List;

import com.atexo.constantes.Variables;
import com.atexo.enumerations.COULEUR;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Azzeddine
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JeuCarte {

	private List<COULEUR> randomCouleurs = new ArrayList<COULEUR>();
	private List<String> randomValeurs = new ArrayList<String>();
	private List<Carte> listeCarte = new ArrayList<Carte>();

	/* Construire un ordre aléatoire des couleur */

	public void melangerCouleur() {

		while (randomCouleurs.size() < Variables.NBR_COULEUR) {
			int c = RandomValue(COULEUR.values().length);
			if (!randomCouleurs.contains(COULEUR.getCouleur(c)))
				randomCouleurs.add(COULEUR.getCouleur(c));
		}
	}

	/* Construire un ordre aléatoire des valeurs */

	public void melangerValeurs() {

		while (randomValeurs.size() < Variables.VALEURS.length) {
			int v = RandomValue(Variables.VALEURS.length);
			if (!randomValeurs.contains(Variables.VALEURS[v]))
				randomValeurs.add(Variables.VALEURS[v]);
		}
	}

	/* Construire une main de 10 carte d'une manière aléatoire */

	public void tirerMain() {

		while (listeCarte.size() < Variables.NBR_CARTE) {

			int c = RandomValue(COULEUR.values().length);
			int v = RandomValue(Variables.VALEURS.length);

			Carte carte = new Carte(COULEUR.getCouleur(c), Variables.VALEURS[v]);
			if (NotExist(carte))
				listeCarte.add(carte);

		}
	}

	/* Retourner une valeur aléatoire entre 0 et MAX-1 */

	private int RandomValue(int MAX) {
		return (int) (Math.random() * MAX);
	}

	private boolean NotExist(Carte c) {
		return !listeCarte.contains(c);
	}

}
