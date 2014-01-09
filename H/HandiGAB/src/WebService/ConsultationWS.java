package WebService;
import handiGab.dto.CarteDTO;
import handiGab.manager.CarteManager;

import org.apache.commons.lang.StringUtils;

import utils.SysEnv;
import utils.Utiles;
import utils.WebService;


/**
 * @author Fatoumata
 *
 */

//http://localhost:8280/HandiGABServer/services/ConsultationWS?wsdl

public class ConsultationWS extends WebService 
{
	
	CarteManager carteManager= (CarteManager) getBean("carteManager");
	
	public String  retraitConsultationSolde(String trame)
	{
		String codeRetour=null;

		try 
		{
			CarteDTO carte= new CarteDTO();
			String [] elementTrame=Utiles.ConversionTrameTab(trame);

			if(StringUtils.equalsIgnoreCase(elementTrame[1], "") || StringUtils.equalsIgnoreCase(elementTrame[2], "") )
			{
				codeRetour="KO";
			}
			else
			{
				carte.setTrame(trame);
				carte.setId(elementTrame[1]);
				carte.setPin(elementTrame[2]);
				carte.setDateExpirationCarte(SysEnv.ToDayTimeStamp());
				carte.setEtatCarte("");
				carte.setNomEmbosse("");
				carte.setLibelleProduit("");
				

				//carteManager.authentifiePorteur(carte);
				
				if(StringUtils.equalsIgnoreCase(elementTrame[0], "R"))
				{
					 //codeservice#numCarte#codePin
					carte.setMontant( Double.parseDouble(elementTrame[2]));
					codeRetour=carteManager.consultationSolde(carte);
				} else 
					if(StringUtils.equalsIgnoreCase(elementTrame[0], "C"))
					{
						 //codeservice R pour retrait et C pour Consultation
						 //codeservice#numCarte#codePin#Montant
						codeRetour=carteManager.retrait(carte);
					}

			}
		} catch (Exception e)
		{
			e.printStackTrace();
			codeRetour="KO";
		}

		return codeRetour;
	}

	
	/*****
	 * ***** Cette méthode permet d'authentifier un porteur
	 * **
	 * */
	public String  authentifiePorteur(String trame)
	{
		String codeRetour="OK";

		try 
		{
			//code service(retrait/consultation solde)-idClient-PIN
			CarteDTO carte= new CarteDTO();
			String [] elementTrame=Utiles.ConversionTrameTab(trame);

			if(StringUtils.equalsIgnoreCase(elementTrame[1], "") || StringUtils.equalsIgnoreCase(elementTrame[2], "") )
			{
				codeRetour="KO";
			}
			else
			{
				carte.setTrame(trame);
				carte.setIdClient(elementTrame[1]);
				carte.setPin(elementTrame[2]);

				//codeRetour = carteManager.authentifiePorteur(utilisateur);

			}
		} catch (Exception e) {
			e.printStackTrace();
			codeRetour="KO";
		}

		return "KO";
	}
	
	
}
