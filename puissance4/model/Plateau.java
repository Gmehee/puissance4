package com.guillaume.puissance4.model;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	int hauteur = 6;
	int largeur = 9;
	List<Jeton> jetons = new ArrayList<Jeton>();

	/**
	 * Renvoie le jeton correspondant au x et y en paramètre.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Jeton getJeton(int x, int y) {
		for (Jeton jeton : jetons) {
			if (jeton.getX() == x) {
				if (jeton.getY() == y) {
					return jeton;
				}
			}
		}

		return null;
	}

	/**
	 * Renvoie le symbole du jeton si il existe sinon renvoie " ".
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public String getSymbole(int x, int y) {
		Joueur joueur;
		Jeton jeton = getJeton(x, y);
		if (jeton != null) {
			joueur = jeton.getJoueur();
			String symbol = joueur.getSymbole();
			return symbol;
		}

		return " ";
	}

	public List<Jeton> getJetons() {
		return jetons;
	}

	public void setJetons(List<Jeton> jetons) {
		this.jetons = jetons;
	}

	/**
	 * Affichage du plateau
	 */
	public void afficher() {
		String affichagePlateau = "-------------------\n";
		for (int j = 1; j <= hauteur; j++) {
			for (int i = 1; i <= largeur; i++) {
				affichagePlateau = affichagePlateau + "|" + getSymbole(i, j);
			}
			affichagePlateau = affichagePlateau + "|\n";
		}
		affichagePlateau = affichagePlateau + "-------------------\n";
		affichagePlateau = affichagePlateau + " 1 2 3 4 5 6 7 8 9\n";
		System.out.print(affichagePlateau);
	}

}
