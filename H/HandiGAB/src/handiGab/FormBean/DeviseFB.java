package handiGab.FormBean;


import javax.faces.bean.SessionScoped;


//@ManagedBean(name="DeviseFB")
@SessionScoped
public class DeviseFB 
{

	private String codeDevIsoNum;
	private String libelle;
	private String codeDevIsoAlpha;
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libellevip) {
		this.libelle = libellevip;
	}
	public String getCodeDevIsoNum() {
		return codeDevIsoNum;
	}
	public void setCodeDevIsoNum(String codeDevIsoNum) {
		this.codeDevIsoNum = codeDevIsoNum;
	}
	public String getCodeDevIsoAlpha() {
		return codeDevIsoAlpha;
	}
	public void setCodeDevIsoAlpha(String codeDevIsoAlpha) {
		this.codeDevIsoAlpha = codeDevIsoAlpha;
	}

	
	
}