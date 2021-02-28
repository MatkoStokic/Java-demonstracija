package hr.java.vjezbe.iznimke;

/**
 * Predstavlja oznacenu iznimku za racunanje poreza nekretnina kada je cijena
 * nekretnine preniska
 * 
 * @author DesBelli
 *
 */
public class CijenaJePreniskaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2555341954833609776L;

	public CijenaJePreniskaException() {
		super();
	}

	public CijenaJePreniskaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CijenaJePreniskaException(String message) {
		super(message);
	}

	public CijenaJePreniskaException(Throwable cause) {
		super(cause);
	}

}
