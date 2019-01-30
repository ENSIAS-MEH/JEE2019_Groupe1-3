package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Terrain;
import dao.AjoutDao;
import dao.ConsulterDao;
import dao.DAOFactory;
import dao.SupprimerTerrainDao;

@WebServlet("/SuppressionTerrain")
public class SuppressionTerrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SupprimerTerrainDao supprimerTerrainDao;
	private ConsulterDao consulterDao;

	
    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.supprimerTerrainDao = daoFactory.getSupprimerTerrainDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*HttpSession session = request.getSession();
    	long id_proprietaire = (long)session.getAttribute("id_proprietaire");*/
		
		System.out.println("hhhhhhhhhhh");


		
		/*long id_terrain ;
		id_terrain = Long.parseLong(request.getParameter("id_terrain"));*/
		long id_terrain = 14;
		
		supprimerTerrainDao.supprimer(id_terrain);
		
		System.out.println("la suppression était bien faite");
		
		String msg ="la suppression était bien faite";

        request.setAttribute("resultatSup", msg);	
		System.out.println("la suppression était bien faite");

		this.getServletContext().getRequestDispatcher("/WEB-INF/ConsulterTerrain.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
