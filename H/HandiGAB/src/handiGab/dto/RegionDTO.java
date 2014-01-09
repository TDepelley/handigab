package handiGab.dto;




public class RegionDTO {
	private String id;
	private String libelleRegion;
	private String codePays;
	private String codeSIB;
	private String userCreation;
	private String typeOperation;
	
	public String getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}
	public String getCodeSIB() {
		return codeSIB;
	}
	public void setCodeSIB(String codeSIB) {
		this.codeSIB = codeSIB;
	}
	public String getUserCreation() {
		return userCreation;
	}
	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLibelleRegion() {
		return libelleRegion;
	}
	public void setLibelleRegion(String libelleRegion) {
		this.libelleRegion = libelleRegion;
	}
	public String getCodePays() {
		return codePays;
	}
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}
}