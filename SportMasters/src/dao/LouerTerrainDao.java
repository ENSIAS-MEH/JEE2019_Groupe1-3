package dao;

import beans.LouerTerrain;
import dao.exceptions.DAOException;

public interface LouerTerrainDao {

	LouerTerrain trouver(int id_utilisateur, int id_terrain, int id_date) throws DAOException;

}
