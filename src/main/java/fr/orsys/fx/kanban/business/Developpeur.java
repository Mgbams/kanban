package fr.orsys.fx.kanban.business;

import java.time.LocalDate;
import java.util.List;

public class Developpeur {

	// Attributs	
	private Long id;
	
	private String prenom;
	
	private String nom;
	
	private LocalDate dateNaissance;
	
	private List<Tache> taches;
	
	private String email;
	
	private int nbTachesEnCours;
	
	private List<Projet> projets;
	
	// Constructeurs
	public Developpeur() {
	}

	public Developpeur(String prenom, String nom) {
		this();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNbTachesEnCours() {
		return nbTachesEnCours;
	}

	public void setNbTachesEnCours(int nbTachesEnCours) {
		this.nbTachesEnCours = nbTachesEnCours;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public String toString() {
		return "Developpeur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
		
}