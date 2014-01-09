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
@Table(name="CARTE")
public class Carte 
{
	@Id
	@Column(nullable = false, length = 3, name = "CODE")
	private String id;
	
	@Column(nullable = false, length = 35, name = "LIBELLE")
	private String libelleProduit;
	
	@Column(nullable = false, length = 4, name = "PIN")
	private String pin;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable = false, name = "MATRICULECLIENT")
	private Client idClient;
	
	@Column(nullable = false, length = 26, name = "NOMEMBOSSE")
	private String nomEmbosse;
	
	@Column(nullable = false, length = 35, name = "ETAT")
	private String etatCarte;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATEEXPIRATION", nullable = true)
	private Date dateExpirationCarte;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelleProduit() {
		return libelleProduit;
	}

	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}

	public String getNomEmbosse() {
		return nomEmbosse;
	}

	public void setNomEmbosse(String nomEmbosse) {
		this.nomEmbosse = nomEmbosse;
	}

	public String getEtatCarte()
	{
		return etatCarte;
	}

	public void setEtatCarte(String etatCarte)
	{
		this.etatCarte = etatCarte;
	}

	public Date getDateExpirationCarte() 
	{
		return dateExpirationCarte;
	}

	public void setDateExpirationCarte(Date dateExpirationCarte) {
		this.dateExpirationCarte = dateExpirationCarte;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	

}
