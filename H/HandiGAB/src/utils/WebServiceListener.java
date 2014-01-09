/**
 * 
 */
package utils;

/**
 * @author Fatoumata
 *
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import utils.ApplicationContexte;



/**
 * Application Lifecycle Listener implementation class WebServiceListener
 *
 */
public class WebServiceListener implements ServletContextListener{



	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
        // TODO Auto-generated method stub
    	System.out.println("Démarrage Context Application");
    	ServletContext context = event.getServletContext();
    	   ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
           ApplicationContexte.getInstance().setCtx(ctx);
    }
	/**

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	
}
