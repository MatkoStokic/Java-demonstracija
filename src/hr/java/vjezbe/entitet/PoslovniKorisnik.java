package hr.java.vjezbe.entitet;

/**
 * Predstavlja vrstu korisnika koji nije fizicka osoba, vec tvrtka, time sto ima
 * naziv i web stranicu
 * 
 * @author DesBelli
 *
 */
public class PoslovniKorisnik extends Korisnik {
	private static final long serialVersionUID = -4437749850531811428L;
	protected String naziv, web;
	
	@Override
	public String toString() {
		String str = "";
		str += this.naziv + ", email:";
		str += this.email + ", web:";
		str += this.web + ", tel:";
		str += this.telefon;

		return str;
	}

	// String tekst korisnika
	@Override
	public String dohvatiKontakt() {
		String podatci = new String();
		podatci += "Naziv tvrtke: " + naziv;
		podatci += ", mail: " + super.getEmail();
		podatci += ", tel: " + super.getTelefon();
		podatci += ", web: " + getWeb();

		return podatci;
	}

	/**
	 * Innicijalizira email i telefon korisnika te dodatno naziv i web stranicu
	 * tvrtke
	 * 
	 * @param _email   predstavlja email korisnika
	 * @param _telefon predstavlja telefon korisnika
	 * @param naziv    predstavlja naziv tvrtke
	 * @param web      predstavlja adresu web stranice tvrtke
	 */
	public PoslovniKorisnik(String _email, String _telefon, String naziv, String web, long id) {
		super(_email, _telefon, id);
		this.naziv = naziv;
		this.web = web;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

}
