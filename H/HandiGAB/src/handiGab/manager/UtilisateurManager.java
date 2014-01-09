package handiGab.manager;

import handiGab.dao.Manager;
import handiGab.dto.UtilisateurDTO;

import java.util.List;



public interface UtilisateurManager extends Manager {
	/**
	 * -------------------------------------------------
	 * cette methode permet d'enregistrer un utilisateur
	 * -------------------------------------------------
	 */
	public String save(UtilisateurDTO utilisateurDTO) throws Exception;
	
	/**
	 * -----------------------------------------------
	 * cette methode permet de modifier un utilisateur
	 * -----------------------------------------------
	 */
	public void update(UtilisateurDTO utilisateurDTO) throws Exception;
	
	/**
	 * ------------------------------------------------
	 * cette methode permet de supprimer un utilisateur
	 * ------------------------------------------------
	 */
	public void delete(UtilisateurDTO utilisateurDTO) throws Exception;
	
	/**
	 * ------------------------------------------------
	 * cette methode permet de consulter un utilisateur
	 * ------------------------------------------------
	 */
	public UtilisateurDTO edit(UtilisateurDTO utilisateurDTO) throws Exception;
	
	/**
	 * -------------------------------------------------
	 * cette methode permet de rechercher un utilisateur
	 * -------------------------------------------------
	 */
	public List<UtilisateurDTO> find(UtilisateurDTO utilisateurDTO) throws Exception;
	
	/**
	 * -----------------------------------------------------
	 * cette methode permet d'afficher tous les utilisateurs
	 * -----------------------------------------------------
	 */
	public List<UtilisateurDTO> all() throws Exception;
	
	
	/***
	 **** Cette méthode permet de vérifier les paramètres de connexion de l'administrateur 
	 ******/
	public String connectAdmin(UtilisateurDTO utilisateurDTO) throws Exception; 
	
	/**
	 * -----------------------------------------------------------------
	 * cette methode permet de modifier le mot de passe d'un utilisateur
	 * -----------------------------------------------------------------
	 */
	public String  ChangePassword(UtilisateurDTO utilisateurDTO) throws Exception;
}