package handiGab.dto;


public class ActionDTO {
	private String id;
	private String libelle;
	private String libelleActionParent;
	private String idActionParent;
	private boolean select=false;
	private String niveau;
	
	
	
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getLibelleActionParent() {
		return libelleActionParent;
	}
	public void setLibelleActionParent(String libelleActionParent) {
		this.libelleActionParent = libelleActionParent;
	}
	public String getIdActionParent() {
		return idActionParent;
	}
	public void setIdActionParent(String idActionParent) {
		this.idActionParent = idActionParent;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	
}