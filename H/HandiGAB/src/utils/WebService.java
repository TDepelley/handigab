package utils;

import org.springframework.context.ApplicationContext;


public class WebService 
{

	 public Object getBean(String name) 
	 {
	        try
	        {
	        	ApplicationContext ctx = ApplicationContexte.getInstance().getCtx();
	            return ctx.getBean(name);
	        } catch (Exception e)
	        {
	            e.printStackTrace();

	            return null;
	        }
	    }  
}
