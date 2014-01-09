package handiGab.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "AGENCE")
public class Agence
{
	@Id
	@Column(name = "CODEAGENCE", nullable = false, length = 6)
	private String codeAgence;
	
	@OrderBy
	@Column(name = "AGENCENAME", nullable=false, length = 100)
	private String nomAgence;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "BANQUE", nullable = false)
	private Banque codeBanque;
	
	@Column(name = "ADRESSE", nullable=false, length = 200)
	private String adresse;
	
	@Column(name = "CODEPOSTAL", nullable=true, length = 100)
	private String codePostal;
	
	@Column(name = "TELEPHONE", nullable=false, length = 30)
	private String telephone;
	
	@Column(name = "FAX", nullable=true, length = 30)
	private String fax;

	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
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
	
	

}
