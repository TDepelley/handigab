package handiGab.FormBean;


import handiGab.dto.UtilisateurDTO;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.UIDataTable;

import utils.SysEnv;



public class BaseFB {
	protected final static String successInsert="successInsert";
	protected final static String successUpdate="successUpdate";
	protected final static String successDelete="successDelete";
	
	private String agence;
	private String user;
	
	public Log log = LogFactory.getLog(BaseFB.class);

	public void setLog(Log log) 
	{
		this.log = log;
	}	
	protected HttpServletRequest getRequest()
	{
		FacesContext context = FacesContext.getCurrentInstance();
	return (HttpServletRequest) context.getExternalContext().getRequest();
	}
	protected HttpServletResponse getResponse()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		return (HttpServletResponse) context.getExternalContext().getResponse();
	}
	/**
	 * Permet de retourner l'utilisateur courant connecter en session 
	 */
	/*public static UtilisateurDTO getCurrentUser(){
		SecurityContext ctx = SecurityContextHolder.getContext();
		Utilisateur userDetails= (Utilisateur)ctx.getAuthentication().getPrincipal();
		return userDetails;
	}*/
	public UtilisateurDTO getCurrentUser()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
		HttpSession ses = request.getSession();
		if(ses.getAttribute("UTILISATEURDTO") != null)
		{
			utilisateurDTO = (UtilisateurDTO) ses.getAttribute("UTILISATEURDTO");
		}
		return utilisateurDTO;
	}
	protected void saveMessageInfo(String codeErreur)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		if(SysEnv.getMessageProperties(codeErreur)!=null)
		{
			//codeErreur= SysEnv.getMessageProperties(codeErreur);
		}
		context.addMessage("msgs", new FacesMessage(FacesMessage.SEVERITY_INFO,codeErreur, ""));
	}
	protected void saveMessageError(String codeErreur)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		//codeErreur= SysEnv.getMessageProperties(codeErreur);
		context.addMessage("msgs", new FacesMessage(FacesMessage.SEVERITY_ERROR,codeErreur, ""));
	}
	public UIDataTable editLine(UIComponent uComponent)
	{
		if(uComponent == null)
			return null;
		if(uComponent instanceof UIDataTable)
			return (UIDataTable) uComponent;
		return editLine(uComponent.getParent());
	}
	
	public String ctrlDate(Date dateDebut, Date dateFin, boolean twoDate) {
		try {
			
			if (twoDate) {
				if (dateDebut == null || dateFin == null || (dateDebut.after(dateFin))) 
				{
					//return SysEnv.getMessageProperties("FrmEditDateError");
					return "A";
				}
				else if (dateFin.after(SysEnv.ToDay())) {
					return "A";
					//return SysEnv.getMessageProperties("FrmEditDateFutureError");
				}
			} 
			else {
				if (dateDebut == null) 
				{
					//return SysEnv.getMessageProperties("FrmEditDateNullError");
					return "A";
				}
				else if (dateDebut.after(SysEnv.ToDay())) {
					return "A";
					//return SysEnv.getMessageProperties("FrmEditDateFutureError");
				}
			}
		} 
		catch (Exception e) {
			saveMessageError(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public String getAgence() {
		UtilisateurDTO u= getCurrentUser();
		user =u.getUserFirstName()+" "+u.getUserLastName();
		agence = u.getAgenceDTO().getNomAgence();
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}