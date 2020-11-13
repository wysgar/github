package code;

public class EvaluateurNiveau {
	
	public static final int MIN_COURS = 0;
	public static final int MIN_EXAM = 0;
	public static final int MAX_COURS = 25;
	public static final int MAX_EXAM = 75;
	
	public static final int LIMITE_DC = 30;
	public static final int LIMITE_CB = 50;
	public static final int LIMITE_BA = 75;
	
	
	private static boolean estEntier( String valeur ) {
		try {
			Integer.valueOf(valeur);
		}
		catch( NumberFormatException e ) {
			return false;
		}
		return true;
	}
	
	private static boolean estDansBorne( int valeur , int min , int max ) {
		return ( valeur >= min && valeur <= max );
	}

	public static String evaluerNiveau(String cours, String examen) throws ExceptionValeurNonEntiere, ExceptionValeurHorsBorne {
		// TODO Auto-generated method stub
		if ( ! estEntier( cours )) {
			throw new ExceptionValeurNonEntiere();
		}
		if ( ! estEntier( examen )) {
			throw new ExceptionValeurNonEntiere();
		}
		// Les valeurs sont entieres 
		int iCours = Integer.valueOf( cours );
		if ( ! estDansBorne(iCours, MIN_COURS , MAX_COURS )) {
			throw new ExceptionValeurHorsBorne();
		}
		int iExamen = Integer.valueOf( examen );
		if ( ! estDansBorne(iExamen, MIN_EXAM , MAX_EXAM )) {
			throw new ExceptionValeurHorsBorne();
		}
		
		int somme = iCours + iExamen;
		
		if ( somme < LIMITE_DC ) {
			return "D";
		} else if ( somme < LIMITE_CB ) {
			return "C";
		} else if ( somme < LIMITE_BA ) {
			return "B";
		}
		else return "A";
			
	}

}
