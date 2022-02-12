package fr.orsys.fx.kanban.dao;

import java.sql.SQLException;
import java.util.List;

import fr.orsys.fx.kanban.business.Colonne;

public interface ColonneDao {

	// C
	/**
	 * Cette méthode ajoute dans la table colonne un enregistrement correspondant à la nouvelle
	 * colonne donnée en paramètre
	 * Cette colonne donné en paramètre ne possède pas encore d'id
	 * 
	 * @param colonne
	 * @return
	 */
	Colonne create(Colonne colonne) throws SQLException;
	
	// R (Read)
	Colonne findOne(Long id) throws SQLException;
	List<Colonne> findAll() throws SQLException;
	List<Colonne> findByNomStartingWith(String filtre) throws SQLException;
	
	// U (Update)
	// YAGNI : You Aren't Gonna Need It
	// n'écrivez pas la méthode de mise à jour si elle ne vous est pas demandée !
	
	// D (Delete)
}
