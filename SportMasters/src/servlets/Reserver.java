package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ListLouerTerrain;
import dao.DAOFactory;
import dao.ListLouerTerrainDao;

/**
 * Servlet implementation class Reserver
 */
@WebServlet("/Reserver")
public class Reserver extends HttpServlet {
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String VUE = "/WEB-INF/reserver.jsp";
	private ListLouerTerrainDao listLouerTerrainDao;

	@Override
	public void init() throws ServletException {
		/* Récupération d'une instance de notre DAO Utilisateur */
		this.listLouerTerrainDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getListLouerTerrainDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(getServletContext().getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ListLouerTerrain listLouerTerrain = listLouerTerrainDao.trouver(id_terrain,
		// id_date);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
