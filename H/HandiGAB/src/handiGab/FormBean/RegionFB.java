package handiGab.FormBean;


import javax.faces.bean.SessionScoped;

//@ManagedBean(name="RegionFB")
@SessionScoped
public class RegionFB
{

	private String id;
	private String libelleRegion;
	private PaysFB codePays;

	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getLibelleRegion()
	{
		return libelleRegion;
	}
	public void setLibelleRegion(String libelleRegion)
	{
		this.libelleRegion = libelleRegion;
	}
	public PaysFB getCodePays() 
	{
		return codePays;
	}
	public void setCodePays(PaysFB codePays) 
	{
		this.codePays = codePays;
	}


}
