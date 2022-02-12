package fr.orsys.fx.kanban.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.orsys.fx.kanban.business.Developpeur;
import fr.orsys.fx.kanban.dao.ConnexionBdd;
import fr.orsys.fx.kanban.dao.DeveloppeurDao;
import fr.orsys.fx.kanban.dao.Requetes;

public class DeveloppeurDaoImpl implements DeveloppeurDao {
	private Connection connexion;

	public DeveloppeurDaoImpl(Connection connexion) {
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
	public Developpeur create(Developpeur developpeur) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_DEVELOPPEUR,
				// On souhaite récupérer l'id que MySQL a attribué à la nouvelle développeur
				Statement.RETURN_GENERATED_KEYS);

		// On remplace le premier point d'interrogation par le date de naissance de la
		// développeur
		ps.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.from(developpeur.getDateNaissance())));
		ps.setString(2, developpeur.getEmail());
		ps.setString(3, developpeur.getNom());
		ps.setString(4, developpeur.getPrenom());
		// On demande l'exécution de la requête SQL à MySQL
		ps.executeUpdate();

		// On récupère l'id attribué par MySQL, cet id est placé dans une matrice de
		// résultat à
		// une ligne et une colonne
		ResultSet rs = ps.getGeneratedKeys();

		if (rs.next()) {
			// On lit dans la matrice de résultat la premiere cellule
			// on se sert de cette donnée pour mettre à jour l'id de la colonne
			developpeur.setId(rs.getLong(1));
		}
		return developpeur;
	}

	@Override
	public Developpeur findOne(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Developpeur> findAll() throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.RECUPERATION_DEVELOPPEURS);
        ResultSet rs = ps.executeQuery();
    
        List<Developpeur> developpeurs = new ArrayList<>();
    
        while (rs.next()) {
            Long idDeveloppeur = rs.getLong("id");
            LocalDate dateDeNaissance = rs.getDate("date_naissance").toLocalDate();
            String email = rs.getString("email");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            
            developpeurs.add(new Developpeur("nom", "prenom"));
        }
        
        return developpeurs;
	}

	@Override
	public List<Developpeur> findByNomStartingWith(String filtre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
