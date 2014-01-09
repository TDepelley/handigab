package handiGab.dto;


public class VilleDTO {
	private String id;
	private String libelleVille;
	private String codeRegion;
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
	public String getCodePays() {
		return codePays;
	}
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLibelleVille() {
		return libelleVille;
	}
	public void setLibelleVille(String libelleVille) {
		this.libelleVille = libelleVille;
	}
	public String getCodeRegion() {
		return codeRegion;
	}
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
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
}