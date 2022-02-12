package fr.orsys.fx.kanban.dao;

import java.sql.SQLException;
import java.util.List;

import fr.orsys.fx.kanban.business.Ville;

public interface VilleDao {

	Ville create(Ville ville) throws SQLException;
	
	Ville findOne(Long id) throws SQLException;
	List<Ville> findAll() throws SQLException;
	
	int count() throws SQLException;
}
