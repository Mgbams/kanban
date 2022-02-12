package fr.orsys.fx.kanban.business;

import java.util.List;

public class TypeTache {

	private Long id;
	
	private String nom;
	private String couleur;
	
	private List<Tache> taches;
	
	private String description;
	
	public TypeTache() {
		// TODO Auto-generated constructor stub
	}

	public TypeTache(String nom, String couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TypeTache [id=" + id + ", nom=" + nom + ", couleur=" + couleur + ", description=" + description + "]";
	}
	
}