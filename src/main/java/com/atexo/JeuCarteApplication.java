package com.atexo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atexo.entities.Carte;
import com.atexo.entities.JeuCarte;
import com.atexo.enumerations.COULEUR;

/**
 * 
 * @author Azzeddine : azddin.smi@gmail.com
 * 
 */

@SpringBootApplication
public class JeuCarteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JeuCarteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/* Commencer le jeu */
		JeuCarte jeuCarte = new JeuCarte();

		System.out.println("\n***************** Construire et afficher l'ordre aléatoire des couleurs (1ère étape) *******************\n");
		
		jeuCarte.melangerCouleur();
		List<COULEUR> randomCouleur = jeuCarte.getRandomCouleurs();
		System.out.println(randomCouleur);

		System.out.println("\n***************** Construire et afficher l'ordre aléatoire des valeurs (2ème étape) ********************\n");
		
		jeuCarte.melangerValeurs();
		List<String> randomValeur = jeuCarte.getRandomValeurs();
		System.out.println(randomValeur);

		
		System.out.println("\n***************** Construire une main de 10 carte d'une manière       *********************\n"
						   + "***************** aléatoire et affichage de la liste des cartes :     *********************\n"
						   + "***************** (Présentation de la main non triée)                 *********************\n");
		
		jeuCarte.tirerMain();
		List<Carte> listCarte = jeuCarte.getListeCarte();
		listCarte.forEach(System.out::println);
		
		System.out.println("\n***************** Présentation de la main triée par couleur et vleur ********************\n"
						   + "***************** selon l'ordre défini dans la 1ère et 2ème étape    ********************\n ");
		
		List<Carte> carteTrier = new ArrayList<>();
		randomCouleur.forEach(
				c -> {
					listCarte.stream().filter(
						carte -> carte.getCouleur().equals(c)).forEach(item -> carteTrier.add(item));
					randomValeur.forEach(
							v -> {
								carteTrier.stream().filter(carteT -> carteT.getOrdre().equals(v)).forEach(System.out::println);
							});
					carteTrier.clear();
				}
				);
		System.out.println("\n***************** Source Code Developed By : BOUYAGARDAYAN Azzeddine ********************\n"
						   + "*****************                     Date : 14/03/2021              ********************\n");
		
	}

}
