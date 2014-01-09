package utils;



public class SysVar {
	
	public final static String SchemaName = "";
	public final static String Prefixe = "CLT_";
	
	public enum TypeOperation {
		 INSERT,
		 UPDATE,
		 DELETE
	}
	
	public static class TypeActivation
	{
		public final static String YES = "O";
		public final static String NON = "N";
	}
	
	public static class TypeAgence
	{
		public final static String SIEGE = "01";
		public final static String AGENC = "02";
	}
	
	public static class TypeTerminal
	{
		public final static String GAB = "1";
		public final static String TPE = "2";
		public final static String DAB = "3";
		public final static String TCA = "4";
	}
	
	public static class EtatCarte
	{
		public final static Long SAVE       = new Long(0);
		public final static Long VALIDATE	= new Long(1);
		public final static Long ACCEPT 	= new Long(2);
		public final static Long STOCK 		= new Long(3);
		public final static Long ISSUE 		= new Long(4);
		public final static Long ACTIVATE   = new Long(5);
		public final static Long UPDATE 	= new Long(6);
		public final static Long RENEW		= new Long(7);
		public final static Long DELETE 	= new Long(-1);
		public final static Long REJECT 	= new Long(-2);
		public final static Long DESTRUCTION= new Long(-3);
		/**
		 * Etat réception distribution
		 */
		public final static Long RECEPTIONSIEGE	= new Long(40);
		public final static Long RECEPTIONAGENC = new Long(50);
		public final static Long DISPATCHERSIEG = new Long(60);
	}
	
	public static class CardProperty
	{
		public final static int NomEmbosseLength = 26;
		public final static int NumberAccount = 2;
	}
	
	public static class EtatGenere
	{
		public final static String GENERER 	= "1";
		public final static String NOTGEN 	= "0";
	}
	
	public static class EtatOpposition
	{
		public final static String SAISIE 	= "0";
		public final static String VALIDER 	= "1";
		public final static String MAINLEVEE= "2";
		public final static String DELETE 	= "-1";
	}
	
	public static class OptionUpdate
	{
		public final static String INSERT 				= "I";
		public final static String PLAFOND 				= "I";
		public final static String RENOUVELEMENT 		= "N";
	    public final static String CALCULPINSANSFRAIS 	= "C";
	    public final static String CALCULPINAVECFRAIS 	= "Y";
	    public final static String REPLACEAVECFRAIS 	= "F";
	    public final static String REPLACESANSFRAIS 	= "R";
	    public final static String ANNULATION 			= "A";
	    public final static String COMPTES 				= "";
	}
	
	public static class EtatCompte
	{
		public final static Long ACTIF 			= new Long(1);
		public final static Long INACTIF 		= new Long(2);
		public final static Long FERMER 		= new Long(3);
		public final static Long SUSPENDU 		= new Long(4);
		public final static Boolean ETATACTIVER = true;
	}
	
	public static class FlagCarte
	{
		public final static String PRIMARY 	= "P";                     
	    public final static String SECONDARY= "S";  
	}
	
	public static class TypeOpposition
	{
	    public final static String CARTE 	= "C";
	    public final static String BIN 		= "B";
	    public final static String TRANCHE 	= "R";
	}
	
	public static class UsageOpposition
	{
	    public final static String PAIEMENTRETRAIT = "B";
	    public final static String RETRAITUNIQUEME = "W";
	    public final static String PAIEMENTUNIQUEM = "P";
	}
	
	public static class ActionOpposition
	{
	    public final static String OPPOSITION 	= "I";
	    public final static String MAINLEVEE 	= "D";
	    public final static String UPDATE 		= "U";
	}
	
	public static class TypeDelivrance
	{
		public final static String PAN = "01";
		public final static String PIN = "02";
	}
	
	public static class TypeReception
	{
		public final static String PAN = "1";
		public final static String PIN = "2";
	}
	
	public static class TypeDistribution
	{
		public final static String PAN = "1";
		public final static String PIN = "2";
	}
	
	public static class TypeDonnee
	{
	    public static String ALPHABET 		= "A";
	    public static String ALPHANUMERIC 	= "AN";
	    public static String NUMERIC 		= "N";
	    public static String DECIMAL 		= "D";
	    public static String BINAIRE 		= "B";
	    public static String SPECIAL 		= "S";
	    public static String TAUX 			= "T";
	    public static String ESPACE 		= " ";
	}
	
	public static class CharPadding
	{
	    public static String ESPACE 		= " ";
	    public static String DIGITE	 		= "0";
	}
	
	public static class SensPadding
	{
	    public static int GAUCHE = 1;
	    public static int DROITE = 2;
	}
	
	public static class AttributStatus
	{
	    public static String OBLIGATOIRE 	= "O";
	    public static String INCHANGE 		= "R";
	    public static String CONDITIONNEL 	= "C";
	}
	
	public static class TypeTransactionPlafond
	{
	    public static String RETRAIT = "08";
	    public static String ACHAT 	 = "02";
	    public static String CASH 	 = "07";
	}
	
	public static class TypeTC
	{
	    public static String ENTETE = "E";
	    public static String DETAIL = "D";
	    public static String FIN 	= "F";
	}
	
	public static class EnteteFinFichier
	{
		public final static String ENTETE = "90";
		public final static String FIN 	  = "91";
	}
	
	public static class EnteteFinSousFichier
	{
		public static String TC92 = "92";
	    public static String TC93 = "93";
	    public static String TC94 = "94";
	    public static String TC95 = "95";
	    public static String TC96 = "96";
	    public static String TC97 = "97";
	    public static String TC98 = "98";
	    public static String TC99 = "99";
	    public static String TC80 = "80";
	    public static String TC81 = "81";
	}
	
	public static class TailleAttributFichier
	{
	    public static int TAILLE_TC 	  = 2;
	    public static int TAILLE_TCR 	  = 1;
	    public static int TAILLE_SEQUENCE = 6;
	}
	
	public static class TCSpecifique
	{
		public static String TC01 = "01";
	    public static String TC02 = "02";
	    public static String TC03 = "03";
	    public static String TC05 = "05";
	    public static String TC06 = "06";
	    public static String TC07 = "07";
	    public static String TC09 = "09";
	    public static String TC15 = "15";
	    public static String TC16 = "16";
	    public static String TC17 = "17";
	    public static String TC19 = "19";
	    public static String TC25 = "25";
	    public static String TC26 = "26";
	    public static String TC27 = "27";
	    public static String TC35 = "35";
	    public static String TC36 = "36";
	    public static String TC37 = "37";
	    public static String TC40 = "40";
	    public static String TC47 = "47";
	    public static String TC48 = "48";
	    public static String TC49 = "49";
	    public static String TC50 = "50";
	    public static String TC51 = "51";
	    public static String TC52 = "52";
	    public static String TC53 = "53";
	    public static String TC55 = "55";
	    public static String TC56 = "56";
	    public static String TC57 = "57";
	    public static String TC60 = "60";
	    public static String TC61 = "61";
	    public static String TC62 = "62";
	    public static String TC63 = "63";
	    public static String TC64 = "64";
	    public static String TC65 = "65";
	    public static String TC66 = "66";
	    public static String TC67 = "67";
	    public static String TC68 = "68";
	    public static String TC70 = "70";
	    public static String TC71 = "71";
	    public static String TC72 = "72";
	    public static String TC73 = "73";
	    public static String TC74 = "74";
	    public static String TC75 = "75";
	    public static String TC76 = "76";
	    public static String TC77 = "77";
	    public static String TC78 = "78";
	    public static String TC82 = "82";
	}
	
	public static class TCRSpecifique
	{
		public static String TCR0 = "0";
		public static String TCR1 = "1";
	    public static String TCR2 = "2";
	    public static String TCR3 = "3";
	    public static String TCR4 = "4";
	    public static String TCR5 = "5";
	}
	
	public static class AttributFichierSpecifique
	{
		public static String DebutFileName		 = "LIS_IN";
		public static String DebutRlisName		 = "rLIS_OUT";
		public static String DestinationBankCode = "101010";
	    public static String TC 				 = "001";
	    public static String FILE_RECORD_SQUENCE = "002";
	    public static String TCR 				 = "003";
	    public static String FILE_SQUENCE_NUMBER = "006";
	    public static String RECORD_NUMBER 		 = "707";
	    public static String NBRECORD 			 = "774";
	    public final static int TCSIZE        	 = 256;
	    public final static int FILENAMESIZE   	 = 19;
	}
	
	public static class PaddingType
	{
		public static String DEBUT		 = "D";
		public static String FIN		 = "F";
	}
	
	public static class LibelleFichierEchanger
	{
	    public  static String RLIS 		= "rLIS";
	    public  static String LIS 		= "LIS";
	    public  static String CHEKFILE 	= "CFILE";
	}
	
	public static class Versions
	{
	    public  static String BACKOF 		= "V10052012R1";
	    public  static String ONLINE 		= "V10052012R1";
	}
	
	
	public static class TypeFichierRetourLis
	{
	    public  static String GLOBAL 	= "";
	    public  static String CARTE		= "CARTE";
	    public  static String MINIRELEVE= "RELEVE";
	    public  static String IMPAYE  	= "IMPAYE";
	    public  static String SOLDE  	= "SOLDE";
	    public  static String OPPO  	= "OPPO";
	}
	
	public static class SuperUtilisateur
	{
		public final static String Code = "99999";
	}
	
	/** the settings of session **/
	public static final int SESSION_LONGTIMEOUT = 1000;
	public static final int SESSION_TIMEOUT 	= 1800000;
	public static final int SESSION_AUTOCLOSE 	= 1000;
	
	/** the queries name **/
	public static final String RegistreNotValid = "RegistreNotValid";
	public static final String RegistreValid 	= "RegistreValid";
	
	public static final String RegistreNotClosed = "RegistreNotClosed";
	public static final String RegistreClosed 	 = "RegistreClosed";
}