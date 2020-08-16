package com.guillaume.puissance4.traitement;

import com.guillaume.puissance4.model.Jeton;
import com.guillaume.puissance4.model.Joueur;
import com.guillaume.puissance4.model.Plateau;

public class Partie {

	private Plateau plateau;
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur dernierajouer;

	public Partie() {
		plateau = new Plateau();
		joueur1 = new Joueur("O");
		joueur2 = new Joueur("X");

	}

	public Joueur getGagnant() {
		boolean gagnant = false;
		boolean vertical = false;
		boolean horizontal = false;
		boolean diagonal = false;
		int alignh = 1;
		int alignv = 1;
		int alignd = 1;
		int x = 1;
		int y = 1;
		String symbol = " ";
		/**
		 * control horizontal
		 */
		while ((x < 9 || y < 6) && alignh < 4) {
			while (x < 10 && alignh < 4) {

				if (plateau.getSymbole(x, y).equals(symbol)) {
					if (!symbol.equals(" ")) {
						alignh = alignh + 1;
					} else {
						alignh = 1;
						symbol = plateau.getSymbole(x, y);
					}
				} else {
					alignh = 1;
					symbol = plateau.getSymbole(x, y);
				}
				x = x + 1;
			}
			if (x == 10 && y < 6) {
				x = 1;
				y = y + 1;
			}
		}
		if (alignh == 4)
			horizontal = true;

		/**
		 * control vertical
		 */
		x = 1;
		y = 1;
		symbol = " ";

		while ((y < 6 || x < 9) && alignv < 4) {
			while (y < 7 && alignv < 4) {

				if (plateau.getSymbole(x, y).equals(symbol)) {
					if (!symbol.equals(" ")) {
						alignv = alignv + 1;
					} else {
						alignv = 1;
						symbol = plateau.getSymbole(x, y);
					}
				} else {
					alignv = 1;
					symbol = plateau.getSymbole(x, y);
				}
				y = y + 1;
			}
			if (y == 7 && x < 9) {
				y = 1;
				x = x + 1;
			}
		}
		if (alignv == 4)
			vertical = true;
		/**
		 * control diagonal
		 */

		if ((horizontal == true) || (vertical == true))
			gagnant = true;
		if (gagnant == true)

		{
			if (symbol.equals("O")) {
				return joueur1;
			} else
				return joueur2;

		}
		return null;

	}

	public boolean isMatchNul() {
		if (plateau.getJetons().size() >= 54 && getGagnant() == null) {
			return true;
		}
		return false;

	}

	public boolean jouer(Joueur joueur, int colonne) {
		int y = 6;

		if (colonne > 9 || colonne < 1) {
			System.out.println("veuillez choisir une colonne entre 1 et 9!");
			return false;
		}
		while (plateau.getJeton(colonne, y) != null && y > 0) {
			y = y - 1;

		}
		if (y == 0) {
			System.out.println("colonne pleine! veuillez en choisir une autre!");
			return false;
		}
		Jeton jeton = new Jeton();
		jeton.setX(colonne);
		jeton.setY(y);
		jeton.setJoueur(joueur);
		plateau.getJetons().add(jeton);
		return true;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public Joueur getDernierajouer() {
		return dernierajouer;
	}

	public void setDernierajouer(Joueur dernierajouer) {
		this.dernierajouer = dernierajouer;
	}
}
