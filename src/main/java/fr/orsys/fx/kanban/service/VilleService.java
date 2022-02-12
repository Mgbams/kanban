package fr.orsys.fx.kanban.service;

import java.util.List;
import java.util.Map;

import fr.orsys.fx.kanban.business.Ville;

public interface VilleService {

	List<Ville> importerVilles();

	int recupererNbVilles();

//	List<Ville> recupCP42330VillesForEach();
//
//	List<Ville> recupCP42330VillesStream();
//
//	List<Ville> recupCP42330VillesParallelStream();

	/**
	 * Méthode qui renvoie toutes les villes du département donné en paramètre et dont le nom débute par le deuxième paramètre
	 * 
	 * @param la liste des villes
	 * @param le filtre sur le département
	 * @param le filtre sur le nom de la ville
	 * 
	 * @return
	 */
//	List<Ville> recupererVillesDuDepartement(String filtreDepartement, String filtreNom);
//
//	List<String> recupererVillesAyantCPNonUnique();
//
//	List<Ville> recupererVillesDuSudOuest();
//
//	Map<Ville, Object> chargerVillesDansMap();
}
