package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;
import java.math.RoundingMode;

/**
 * Predstavlja entitet nekretnine implementirajuci metodu izracunajPorez
 * 
 * @author DesBelli
 *
 */
public interface Nekretnina {

	/**
	 * Racuna porez temeljen na cijeni nekretnine
	 * 
	 * @param cijenaNekretnine prestavlja cijenu nekretnine na kojoj se temelji izracunati
	 *                         porez
	 * @return porez izracunat pomocu cijene nekretnine i postotka poreza
	 * @throws CijenaJePreniskaException
	 */
	default BigDecimal izracunajPorez(BigDecimal cijenaNekretnine) throws CijenaJePreniskaException {
		BigDecimal porez;
		final BigDecimal postotak = new BigDecimal(0.03);

		if (cijenaNekretnine.compareTo(new BigDecimal(10000)) == -1) {
			throw new CijenaJePreniskaException("Cijena ne smije biti manja od 10000kn");
		}

		porez = cijenaNekretnine.multiply(postotak);

		return porez.setScale(2, RoundingMode.CEILING);
	}
}
