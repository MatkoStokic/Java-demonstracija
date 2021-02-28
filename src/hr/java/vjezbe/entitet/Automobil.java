package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Predstavlja vrstu artikla koje implementira sucelje vozila
 * 
 * @author DesBelli
 *
 */
public class Automobil extends Artikl implements Vozilo {
	private static final long serialVersionUID = -3617238282887788759L;
	protected BigDecimal snagaKs;

	@Override
	public String toString() {
		String str = "";
		str += this.naslov + ", ";
		str += this.opis + ", snaga:";
		str += this.snagaKs.toString() + ", cijena:";
		str += this.cijena.toString() + "kn, stanje:";
		str += this.stanje.toString();

		return str;
	}

	/**
	 * Izracunava grupu osiguranja automobila na temelju njegove snage
	 */
	@Override
	public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
		BigDecimal grupa;
		BigDecimal snagaKw = izracunajKw(snagaKs);

		// Dodjeljivnje grupa
		if (snagaKw.compareTo(new BigDecimal(130)) == -1)
			grupa = new BigDecimal(1);
		else if (snagaKw.compareTo(new BigDecimal(150)) == -1)
			grupa = new BigDecimal(2);
		else if (snagaKw.compareTo(new BigDecimal(180)) == -1)
			grupa = new BigDecimal(3);
		else if (snagaKw.compareTo(new BigDecimal(200)) == -1)
			grupa = new BigDecimal(4);
		else if (snagaKw.compareTo(new BigDecimal(220)) == -1)
			grupa = new BigDecimal(5);
		else {
			throw new NemoguceOdreditiGrupuOsiguranjaException("Previše kw, ne mogu odrediti grupu osiguranja");
		}

		return grupa;
	}

	// String teksta oglasa automobila
	@Override
	public String tekstOglasa() {
		String tekst = new String();
		Logger log = LoggerFactory.getLogger(Automobil.class);

		tekst += "Naslov automobila: " + super.getNaslov();
		tekst += "\nOpis automobila: " + super.getOpis();
		tekst += "\nSnaga automobila: " + getSnagaKs();
		tekst += ("\nStanje automobila: " + super.stanje);
		try {
			tekst += "\nIzracun osiguranja automobila: ";
			tekst += izracunajCijenuOsiguranja();
		} catch (NemoguceOdreditiGrupuOsiguranjaException e) {
			tekst += e.getMessage();
			log.error("Pogreska prilikom odredivanja cijene osiguranja!", e);
		}
		tekst += "\nCijena automobila: " + super.getCijena();

		return tekst;
	}

	/**
	 * Inicijalizira naslov, opis i cijenu Artikla te dodatno snagu u konjskim
	 * snagama
	 * 
	 * @param naslov  predstavlja naslov artikla
	 * @param opis    predstavlja opis artikla
	 * @param cijena  predstavlja cijenu artikla
	 * @param stanje  predstavlja stanje artikla
	 * @param snagaKs predstavlja snagu automobila u konjskim snagama
	 */
	public Automobil(String naslov, String opis, BigDecimal cijena, Stanje stanje, BigDecimal snagaKs, long id) {
		super(naslov, opis, cijena, stanje, id);
		this.snagaKs = snagaKs;
	}

	public BigDecimal getSnagaKs() {
		return snagaKs;
	}

	public void setSnagaKs(BigDecimal snagaKs) {
		this.snagaKs = snagaKs;
	}

}
