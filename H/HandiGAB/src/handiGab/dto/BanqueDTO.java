package handiGab.dto;


public class BanqueDTO 
{
	private String banqueCode;
	private String banqueName;
	private String nomAbrege;
	private String codePays;
	private String libellPays;
	
	private String licence;
	
	public String getLibellPays() {
		return libellPays;
	}
	public void setLibellPays(String libellPays) {
		this.libellPays = libellPays;
	}
	
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
	
	
	public String getCodePays() {
		return codePays;
	}
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}
	
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	
}