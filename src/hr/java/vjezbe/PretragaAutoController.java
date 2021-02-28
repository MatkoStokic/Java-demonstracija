package hr.java.vjezbe;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PretragaAutoController {
	@FXML
	private TextField automobiliNaslovFld;

	@FXML
	private TextField automobiliOpisFld;

	@FXML
	private TextField automobiliSnagaFld;

	@FXML
	private TextField automobiliCijenaFld;

	@FXML
	private TableView<Automobil> automobiliTable;

	@FXML
	private TableColumn<Automobil, String> automobiliNaslovCol;

	@FXML
	private TableColumn<Automobil, String> automobiliOpisCol;

	@FXML
	private TableColumn<Automobil, BigDecimal> automobiliSnagaCol;

	@FXML
	private TableColumn<Automobil, BigDecimal> automobiliCijenaCol;

	@FXML
	private TableColumn<Automobil, Stanje> automobiliStanjeCol;

	public void initialize() {
		automobiliNaslovCol.setCellValueFactory(new PropertyValueFactory<Automobil, String>("naslov"));
		automobiliOpisCol.setCellValueFactory(new PropertyValueFactory<Automobil, String>("opis"));
		automobiliSnagaCol.setCellValueFactory(new PropertyValueFactory<Automobil, BigDecimal>("snagaKs"));
		automobiliCijenaCol.setCellValueFactory(new PropertyValueFactory<Automobil, BigDecimal>("cijena"));
		automobiliStanjeCol.setCellValueFactory(new PropertyValueFactory<Automobil, Stanje>("stanje"));

		prikaziTablicu();
	}

	public void prikaziTablicu() {
		String tmpNaslov = null;
		String tmpOpis = null;
		BigDecimal tmpSnaga = null;
		BigDecimal tmpCijena = null;
		
		if (automobiliNaslovFld.getText().isBlank() == false)
			tmpNaslov = automobiliNaslovFld.getText();
		if (automobiliOpisFld.getText().isBlank() == false)
			tmpOpis = automobiliOpisFld.getText();
		if (automobiliSnagaFld.getText().isBlank() == false)
			tmpSnaga = new BigDecimal(automobiliSnagaFld.getText());
		if (automobiliCijenaFld.getText().isBlank() == false)
			tmpCijena = new BigDecimal(automobiliCijenaFld.getText());
		
		Automobil auto = new Automobil(tmpNaslov, tmpOpis, tmpCijena, null, tmpSnaga, -1);
		
		try {
			List<Automobil> automobili = BazaPodataka.dohvatiAutePremaKriterijima(auto);
			automobiliTable.getItems().clear();
			automobiliTable.getItems().addAll(automobili);
		}catch(BazaPodatakaException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
	}

	// MENU
	private Logger log = LoggerFactory.getLogger(Main.class);

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
