package dao;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ListLouerTerrain;
import beans.LouerTerrain;
import dao.exceptions.DAOException;

public class ListLouerTerrainDaoImpl implements ListLouerTerrainDao {

	private DAOFactory daoFactory;
	private static final String SQL_SELECT = "SELECT  * FROM louerTerrain WHERE id_terrain = ? , id_date = ? ";

	ListLouerTerrainDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public ListLouerTerrain trouver(int id_terrain, int id_date) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ListLouerTerrain listLouerTerrain = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT, false, id_terrain, id_date);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			if (resultSet.next()) {
				listLouerTerrain = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return listLouerTerrain;

	}

	private static ListLouerTerrain map(ResultSet resultSet) throws SQLException {
		ListLouerTerrain listLouerTerrain = new ListLouerTerrain();
		ArrayList<LouerTerrain> liste = new ArrayList<LouerTerrain>();

		while (resultSet.next()) {
			LouerTerrain louerTerrain = new LouerTerrain();
			louerTerrain.setId_utilisateur(resultSet.getInt("id_utilisateur"));
			louerTerrain.setId_date(resultSet.getInt("id_date"));
			louerTerrain.setId_terrain(resultSet.getInt("id_terrain"));
			louerTerrain.setHeure(resultSet.getInt("heure"));

			liste.add(louerTerrain);
		}
		listLouerTerrain.setList(liste);

		return listLouerTerrain;
	}
}
