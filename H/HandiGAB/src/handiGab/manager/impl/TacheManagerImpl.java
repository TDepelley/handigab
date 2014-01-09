package handiGab.manager.impl;


import handiGab.dao.impl.BaseManager;
import handiGab.dto.ActionAutoriserDTO;
import handiGab.dto.ActionDTO;
import handiGab.manager.TacheManager;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;



@Transactional(readOnly = true)
public class TacheManagerImpl extends BaseManager implements TacheManager 
{

	@Override
	public void save(ActionDTO actionDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ActionDTO> find(ActionDTO actionDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActionDTO> all() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ActionAutoriserDTO actionAutoriserDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ActionAutoriserDTO> find(ActionAutoriserDTO actionAutoriserDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}