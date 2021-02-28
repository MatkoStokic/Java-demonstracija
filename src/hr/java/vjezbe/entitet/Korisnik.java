package hr.java.vjezbe.entitet;

/**
 * Predstavlja korisnika u sustavu prodaja, odnosno prodavaca sa kontakt
 * informacijama emaila i telefona
 * 
 * @author DesBelli
 *
 */
public abstract class Korisnik extends Entitet {
	private static final long serialVersionUID = 7989996267177953002L;
	protected String email, telefon;

	/**
	 * Generira tekst svih informacija vezanih za korisnika
	 * 
	 * @return
	 */
	public abstract String dohvatiKontakt();

	/**
	 * Inicijalizira poddatke emaila i telefona
	 * 
	 * @param _email   podatak o elektronickoj posti korisnika
	 * @param _telefon podatak o telefonu korisnika
	 */
	public Korisnik(String _email, String _telefon, long id) {
		super(id);
		setEmail(_email);
		setTelefon(_telefon);
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
