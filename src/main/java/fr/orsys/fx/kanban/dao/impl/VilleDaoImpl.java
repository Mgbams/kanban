package fr.orsys.fx.kanban.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.orsys.fx.kanban.business.Colonne;
import fr.orsys.fx.kanban.business.Ville;
import fr.orsys.fx.kanban.dao.ConnexionBdd;
import fr.orsys.fx.kanban.dao.Requetes;
import fr.orsys.fx.kanban.dao.VilleDao;

public class VilleDaoImpl implements VilleDao	 {

	private Connection connexion;
	
	public VilleDaoImpl() {
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
	public Ville create(Ville ville) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(Requetes.AJOUT_VILLE,
				// On souhaite récupérer l'id que MySQL a attribué à la nouvelle ville
				Statement.RETURN_GENERATED_KEYS);
		
		// On remplace le premier point d'interrogation par le nom de la ville
		preparedStatement.setString(1, ville.getNom());
		preparedStatement.setString(2, ville.getCodePostal());
		preparedStatement.setString(3, ville.getCodeInsee());
		preparedStatement.setString(4, ville.getComplement());
		preparedStatement.setDouble(5, ville.getLatitude());
		preparedStatement.setDouble(6, ville.getLongitude());
		// On demande l'exécution de la requête SQL à MySQL
		preparedStatement.executeUpdate();
		
		// On récupère l'id attribué par MySQL, cet id est placé dans une matrice de résultat à 
		// une ligne et une colonne
		ResultSet rs = preparedStatement.getGeneratedKeys();
		
		if (rs.next()) {
			// On lit dans la matrice de résultat la premiere cellule
			// on se sert de cette donnée pour mettre à jour l'id de la ville
			ville.setId(rs.getLong(1));
		}
		return ville;
	}

	@Override
	public Ville findOne(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ville> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(Requetes.RECUPERATION_NB_VILLES);
		ResultSet rs = preparedStatement.executeQuery();		
		
		if (rs.next()) {
			return rs.getInt("nbVilles");
		}
		return 0;
	}

}
