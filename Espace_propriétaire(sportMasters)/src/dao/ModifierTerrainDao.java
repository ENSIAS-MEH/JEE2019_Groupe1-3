package dao;

import beans.Terrain;
import dao.exceptions.DAOException;

public interface ModifierTerrainDao {
	
	void modifier(Terrain terrain) throws DAOException;

}
