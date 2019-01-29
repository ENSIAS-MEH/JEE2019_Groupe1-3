package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ListLouerTerrain;
import beans.Terrain;
import dao.DAOFactory;
import dao.ListLouerTerrainDao;
import dao.TerrainDao;

/**
 * Servlet implementation class ConfirmerReservation
 */
@WebServlet("/ConfirmerReservation")
public class ConfirmerReservation extends HttpServlet {
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String VUE = "/WEB-INF/confirmerReservation.jsp";
	public static final String VUE_SERVLET = "/reserver";
	public static final String ID_TERRAIN_ATT = "id_terrain";
	public static final String TERRAIN_ATT = "terrain";
	public static final String ID_DATE_ATT = "id_date";
	public static final String LIST_LOUER_TERRAIN_ATT = "listLouerTerrain";
	private ListLouerTerrainDao listLouerTerrainDao;
	private TerrainDao terrainDao;

	@Override
	public void init() throws ServletException {
		/* Récupération d'une instance de notre DAO Utilisateur */
		this.listLouerTerrainDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getListLouerTerrainDao();
		this.terrainDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getTerrainDao();

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
		HttpSession session = request.getSession();

		// String str_id_terrain = request.getParameter(ID_TERRAIN_ATT);

		String str_id_date = request.getParameter(ID_DATE_ATT);
		if (str_id_date.equals("")) {
			String erreur = "erreur!!!";
			session.setAttribute("erreur_date", erreur);
			System.out.println("voila : " + erreur);
			response.sendRedirect(getServletContext().getContextPath() + VUE_SERVLET);

		} else {
			session.setAttribute("erreur_date", null);
			// Integer id_terrain = Integer.valueOf(str_id_terrain);
			Integer id_date = Integer.valueOf(str_id_date);
			Terrain terrain = (Terrain) session.getAttribute(TERRAIN_ATT);
			// System.out.println("voilaa id_terrain: " + terrain.getId_terrain());
			// System.out.println("voilaa id_date : " + id_date.intValue());
			ListLouerTerrain listLouerTerrain = listLouerTerrainDao.trouver(terrain.getId_terrain(),
					id_date.intValue());
			session.setAttribute(TERRAIN_ATT, terrain);
			session.setAttribute(LIST_LOUER_TERRAIN_ATT, listLouerTerrain);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
	}

}
