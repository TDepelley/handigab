package handiGab.FormBean;

import handiGab.dto.UtilisateurDTO;
import handiGab.manager.UtilisateurManager;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.SystemException;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import utils.SysEnv;

@ManagedBean(name="utilisateurFB")
@SessionScoped
public class UtilisateurFB extends BaseFB implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5153527336982741039L;

	@ManagedProperty(value="#{utilisateurManager}")
	UtilisateurManager utilisateurManager;

	private String userId;
	private String userFirstName;
	private String userLastName;
	private Short disabled;
	private String userEmail;
	private Integer numberSessionAuthorized;
	private String username; 
	private String password;
	private String confirmPassword;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private String codeRoles;
	private boolean saveAction = false;
	private boolean btnAction = true;
	private List<UtilisateurDTO> utilisateurList = new ArrayList<UtilisateurDTO>();
	private String codeAgence;


	public String getCodeRoles() {
		return codeRoles;
	}

	public void setCodeRoles(String codeRoles) {
		this.codeRoles = codeRoles;
	}

	public boolean isSaveAction() {
		return saveAction;
	}

	public void setSaveAction(boolean saveAction) {
		this.saveAction = saveAction;
	}

	public boolean isBtnAction() {
		return btnAction;
	}

	public void setBtnAction(boolean btnAction) {
		this.btnAction = btnAction;
	}

	public List<UtilisateurDTO> getUtilisateurList() {
		return utilisateurList;
	}

	public void setUtilisateurList(List<UtilisateurDTO> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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



	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	/**
	 * ---------------------------------------------------------------
	 * Cette methode permet de récupere les informations du formulaire
	 * ---------------------------------------------------------------
	 */
	public UtilisateurDTO setForms()
	{
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
		utilisateurDTO.setUserCreation(getCurrentUser().getUserId());
		utilisateurDTO.setUserId(userId);
		utilisateurDTO.setUserFirstName(userFirstName);
		utilisateurDTO.setUserLastName(userLastName);
		utilisateurDTO.setUserEmail(userEmail);
		utilisateurDTO.setUsername(username);
		utilisateurDTO.setPassword(password);
		utilisateurDTO.setConfirmPassword(confirmPassword);
		utilisateurDTO.setCodeRoles(codeRoles);
		return utilisateurDTO;
	}

	/**
	 * -------------------------------------------
	 * Cette methode permet de vider le formulaire
	 * -------------------------------------------
	 */
	public void iNitForms()
	{
		setUserId("");
		setUserFirstName("");
		setUserLastName("");
		setUserEmail("");
		setUsername(""); 
		setPassword(""); 
		setConfirmPassword("");
		setCodeRoles("");
	}

	/**
	 * --------------------------------------------------------------------------------------------------
	 * Cette methode permet de charger le formulaire avec les information récuperées de la base de donnée
	 * --------------------------------------------------------------------------------------------------
	 */
	public void getForms(UtilisateurDTO utilisateurDTO)
	{
		setUserId(utilisateurDTO.getUserId());
		setUserFirstName(utilisateurDTO.getUserFirstName());
		setUserLastName(utilisateurDTO.getUserLastName());
		setUserEmail(utilisateurDTO.getUserEmail());
		setUsername(utilisateurDTO.getUsername()); 
		setPassword(utilisateurDTO.getPassword()); 
		setConfirmPassword(utilisateurDTO.getConfirmPassword());
		setCodeRoles(utilisateurDTO.getCodeRoles());
	}
	
	
	public void connect(ActionEvent event)
	{	
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession ses = request.getSession();
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO() ;	
		try 
		{
			utilisateurDTO.setUsername(username);
			utilisateurDTO.setPassword(password);
			
			utilisateurDTO = utilisateurManager.edit(utilisateurDTO);
			
			ses.setAttribute("UTILISATEURDTO", utilisateurDTO);			
			//FacesContext.getCurrentInstance().getExternalContext().redirect(path+"/common/home.xhtml");
			FacesContext.getCurrentInstance().getExternalContext().redirect(path+"/pages/Client.xhtml");
		} 
		catch (Exception e) 
		{
			saveMessageError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void clean()
	{
		Enumeration<String > enums =getRequest().getSession().getAttributeNames();
    	while(enums.hasMoreElements())
    	{
    		String att=enums.nextElement();
    		getRequest().getSession().removeAttribute(att);
    	}
	}

	
	public void deconect()
	{
		String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession ses = request.getSession();
		ses.removeAttribute("UTILISATEURDTO");
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(path+"/index.xhtml");
			clean();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ------------------------------------------------------------------------------------------------
	 * Cette methode permet de vérifier la saisie des informations obligatoires au niveau du formulaire
	 * ------------------------------------------------------------------------------------------------
	 */
	public String checkError()
	{

		Pattern pMail = Pattern.compile("[a-z][0-9a-z.]+@[a-z0-9.]{2,}\\.[a-z]{2,4}$",Pattern.CASE_INSENSITIVE);
		Matcher mMail = pMail.matcher(userEmail);

		String messageReturn = null;

		if(StringUtils.isEmpty(getCodeRoles()))
		{
			messageReturn = SysEnv.getMessageProperties("Veuillez vérifier votre saisie");
		}
		else if(StringUtils.isEmpty(getUserId()))
		{
			messageReturn = SysEnv.getMessageProperties("Veuillez vérifier votre saisie");
		}
		else if(StringUtils.isEmpty(getUserEmail()))
		{
			messageReturn = SysEnv.getMessageProperties("Veuillez vérifier votre saisie");
		}
		else if(StringUtils.isEmpty(getUserFirstName()))
		{
			messageReturn = SysEnv.getMessageProperties("Veuillez vérifier votre saisie");
		}
		else if(StringUtils.isEmpty(getUserLastName()))
		{
			messageReturn = SysEnv.getMessageProperties("Veuillez vérifier votre saisie");
		}
		else if(StringUtils.isEmpty(getUsername()))
		{
			messageReturn = SysEnv.getMessageProperties("Veuillez vérifier votre saisie");
		}
		else if(!mMail.find())
		{
			messageReturn = SysEnv.getMessageProperties("Veuillez vérifier votre saisie");
		}

		return messageReturn;
	}



	/**
	 * -----------------------------------------------------------
	 * Cette methode permet d'actualiser la liste après une action
	 * -----------------------------------------------------------
	 */
	public void refresh(String typeOperation, UtilisateurDTO utilisateurDTO)
	{
		List<UtilisateurDTO> tmpList = new ArrayList<UtilisateurDTO>();
		int temp = 0;

		for(UtilisateurDTO tmp:this.utilisateurList)
		{
			if(!tmp.getUserId().equalsIgnoreCase(getUserId()))
			{
				tmpList.add(tmp);
			}
			else
			{
				temp = 1;
				tmpList.add(utilisateurDTO);
			}
		}
		if(temp == 0)
		{
			utilisateurList.add(utilisateurDTO);
		}
		else
		{
			setUtilisateurList(tmpList);
		}

		if(utilisateurList.size() > 0)
		{
			getForms(utilisateurList.get(0));
			setSaveAction(true);
			setBtnAction(false);
		}
		else
		{
			iNitForms();
			setSaveAction(false);
			setBtnAction(true);
		}
	}
	
	
	
	/**
	 * ---------------------------------------------
	 * Cette methode permet d'enregistrer / Modifier
	 * ---------------------------------------------
	 */
	public void save(ActionEvent event)
	{
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO() ;	
		String rMessage = null;
		String password = "";
		try 
		{
			rMessage = checkError();
			if(rMessage == null && checkLogin()==null)
			{
				utilisateurDTO = setForms();
				sendInfoConnexionUser(utilisateurDTO.getUserEmail(),utilisateurDTO.getUsername(),password);
				refresh("", utilisateurDTO);
				saveMessageInfo(successInsert);
			} 
			else
			{
				if (checkError()==null) {
					saveMessageError(checkLogin());
				}else
				{
				saveMessageError(rMessage);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			saveMessageError(e.getMessage());
		} 
	}
	
	public String checkLogin() 
	{

		String messageReturn = null;
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO() ;
		List<UtilisateurDTO> listeUser =new ArrayList<UtilisateurDTO>();
		try {
		if (!this.saveAction) {
			
				listeUser = utilisateurManager.find(utilisateurDTO);
				if(listeUser.size() > 0)
				{
					for (UtilisateurDTO item : listeUser) {
						//System.out.println(item.getUserId()+"  :  "+item.getTypeOperation());
						if (StringUtils.equalsIgnoreCase(item.getUsername(), getUsername()) 
								) {
							//utilisateurList.remove(item);
							messageReturn = SysEnv.getMessageProperties("FormUtilisateurLegende027");
							return messageReturn;
						}
					}
					
				}
			
			
		}else {
			utilisateurDTO.setUserId(this.userId);
			listeUser = utilisateurManager.find(utilisateurDTO);
			if (listeUser.size()>0) {
				utilisateurDTO = listeUser.get(0);
				if (!StringUtils.equals(utilisateurDTO.getUsername(), getUsername())) {
					 utilisateurDTO = new UtilisateurDTO() ;
					 listeUser = utilisateurManager.find(utilisateurDTO);
					 if(listeUser.size() > 0)
						{
							for (UtilisateurDTO item : listeUser) {
								//System.out.println(item.getUserId()+"  :  "+item.getTypeOperation());
								if (StringUtils.equalsIgnoreCase(item.getUsername(), getUsername()) 
										) {
									//utilisateurList.remove(item);
									messageReturn = SysEnv.getMessageProperties("FormUtilisateurLegende027");
									return messageReturn;
								}
							}
							
						}
					 
					 
				}
			}
			
		}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return messageReturn;
	
	}
	/**
	 * -------------------------------------------------------------------------
	 * Cette methode permet d'envoyé un mail à une utilisteur nouvellement créer
	 * -------------------------------------------------------------------------
	 */
	public void sendInfoConnexionUser(String email,String username,String pwd)
	{
		
	}

	
}
