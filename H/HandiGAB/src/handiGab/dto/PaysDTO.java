package handiGab.dto;


import java.util.ArrayList;
import java.util.List;

public class PaysDTO {
	private String codeIsoNum;
	private String libellePays;
	private String codeIsoAlpha;
	private String nationalite;
	private String idDevise;
	private String correspondance;
	private List<RegionDTO> regionsDTO = new ArrayList<RegionDTO>();
	private String userCreation;
	private String typeOperation;
	
	public String getCorrespondance() {
		return correspondance;
	}
	public void setCorrespondance(String correspondance) {
		this.correspondance = correspondance;
	}
	public String getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}
	public List<RegionDTO> getRegionsDTO() {
		return regionsDTO;
	}
	public void setRegionsDTO(List<RegionDTO> regionsDTO) {
		this.regionsDTO = regionsDTO;
	}
	public String getUserCreation() {
		return userCreation;
	}
	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}	
	public String getCodeIsoNum() {
		return codeIsoNum;
	}
	public void setCodeIsoNum(String codeIsoNum) {
		this.codeIsoNum = codeIsoNum;
	}
	public String getLibellePays() {
		return libellePays;
	}
	public void setLibellePays(String libellePays) {
		this.libellePays = libellePays;
	}
	public String getCodeIsoAlpha() {
		return codeIsoAlpha;
	}
	public void setCodeIsoAlpha(String codeIsoAlpha) {
		this.codeIsoAlpha = codeIsoAlpha;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getIdDevise() {
		return idDevise;
	}
	public void setIdDevise(String idDevise) {
		this.idDevise = idDevise;
	}
}