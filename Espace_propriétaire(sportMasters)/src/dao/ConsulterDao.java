package dao;

import dao.exceptions.DAOException;

import java.util.ArrayList;

import beans.Terrain;

public interface ConsulterDao {

	ArrayList<Terrain> getMesListeTerrains(long id_proprietaire)throws DAOException;
	
}