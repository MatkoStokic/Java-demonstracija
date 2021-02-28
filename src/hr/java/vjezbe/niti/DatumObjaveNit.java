package hr.java.vjezbe.niti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DatumObjaveNit implements Runnable {
	private static Logger log = LoggerFactory.getLogger(DatumObjaveNit.class);

	public DatumObjaveNit() {
	}

	@Override
	public void run() {
		try {
			Prodaja prodaja = BazaPodataka.dohvatiZadnjuProdaju();
			String obavjest = "Oglas: " + prodaja.getArtikl().toString() + "\n";
			obavjest += "Prodavatelj: " + prodaja.getKorisnik().toString() + "\n";
			obavjest += "DatumObjave: " + prodaja.getDatumObjave().toString();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("INFORMATION");
			alert.setHeaderText("");
			alert.setContentText(obavjest);
			alert.showAndWait();
		} catch (BazaPodatakaException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}

	}

}
