package hr.java.vjezbe.entitet;

/**
 * Predstavlja vrtu korisnika koji je fizicka osoba time sto ima ime i prezime
 * 
 * @author DesBelli
 *
 */
public class PrivatniKorisnik extends Korisnik {
	private static final long serialVersionUID = -6799125219838566793L;
	protected String ime, prezime;
	
	@Override
	public String toString() {
		String str = "";
		str += this.ime + ", ";
		str += this.prezime + ", email:";
		str += this.email + ", tel:";
		str += this.telefon;

		return str;
	}

	// String teksta korisnika
	@Override
	public String dohvatiKontakt() {
		String podatci = new String();
		podatci += "Osobni podaci prodavatelja: " + ime + " " + prezime;
		podatci += ", mail: " + super.getEmail();
		podatci += ", tel: " + super.getTelefon();
		return podatci;
	}

	/**
	 * Inicijalizira email i telefon korisnika te dodatno ime i prezime fizicke
	 * osobe
	 * 
	 * @param _email   predstavlja email korisnika
	 * @param _telefon predstavlja telefon korisnika
	 * @param ime      predstavlja ime fizicke osobe
	 * @param prezime  predstavlja prezime fizicke osobe
	 */
	public PrivatniKorisnik(String _email, String _telefon, String ime, String prezime, long id) {
		super(_email, _telefon, id);
		this.ime = ime;
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

}
