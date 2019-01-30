package dao;

import beans.Terrain;
import dao.exceptions.DAOException;

public interface AjoutDao {
	
	void ajouter(Terrain terrain) throws DAOException;

}
