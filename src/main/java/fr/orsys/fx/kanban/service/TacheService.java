package fr.orsys.fx.kanban.service;

import java.util.List;

import fr.orsys.fx.kanban.business.Developpeur;
import fr.orsys.fx.kanban.business.Projet;
import fr.orsys.fx.kanban.business.Tache;
import fr.orsys.fx.kanban.business.TypeTache;

public interface TacheService {

	Tache ajouterTache(Developpeur developpeur, String intitule, int nbHeuresEstimees, Projet projet, TypeTache typeTache);
	Tache ajouterTache(Tache tache);
	
	Tache recupererTache(Long id);
	List<Tache> recupererTaches();
	
	boolean supprimerTache(Long id);
}
