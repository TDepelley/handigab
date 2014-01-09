package handiGab.Modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CLIENT")
public class Client 
{
	@Id
	@Column(name = "MATRICULE", nullable = false, length = 24)
	private String id;
	
	@OrderBy
	@Column(name = "NOM", nullable = false, length = 40)
	private String nom;
	
	@OrderBy
	@Column(name = "PRENOM", nullable = false, length = 40)
	private String prenom;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CODEAGENCE", nullable = false)
	private Agence codeAgence;
	
	
	@Column(name = "ADRESSE", nullable = true, length = 200)
	private String adresse;

	
	@Column(name = "SEXE", nullable = false, length = 35)
	private String sexe;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CODEPAYSNAISSANCE", nullable = false)
	private Pays paysnaissance;
	
	@Column(name = "VILLENAISSANCE", nullable = true, length = 30)
	private String villeNaissance;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CODENATIONALITE", nullable = false)
	private Pays nationalite;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATENAISSANCE", nullable = true)
	private Date dateNaissance;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name = "CODENATUREPIECE", nullable = false)
//	private NaturePieceIdentification naturePieceIdentification;
	
	@Column(name = "NUMEROPIECEIDENTIFICATION", nullable = false, length = 30)
	private String numeroPiece;
	
	@Column(name = "VILLEEMISSIONPIECE", nullable = true, length = 30)
	private String villeEmissionPiece;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATEEMISSIONPIECE", nullable = true)
	private Date dateEmissionPiece;
	
	
	@Column(name = "EMAIL", nullable = true, length = 40)
	private String email;
	
	
	
	@Column(name = "TELEPHONE", nullable = true, length = 20)
	private String telephone;
	
	
	@Column(name = "FAX", nullable = true, length = 20)
	private String fax;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "COMPTE", nullable = true)
	private Compte compte;
	
	public Pays getPaysnaissance() {
		return paysnaissance;
	}

	public void setPaysnaissance(Pays paysnaissance) {
		this.paysnaissance = paysnaissance;
	}

	public Pays getNationalite() {
		return nationalite;
	}

	public void setNationalite(Pays nationalite) {
		this.nationalite = nationalite;
	}

	

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Agence getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(Agence codeAgence) {
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

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	

	
	
	
	
	


}
