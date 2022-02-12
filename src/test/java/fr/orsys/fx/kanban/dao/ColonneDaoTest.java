package fr.orsys.fx.kanban.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.orsys.fx.kanban.business.Colonne;
import fr.orsys.fx.kanban.dao.impl.ColonneDaoImpl;

class ColonneDaoTest {

	private ColonneDao colonneDao = new ColonneDaoImpl();
		
	@Test
	@DisplayName("Méthode qui teste l'ajout d'une colonne")
	void testCreate() throws SQLException {
		String nom = "Test";
		Colonne colonne = new Colonne(nom);

		try {
				colonneDao.create(colonne);
			} catch (Exception e) {
				fail("insertion de la colonne impossible : "+ e);
			}
		assertNotNull(colonne);
		assertNotNull(colonne.getId());
		assertTrue(colonne.getId()>0);
		assertNotNull(colonne.getNom());
		assertEquals(colonne.getNom(), nom);
	}

	@Test
	void testFindOne() {
		//assertThrows(SQLException.class, () -> colonneDao.findOne(1L));
	}

	@Test
	void testFindAll() {
		//fail("Not yet implemented");
	}

	@Test
	void testFindByNomStartingWith() {
		//fail("Not yet implemented");
	}

}
