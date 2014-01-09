package handiGab.FormBean;

import java.util.Date;

import javax.faces.bean.SessionScoped;

//@ManagedBean(name="CompteFB")
@SessionScoped
public class CompteFB
{
	private String id;
	private String agence;
	private String devise;
	private String client;
	private Long solde;
	private Date dateOuverture;
	private Date dateFermeture;

	public String getId()
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	
	public Long getSolde() 
	{
		return solde;
	}

	public void setSolde(Long solde) 
	{
		this.solde = solde;
	}

	public Date getDateOuverture()
	{
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) 
	{
		this.dateOuverture = dateOuverture;
	}

	public Date getDateFermeture() {
		return dateFermeture;
	}

	public void setDateFermeture(Date dateFermeture) {
		this.dateFermeture = dateFermeture;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise)
	{
		this.devise = devise;
	}

	public String getClient()
	{
		return client;
	}

	public void setClient(String client) 
	{
		this.client = client;
	}
	

}
