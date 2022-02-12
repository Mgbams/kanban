package fr.orsys.fx.kanban.service;

import java.util.List;

import fr.orsys.fx.kanban.business.Colonne;

public interface ColonneService {

	Colonne ajouterColonne(String string);
	
	Colonne recupererColonne(Long id);
	List<Colonne> recupererColonnes();
}
