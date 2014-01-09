package handiGab.dto;


import java.util.List;

public class ActionAutoriserDTO  {
	private String codeRole;
	private String codeAction;
	private List<String> listeActionAutorise;
	private List<String> listeActionNonAutorise;
	;
	
	public String getCodeRole() {
		return codeRole;
	}
	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}
	public String getCodeAction() {
		return codeAction;
	}
	public void setCodeAction(String codeAction) {
		this.codeAction = codeAction;
	}
	public List<String> getListeActionAutorise() {
		return listeActionAutorise;
	}
	public void setListeActionAutorise(List<String> listeActionAutorise) {
		this.listeActionAutorise = listeActionAutorise;
	}
	public List<String> getListeActionNonAutorise() {
		return listeActionNonAutorise;
	}
	public void setListeActionNonAutorise(List<String> listeActionNonAutorise) {
		this.listeActionNonAutorise = listeActionNonAutorise;
	}
	
}
