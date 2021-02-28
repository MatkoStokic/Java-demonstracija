package hr.java.vjezbe;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class UnosPoslovniController {
	private Logger log =  LoggerFactory.getLogger(UnosPoslovniController.class);

	@FXML
	private TextField nazivFld;

	@FXML
	private TextField webFld;

	@FXML
	private TextField mailFld;

	@FXML
	private TextField telFld;

	public void unesi() {
		String notice = "";
		if (nazivFld.getText().isBlank())
			notice += "Naziv je obavezan podatak\n";
		if (webFld.getText().isBlank())
			notice += "Web je obavezan podatak\n";
		if (mailFld.getText().isBlank())
			notice += "E-mail je obavezan podatak\n";
		if (telFld.getText().isBlank())
			notice += "Telefon je obavezan podatak\n";

		if (!notice.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("");
			alert.setContentText(notice);
			alert.showAndWait();
			return;
		}
		
		String tmpNaziv = nazivFld.getText();
		String tmpWeb = webFld.getText();
		String tmpMail = mailFld.getText();
		String tmpTel = telFld.getText();
		
		PoslovniKorisnik korisnik = new PoslovniKorisnik(tmpMail, tmpTel, tmpNaziv, tmpWeb, -1);
		try{	
			BazaPodataka.pohraniNovogPoslovnog(korisnik);
		}catch(BazaPodatakaException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("");
		alert.setContentText("Uspjesno unesen poslovni korisnik\n");
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