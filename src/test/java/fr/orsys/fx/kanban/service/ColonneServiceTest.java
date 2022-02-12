package fr.orsys.fx.kanban.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.orsys.fx.kanban.business.Colonne;
import fr.orsys.fx.kanban.service.impl.ColonneServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ColonneServiceTest {

	private ColonneService colonneService = new ColonneServiceImpl();
	
	@Test
	@Order(1)
	void testAjouterColonne() {
		String nomColonne = "Test";
		 Colonne colonne = colonneService.ajouterColonne(nomColonne);
		 assertNotNull(colonne);
		 assertNotNull(colonne.getNom());
		 assertEquals(colonne.getNom(), nomColonne);
	}

	@Test
	@Order(2)
	void testRecupererColonne() {
		String nomColonne = "Test";
		Colonne colonne = colonneService.ajouterColonne(nomColonne);
		colonne = colonneService.recupererColonne(colonne.getId());
		assertNotNull(colonne);
		assertEquals(colonne.getNom(), nomColonne);
		assertTrue(colonne.getId()>0);
	}

	@Test
	@Order(3)
	void testRecupererColonnes() {
		//fail("Not yet implemented");
	}

}
