package handiGab.manager.impl;


import handiGab.Modele.Utilisateur;
import handiGab.dao.BaseDao;
import handiGab.dao.impl.BaseManager;
import handiGab.dto.UtilisateurDTO;
import handiGab.manager.UtilisateurManager;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;



@Transactional(readOnly = true)
public class UtilisateurManagerImpl extends BaseManager implements UtilisateurManager
{
	private BaseDao<Utilisateur, String> utilisateurDAO;
	
	public void setUtilisateurDAO(BaseDao<Utilisateur, String> utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	@Override
	public String save(UtilisateurDTO utilisateurDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UtilisateurDTO utilisateurDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UtilisateurDTO utilisateurDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UtilisateurDTO edit(UtilisateurDTO utilisateurDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UtilisateurDTO> find(UtilisateurDTO utilisateurDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UtilisateurDTO> all() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String connectAdmin(UtilisateurDTO utilisateurDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ChangePassword(UtilisateurDTO utilisateurDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	}