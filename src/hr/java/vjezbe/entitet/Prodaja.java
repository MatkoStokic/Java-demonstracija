package hr.java.vjezbe.entitet;

import java.time.LocalDate;

/**
 * Predstavlja oglas za prodaju pojedinog artikla s kontaktom korisnika koji ga
 * prodaje te datumom objave
 * 
 * @author DesBelli
 *
 */
public class Prodaja extends Entitet {
	private static final long serialVersionUID = 8616908020106898695L;
	private Artikl artikl;
	private Korisnik korisnik;
	private LocalDate datumObjave;

	/**
	 * Inicijalizira podatke o artiklu na prodaji, korisniku koji ga prodaje te
	 * datumu objave
	 * 
	 * @param _artikl      podatak o artiklu na prodaji
	 * @param _korisnik    podatak o korisniku koji prodaje artikl
	 * @param _datumObjave podatak o datumu objave oglasa
	 */
	public Prodaja(Artikl _artikl, Korisnik _korisnik, LocalDate _datumObjave, long id) {
		super(id);
		setArtikl(_artikl);
		setKorisnik(_korisnik);
		setDatumObjave(_datumObjave);
	}

	public Artikl getArtikl() {
		return artikl;
	}

	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public LocalDate getDatumObjave() {
		return datumObjave;
	}

	public void setDatumObjave(LocalDate datumObjave) {
		this.datumObjave = datumObjave;
	}
}
