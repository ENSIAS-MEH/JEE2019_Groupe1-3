package dao;

import static dao.DAOUtilitaire.*;

import java.sql.*;

import beans.Terrain;
import dao.exceptions.DAOException;

public class ModifierTerrainDaoImpl implements ModifierTerrainDao {
	
    private DAOFactory daoFactory;
	private static final String SQL_INSERT ="Update terrains set description_terrain = ? , prix = ? ,brand = ? ,address = ? ,code_postale = ?  ,ville  = ? , urlMaps = ?  ,infoclub = ? where id_terrain = ? ;" ; 


	ModifierTerrainDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void modifier(Terrain terrain) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;
        try {
            connexion = daoFactory.getConnection();
            
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true, 
		           terrain.getDescription(),
		           //terrain.getImage(),
		           terrain.getPrix(),
		           terrain.getBrand(),
		           terrain.getAddress(),
		           terrain.getCodePostale(),
		           terrain.getVille(),
		           terrain.getUrl(),
		           terrain.getInfoClub(),
		           terrain.getId_terrain()
		           );
			
			
			preparedStatement.executeUpdate();
			/* Analyse du statut retourné par la requête d'insertion */
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}
        
           /* preparedStatement = connexion.prepareStatement("INSERT INTO terrains(description_terrain, image_terrain , prix ,brand ,address ,code_postale ,ville , urlMaps,infoDispo ,infoclub,id_proprietaire ) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, terrain.getDescription());
            preparedStatement.setString(2, terrain.getImage());
            preparedStatement.setDouble(3, terrain.getPrix());
            preparedStatement.setString(4, terrain.getBrand());
            preparedStatement.setString(5, terrain.getAddress());
            preparedStatement.setString(6, terrain.getCodePostale());
            preparedStatement.setString(7, terrain.getVille());
            preparedStatement.setString(8, terrain.getUrl());
            preparedStatement.setString(9, terrain.getInfoDispo());
            preparedStatement.setString(10, terrain.getInfoClub());
            preparedStatement.setInt(11, terrain.getId_propriétaire());*/

            //preparedStatement.executeUpdate();
            //connexion.commit();
            

    }

}