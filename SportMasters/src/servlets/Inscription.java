package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.DAOFactory;
import dao.UtilisateurDao;
import forms.InscriptionForm;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/inscription.jsp";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String ATT_LISTETERRAINS = "listeTerrains";
	public static final String VUE_LISTETERRAINS = "/listeTerrains";

	private UtilisateurDao utilisateurDao;

	@Override
	public void init() throws ServletException {
		/* Récupération d'une instance de notre DAO Utilisateur */
		this.utilisateurDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUtilisateurDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* Préparation de l'objet formulaire */
		System.out.println("heere2");
		InscriptionForm form = new InscriptionForm(utilisateurDao);

		/* Traitement de la requête et récupération du bean en résultant */
		Utilisateur utilisateur = form.inscrireUtilisateur(request);

		HttpSession session = request.getSession();

		/* Stockage du formulaire et du bean dans l'objet request */
		if (form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_SESSION_USER, utilisateur);
			if (session.getAttribute(ATT_LISTETERRAINS) != null) {
				session.setAttribute(ATT_LISTETERRAINS, null);
				response.sendRedirect(getServletContext().getContextPath() + VUE_LISTETERRAINS); // pour qu'on se trouve
				// une autre fois dans la page listeTerrains
			} else
				response.sendRedirect(getServletContext().getContextPath());
		} else {
			request.setAttribute(ATT_FORM, form); // on fait passer la forme pour gérer les érreurs
			request.setAttribute(ATT_USER, utilisateur);
			session.setAttribute(ATT_SESSION_USER, null);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
	}

}
