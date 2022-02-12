package fr.orsys.fx.kanban.business;

import java.util.List;

public class Client {

	private Long id;
	
	// Le client a un nom
	private String nom;
	
	// Le client a un ensemble de projet
	private List<Projet> projets;
		
	public Client() {
		// TODO Auto-generated constructor stub
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

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + "]";
	}
	
}