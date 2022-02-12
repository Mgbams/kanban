package fr.orsys.fx.kanban.business;

import java.time.LocalDateTime;
import java.util.List;

public class Projet {

	private Long id;
	
	private String nom;
	
	private String code;
	
	private Client client;
	
	// Un projet comporte plusieurs taches
	private List<Tache> taches;
	
	// Un projet a une date de création
	private LocalDateTime dateHeureCreation;
	
	// Un projet a une deadline
	private LocalDateTime dateHeureLivraison;
	
	private List<Developpeur> developpeurs;
	
	public Projet() {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	public LocalDateTime getDateHeureLivraison() {
		return dateHeureLivraison;
	}

	public void setDateHeureLivraison(LocalDateTime dateHeureLivraison) {
		this.dateHeureLivraison = dateHeureLivraison;
	}

	public List<Developpeur> getDeveloppeurs() {
		return developpeurs;
	}

	public void setDeveloppeurs(List<Developpeur> developpeurs) {
		this.developpeurs = developpeurs;
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", nom=" + nom + ", code=" + code + ", client=" + client + ", dateHeureCreation="
				+ dateHeureCreation + ", dateHeureLivraison=" + dateHeureLivraison + "]";
	}

}
