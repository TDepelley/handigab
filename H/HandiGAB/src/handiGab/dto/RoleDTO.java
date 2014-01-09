package handiGab.dto;

import java.util.HashSet;
import java.util.Set;



public class RoleDTO {
    private String roleid;
	private String libelle;
	private Set<ActionDTO> actions = new HashSet<ActionDTO>();

	
	
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Set<ActionDTO> getActions() {
		return actions;
	}
	public void setActions(Set<ActionDTO> actions) {
		this.actions = actions;
	}
}