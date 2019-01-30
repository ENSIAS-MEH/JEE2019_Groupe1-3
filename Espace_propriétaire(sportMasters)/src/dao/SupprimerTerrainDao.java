package dao;

import beans.Terrain;
import dao.exceptions.DAOException;

public interface SupprimerTerrainDao {
	
	public void supprimer(long id_terrain) throws DAOException;

}
