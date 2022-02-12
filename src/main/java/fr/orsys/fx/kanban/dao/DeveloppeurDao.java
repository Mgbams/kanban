package fr.orsys.fx.kanban.dao;

import java.sql.SQLException;
import java.util.List;

import fr.orsys.fx.kanban.business.Developpeur;

public interface DeveloppeurDao {
	Developpeur create(Developpeur developpeur) throws SQLException;

	// R (Read)
	Developpeur findOne(Long id) throws SQLException;

	List<Developpeur> findAll() throws SQLException;

	List<Developpeur> findByNomStartingWith(String filtre) throws SQLException;

}
