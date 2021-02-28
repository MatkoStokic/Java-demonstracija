package hr.java.vjezbe.iznimke;

/**
 * Predstavlja iznimku za odredivanje grupa osiguranja kada je snaga automobila
 * prevelika da bi se odredila prikladna grupa
 * 
 * @author DesBelli
 *
 */
public class NemoguceOdreditiGrupuOsiguranjaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2291535264076831445L;

	public NemoguceOdreditiGrupuOsiguranjaException() {
		super();
	}

	public NemoguceOdreditiGrupuOsiguranjaException(String message, Throwable cause) {
		super(message, cause);
	}

	public NemoguceOdreditiGrupuOsiguranjaException(String message) {
		super(message);
	}

	public NemoguceOdreditiGrupuOsiguranjaException(Throwable cause) {
		super(cause);
	}

}
