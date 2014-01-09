package handiGab.dto;


import java.util.ArrayList;
import java.util.List;


public class UtilisateurDTO {
	private String userId;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String username; 
	private String password; 
	private String confirmPassword;
	private String passwordHint;
	private String codeRoles;
	private String libelleRoles;
	private String localite;
	private String userCreation;
	private String typeOperation;
	private boolean enabled;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
	private Integer numberSessionAuthorized;
	private Short disabled;
	private AgenceDTO agenceDTO;
	private List<String> processusProfil = new ArrayList<String>();
	
	private String service;
	private String canal;
	private String trame;
	
	
	public AgenceDTO getAgenceDTO() {
		return agenceDTO;
	}
	public void setAgenceDTO(AgenceDTO agenceDTO) {
		this.agenceDTO = agenceDTO;
	}
	public List<String> getProcessusProfil() {
		return processusProfil;
	}
	public void setProcessusProfil(List<String> processusProfil) {
		this.processusProfil = processusProfil;
	}
	public String getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}
	public String getLibelleRoles() {
		return libelleRoles;
	}
	public void setLibelleRoles(String libelleRoles) {
		this.libelleRoles = libelleRoles;
	}
	public String getUserCreation() {
		return userCreation;
	}
	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}	
	public String getCodeRoles() {
		return codeRoles;
	}
	public void setCodeRoles(String codeRoles) {
		this.codeRoles = codeRoles;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public Short getDisabled() {
		return disabled;
	}
	public void setDisabled(Short disabled) {
		this.disabled = disabled;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Integer getNumberSessionAuthorized() {
		return numberSessionAuthorized;
	}
	public void setNumberSessionAuthorized(Integer numberSessionAuthorized) {
		this.numberSessionAuthorized = numberSessionAuthorized;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountExpired() {
		return accountExpired;
	}
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}
	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getTrame() {
		return trame;
	}
	public void setTrame(String trame) {
		this.trame = trame;
	}
	
	
	
}
