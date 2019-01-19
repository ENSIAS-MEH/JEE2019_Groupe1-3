package forms;

import forms.exceptions.*;

import dao.exceptions.*;

import dao.UtilisateurDao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;

public final class InscriptionForm {
	public static final String CHAMP_NOM = "nom";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_CONF = "confirmation";
	public static final String CHAMP_PASS = "motdepasse";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private UtilisateurDao utilisateurDao;

	public InscriptionForm(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Utilisateur inscrireUtilisateur(HttpServletRequest request) {
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String confirmation = getValeurChamp(request, CHAMP_CONF);
		String nom = getValeurChamp(request, CHAMP_NOM);

		Utilisateur utilisateur = new Utilisateur();
		try {
			traiterEmail(email, utilisateur);
			traiterMotsDePasse(motDePasse, confirmation, utilisateur);
			traiterNom(nom, utilisateur);

			if (erreurs.isEmpty()) {
				utilisateurDao.creer(utilisateur);
				resultat = "Succ�s de l'inscription.";
			} else {
				resultat = "�chec de l'inscription.";
			}
		} catch (DAOException e) {
			resultat = "�chec de l'inscription : une erreur impr�vue est survenue, merci de r�essayer dans quelques instants.";
			e.printStackTrace();
		}

		return utilisateur;
	}

	/*
	 * Appel � la validation de l'adresse email re�ue et initialisation de la
	 * propri�t� email du bean
	 */
	private void traiterEmail(String email, Utilisateur utilisateur) {
		try {
			validationEmail(email);
		} catch (FormValidationException e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		utilisateur.setEmail(email);
	}

	/*
	 * Appel � la validation des mots de passe re�us initialisation de la propri�t�
	 * motDePasse du bean
	 */
	private void traiterMotsDePasse(String motDePasse, String confirmation, Utilisateur utilisateur) {
		try {
			validationMotsDePasse(motDePasse, confirmation);
		} catch (FormValidationException e) {
			setErreur(CHAMP_PASS, e.getMessage());
			setErreur(CHAMP_CONF, null);
		}
		utilisateur.setMotDePasse(motDePasse);
	}

	/*
	 * Appel � la validation du nom re�ue et initialisation de la propri�t� nom du
	 * bean
	 */
	private void traiterNom(String nom, Utilisateur utilisateur) {
		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		utilisateur.setNom(nom);
	}

	/*
	 * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}

	/* Validation de l'adresse email */
	private void validationEmail(String email) throws FormValidationException {
		if (email != null) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new FormValidationException("Merci de saisir une adresse mail valide.");
			} else if (utilisateurDao.trouver(email) != null) {
				throw new FormValidationException(
						"Cette adresse email est d�j� utilis�e, merci d'en choisir une autre.");
			}
		} else {
			throw new FormValidationException("Merci de saisir une adresse mail.");
		}
	}

	private void validationMotsDePasse(String motDePasse, String confirmation) throws FormValidationException {
		if (motDePasse != null && confirmation != null) {
			if (!motDePasse.equals(confirmation)) {
				throw new FormValidationException(
						"Les mots de passe entr�s sont diff�rents, merci de les saisir � nouveau.");
			} else if (motDePasse.length() < 3) {
				throw new FormValidationException("Les mots de passe doivent contenir au moins 3 caract�res.");
			}
		} else {
			throw new FormValidationException("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	private void validationNom(String nom) throws FormValidationException {
		if (nom != null && nom.length() < 3) {
			throw new FormValidationException("Le nom d'utilisateur doit contenir au moins 3 caract�res.");
		}
	}

	/*
	 * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

}
