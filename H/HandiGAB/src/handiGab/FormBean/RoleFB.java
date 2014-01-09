package handiGab.FormBean;

import javax.faces.bean.SessionScoped;

//@ManagedBean(name="RoleFB")
@SessionScoped
public class RoleFB
{
	private String roleid;
	private String rolename;
	private String libelle;

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() 
	{
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	

}
