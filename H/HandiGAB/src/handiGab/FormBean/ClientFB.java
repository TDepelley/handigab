package handiGab.FormBean;

import handiGab.dto.ClientDTO;
import handiGab.dto.UtilisateurDTO;
import handiGab.manager.ClientManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="clientFB")
@SessionScoped
public class ClientFB 
{
	@ManagedProperty(value="#{clientManager}")
	ClientManager clientManager;
	
	

	private String id;
	private String nom;
	private String prenom;
	private AgenceFB codeAgence;
	private String adresse;
	private String sexe;
	private String paysnaissance;
	private String villeNaissance;
	private String nationalite;
	private Date dateNaissance;
	private String numeroPiece;
	private String villeEmissionPiece;
	private Date dateEmissionPiece;
	private String email;
	private String telephone;
	private String fax;
	
	private String compte;
	private List<ClientDTO> clientList = new ArrayList<ClientDTO>();
	private boolean saveAction = false;
	private boolean btnAction = true;
	
	
	
	
	public List<ClientDTO> getClientList() {
		return clientList;
	}

	public void setClientList(List<ClientDTO> clientList) {
		this.clientList = clientList;
	}

	public boolean isSaveAction() {
		return saveAction;
	}

	public void setSaveAction(boolean saveAction) {
		this.saveAction = saveAction;
	}

	public boolean isBtnAction() {
		return btnAction;
	}

	public void setBtnAction(boolean btnAction) {
		this.btnAction = btnAction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AgenceFB getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(AgenceFB codeAgence) {
		this.codeAgence = codeAgence;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVilleNaissance() {
		return villeNaissance;
	}

	public void setVilleNaissance(String villeNaissance) {
		this.villeNaissance = villeNaissance;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNumeroPiece() {
		return numeroPiece;
	}

	public void setNumeroPiece(String numeroPiece) {
		this.numeroPiece = numeroPiece;
	}

	public String getVilleEmissionPiece() {
		return villeEmissionPiece;
	}

	public void setVilleEmissionPiece(String villeEmissionPiece) {
		this.villeEmissionPiece = villeEmissionPiece;
	}

	public Date getDateEmissionPiece() {
		return dateEmissionPiece;
	}

	public void setDateEmissionPiece(Date dateEmissionPiece) {
		this.dateEmissionPiece = dateEmissionPiece;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPaysnaissance() {
		return paysnaissance;
	}

	public void setPaysnaissance(String paysnaissance) {
		this.paysnaissance = paysnaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getCompte() {
		return compte;
	}

	public void setCompte(String compte) {
		this.compte = compte;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}

	



}
