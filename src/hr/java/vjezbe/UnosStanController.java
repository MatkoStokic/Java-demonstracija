package hr.java.vjezbe;

import java.io.IOException;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class UnosStanController {
	private Logger log =  LoggerFactory.getLogger(UnosStanController.class);

	@FXML
	private TextField naslovFld;

	@FXML
	private TextField opisFld;

	@FXML
	private TextField kvadraturaFld;

	@FXML
	private TextField cijenaFld;

	@FXML
	private ComboBox<Stanje> stanjeCBox;

	@FXML
	private void initialize() {
		ObservableList<Stanje> Stanja = FXCollections.observableArrayList(Stanje.novo, Stanje.izvrsno, Stanje.rabljeno, Stanje.neispravno);
		stanjeCBox.setItems(Stanja);
	}

	public void unesi() {
		String notice = "";
		if (naslovFld.getText().isBlank())
			notice += "Naslov je obavezan podatak\n";
		if (opisFld.getText().isBlank())
			notice += "Opis je obavezan podatak\n";
		if (kvadraturaFld.getText().isBlank())
			notice += "Kvadratura je obavezan podatak\n";
		if (cijenaFld.getText().isBlank())
			notice += "Cijena je obavezan podatak\n";

		if (!notice.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("");
			alert.setContentText(notice);
			alert.showAndWait();
			return;
		}
		
		String tmpNaslov = naslovFld.getText();
		String tmpOpis = opisFld.getText();
		Integer tmpKvadratura = Integer.parseInt(kvadraturaFld.getText());
		Stanje tmpStanje;
		if (stanjeCBox.getSelectionModel().isEmpty())
			tmpStanje = Stanje.novo;
		else
			tmpStanje = stanjeCBox.getValue();
		
		BigDecimal tmpCijena = new BigDecimal(cijenaFld.getText());
		
		Stan stan = new Stan(tmpNaslov, tmpOpis, tmpCijena, tmpStanje, tmpKvadratura, -1);
		try{	
			BazaPodataka.pohraniNoviStan(stan);;
		}catch(BazaPodatakaException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("");
		alert.setContentText("Uspjesno unesen stan\n");
		alert.showAndWait();
	}

	// MENU
	public void prikaziPretragaAutomobila() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("automobili_pretraga.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziPretragaStanova() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("stanovi_pretraga.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziPretragaUsluga() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("usluge_pretraga.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziPretragaPrivatnih() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("privatni_pretraga.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziPretragaPoslovnih() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("poslovni_pretraga.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziPretragaProdaja() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("prodaje_pretraga.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziUnosAutomobila() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("automobili_unos.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziUnosUsluga() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("usluge_unos.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziUnosStanova() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("stanovi_unos.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziUnosPrivatnih() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("privatni_unos.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziUnosPoslovnih() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("poslovni_unos.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
	
	public void prikaziUnosProdaja() {
		try {
			BorderPane center = (BorderPane) FXMLLoader.load(getClass().
			getResource("prodaje_unos.fxml"));
			Main.setCenterPane(center);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}
	}
}
