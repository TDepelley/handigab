package handiGab.manager.impl;


import handiGab.Modele.Client;
import handiGab.dao.BaseDao;
import handiGab.dao.impl.BaseManager;
import handiGab.dto.ClientDTO;
import handiGab.manager.ClientManager;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;



@Transactional(readOnly = true)
public class ClientManagerImpl extends BaseManager implements ClientManager
{
	private BaseDao<Client, String> clientDAO;


	

	public void setClientDAO(BaseDao<Client, String> clientDAO) 
	{
		this.clientDAO = clientDAO;
	}




	@Override
	public void save(ClientDTO clientDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}




	@Override
	public List<ClientDTO> find(ClientDTO clientDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<ClientDTO> all() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String consultationSolde(ClientDTO clientDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String retrait(ClientDTO clientDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	



}