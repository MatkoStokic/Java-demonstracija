package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja vrstu artikla koji nije fizicki predmet, vec usluga
 * 
 * @author DesBelli
 *
 */
public class Usluga extends Artikl {
	private static final long serialVersionUID = -1352911679795587058L;

	@Override
	public String toString() {
		String str = "";
		str += this.naslov + ", ";
		str += this.opis + ", cijena:";
		str += this.cijena.toString() + "kn, stanje:";
		str += this.stanje.toString();

		return str;
	}
	
	/**
	 * Inicjalizira naslov, opis i cijenu artikla
	 * 
	 * @param _naslov predstavlja naslov artikla
	 * @param _opis   predstavlja opis artikla
	 * @param _cijena prestavlja cijenu artikla
	 * @param stanje  predstavlja stanje artikla
	 */
	public Usluga(String naslov, String opis, BigDecimal cijena, Stanje stanje, long id) {
		super(naslov, opis, cijena, stanje, id);
	}

	// Strign teksta usluge
	@Override
	public String tekstOglasa() {
		String tekst = new String();
		tekst += "Naslov usluge: " + super.getNaslov();
		tekst += "\nOpis usluge: " + super.getOpis();
		tekst += ("\nStanje usluge: " + super.stanje);
		tekst += "\nCijena usluge: " + super.getCijena();

		return tekst;
	}

}
