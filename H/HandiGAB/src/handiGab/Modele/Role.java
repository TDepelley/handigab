package handiGab.Modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role
{
	@Id
	@Column(name = "ID", nullable = false,length=5)
	private String roleid;
	
	@Column(name = "ROLENAME", length = 35)
	private String rolename;
	
	@OrderBy
	@Column(name = "LIBELLE", length = 35)
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
