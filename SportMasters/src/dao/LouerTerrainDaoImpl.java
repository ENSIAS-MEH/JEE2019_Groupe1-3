package dao;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.LouerTerrain;
import dao.exceptions.DAOException;

public class LouerTerrainDaoImpl implements LouerTerrainDao {

	private DAOFactory daoFactory;
	private static final String SQL_SELECT = "SELECT  * FROM louerTerrain WHERE id_utilisateur = ? , id_terrain = ? , id_client = ? ";

	LouerTerrainDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public LouerTerrain trouver(int id_utilisateur, int id_terrain, int id_date) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		LouerTerrain louerTerrain = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT, false, id_utilisateur, id_terrain,
					id_date);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			if (resultSet.next()) {
				louerTerrain = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return louerTerrain;

	}

	private static LouerTerrain map(ResultSet resultSet) throws SQLException {
		LouerTerrain louerTerrain = new LouerTerrain();
		louerTerrain.setId_utilisateur(resultSet.getInt("id_utilisateur"));
		louerTerrain.setId_date(resultSet.getInt("id_date"));
		louerTerrain.setId_terrain(resultSet.getInt("Id_terrain"));
		louerTerrain.setHeure(resultSet.getInt("heure"));
		return louerTerrain;
	}

}
