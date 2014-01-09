package handiGab.manager.impl;


import handiGab.Modele.Carte;
import handiGab.Modele.Client;
import handiGab.dao.BaseDao;
import handiGab.dao.impl.BaseManager;
import handiGab.dto.CarteDTO;
import handiGab.dto.RoleDTO;
import handiGab.manager.CarteManager;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;



@Transactional(readOnly = true)
public class CarteManagerImpl extends BaseManager implements CarteManager 
{
	private BaseDao<Carte, String> carteDAO;
	private BaseDao<Client, String> clientDAO;


	public void setCarteDAO(BaseDao<Carte, String> carteDAO) 
	{
		this.carteDAO = carteDAO;
	}

	public void setClientDAO(BaseDao<Client, String> clientDAO) 
	{
		this.clientDAO = clientDAO;
	}

	@Override
	public void save(CarteDTO carteDTO) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<CarteDTO> find(CarteDTO carteDTO) throws Exception 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarteDTO> all() throws Exception 
	{
		return null;
	}

	@Override
	public String consultationSolde(CarteDTO carteDTO) throws Exception 
	{

		String retour="OK";
		Carte carte= new Carte();
		Client client= new Client();
		try 
		{
			if(carteDAO.exists(carteDTO.getId()))
			{
				carte=carteDAO.get(carteDTO.getId());

				if(clientDAO.exists(carte.getIdClient().getId()))
				{
					client=clientDAO.get(carte.getIdClient().getId());

					if(!StringUtils.equalsIgnoreCase(carte.getPin(), carteDTO.getPin()))
					{
						retour= "PIN-INVALIDE";
						throw new Exception("Exception : PIN invalide");
					}
					else 
					{
						retour=client.getCompte().getSolde().toString();
					}
				}
			}

		} catch (Exception e) 
		{

		}
		return retour;
	}

	@Override
	public String retrait(CarteDTO carteDTO) throws Exception 
	{
		String retour="OK";
		Carte carte= new Carte();
		Client client= new Client();
		try 
		{
			if(carteDAO.exists(carteDTO.getId()))
			{
				carte=carteDAO.get(carteDTO.getId());

				if(clientDAO.exists(carte.getIdClient().getId()))
				{
					client=clientDAO.get(carte.getIdClient().getId());

					if(!StringUtils.equalsIgnoreCase(carte.getPin(), carteDTO.getPin()))
					{
						retour= "PIN-INVALIDE";
						throw new Exception("Exception : PIN invalide");
					}
					
					else if(client.getCompte().getSolde()-carteDTO.getMontant()<0)
					{
						retour="SOLDE-INSUFFISANT";
					}
					else if(client.getCompte().getSolde()-carteDTO.getMontant()>=0)
					{
						retour="OK";
					}
				}
			}

		} catch (Exception e) 
		{

		}
return retour;


	}




}