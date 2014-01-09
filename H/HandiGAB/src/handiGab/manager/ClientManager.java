package handiGab.manager;

import handiGab.dto.ClientDTO;

import java.util.List;


public interface ClientManager
{
	
	
	public void save(ClientDTO clientDTO) throws Exception;
	
	public List<ClientDTO> find(ClientDTO clientDTO) throws Exception;
	
	public List<ClientDTO> all() throws Exception;
	
	public String consultationSolde(ClientDTO clientDTO) throws Exception;
	
	public String retrait(ClientDTO clientDTO) throws Exception;
}
