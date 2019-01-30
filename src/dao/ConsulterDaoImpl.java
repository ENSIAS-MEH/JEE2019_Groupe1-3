package dao;

import static dao.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Terrain;
import dao.exceptions.DAOException;

public class ConsulterDaoImpl implements ConsulterDao {
	private DAOFactory daoFactory;
	private static final String SQL_SELECT_MES_TERRAINS = "SELECT * FROM terrains where id_proprietaire = ? ";
	// private static final String SQL_INSERT = "INSERT INTO utilisateur (email,
	// mot_de_passe, nom, date_inscription) VALUES (?, ?, ?, NOW())";

	ConsulterDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public ArrayList<Terrain> getMesListeTerrains(long id_proprietaire) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Terrain> listeTerrains = new ArrayList<Terrain>();
		int count = 0;
		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_MES_TERRAINS, false, id_proprietaire);
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			while (resultSet.next()) {
				count++;
				
				Terrain terrain = new Terrain();
				
				terrain.setId_terrain(resultSet.getInt("id_terrain"));
				terrain.setDescription(resultSet.getString("description_terrain"));
				terrain.setImage(resultSet.getString("image_terrain"));
				terrain.setPrix(resultSet.getDouble("prix"));
				terrain.setBrand(resultSet.getString("brand"));
				terrain.setAddress(resultSet.getString("address"));
				terrain.setCodePostale(resultSet.getString("code_postale"));
				terrain.setVille(resultSet.getString("ville"));
				terrain.setUrl(resultSet.getString("urlMaps"));
				terrain.setInfoClub(resultSet.getString("infoClub"));

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
