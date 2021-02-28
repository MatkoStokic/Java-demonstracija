package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Predstavlja entitet vozila definiranog metodama IzracunajKw te
 * IzracunajCjenuOsiguranja
 * 
 * @author DesBelli
 *
 */
public interface Vozilo {

	/**
	 * Preracunava konjse snage u kilovate
	 * 
	 * @param konjskaSnaga jedinica snage koja se preracunava u kilovate
	 * @return snaga motora u kilovatima
	 */
	default BigDecimal izracunajKw(BigDecimal konjskaSnaga) {
		final BigDecimal koeficient = new BigDecimal(1.341);

		return (konjskaSnaga.multiply(koeficient));
	}

	/**
	 * Izracunava grupu osiguranja vozila
	 * 
	 * @return broj grupe osiguranja
	 * @throws NemoguceOdreditiGrupuOsiguranjaException
	 */
	abstract BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException;

	/**
	 * Racuna cijenu osiguranja vozila na bazi izracunate grupe osiguranja
	 * 
	 * @return cijena osiguranja vozila u kunama
	 * @throws NemoguceOdreditiGrupuOsiguranjaException
	 */
	default BigDecimal izracunajCijenuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
		BigDecimal grupa = izracunajGrupuOsiguranja();
		BigDecimal rezultat;

		// Java 13 switch-case
		switch (grupa.toString()) {
		case "1":
			rezultat = new BigDecimal(500);
			break;
		case "2":
			rezultat = new BigDecimal(1000);
			break;
		case "3":
			rezultat = new BigDecimal(1500);
			break;
		case "4":
			rezultat = new BigDecimal(2000);
			break;
		default:
			rezultat = new BigDecimal(3000);
		}
		;

		return rezultat;
	}
}
