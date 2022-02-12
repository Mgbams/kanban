package fr.orsys.fx.kanban.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import fr.orsys.fx.kanban.service.impl.VilleServiceImpl;

class VilleServiceTest {

	private VilleService villeService = new VilleServiceImpl();
	
	@Test
	void testImporterVilles() {
		assertTimeout(Duration.ofSeconds(5), new Executable() {
			
			@Override
			public void execute() throws Throwable {
				//villeService.importerVilles();
				
			}
		});
	}

}
