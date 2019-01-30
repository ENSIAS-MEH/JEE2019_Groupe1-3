package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Terrain;
import dao.AjoutDao;
import dao.DAOFactory;
import dao.ModifierTerrainDao;
import dao.TerrainDao;
import forms.AjoutForm;

@WebServlet("/ModificationTerrain")
public class ModificationTerrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ModifierTerrainDao modifierDao;
	private TerrainDao terrainDao;

	
    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.modifierDao = daoFactory.getModifierTerrainDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//long id_terrain = Long.parseLong(request.getParameter("id_terrain"));
		
		System.out.println("la modification doGet 00000 était bien faite");

		
		long id_terrain = 14 ;
		Terrain terrain = terrainDao.getTerrain(id_terrain);
		System.out.println("mooodif");
		request.setAttribute("terrain" ,terrain);
		
		System.out.println("la modification doGet était bien faite");

		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierTerrain.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		
		AjoutForm ajoutForm = new AjoutForm();
				
		Terrain terrain = new Terrain();
		
	    terrain = ajoutForm.getNewTerrain(request);
	    
		long id_terrain = Long.parseLong(request.getParameter("id_terrain"));
		terrain.setId_terrain(id_terrain);
	    
		modifierDao.modifier(terrain);
		
		String msg ="la modification était bien faite";

        request.setAttribute("resultatMod", msg);	
		
		System.out.println("la modification doPost était bien faite");

        
		this.getServletContext().getRequestDispatcher("/WEB-INF/ConsulterTerrain.jsp").forward(request, response);

	}
}
