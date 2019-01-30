package dao;

import static dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Terrain;
import dao.exceptions.DAOException;

public class SupprimerTerrainDaoImpl implements SupprimerTerrainDao {
	private DAOFactory daoFactory;
	private static final String SQL_DELETE_TERRAIN = "DELETE FROM terrains WHERE id_terrain = ?;";
	// private static final String SQL_INSERT = "INSERT INTO utilisateur (email,
	// mot_de_passe, nom, date_inscription) VALUES (?, ?, ?, NOW())";

	SupprimerTerrainDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void supprimer(long id_terrain) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		//ResultSet valeursAutoGenerees = null;
		ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            
			//preparedStatement = initialisationRequetePreparee(connexion, SQL_DELETE_TERRAIN, true, id_terrain );
			
			preparedStatement = connexion.prepareStatement(SQL_DELETE_TERRAIN);
			resultSet = preparedStatement.executeQuery();
			
			//preparedStatement.executeUpdate();
			/* Analyse du statut retourné par la requête d'insertion */

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

}
}
