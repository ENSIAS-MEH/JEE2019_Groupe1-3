package dao;

import static dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Terrain;
import dao.exceptions.DAOException;

public class TerrainDaoImpl implements TerrainDao {
	private DAOFactory daoFactory;
	private static final String SQL_SELECT_TOUS_TERRAINS = "SELECT * FROM terrains ";
	// private static final String SQL_INSERT = "INSERT INTO utilisateur (email,
	// mot_de_passe, nom, date_inscription) VALUES (?, ?, ?, NOW())";

	TerrainDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void creer(Terrain terrain) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Terrain> getListeTerrains() throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Terrain> listeTerrains = new ArrayList<Terrain>();
		int count = 0;
		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement(SQL_SELECT_TOUS_TERRAINS);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			while (resultSet.next()) {
				count++;
				Terrain terrain = new Terrain();
				terrain.setId_terrain(resultSet.getInt("id_terrain"));
				terrain.setDescription(resultSet.getString("description_terrain"));
				terrain.setImage(resultSet.getString("image_terrain"));
				terrain.setPrix(resultSet.getDouble("prix"));
				listeTerrains.add(terrain);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
		if (count != 0)
			return listeTerrains;
		else
			return null;
	}

}
