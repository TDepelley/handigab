package handiGab.dto;

import java.util.Date;

public class CarteDTO 
{
	
	private String id;
	private String libelleProduit;
	private String pin;
	private String idClient;
	private String nomEmbosse;
	private String etatCarte;
	private Date dateExpirationCarte;
	private String trame;
	private double montant;

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

	
	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
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

	public String getTrame() {
		return trame;
	}

	public void setTrame(String trame) {
		this.trame = trame;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	

}
