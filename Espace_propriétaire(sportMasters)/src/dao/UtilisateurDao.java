package dao;

import beans.Utilisateur;
import dao.exceptions.DAOException;

public interface UtilisateurDao {

	void creer(Utilisateur utilisateur) throws DAOException;

	Utilisateur trouver(String email) throws DAOException;

}