package handiGab.manager;

import handiGab.dto.RoleDTO;

import java.util.List;


public interface RoleManager {
	
	/**
	 * ------------------------------------
	 * Méthode de consultation d'un role
	 * ------------------------------------
	 */
	public void save(RoleDTO roleDTO) throws Exception;
	
	/**
	 * --------------------------------
	 * Méthode de recherche role
	 * --------------------------------
	 */
	public List<RoleDTO> find(RoleDTO roleDTO) throws Exception;
	
	/**
	 * ------------------------------------------
	 * Méthode permet de lister toutes les roles
	 * ------------------------------------------
	 */
	public List<RoleDTO> all() throws Exception;
	
	/**
	 * ----------------------------------
	 * Méthode de suppression role
	 * ----------------------------------
	 */
	public void dell(RoleDTO roleDTO) throws Exception;
}
