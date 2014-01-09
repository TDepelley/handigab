package handiGab.dao.impl;

import handiGab.dao.Manager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BaseManager implements Manager {
	protected final Log log = LogFactory.getLog(getClass());

	 /**
     *  Permet de convertir une chaine via le modele pour la clause LIKE .
     *
     * @param text un bit de text
     * @return  un modele like qui matche en une chaine de text
     */
    protected String asPattern(String text)
    {
        return asPattern(text, true);
    }


    /**
     * Permet de convertir une chaine via le modele pour la clause LIKE .
     *
     * @param text      un bit de text
     * @param wildcards si {@code true}, les caractères '*' and '?' seront traduisés dans le wildcards
     * @return un modele like qui matche en une chaine de text
     */
    protected String asPattern(String text, boolean wildcards)
    {
    	String pattern;
        if (text == null)
        {
            pattern = null;
        }
        else if (text.length() == 0)
        {
            pattern = "%";
        }
        else
        {
        	pattern = text;
        	pattern = pattern.replaceAll("\\\\", "\\\\");
            pattern = pattern.replaceAll("%", "\\%");
            pattern = pattern.replaceAll("_", "\\_");
            if (wildcards)
            {
            	pattern = pattern.replace('*', '%');
                pattern = pattern.replace('?', '_');
            }
            pattern = '%' + pattern + '%';
        }
        return pattern;
    }
}