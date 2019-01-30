package dao;

import static dao.DAOUtilitaire.*;

import java.sql.*;

import beans.Terrain;
import dao.exceptions.DAOException;

public class AjoutDaoImpl implements AjoutDao {
    private DAOFactory daoFactory;
	private static final String SQL_INSERT ="INSERT INTO terrains(description_terrain, prix ,brand ,address ,code_postale ,ville , urlMaps ,infoclub ) VALUES(?,?,?,?,?,?,?,?);" ; 


    AjoutDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Terrain terrain) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;
		System.out.println("AjoutDamImpl--->ajouter(terrain)");
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
		           terrain.getInfoClub()
		           /* ,terrain.getId_propri�taire()*/
		           );
			
			
			int statut = preparedStatement.executeUpdate();
			/* Analyse du statut retourn� par la requ�te d'insertion */
			if (statut == 0) {
				throw new DAOException("�chec de la cr�ation du terrain, aucune ligne ajout�e dans la table.");
			}
			/* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
			valeursAutoGenerees = preparedStatement.getGeneratedKeys();
			if (valeursAutoGenerees.next()) {
				/* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
				terrain.setId_terrain(valeursAutoGenerees.getLong(1));
			} else {
				throw new DAOException("�chec de la cr�ation du terrain en base, aucun ID auto-g�n�r� retourn�.");
			}
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
            preparedStatement.setInt(11, terrain.getId_propri�taire());*/

            //preparedStatement.executeUpdate();
            //connexion.commit();
            

    }

}