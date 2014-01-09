package handiGab.FormBean;


import javax.faces.bean.SessionScoped;


//@ManagedBean(name="VilleFB")
@SessionScoped
public class VilleFB  {

	/**
	 * 
	 */

	private String id;
	private String libelleVille;
	private String codeRegion;
	
	public String getId() {
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public String getLibelleVille()
	{
		return libelleVille;
	}
	public void setLibelleVille(String libelleVille) 
	{
		this.libelleVille = libelleVille;
	}
	public String getCodeRegion() {
		return codeRegion;
	}
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}
	

}
