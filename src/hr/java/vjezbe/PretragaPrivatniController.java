package hr.java.vjezbe;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.PrivatniKorisnik;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PretragaPrivatniController {
	@FXML
	private TextField privatniImevFld;

	@FXML
	private TextField privatniPrezimeFld;

	@FXML
	private TextField privatniMeilFld;

	@FXML
	private TextField privatniTelFld;

	@FXML
	private TableView<PrivatniKorisnik> privatniTable;

	@FXML
	private TableColumn<PrivatniKorisnik, String> privatniImevCol;

	@FXML
	private TableColumn<PrivatniKorisnik, String> privatniPrezimCol;

	@FXML
	private TableColumn<PrivatniKorisnik, String> privatniMeilCol;

	@FXML
	private TableColumn<PrivatniKorisnik, String> privatniTelCol;

	public void initialize() {
		privatniImevCol.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("ime"));
		privatniPrezimCol.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("prezime"));
		privatniMeilCol.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("email"));
		privatniTelCol.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("telefon"));

		prikaziTablicu();
	}

	public void prikaziTablicu() {
		String tmpIme = null;
		String tmpPrezime = null;
		String tmpEmail = null;
		String tmpTel = null;
		
		if (privatniImevFld.getText().isBlank() == false)
			tmpIme = privatniImevFld.getText();
		if (privatniMeilFld.getText().isBlank() == false)
			tmpEmail = privatniMeilFld.getText();
		if (privatniTelFld.getText().isBlank() == false)
			tmpTel = privatniTelFld.getText();
		if (privatniPrezimeFld.getText().isBlank() == false)
			tmpPrezime = privatniPrezimeFld.getText();
		
		PrivatniKorisnik korisnik = new PrivatniKorisnik(tmpEmail, tmpTel, tmpIme, tmpPrezime, -1);
		
		try {
			List<PrivatniKorisnik> korisnici = BazaPodataka.dohvatiPrivatnePremaKriterijima(korisnik);
			privatniTable.getItems().clear();
			privatniTable.getItems().addAll(korisnici);
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
