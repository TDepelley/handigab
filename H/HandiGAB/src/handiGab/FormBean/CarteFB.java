package handiGab.FormBean;

import java.util.Date;

import javax.faces.bean.SessionScoped;

//@ManagedBean(name="AgenceFB")
@SessionScoped
public class CarteFB 
{
	private String id;
	private String libelleProduit;
	private ClientFB idClient;
	private String nomEmbosse;
	private String etatCarte;
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
	public ClientFB getIdClient() {
		return idClient;
	}
	public void setIdClient(ClientFB idClient) {
		this.idClient = idClient;
	}
	public String getNomEmbosse() {
		return nomEmbosse;
	}
	public void setNomEmbosse(String nomEmbosse) {
		this.nomEmbosse = nomEmbosse;
	}
	public String getEtatCarte() {
		return etatCarte;
	}
	public void setEtatCarte(String etatCarte) {
		this.etatCarte = etatCarte;
	}
	public Date getDateExpirationCarte() {
		return dateExpirationCarte;
	}
	public void setDateExpirationCarte(Date dateExpirationCarte) {
		this.dateExpirationCarte = dateExpirationCarte;
	}
	
	

}
