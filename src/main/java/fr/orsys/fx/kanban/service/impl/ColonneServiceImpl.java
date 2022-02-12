package fr.orsys.fx.kanban.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.orsys.fx.kanban.business.Colonne;
import fr.orsys.fx.kanban.dao.ColonneDao;
import fr.orsys.fx.kanban.dao.impl.ColonneDaoImpl;
import fr.orsys.fx.kanban.service.ColonneService;

public class ColonneServiceImpl implements ColonneService {

	private ColonneDao colonneDao = new ColonneDaoImpl();
	
	@Override
	public Colonne ajouterColonne(String nom) {
		try {
			return colonneDao.create(new Colonne(nom));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Colonne recupererColonne(Long id) {
		try {
			return colonneDao.findOne(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Colonne> recupererColonnes() {
		try {
			return colonneDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}