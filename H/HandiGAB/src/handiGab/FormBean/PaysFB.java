package handiGab.FormBean;


import javax.faces.bean.SessionScoped;


//@ManagedBean(name="PaysFB")
@SessionScoped
public class PaysFB {


	private String codeIsoNum;
	private String libellePays;
	private String nationalite;
	private String codeIsoAlpha;
	private String idDevise;
		
	
	public String getIdDevise() {
		return idDevise;
	}
	public void setIdDevise(String idDevise)
	{
		this.idDevise = idDevise;
	}
	public String getLibellePays() {
		return libellePays;
	}
	public void setLibellePays(String libellePays) {
		this.libellePays = libellePays;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getCodeIsoNum() {
		return codeIsoNum;
	}
	public void setCodeIsoNum(String codeIsoNum) {
		this.codeIsoNum = codeIsoNum;
	}
	public String getCodeIsoAlpha() {
		return codeIsoAlpha;
	}
	public void setCodeIsoAlpha(String codeIsoAlpha) {
		this.codeIsoAlpha = codeIsoAlpha;
	}


}
