package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

/**
 * Predstavlja vrstu artikla koji implementira sucelje nekretnine, karakterizira
 * ga atribut kvadrature
 * 
 * @author DesBelli
 *
 */
public class Stan extends Artikl implements Nekretnina {
	private static final long serialVersionUID = -3082514357483875904L;
	private Integer kvadratura;
	
	@Override
	public String toString() {
		String str = "";
		str += this.naslov + ", ";
		str += this.opis + ", ";
		str += this.kvadratura.toString() + "m2, cijena:";
		str += this.cijena.toString() + "kn, stanje:";
		str += this.stanje.toString();

		return str;
	}

	@Override
	public String tekstOglasa() {
		String tekst = new String();
		Logger log = LoggerFactory.getLogger(Stan.class);

		tekst += "Naslov nekretnine: " + super.getNaslov();
		tekst += "\nOpis nekretnine: " + super.getOpis();
		tekst += "\nKvadratura nekretnine: " + getKvadratura();
		tekst += ("\nStanje nekretnine: " + super.stanje);
		try {
			tekst += "\nPorez na nekretnine: ";
			tekst += izracunajPorez(super.getCijena());
		} catch (CijenaJePreniskaException e) {
			tekst += e.getMessage();
			log.error("Pogreska prilikom odredivanja iznosa poreza!", e);
		}
		tekst += "\nCijena nekretnine: " + super.getCijena();

		return tekst;
	}

	/**
	 * Inicijalizira naslov, opis i cijenu artikla te dodatno kvadraturu stana
	 * 
	 * @param naslov     predstavlja naziv artikla
	 * @param opis       predstavlja opis artikla
	 * @param cijena     predstavlja cijenu artikla
	 * @param stanje     predstavlja stanje artikla
	 * @param kvadratura predstavlja kvadraturu stana u kvadratnim metrima
	 */
	public Stan(String naslov, String opis, BigDecimal cijena, Stanje stanje, Integer kvadratura, long id) {
		super(naslov, opis, cijena, stanje, id);
		this.kvadratura = kvadratura;
	}

	public int getKvadratura() {
		return kvadratura;
	}

	public void setKvadratura(int kvadratura) {
		this.kvadratura = kvadratura;
	}

}
