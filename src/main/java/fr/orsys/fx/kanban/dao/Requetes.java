package fr.orsys.fx.kanban.dao;

public class Requetes {

	public static final String AJOUT_COLONNE = "INSERT INTO colonne (nom) VALUES (?)";
	public static final String RECUPERATION_COLONNES = "SELECT id, nom FROM colonne";
	public static final String RECUPERATION_COLONNE_PAR_ID = "SELECT id, nom FROM colonne WHERE id=?";
	
	public static final String AJOUT_VILLE = "INSERT INTO ville (nom, code_postal, code_insee, complement, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String RECUPERATION_VILLES = "SELECT id, nom, code_postal, code_insee, complement, latitude, longitude FROM ville";
	public static final String RECUPERATION_VILLE_PAR_ID = "SELECT id, nom, code_postal, code_insee, complement, latitude, longitude FROM colonne WHERE id=?";
	public static final String RECUPERATION_NB_VILLES = "SELECT count(*) as nbVilles FROM ville";
	
	public static final String AJOUT_DEVELOPPEUR = "INSERT INTO developpeur (date_naissance, email, nom, prenom) VALUES (?, ?, ?, ?)";
	public static final String RECUPERATION_DEVELOPPEURS  = "SELECT id, date_naissance, email, nom, prenom FROM developpeur";
	public static final String RECUPERATION_DEVELOPPEUR_PAR_ID = "SELECT id, date_naissance, email, nom, prenom FROM developpeur WHERE id = ?";
	public static final String RECUPERATION_DEVELOPPEUR_PAR_SEARCH = "SELECT id, date_naissance, email, nom, prenom FROM developpeur WHERE nom LIKE %?%";


}
