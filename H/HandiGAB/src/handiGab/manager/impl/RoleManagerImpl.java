package handiGab.manager.impl;


import handiGab.Modele.Role;
import handiGab.Modele.Utilisateur;
import handiGab.dao.BaseDao;
import handiGab.dao.impl.BaseManager;
import handiGab.dto.RoleDTO;
import handiGab.manager.RoleManager;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public class RoleManagerImpl extends BaseManager implements RoleManager 
{
	private BaseDao<Role, String> roleDAO;
	private BaseDao<Utilisateur, String> utilisateurDAO;
	
	public void setRoleDAO(BaseDao<Role, String> roleDAO) {
		this.roleDAO = roleDAO;
	}
	public void setUtilisateurDAO(BaseDao<Utilisateur, String> utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
	

	/**
	 * ------------------------------------
	 * Méthode de consultation d'une role
	 * ------------------------------------
	 */
	@Transactional(readOnly = false)
	@Override
	public void save(RoleDTO roleDTO) throws Exception 
	{
		@SuppressWarnings("unused")
		Utilisateur utilisateur = new Utilisateur();
		Role role = new Role();
		try
		{
			role = roleDAO.get(roleDTO.getRoleid());
			role.setRoleid(roleDTO.getRoleid());
			role.setLibelle(roleDTO.getLibelle());
			role.setRolename("ROLE_ADMIN");
			roleDAO.saveOrUpdate(role,roleDTO.getRoleid());
			
		}
		catch (Exception e) 
		{
			log.error("Exception : "+e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
	

	public List<RoleDTO> find(RoleDTO roleDTO) throws Exception 
	{
		return null;
	}
	
	
	
	public List<RoleDTO> all()throws Exception 
	{
		return null;
	}
	
	
	public void dell(RoleDTO roleDTO)throws Exception 
	{
		
	}
	
}