package forms;

import forms.exceptions.*;

import dao.exceptions.*;

import dao.AjoutDao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Terrain;


public class AjoutForm {
	
	public static final String CHAMP_brand = "brand";
	public static final String CHAMP_address = "Address";
	//public static final String CHAMP_image = "image" ;
	public static final String CHAMP_urlMaps  = "urlMaps";
	public static final String CHAMP_prix = "prix" ;
	public static final String CHAMP_ville = "ville" ;
	public static final String CHAMP_codePostale = "codePostale" ;
	public static final String CHAMP_description = "description" ;
	public static final String CHAMP_infoDispo = "infoDispo" ;
	public static final String CHAMP_infoClub = "infoClub" ;
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private AjoutDao ajoutDao;
	
	
	
	public AjoutForm (AjoutDao ajoutDao) {
		this.ajoutDao = ajoutDao ;
	}
	
	public AjoutForm() {
		// TODO Auto-generated constructor stub
	}

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	public Terrain getNewTerrain(HttpServletRequest request) {
		
		/*String brand = getValeurChamp(request, CHAMP_brand);
		String address = getValeurChamp(request, CHAMP_address);
		//String image = getValeurChamp(request, CHAMP_image);
		String urlMaps = getValeurChamp(request, CHAMP_urlMaps);
		String infoClub = getValeurChamp(request, CHAMP_infoClub);
		String prix_ =  getValeurChamp(request, CHAMP_prix);
		String ville =  getValeurChamp(request, CHAMP_ville);
		String codePostale =  getValeurChamp(request, CHAMP_codePostale);
		String description =  getValeurChamp(request, CHAMP_description);*/
		
		System.out.println("AjoutForm--->getNewTerrain");

		Terrain terrain = new Terrain();
		
		terrain.setBrand(request.getParameter("brand"));
		terrain.setAddress(request.getParameter("address"));
		//terrain.setImage(image);
		terrain.setCodePostale(request.getParameter("codePostale"));
		terrain.setVille(request.getParameter("ville"));
		terrain.setDescription(request.getParameter("description"));
		terrain.setInfoClub(request.getParameter("infoClub"));
		terrain.setUrl(request.getParameter("urlMaps"));
		
		System.out.println("AjoutForm--->getNewTerrainAvantPrix0");
		System.out.println(terrain.getBrand());
		System.out.println(terrain.getAddress());
		
		double prix = Double.parseDouble(request.getParameter("prix"));
		
		System.out.println("AjoutForm--->getNewTerrainAvantPrix");

		terrain.setPrix(prix);
		

		/*try {
			traiterPrix(prix_, terrain);

			if (erreurs.isEmpty()) {
				ajoutDao.ajouter(terrain);
				resultat = "Succès de l'ajout.";
			} else {
				resultat = "Échec de l'ajout.";
			}
		} catch (DAOException e) {
			resultat = "Échec de l'inscription : une erreur imprévue est survenue, merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}
		*/
		System.out.println("AjoutForm--->getNewTerrainFin");
				
		return terrain;
	}
	
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}
	
	}
	
/*	
	private void traiterPrix(String prix_ ,Terrain terrain) {
		try {
			validationPrix(prix_);
		} catch (FormValidationException e) {
			setErreur(prix_, e.getMessage());
		}
		try {
			terrain.setPrix(validationPrix(prix_));
		} catch (FormValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private double validationPrix(String prix_) throws FormValidationException {
		double prix;
		try {
			 prix = Double.parseDouble(prix_);
		} catch (NumberFormatException e) {
			throw new FormValidationException(" le prix doit être un nombre , exemple 123.5 dh/heure.");
		}
		
		return prix;		
	}

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}
*/
	
