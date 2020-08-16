package com.guillaume.puissance4.main;

import java.util.Scanner;

import com.guillaume.puissance4.model.Joueur;
import com.guillaume.puissance4.model.Plateau;
import com.guillaume.puissance4.traitement.Partie;

public class main {

	public static void main(String[] args) {
		Partie partie = new Partie();
		Plateau plateau = partie.getPlateau();
		Joueur joueur1 = partie.getJoueur1();
		Joueur joueur2 = partie.getJoueur2();
		String nomjoueur1;
		String nomjoueur2;
		/**
		 * recupération du nom des joueurs
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("nom du joueur 1 :");
		nomjoueur1 = sc.nextLine();
		System.out.println("nom du joueur 2 :");
		nomjoueur2 = sc.nextLine();
		joueur1.setPrenom(nomjoueur1);
		joueur1.setCouleur("jaune (O)");
		joueur2.setPrenom(nomjoueur2);
		joueur2.setCouleur("rouge (X)");
		System.out.println("nom du joueur 1 :" + nomjoueur1 + " " + joueur1.getCouleur());
		System.out.println("nom du joueur 2 :" + nomjoueur2 + " " + joueur2.getCouleur());
		plateau.afficher();
		/**
		 * boucle de jeu
		 */
		Joueur joueur = joueur1;

		while (partie.isMatchNul() == false && partie.getGagnant() == null) {
			System.out.println(joueur.getPrenom() + " choisit une colonne");
			while (partie.jouer(joueur, sc.nextInt()) == false) {
			}
			plateau.afficher();
			if (joueur.equals(joueur1)) {
				joueur = joueur2;

			} else {
				joueur = joueur1;
			}
		}
		if (partie.getGagnant() != null) {
			System.out.println("le gagnant est " + partie.getGagnant().getPrenom());
		} else
			System.out.println("match nul!");
	}

}
