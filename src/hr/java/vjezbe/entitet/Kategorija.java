package hr.java.vjezbe.entitet;

import java.util.ArrayList;
import java.util.List;

/**
 * Predstavlja kategoriju artikala za prodaju
 * 
 * @author DesBelli
 *
 * @param T genericna klasa koja nasljeduje klsu Artikl. Koristi se za
 *          incijalizaciju liste artikla.
 */
public class Kategorija<T extends Artikl> extends Entitet{
	private static final long serialVersionUID = 1076311606323152393L;
	private String naziv;
	private List<T> artikli;

	/**
	 * Inicijalizira podatke o nazivu pojedine kategorije te o skupini artikala koji
	 * joj pripadaju
	 * 
	 * @param _naziv     podatak o nazivu kategorije
	 * @param tmpArtikli skupina artikala koji pripadaju pojedinoj kategoriji
	 */
	public Kategorija(String _naziv, long id) {
		super(id);
		this.naziv = _naziv;
		this.artikli =  new ArrayList<>();;
	}

	/**
	 * Dodaje element u listu arikla
	 * 
	 * @param element objekt koji se dodaje u listu artikla
	 */
	public void dodajArtikl(T element) {
		getArtikli().add(element);
	}

	/**
	 * Dohvaca objek iz liste artikala na unesenom indeksu
	 * 
	 * @param index indeks po kojem se vraca objekt iz liste
	 * @return objekt iz liste artikla na mjestu indeksa
	 */
	public T dohvatiArtikl(int index) {
		return getArtikli().get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kategorija other =  (Kategorija) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<T> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<T> tmpArtikli) {
		this.artikli = tmpArtikli;
	}

}
