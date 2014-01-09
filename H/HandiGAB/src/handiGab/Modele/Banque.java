package handiGab.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANQUE")
public class Banque 
{
	@Id
	@Column(nullable = false, length = 3, name = "CODE")
	private String banqueCode;
	
	@Column(nullable = false, length = 35, name = "NOM")
	private String banqueName;
	
	@Column(nullable = false, length = 35, name = "NOMABRE")
	private String nomAbrege;
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name = "CODEPAYS", nullable = true)
//	private String codePays;
	
	@Column(nullable = false, length = 35, name = "LICENCE")	
	private String licence;
	
	
	public String getBanqueCode() {
		return banqueCode;
	}
	public void setBanqueCode(String banqueCode) {
		this.banqueCode = banqueCode;
	}
	public String getBanqueName() {
		return banqueName;
	}
	public void setBanqueName(String banqueName) {
		this.banqueName = banqueName;
	}
	public String getNomAbrege() {
		return nomAbrege;
	}
	public void setNomAbrege(String nomAbrege) {
		this.nomAbrege = nomAbrege;
	}
	
	
	
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	
	
	
}