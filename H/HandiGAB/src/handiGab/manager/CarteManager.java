package handiGab.manager;

import handiGab.dto.CarteDTO;

import java.util.List;


public interface CarteManager {
	
	
	public void save(CarteDTO carteDTO) throws Exception;
	
	public List<CarteDTO> find(CarteDTO carteDTO) throws Exception;
	
	public List<CarteDTO> all() throws Exception;
	
	public String consultationSolde(CarteDTO carteDTO) throws Exception;
	
	public String retrait(CarteDTO carteDTO) throws Exception;
}
