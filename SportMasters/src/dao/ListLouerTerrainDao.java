package dao;

import beans.ListLouerTerrain;
import dao.exceptions.DAOException;

public interface ListLouerTerrainDao {
	ListLouerTerrain trouver(int id_terrain, int id_date) throws DAOException;
}
