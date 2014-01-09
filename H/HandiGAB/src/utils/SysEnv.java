package utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Vector;


/**
 *
 * 
 * @version 1.0
 *
 */
public class SysEnv {
    private static String DayMonthYearSeparator = "/";
    private static String HourMinuteSecondeSeparator = ":";
    private static String DateTimeDelimiter = " ";
    public static String DateFormat = "dd" + DayMonthYearSeparator + "MM" + DayMonthYearSeparator + "yyyy";
    public static String TimeFormat = "dd" + DayMonthYearSeparator + "MM" + DayMonthYearSeparator + "yyyy" + DateTimeDelimiter + "hh" + HourMinuteSecondeSeparator + "mm" + HourMinuteSecondeSeparator + "ss";
    public static String HMSFormat = "hh" + HourMinuteSecondeSeparator + "mm" + HourMinuteSecondeSeparator + "ss";
    public static String HMSInitialisation=" 00"+HourMinuteSecondeSeparator+"00"+HourMinuteSecondeSeparator+"00";
    public static String HMSFin=" 23"+HourMinuteSecondeSeparator+"59"+HourMinuteSecondeSeparator+"59";

    /**
     *
     *
     */
    public SysEnv() {
    }

    /**
     * ToDay
     *
     * @return
     */
    public static java.sql.Date ToDay() {
        return new java.sql.Date(System.currentTimeMillis());
    }
    
    /**
     * ToDay
     *
     * @return
     */
    public static java.util.Date ToDayUtil() {
        return new java.util.Date(System.currentTimeMillis());
    }
    /**
     * ToDayTimeStamp
     *
     * @return
     */
    public static Timestamp ToDayTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * TIME
     *
     * @return
     */
    public static java.sql.Time TIME() {
        return new java.sql.Time(System.currentTimeMillis());
    }

    /**
     * YEAR
     *
     * @return
     */
    public static String YEAR() {
        return ToDay().toString().substring(0, 4);
    }

    /**
     * MONTH
     *
     * @return
     */
    public static String MONTH() {
        return ToDay().toString().substring(5, 7);
    }

    /**
     * DAY
     *
     * @return
     */
    public static String DAY() {
        return ToDay().toString().substring(8, 10);
    }
    
    /**
     * HOUR
     *
     * @return
     */
    public static String HOUR() {
        return TIME().toString().substring(0, 2);
    }
    
    /**
     * MINUTE
     *
     * @return
     */
    public static String MINUTE() {
        return TIME().toString().substring(3, 5);
    }
    
    /**
     * SECOND
     *
     * @return
     */
    public static String SECOND() {
        return TIME().toString().substring(6, 8);
    }
    
    /**
     * strToDate
     *
     * @param value
     * @return
     */
    public static java.sql.Date strToDate(String value) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(DateFormat);
            df.setLenient(false);

            return new java.sql.Date(df.parse(value).getTime());
        } catch (Exception E) {
            return null;
        }
    }
    
    /**
     * stringToDate
     *
     * @param value
     * @return
     */
    public static java.util.Date stringToDate(String value) {
        try {
        	String jour = value.substring(0, 2);
        	String mois = value.substring(2, 4);
        	String anne = value.substring(4, value.length());
        	String date = jour + DayMonthYearSeparator + mois + DayMonthYearSeparator + anne; 
        	return strToDate(date);
        } 
        catch (Exception E) {
            return null;
        }
    }
    
    public static java.util.Date strToDateUtil(String value)
    {
    	try {
            SimpleDateFormat df = new SimpleDateFormat(DateFormat);
            df.setLenient(false);

            return new java.util.Date(df.parse(value).getTime());
        } catch (Exception E) {
            return null;
        }
    }
    
    /**
     * dateToStr
     *
     * @param value
     * @return
     */
    public static String dateToStr(java.sql.Date value) {
        String d = "";
        String m = "";

        if (value == null) {
            return "";
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(new java.util.Date(value.getTime()));
            d = String.valueOf(gc.get(Calendar.DATE));
            m = String.valueOf(gc.get(Calendar.MONTH) + 1);

            if (d.length() == 1) {
                d = "0" + d;
            }

            if (m.length() == 1) {
                m = "0" + m;
            }

            return d + DayMonthYearSeparator + m + DayMonthYearSeparator +
            String.valueOf(gc.get(Calendar.YEAR));
        }
    }
    public static String dateToStr(java.util.Date value) {
    	return dateToStr(utilDateToSqlDate(value));
    }
    /**
     * strToTime
     *
     * @param value
     * @return
     */
    public static Time strToTime(String value) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(TimeFormat);

            return new java.sql.Time(df.parse(value).getTime());
        } catch (Exception E) {
            return null;
        }
    }

    public static Time strToTimeHMS(String value) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(HMSFormat);

            return new java.sql.Time(df.parse(value).getTime());
        } catch (Exception E) {
            return null;
        }
    }

    /**
     * timeToStr
     *
     * @param value
     * @return
     */
    public static String timeToStr(Time value) {
        if (value == null) {
            return "";
        } else {
            GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(
                        "GMT"));
            gc.setTime(new java.util.Date(value.getTime()));

            return String.valueOf(gc.get(Calendar.DATE)) +
            DayMonthYearSeparator + String.valueOf(gc.get(Calendar.MONTH) + 1) +
            DayMonthYearSeparator + String.valueOf(gc.get(Calendar.YEAR)) +
            DateTimeDelimiter + String.valueOf(gc.get(Calendar.HOUR_OF_DAY)) +
            HourMinuteSecondeSeparator +
            String.valueOf(gc.get(Calendar.MINUTE)) +
            HourMinuteSecondeSeparator +
            String.valueOf(gc.get(Calendar.SECOND));
        }
    }
    
    public static String dateTimeToStr(Date value) {
        if (value == null) {
            return "";
        } else {
            GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone(
                        "GMT"));
            gc.setTime(new java.util.Date(value.getTime()));

            return String.valueOf(gc.get(Calendar.DATE)) +
            String.valueOf(gc.get(Calendar.MONTH) + 1) +
            String.valueOf(gc.get(Calendar.YEAR)) +
            String.valueOf(gc.get(Calendar.HOUR_OF_DAY)) +
            String.valueOf(gc.get(Calendar.MINUTE)) +
            String.valueOf(gc.get(Calendar.SECOND)) + 
            String.valueOf(gc.get(Calendar.MILLISECOND));
        }
    }
    
    public static String timeToDate(Timestamp value) {
        if (value == null) {
            return "";
        } else {
            return value.toString().substring(0, value.toString().indexOf(" "));
        }
    }
    
    /**
     * split
     *
     * @param chaine
     * @param separator
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector split(String chaine, String separator) {
        Vector vector = new Vector();
        int nbreSeperat = 0;

        while ((chaine.indexOf(separator) != -1) || (nbreSeperat != 0)) {
            if (chaine.indexOf(separator) != -1) {
                nbreSeperat++;

                //System.out.println(chaine.substring(0,chaine.indexOf(separator))+"-----");
                vector.add(chaine.substring(0, chaine.indexOf(separator)));
            } else {
                nbreSeperat = 0;
                vector.add(chaine.substring(0, chaine.length()));
            }

            chaine = chaine.substring(chaine.indexOf(separator) +
                    separator.length(), chaine.length());
        }

        return vector;
    }

    /**
     *
     * @param value
     * @return
     */
    public static Timestamp strToTimestamp(String value) {
    	SimpleDateFormat df = new SimpleDateFormat(TimeFormat);
        try {         
        	if(value!=null)
        		return new java.sql.Timestamp(df.parse(value).getTime());
        	else
        		return null; 
        }catch (ParseException e) {
        	try {
				return new java.sql.Timestamp(df.parse(value+SysEnv.HMSInitialisation).getTime());
			} catch (ParseException e1) {
				return null;
			}
		}
        catch (Exception E) {
            E.printStackTrace(System.out);

            return null;
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static String timestampToStr(Timestamp value) {
        if (value == null) {
            return "";
        } else {
            GregorianCalendar gc = new GregorianCalendar();//TimeZone.getTimeZone("GMT+1"));
            gc.setTime(new java.util.Date(value.getTime()));

            return String.valueOf(gc.get(Calendar.DATE)) +
            DayMonthYearSeparator + String.valueOf(gc.get(Calendar.MONTH) + 1) +
            DayMonthYearSeparator + String.valueOf(gc.get(Calendar.YEAR)) +
            DateTimeDelimiter + String.valueOf(gc.get(Calendar.HOUR_OF_DAY)) +
            HourMinuteSecondeSeparator +
            String.valueOf(gc.get(Calendar.MINUTE)) +
            HourMinuteSecondeSeparator +
            String.valueOf(gc.get(Calendar.SECOND));
        }
    }
    
    public static String dateTimeToStr(Timestamp value) {
        if (value == null) {
            return "";
        } else {
            GregorianCalendar gc = new GregorianCalendar();//TimeZone.getTimeZone("GMT+1"));
            gc.setTime(new java.util.Date(value.getTime()));

            return String.valueOf(gc.get(Calendar.DATE)) +
            String.valueOf(gc.get(Calendar.MONTH) + 1) +
            String.valueOf(gc.get(Calendar.YEAR)) +
            String.valueOf(gc.get(Calendar.HOUR_OF_DAY)) +
            String.valueOf(gc.get(Calendar.MINUTE)) +
            String.valueOf(gc.get(Calendar.SECOND)) +
            String.valueOf(gc.get(Calendar.MILLISECOND));
        }
    }

    /**
     * fonction qui recupere une valeur correspond a un key dans un fichier
     * properties il faut preciser le chemin de fichier properties
     *
     * @param pathProperties
     * @param key
     * @return
     */
    public static final String getvalFromProperties(String pathProperties,
        String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(pathProperties);

        return bundle.getString(key);
    }

    /**
     * fonction permet d'ajouter nombre de jours dans une date
     *
     * @param date
     * @param nbrjours
     * @return
     */
    public static final Date addDays(java.sql.Date date, int nbrjours) {
        long jour = 1000 * 60 * 60 * 24;
        long dat = date.getTime();
        long som = dat + (jour * nbrjours);
        java.util.Date date2 = new java.util.Date();
        date2.setTime(som);

        return utilDateToSqlDate(date2);
    }

    /**
     * fonction qui retourne l'annee dans une date
     *
     * @param date
     * @return
     */
    public static final int getYearFomDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR);
    }

    /**
     * fonction qui retourne le mois dans une date
     *
     * @param date
     * @return
     */
    public static final int getMonthFomDate(Date date) {
        GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gc.setTime(sqlDateToUtilDate(date));

        return gc.get(GregorianCalendar.MONTH);
    }

    /**
     * fonction qui retourne le jour dans une date
     *
     * @param date
     * @return
     */
    public static final int getDayFomDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * fonction permet de comparer deux dates en fesant la difference en nombre
     * de jours
     *
     * @param dat1
     * @param dat2
     * @return
     */
    public static final int differenceFrom2Date(Date dat1, Date dat2) {
        long day = 1000 * 60 * 60 * 24;
        long diff = (dat1.getTime() / day) - (dat2.getTime() / day);

        return new Long(diff).intValue();
    }
    
    /**
     * fonction permet de comparer deux dates en fesant la difference en nombre
     * de jours
     *
     * @param dat1
     * @param dat2
     * @return
     */
    public static final int differenceFrom2Date(java.util.Date dat1, java.util.Date dat2) {
        long day = 1000 * 60 * 60 * 24;
        long diff = 0;
        if(dat1 == null && dat2 != null)
        {
        	diff = 0 - (dat2.getTime() / day);
        }
        else if(dat1 != null && dat2 == null)
        {
        	diff = (dat1.getTime() / day);
        }
        else
        {
        	diff = (dat1.getTime() / day) - (dat2.getTime() / day);
        }
        return new Long(diff).intValue();
    }
    
    public static final int differenceFrom2DateEnMinute(Timestamp datetime, Timestamp datetime2) {
        long hour = 1000 * 60  ;
      
        long diff = (datetime.getTime() / hour) - (datetime2.getTime() / hour);        
        return new Long(diff).intValue();
    }
    /**
     * fonction qui retourne un decimal en introduisant nbre de chiffre apres la
     * virgule
     *
     * @param value
     * @param scale
     * @return
     */
    public static String NumberToStr(Number value, int scale) {
        DecimalFormat nbrF = new DecimalFormat("#0");
        nbrF.setMinimumFractionDigits(scale);

        if (value == null) {
            return "";
        } else {
            return replace(nbrF.format(new Double(value.doubleValue())), ",",
                ".");
        }
    }

    public static String BigdecimalToStr(BigDecimal value) {
        if (value == null) {
            return "";
        } else {
            return value.toString();
        }
    }

    public static String IntegerToStr(Integer value) {
        if (value == null) {
            return "";
        } else {
            return value.toString();
        }
    }

    public static BigDecimal NumberToBigDecimal(Number value, int scale) {
        DecimalFormat nbrF = new DecimalFormat("#0");
        nbrF.setMinimumFractionDigits(scale);

        if (value == null) {
            value = new BigDecimal(0);
        }

        return new BigDecimal(replace(nbrF.format(
                    new Double(value.doubleValue())), ",", "."));
    }

    /**
     *
     * @param value
     * @return
     */
    public static Float strToFloat(String value) {
        if (value == null) {
            return null;
        } else if (value.trim().equals("")) {
            return null;
        } else {
            return new Float(value);
        }
    }

    /**
     * fonction qui retourne l'oppose d'un double
     *
     * @param value
     * @return
     */
    public static Double opposeOfDouble(Double value) {
        Long val = null;
        Double val1 = null;

        if (value == null) {
            return (new Double(0));
        } else {
            val1 = new Double(value.doubleValue() * 1000);
            val = new Long((-1) * val1.longValue());

            return (new Double(val.doubleValue() / 1000));
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static BigDecimal integerToBigDecimal(Integer value) {
        if (value == null) {
            return new BigDecimal(0);
        } else {
            return new BigDecimal(value.doubleValue());
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static BigDecimal strToBigDecimal(String value) {
        if (value == null) {
            return null;
        } else if (value.trim().equals("")) {
            return null;
        } else {
            return new BigDecimal(value);
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static Double strToDouble(String value) {
        if (value == null) {
            return null;
        } else if (value.trim().equals("") || value.trim().equals("null")) {
            return null;
        } else {
            return new Double(value.trim());
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static Integer strToInteger(String value) {
        if (value == null) {
            return null;
        } else if (value.trim().equals("")) {
            return null;
        } else {
            return new Integer(value);
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static Long strToLong(String value) {
        if (value == null) {
            return new Long(0);
        } else if (value.trim().equals("") || value.trim().equals("null")) {
            return new Long(0);
        } else {
            return new Long(value);
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static Short strToShort(String value) {
        if (value == null) {
            return null;
        } else if (value.trim().equals("")) {
            return null;
        } else {
            return new Short(value);
        }
    }

    /**
     *
     * @param value
     * @return
     */
    public static BigInteger strToBigInteger(String value) {
        if (value == null) {
            return null;
        } else if (value.trim().equals("")) {
            return null;
        } else {
            return new BigInteger(value);
        }
    }

    /**
     * convertir une date java.util.date en java.sql.date
     *
     * @param date
     * @return
     */
    public static java.sql.Date utilDateToSqlDate(java.util.Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        } else {
            return null;
        }
    }

    /**
     * convertir une date java.sql.date en java.util.date
     *
     * @param date
     * @return
     */
    public static java.util.Date sqlDateToUtilDate(java.sql.Date date) {
        if (date != null) {
            return new java.util.Date(date.getTime());
        } else {
            return null;
        }
    }

    /**
     * ajout nbre de jour dans une date
     *
     * @param date
     * @param n
     * @return
     */
    public static java.sql.Date addJour(java.sql.Date date, int n) {
        GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gc.setTime(sqlDateToUtilDate(date));
        gc.add(GregorianCalendar.DAY_OF_MONTH, n);

        return (utilDateToSqlDate(gc.getTime()));
    }

    /**
     * ajout nbre de mois dans une date
     *
     * @param date
     * @param m
     * @return
     */
    public static java.sql.Date addMonth(java.sql.Date date, int m) {
        GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gc.setTime(sqlDateToUtilDate(date));
        gc.add(GregorianCalendar.MONTH, m);

        return (utilDateToSqlDate(gc.getTime()));
    }

    /**
     * augmenter une date par nbre de jour
     *
     * @param date
     * @param n
     * @return
     */
    public static java.sql.Date CalcDatePlus(java.sql.Date date, int n) {
        return addJour(date, n);
    }

    /**
     * diminuer une date d'un nbre de jour
     *
     * @param date
     * @param n
     * @return
     */
    public static java.sql.Date CalcDateMoins(java.sql.Date date, int n) {
        return addJour(date, -n);
    }

    /*
     * public static int getDay(java.sql.Date date){ GregorianCalendar gc=new
     * GregorianCalendar(TimeZone.getTimeZone("GMT"));
     * gc.setTime(sqlDateToUtilDate(date)); return
     * gc.get(GregorianCalendar.DATE); }
     */

    /**
     *
     */
    public static java.sql.Date getDate(int day, int month, int year) {
        GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gc.set(year, month, day);

        return utilDateToSqlDate(gc.getTime());
    }

    /**
     * convertir une date en une format francaise
     *
     * @param value
     * @return
     */
    public static java.text.DateFormat strToDateFr(String value) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(DateFormat);
            df.setLenient(false);

            return SimpleDateFormat.getDateInstance(2, new Locale("fr", ""));
        } catch (Exception E) {
            return null;
        }
    }

    /**
     *
     * @param value
     * @param ancien
     * @param nouveau
     * @return
     */
    public static String replace(String value, String ancien, String nouveau) {
        if (value == null) {
            return null;
        } else if (value.equals("")) {
            return "";
        } else if (value.indexOf(ancien) == -1) {
            return value;
        } else {
            return value.substring(0, value.indexOf(ancien)) + nouveau +
            replace(value.substring(value.indexOf(ancien) + ancien.length(),
                    value.length()), ancien, nouveau);
        }
    }

    /**
     *
     * @param value
     * @param delimiter
     * @return
     */
    public static String[] splitString(String value, String delimiter) {
        StringTokenizer strTake = new StringTokenizer(value, delimiter);
        String[] result = new String[strTake.countTokens()];
        int i = 0;

        while (strTake.hasMoreTokens()) {
            result[i] = strTake.nextToken();
            i++;
        }

        return result;
    }
    
    /**
     * si null elle met vide
     *
     * @param value
     * @return
     */
    public static String emptyIfNull(java.util.Date value) {
        if (value == null) {
            return "";
        } else {
            return value.toString();
        }
    }
    
    /**
     * si null elle met vide
     *
     * @param value
     * @return
     */
    public static String emptyIfNull(String value) {
        if (value == null) {
            return "";
        } else {
            return value;
        }
    }

    /**
     * verifier si vide
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        return (value == null) || (value.trim().equals(""));
    }

    public static String onlyFirstIsUpper(String nom) {
        if (nom == null) {
            nom = "";
        }

        nom = nom.toLowerCase();

        return nom.replaceFirst("" + nom.charAt(0),
            new String("" + nom.charAt(0)).toUpperCase());
    }

    public static BigDecimal add(BigDecimal val1, BigDecimal val2) {
        if ((val1 != null) && (val2 != null)) {
            val1 = val1.add(val2);
            val1 = NumberToBigDecimal(val1, BigDecimal.ROUND_CEILING);
        }

        return val1;
    }

    public static Integer add(Integer val1, Integer val2) {
        if ((val1 != null) && (val2 != null)) {
            val1 = new Integer(val1.intValue() + (val2.intValue()));
        }

        return val1;
    }

    public static BigDecimal soustract(BigDecimal val1, BigDecimal val2) {
        if ((val1 != null) && (val2 != null)) {
            val1 = val1.subtract(val2);
            val1 = NumberToBigDecimal(val1, BigDecimal.ROUND_CEILING);
        }

        return val1;
    }

    public static BigInteger soustract(BigInteger val1, BigInteger val2) {
        if ((val1 != null) && (val2 != null)) {
            val1 = val1.subtract(val2);
        }

        return val1;
    }

    public static Integer soustract(Integer val1, Integer val2) {
        if ((val1 != null) && (val2 != null)) {
            val1 = new Integer(val1.intValue() - val2.intValue());
        }

        return val1;
    }

    public static Double soustract(Double val1, Double val2) {
        if ((val1 != null) && (val2 != null)) {
            val1 = new Double(val1.doubleValue() - val2.doubleValue());
        }

        return val1;
    }

    /**
     * fonction qui donne la valeur la plus grande d'une liste des valeurs
     *
     * @param listvaleur
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object returnBigValue(Vector listvaleur) {
        Collections.sort(listvaleur);

        if (listvaleur.size() != 0) {
            return listvaleur.get(listvaleur.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * @param i
     * @return
     */
    public static Integer int2Integer(int i) {
        return new Integer(i);
    }
    
    public static boolean isANumber(String s) 
    {
    	//if (s == null) 
    		//return false;
    	try 
    	{
    		new java.math.BigDecimal(s);
    	    return true;
    	} 
    	catch (NumberFormatException e) {
    		return false;
    	}
    }
    
    /**
     *
     * @param keyMessage
     * @return
     */
    public static String getMessageProperties(String keyMessage) {
        String message = "";

        try {
        	
           // ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources",
                    //Locale.getDefault());
           // message = bundle.getString(keyMessage);
        } catch (Exception e) {
        	message= keyMessage;
            //e.printStackTrace();
        }

        return message;
    }
    
    
    
    public static String concactener(String enter, int taille,String bourage) {
		int tailleentre=0;
		String chaine="";
		if(enter!=null){
			enter.length();
			chaine=enter;
		}
		
		int i=tailleentre;
		while(i<taille)
		{
			chaine=chaine+bourage;
			i++;
		}
		return chaine;
	}
    public static String concactenerLeft(String enter, int taille,String bourage) {
		int tailleentre=0;
		String chaine="";
		if(enter!=null){
			enter.length();
			chaine=enter;
		}
		
		int i=tailleentre;
		while(i<taille)
		{
			chaine=bourage+chaine;
			i++;
		}
		return chaine;
	}
    public static String longToStr(Long value) {
        if (value == null) {
            return null;
        } else {
            return value.toString();
        }
    }
    public static boolean verifeType(String value, String type) {
    	int codeascii;
        if (value == null || type==null) {
            return false;
        } else
        	if(type.toLowerCase().equals("n") || type.toLowerCase().equals("integer") || type.toLowerCase().equals("int") || type.toLowerCase().equals("long") || type.toLowerCase().equals("biginteger")){
        		for(char ch:value.toCharArray()){
        			codeascii=(int) ch;
        			if(codeascii <48 && codeascii >57)
        				return false;
        		}
        	}else
        		if(type.toLowerCase().equals("string") || type.toLowerCase().equals("an") ){
            		for(char ch:value.toCharArray()){
            			codeascii=(int) ch;
            			if(codeascii <65 && codeascii >90 && codeascii<97 && codeascii>122)
            				return false;
            		}
            	}else
            		if(type.toLowerCase().equals("d") || type.toLowerCase().equals("float") || type.toLowerCase().equals("bigdecimal") || type.toLowerCase().equals("double") ){
                		for(char ch:value.toCharArray()){
                			codeascii=(int) ch;
                			if(codeascii <48 && codeascii >57 && codeascii !=46 && codeascii !=44)
                				return false;
                		}
                	}
        return true;
    }
    
    /**
     * dateToStr
     *
     * @param value
     * @return
     */
    public static String dateToStrYYYYMMDD(String value) {
    	String date08 = "";
        if (value == null) 
        {
            return "";
        } 
        else if(value.length() == 0)
        {
        	return "";
        }
        else 
        {
        	if(value.toString().length() > 10)
        	{
        		date08 = value.toString().substring(0, 10);
        	}
        	else
        	{
        		date08 = value.toString();
        	}
        	String d[] = date08.split("-");
            return d[0] + "" + d[1] + "" + d[2];
        }
    }
    
    /**
     * dateToStr
     *
     * @param value
     * @return
     */
    public static Date expiryteDate(String value) {
    	return strToDate(value);
    }
    
    /**
     * dateToStr
     *
     * @param value
     * @return
     */
    public static String dateToStrJJMMAA(Date value) {
        if (value == null) 
        {
            return "";
        } 
        else 
        {
        	String d[] = value.toString().split("-");
            return d[2] + "" + "" + d[1] + "" +d[0].substring(2, 4);
        }
    }
    
    public static String JulianDay()
    {
    	String dateDebut = "0101"+SysEnv.YEAR();
    	long day = 1000 * 60 * 60 * 24;
    	long julienneDate = 0; 
    	String date = dateDebut.substring(0, 2) + DayMonthYearSeparator + dateDebut.substring(2, 4) + DayMonthYearSeparator + dateDebut.substring(4, dateDebut.length()); 
    	julienneDate = (((SysEnv.ToDayUtil().getTime())/day)-((SysEnv.strToDateUtil(date).getTime())/day)) + 1;
       return YEAR().substring(2, 4) + "" + julienneDate;
    }
    
    
    
    /**
     * Traitement chaine de caractère  dans sysEnv
     */
    public static String formatString(String string) {
		
    	string = string.replace(" ", "_");
    	string = string.replace("/", "_");
    	string = string.replace("\\", "_");
    	string = string.replace("<", "_");
    	string = string.replace(">", "_");
    	string = string.replace(":", "_");
    	string = string.replace("|", "_");
    	string = string.replace("_____", "_");
    	string = string.replace("____", "_");
    	string = string.replace("___", "_");
    	string = string.replace("__", "_");
    	return string;
	}
    
    public static String padding(String chaine, int position, String charPading, String paddingType) throws Exception{
 		String returnValue = "";
 		try{
 			if(chaine == null)
 			{
 				chaine = "";
 			}
 			int tailleEntre = chaine.length();
 			returnValue = chaine;
 			if(tailleEntre < position)
 			{
 				int i=tailleEntre;
 				while(i < position){
 					if(paddingType.equalsIgnoreCase(SysVar.PaddingType.DEBUT))
 					{
 						returnValue = charPading+""+returnValue;
 					}
 					else if(paddingType.equalsIgnoreCase(SysVar.PaddingType.FIN))
 					{
 						returnValue = returnValue+""+charPading;
 					}
 					i++;
 				}
 			}
 			else
 			{
 				returnValue = chaine.substring(0, position);
 			}
 		}
 		catch (Exception e) {
 			throw new Exception(e.getMessage());
 		}
 		return returnValue;
 	}
}
