package utils;
import org.springframework.context.ApplicationContext;

public class ApplicationContexte {

	static ApplicationContexte instance;
	protected ApplicationContext ctx;
	
	 private ApplicationContexte(){
		
	}
	 
	 public static ApplicationContexte getInstance(){
		 if(instance==null){
			 instance = new ApplicationContexte();
		 }
		 
		 return instance;
	 }

	public ApplicationContext getCtx() {
		return ctx;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}
	 
	 
	 
}
