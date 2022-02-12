package fr.orsys.fx.kanban.business;

import java.util.List;

public class Colonne {

	private Long id;
	
	// Une colonne a un nom
	private String nom;
	
	// Une colonne comporte un ensemble de taches
	private List<Tache> taches;

	public Colonne() {
		// TODO Auto-generated constructor stub
	}
	
	public Colonne(String nom) {
		this();
		this.nom = nom;
	}

	public Colonne(Long id, String nom) {
		this(nom);
		setId(id);
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

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	@Override
	public String toString() {
		return "Colonne [id=" + id + ", nom=" + nom + "]";
	}
	
}