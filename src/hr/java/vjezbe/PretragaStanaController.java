package hr.java.vjezbe;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PretragaStanaController {
	@FXML
	private TextField stanoviNaslovFld;

	@FXML
	private TextField stanoviOpisFld;

	@FXML
	private TextField stanoviKvdraturaFld;

	@FXML
	private TextField stanoviCijenaFld;

	@FXML
	private TableView<Stan> stanoviTable;

	@FXML
	private TableColumn<Stan, String> stanoviiNaslovCol;

	@FXML
	private TableColumn<Stan, String> stanoviOpisCol;

	@FXML
	private TableColumn<Stan, Integer> stanoviKvadraturaCol;

	@FXML
	private TableColumn<Stan, BigDecimal> stanoviCijenaCol;

	@FXML
	private TableColumn<Stan, Stanje> stanoviStanjeCol;

	public void initialize() {
		stanoviiNaslovCol.setCellValueFactory(new PropertyValueFactory<Stan, String>("naslov"));
		stanoviOpisCol.setCellValueFactory(new PropertyValueFactory<Stan, String>("opis"));
		stanoviKvadraturaCol.setCellValueFactory(new PropertyValueFactory<Stan, Integer>("kvadratura"));
		stanoviCijenaCol.setCellValueFactory(new PropertyValueFactory<Stan, BigDecimal>("cijena"));
		stanoviStanjeCol.setCellValueFactory(new PropertyValueFactory<Stan, Stanje>("stanje"));

		prikaziTablicu();
	}

	public void prikaziTablicu() {
		String tmpNaslov = null;
		String tmpOpis = null;
		Integer tmpKvadratura = -1;
		BigDecimal tmpCijena = null;
		
		if (stanoviNaslovFld.getText().isBlank() == false)
			tmpNaslov = stanoviNaslovFld.getText();
		if (stanoviOpisFld.getText().isBlank() == false)
			tmpOpis = stanoviOpisFld.getText();
		if (stanoviKvdraturaFld.getText().isBlank() == false)
			tmpKvadratura = Integer.parseInt(stanoviKvdraturaFld.getText());
		if (stanoviCijenaFld.getText().isBlank() == false)
			tmpCijena = new BigDecimal(stanoviCijenaFld.getText());
		
		Stan stan = new Stan(tmpNaslov, tmpOpis, tmpCijena, null, tmpKvadratura, -1);
		
		try {
			List<Stan> stanovi = BazaPodataka.dohvatiStanovePremaKriterijima(stan);
			stanoviTable.getItems().clear();
			stanoviTable.getItems().addAll(stanovi);
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
