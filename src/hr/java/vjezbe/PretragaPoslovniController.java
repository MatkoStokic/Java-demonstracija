package hr.java.vjezbe;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PretragaPoslovniController {
	@FXML
	private TextField poslovniNazivFld;

	@FXML
	private TextField poslovniMailFld;

	@FXML
	private TextField poslovniTelFld;

	@FXML
	private TextField poslovniWebFld;

	@FXML
	private TableView<PoslovniKorisnik> poslovniTable;

	@FXML
	private TableColumn<PoslovniKorisnik, String> poslovniNazivCol;

	@FXML
	private TableColumn<PoslovniKorisnik, String> poslovniMailCol;

	@FXML
	private TableColumn<PoslovniKorisnik, String> poslovniTelCol;

	@FXML
	private TableColumn<PoslovniKorisnik, String> poslovniWebCol;

	public void initialize() {
		poslovniNazivCol.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("naziv"));
		poslovniMailCol.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("email"));
		poslovniTelCol.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("telefon"));
		poslovniWebCol.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("web"));

		prikaziTablicu();
	}

	public void prikaziTablicu() {
		String tmpNaziv = null;
		String tmpWeb = null;
		String tmpEmail = null;
		String tmpTel = null;
		
		if (poslovniNazivFld.getText().isBlank() == false)
			tmpNaziv = poslovniNazivFld.getText();
		if (poslovniMailFld.getText().isBlank() == false)
			tmpEmail = poslovniMailFld.getText();
		if (poslovniTelFld.getText().isBlank() == false)
			tmpTel = poslovniTelFld.getText();
		if (poslovniWebFld.getText().isBlank() == false)
			tmpWeb = poslovniWebFld.getText();
		
		PoslovniKorisnik korisnik = new PoslovniKorisnik(tmpEmail, tmpTel, tmpNaziv, tmpWeb, -1);
		
		try {
			List<PoslovniKorisnik> korisnici = BazaPodataka.dohvatiPoslovnePremaKriterijima(korisnik);
			poslovniTable.getItems().clear();
			poslovniTable.getItems().addAll(korisnici);
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
