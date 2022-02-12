package fr.orsys.fx.kanban.business;

import java.time.LocalDateTime;

public class Tache {

	private Long id;

	private String intitule;

	private LocalDateTime dateCreation;

	private int nbHeuresEstimees;

	private int nbHeuresReelles;

	private Developpeur developpeur;

	private TypeTache typeTache;

	private Colonne colonne;
	
	private Projet projet;
	
	// Surcharge de constructeurs (overload)
	public Tache() {
		setDateCreation(LocalDateTime.now());
	}
	
	public Tache(String intitule) {
		this();
		this.intitule = intitule;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	
	public int getNbHeuresEstimees() {
		return nbHeuresEstimees;
	}

	public void setNbHeuresEstimees(int nbHeuresEstimees) {
		this.nbHeuresEstimees = nbHeuresEstimees;
	}

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	public TypeTache getTypeTache() {
		return typeTache;
	}

	public void setTypeTache(TypeTache typeTache) {
		this.typeTache = typeTache;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public int getNbHeuresReelles() {
		return nbHeuresReelles;
	}

	public void setNbHeuresReelles(int nbHeuresReelles) {
		this.nbHeuresReelles = nbHeuresReelles;
	}

	public Colonne getColonne() {
		return colonne;
	}

	public void setColonne(Colonne colonne) {
		this.colonne = colonne;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", intitule=" + intitule + ", dateCreation=" + dateCreation + ", nbHeuresEstimees="
				+ nbHeuresEstimees + ", nbHeuresReelles=" + nbHeuresReelles + ", developpeur=" + developpeur
				+ ", typeTache=" + typeTache + ", colonne=" + colonne + ", projet=" + projet + "]";
	}

}