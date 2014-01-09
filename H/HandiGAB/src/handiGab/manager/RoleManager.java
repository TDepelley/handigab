package handiGab.manager;

import handiGab.dto.RoleDTO;

import java.util.List;


public interface RoleManager {
	
	/**
	 * ------------------------------------
	 * M�thode de consultation d'un role
	 * ------------------------------------
	 */
	public void save(RoleDTO roleDTO) throws Exception;
	
	/**
	 * --------------------------------
	 * M�thode de recherche role
	 * --------------------------------
	 */
	public List<RoleDTO> find(RoleDTO roleDTO) throws Exception;
	
	/**
	 * ------------------------------------------
	 * M�thode permet de lister toutes les roles
	 * ------------------------------------------
	 */
	public List<RoleDTO> all() throws Exception;
	
	/**
	 * ----------------------------------
	 * M�thode de suppression role
	 * ----------------------------------
	 */
	public void dell(RoleDTO roleDTO) throws Exception;
}
