package dao;

import dao.exceptions.DAOException;

import java.util.ArrayList;

import beans.Terrain;

public interface TerrainDao {
	void creer(Terrain terrain) throws DAOException;

	ArrayList<Terrain> getListeTerrains() throws DAOException;
	
	Terrain getTerrain(long id_terrain) throws DAOException;

}
