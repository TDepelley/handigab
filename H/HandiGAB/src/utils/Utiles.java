package utils;

import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

public class Utiles 
{
	
	
	//Met les elements de la trame dans une table
		public static String [] ConversionTrameTab(String trame)
		{
			StringTokenizer tokenizer = new StringTokenizer(trame, "#");
			String elementTrame[]=new String [tokenizer.countTokens()];
			int i=0;
			if (!trame.isEmpty())
			{	
				while ( tokenizer.hasMoreTokens() ) 
				{	
					elementTrame[i]=StringUtils.trimToEmpty(tokenizer.nextToken());
					System.out.println(elementTrame[i]);
					i++;
				}
			}
			return elementTrame;
		}


}
