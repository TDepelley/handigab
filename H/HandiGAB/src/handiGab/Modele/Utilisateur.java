package handiGab.Modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "UTILISATEUR")
public class Utilisateur
{
	@Id
	@Column(name = "CODE", nullable = false, length = 5)
	private String code;
	
	@Column(name = "USERFIRSTNAME", length = 35, nullable = false)
	private String userFirstName;
	
	@Column(name = "USERLASTNAME", length = 35, nullable = false)
	private String userLastName;
	
	@Column(name = "ENABLED")
	private Short disabled;
	
	@Column(name = "USEREMAIL", length = 100, nullable = false)
	private String userEmail;
	
	@Column(name = "NUMBERSESSIONAUTHORIZED")
	private Integer numberSessionAuthorized;
	
	@Column(nullable = false, length = 20, unique = true)
	private String username; 
	
	@Column(nullable = false, name = "PASSWORD")
	private String password;
	
	@Column(name = "ACCOUNT_ENABLED")
	private boolean enabled;
	
	@Column(name = "ACCOUNT_EXPIRED", nullable = false)
	private boolean accountNonExpired;
	
	@Column(name = "ACCOUNT_LOCKED", nullable = false)
	private boolean accountNonLocked;
	
	@Column(name = "CREDENTIALS_EXPIRED", nullable = false)
	private boolean credentialsNonExpired;
	
	@JoinTable(name ="ROLEUTILISATEUR", joinColumns = @JoinColumn(name = "CODEUTILISATEUR"), inverseJoinColumns = @JoinColumn(name = "CODEROLE"))
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Role> roles = new ArrayList<Role>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AGENCE", nullable = true)
	private Agence codeAgence;
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getUserFirstName() 
	{
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName)
	{
		this.userFirstName = userFirstName;
	}

	public String getUserLastName()
	{
		return userLastName;
	}

	public void setUserLastName(String userLastName) 
	{
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	

	
	
}
