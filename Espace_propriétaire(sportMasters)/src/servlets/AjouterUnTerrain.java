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
import forms.AjoutForm;

@WebServlet("/AjouterUnTerrain")
public class AjouterUnTerrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_Terrain = "terrain";
	public static final String ATT_FORM = "ajoutForm";
	private AjoutDao ajoutDao;
	
    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.ajoutDao = daoFactory.getAjoutDao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/formaj.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		AjoutForm ajoutForm = new AjoutForm(ajoutDao);
		System.out.println("ajoutForm is ok !");
				
		Terrain terrain = new Terrain();
		
	    terrain = ajoutForm.getNewTerrain(request);
		System.out.println("newTerrain is ok !");
		
        //request.setAttribute("newTerrain", terrain);

		ajoutDao.ajouter(terrain);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/formaj.jsp").forward(request, response);
	}

}
