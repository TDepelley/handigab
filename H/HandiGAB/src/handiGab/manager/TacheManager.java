package handiGab.manager;

import handiGab.dto.ActionAutoriserDTO;
import handiGab.dto.ActionDTO;

import java.util.List;



public interface TacheManager {
	
	
	public void save(ActionDTO actionDTO) throws Exception;
	
	
	public List<ActionDTO> find(ActionDTO actionDTO) throws Exception;
	
	
	public List<ActionDTO> all() throws Exception;
	
	
	/**
	 * 
	 */
	public void save(ActionAutoriserDTO actionAutoriserDTO)throws Exception ;
	
	/**
	 * 
	 */
	public List<ActionAutoriserDTO> find(ActionAutoriserDTO actionAutoriserDTO)throws Exception;

}