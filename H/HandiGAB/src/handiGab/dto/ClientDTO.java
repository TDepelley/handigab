package handiGab.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientDTO {
	
	private String id;
	private String codeAgence;
	private String typeClient;
	private String sexe;
	private String titre;
	private String relation;
	private String nom;
	private String prenom;
	private String paysnaissance;
	private String villeNaissance;
	private String nationalite;
	private Date dateNaissance;
	private String naturePieceIdentification;
	private String numeroPiece;
	private String villeEmissionPiece;
	private Date dateEmissionPiece;
	private Date dateEmbauche;
	private String socioProf;
	private String situationProf;
	private String situationMatrimoniale;
	private String email;
	private String langue;
	private String modeEnvoi;
	private String vip;
	private String owner;
	private String telephone;
	private String fax;
		private String libelleAgence;
	private String libelleTypeClient;
	private String libellesexe;
	private String libelletitre;
	private String libellerelation;
	private String libellePaysNaissance;
	private String libelleNationalite;
	private String libelleNaturePieceIdentification;
	private String libelleSocioProf;
	private String libelleSituationProf;
	private String libelleSituationMatrimoniale;
	private String libelleLangue;
	private String libelleModeEnvoi;
	private String libelleVip;
	private String libelleIndexSegmentClient;
	private String libelleOwner;
	private String numeroCompte;
	private List<CompteDTO> compteList = new ArrayList<CompteDTO>();
	private String requeteImportation;
	private String requeteImportationCompte;
	
	
	public String getRequeteImportationCompte() {
		return requeteImportationCompte;
	}
	public void setRequeteImportationCompte(String requeteImportationCompte) {
		this.requeteImportationCompte = requeteImportationCompte;
	}
	public String getRequeteImportation() {
		return requeteImportation;
	}
	public void setRequeteImportation(String requeteImportation) {
		this.requeteImportation = requeteImportation;
	}
	public String getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodeAgence() {
		return codeAgence;
	}
	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}
	public String getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
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
	public String getPaysnaissance() {
		return paysnaissance;
	}
	public void setPaysnaissance(String paysnaissance) {
		this.paysnaissance = paysnaissance;
	}
	public String getVilleNaissance() {
		return villeNaissance;
	}
	public void setVilleNaissance(String villeNaissance) {
		this.villeNaissance = villeNaissance;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getNaturePieceIdentification() {
		return naturePieceIdentification;
	}
	public void setNaturePieceIdentification(String naturePieceIdentification) {
		this.naturePieceIdentification = naturePieceIdentification;
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
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public String getSocioProf() {
		return socioProf;
	}
	public void setSocioProf(String socioProf) {
		this.socioProf = socioProf;
	}
	public String getSituationProf() {
		return situationProf;
	}
	public void setSituationProf(String situationProf) {
		this.situationProf = situationProf;
	}
	public String getSituationMatrimoniale() {
		return situationMatrimoniale;
	}
	public void setSituationMatrimoniale(String situationMatrimoniale) {
		this.situationMatrimoniale = situationMatrimoniale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getModeEnvoi() {
		return modeEnvoi;
	}
	public void setModeEnvoi(String modeEnvoi) {
		this.modeEnvoi = modeEnvoi;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getLibelleAgence() {
		return libelleAgence;
	}
	public void setLibelleAgence(String libelleAgence) {
		this.libelleAgence = libelleAgence;
	}
	public String getLibelleTypeClient() {
		return libelleTypeClient;
	}
	public void setLibelleTypeClient(String libelleTypeClient) {
		this.libelleTypeClient = libelleTypeClient;
	}
	public String getLibellesexe() {
		return libellesexe;
	}
	public void setLibellesexe(String libellesexe) {
		this.libellesexe = libellesexe;
	}
	public String getLibelletitre() {
		return libelletitre;
	}
	public void setLibelletitre(String libelletitre) {
		this.libelletitre = libelletitre;
	}
	public String getLibellerelation() {
		return libellerelation;
	}
	public void setLibellerelation(String libellerelation) {
		this.libellerelation = libellerelation;
	}
	public String getLibellePaysNaissance() {
		return libellePaysNaissance;
	}
	public void setLibellePaysNaissance(String libellePaysNaissance) {
		this.libellePaysNaissance = libellePaysNaissance;
	}
	public String getLibelleNationalite() {
		return libelleNationalite;
	}
	public void setLibelleNationalite(String libelleNationalite) {
		this.libelleNationalite = libelleNationalite;
	}
	public String getLibelleNaturePieceIdentification() {
		return libelleNaturePieceIdentification;
	}
	public void setLibelleNaturePieceIdentification(
			String libelleNaturePieceIdentification) {
		this.libelleNaturePieceIdentification = libelleNaturePieceIdentification;
	}
	public String getLibelleSocioProf() {
		return libelleSocioProf;
	}
	public void setLibelleSocioProf(String libelleSocioProf) {
		this.libelleSocioProf = libelleSocioProf;
	}
	public String getLibelleSituationProf() {
		return libelleSituationProf;
	}
	public void setLibelleSituationProf(String libelleSituationProf) {
		this.libelleSituationProf = libelleSituationProf;
	}
	public String getLibelleSituationMatrimoniale() {
		return libelleSituationMatrimoniale;
	}
	public void setLibelleSituationMatrimoniale(String libelleSituationMatrimoniale) {
		this.libelleSituationMatrimoniale = libelleSituationMatrimoniale;
	}
	public String getLibelleLangue() {
		return libelleLangue;
	}
	public void setLibelleLangue(String libelleLangue) {
		this.libelleLangue = libelleLangue;
	}
	public String getLibelleModeEnvoi() {
		return libelleModeEnvoi;
	}
	public void setLibelleModeEnvoi(String libelleModeEnvoi) {
		this.libelleModeEnvoi = libelleModeEnvoi;
	}
	public String getLibelleVip() {
		return libelleVip;
	}
	public void setLibelleVip(String libelleVip) {
		this.libelleVip = libelleVip;
	}
	public String getLibelleIndexSegmentClient() {
		return libelleIndexSegmentClient;
	}
	public void setLibelleIndexSegmentClient(String libelleIndexSegmentClient) {
		this.libelleIndexSegmentClient = libelleIndexSegmentClient;
	}
	public String getLibelleOwner() {
		return libelleOwner;
	}
	public void setLibelleOwner(String libelleOwner) {
		this.libelleOwner = libelleOwner;
	}
	public List<CompteDTO> getCompteList() {
		return compteList;
	}
	public void setCompteList(List<CompteDTO> compteList) {
		this.compteList = compteList;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}