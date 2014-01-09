package handiGab.dto;


import java.util.Date;


public class CompteDTO {

	private String id;
	private String categorie;
	private String libelleCategorie;
	private String agence;
	private String devise;
	private String etatCompte;
	private String libelleEtatCompte;
	private String client;
	private double solde;
	private double faciliteCaise;
	private Date dateDernierArret;
	private Date dateOuverture;
	private Date dateFermeture;
	private String userCreation;
	private String requete;
	
	public String getRequete() {
		return requete;
	}
	public void setRequete(String requete) {
		this.requete = requete;
	}
	public Date getDateFermeture() {
		return dateFermeture;
	}
	public void setDateFermeture(Date dateFermeture) {
		this.dateFermeture = dateFermeture;
	}
	public String getLibelleCategorie() {
		return libelleCategorie;
	}
	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}
	public String getLibelleEtatCompte() {
		return libelleEtatCompte;
	}
	public void setLibelleEtatCompte(String libelleEtatCompte) {
		this.libelleEtatCompte = libelleEtatCompte;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
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
	public void setDevise(String devise) {
		this.devise = devise;
	}
	public String getEtatCompte() {
		return etatCompte;
	}
	public void setEtatCompte(String etatCompte) {
		this.etatCompte = etatCompte;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public double getFaciliteCaise() {
		return faciliteCaise;
	}
	public void setFaciliteCaise(double faciliteCaise) {
		this.faciliteCaise = faciliteCaise;
	}
	public Date getDateDernierArret() {
		return dateDernierArret;
	}
	public void setDateDernierArret(Date dateDernierArret) {
		this.dateDernierArret = dateDernierArret;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	public String getUserCreation() {
		return userCreation;
	}
	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}
	
}