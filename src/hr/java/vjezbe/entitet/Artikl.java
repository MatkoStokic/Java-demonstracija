package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 * Predstavlja artikl s naslovom, opisom i cijenom u svrhu prikaza prodaja
 * 
 * @author DesBelli
 *
 */
public abstract class Artikl extends Entitet {
	private static final long serialVersionUID = -5059540399990163025L;
	protected String naslov;
	protected String opis;
	protected BigDecimal cijena;
	protected Stanje stanje;

	/**
	 * Generira tekst svih informacija vezanih za artikl
	 * 
	 * @return tekst za ispis svih atributa koje artikl sadrzi
	 */
	public abstract String tekstOglasa();

	/**
	 * Inicijalizira podatke o naslovu, opisu i cijeni pojedinog artikla
	 * 
	 * @param naslov podatak naslova artikla
	 * @param opis   podatak opisa artikla
	 * @param cijena podatak cijene artikla
	 * @param stanje podatak stanja artikla
	 */
	public Artikl(String naslov, String opis, BigDecimal cijena, Stanje stanje, long id) {
		super(id);
		this.naslov = naslov;
		this.opis = opis;
		this.cijena = cijena;
		this.stanje = stanje;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cijena == null) ? 0 : cijena.hashCode());
		result = prime * result + ((naslov == null) ? 0 : naslov.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((stanje == null) ? 0 : stanje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikl other = (Artikl) obj;
		if (cijena == null) {
			if (other.cijena != null)
				return false;
		} else if (!cijena.equals(other.cijena))
			return false;
		if (naslov == null) {
			if (other.naslov != null)
				return false;
		} else if (!naslov.equals(other.naslov))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (stanje != other.stanje)
			return false;
		return true;
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public BigDecimal getCijena() {
		return cijena;
	}

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}

}
