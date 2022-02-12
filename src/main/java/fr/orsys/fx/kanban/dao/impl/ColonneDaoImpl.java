package fr.orsys.fx.kanban.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.orsys.fx.kanban.business.Colonne;
import fr.orsys.fx.kanban.dao.ColonneDao;
import fr.orsys.fx.kanban.dao.ConnexionBdd;
import fr.orsys.fx.kanban.dao.Requetes;

public class ColonneDaoImpl implements ColonneDao {

	private Connection connexion;
	
	public ColonneDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Colonne create(Colonne colonne) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(Requetes.AJOUT_COLONNE,
				// On souhaite récupérer l'id que MySQL a attribué à la nouvelle colonne
				Statement.RETURN_GENERATED_KEYS);
		
		// On remplace le premier point d'interrogation par le nom de la colonne
		preparedStatement.setString(1, colonne.getNom());
		// On demande l'exécution de la requête SQL à MySQL
		preparedStatement.executeUpdate();
		
		// On récupère l'id attribué par MySQL, cet id est placé dans une matrice de résultat à 
		// une ligne et une colonne
		ResultSet rs = preparedStatement.getGeneratedKeys();
		
		if (rs.next()) {
			// On lit dans la matrice de résultat la premiere cellule
			// on se sert de cette donnée pour mettre à jour l'id de la colonne
			colonne.setId(rs.getLong(1));
		}
		return colonne;
	}

	@Override
	public Colonne findOne(Long id) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(Requetes.RECUPERATION_COLONNE_PAR_ID);
		preparedStatement.setLong(1, id);
		ResultSet rs = preparedStatement.executeQuery();		
		
		if (rs.next()) {
			String nom = rs.getString("nom");
			return new Colonne(id, nom);
		}
		return null;
	}

	@Override
	public List<Colonne> findAll() throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(Requetes.RECUPERATION_COLONNES);
		ResultSet rs = preparedStatement.executeQuery();		
		List<Colonne> colonnes = new ArrayList<>();
		
		while (rs.next()) {
			Long id = rs.getLong("id");
			String nom = rs.getString("nom");
			colonnes.add(new Colonne(id, nom));
		}
		return colonnes;
	}

	@Override
	public List<Colonne> findByNomStartingWith(String filtre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
