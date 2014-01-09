package handiGab.Modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name =  "COMPTECLIENT")
public class Compte
{
	@Id
	@Column(name = "NUMEROCOMPTE", nullable = false, length = 24)
	private String id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "AGENCE", nullable = false)
	private Agence agence;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DEVISE", nullable = false)
	private Devise devise;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name = "ETAT", nullable = false)
//	private StatutCompte etatCompte;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CLIENT", nullable = false)
	private Client client;
	
	@Column(name = "SOLDE", nullable=false)
	private Long solde;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATEOUVERTURE", nullable=true)
	private Date dateOuverture;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATEFERMETURE", nullable=true)
	private Date dateFermeture;

	public String getId()
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public Agence getAgence() 
	{
		return agence;
	}

	public void setAgence(Agence agence)
	{
		this.agence = agence;
	}

	public Client getClient() 
	{
		return client;
	}

	public void setClient(Client client) 
	{
		this.client = client;
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
	
	
	
	

}
