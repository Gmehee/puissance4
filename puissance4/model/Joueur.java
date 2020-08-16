package com.guillaume.puissance4.model;

public class Joueur {
	private String prenom;
	private String couleur;
	private String symbole;

	public Joueur() {
	}

	public Joueur(String symbole) {
		this.symbole = symbole;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
}
