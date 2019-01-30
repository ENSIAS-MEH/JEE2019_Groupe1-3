package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Terrain;
import dao.ConsulterDao;
import dao.DAOFactory;
import dao.SupprimerTerrainDao;


@WebServlet("/MesTerrain")
public class MesTerrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String Mes_Terrains = "mesTerrains";
	private ConsulterDao consulterDao;
	private SupprimerTerrainDao supprimerTerrainDao;

	
    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.consulterDao = daoFactory.getConsulterDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
    	/*HttpSession session = request.getSession();
    	long id_proprietaire = (long)session.getAttribute("id_proprietaire");*/
		
		System.out.println("hhhhhhhhhhh");
		long id_propriétaire= 1 ;
		
		ArrayList<Terrain> listeTerrains = consulterDao.getMesListeTerrains(id_propriétaire);

		request.setAttribute("listeTerrains", listeTerrains);
		
		System.out.println(listeTerrains);
		
		System.out.println("yyyyyyyyyy");

		this.getServletContext().getRequestDispatcher("/WEB-INF/ConsulterTerrains.jsp").forward(request, response);

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
