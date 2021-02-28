package hr.java.vjezbe;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class PretragaProdajaController {
	@FXML
	private ComboBox<Artikl> artikli;

	@FXML
	private ComboBox<Korisnik> korisnici;

	@FXML
	private DatePicker datum;

	@FXML
	private TableView<Prodaja> table;

	@FXML
	private TableColumn<Prodaja, Artikl> artikliCol;
	
	@FXML
	private TableColumn<Prodaja, Korisnik> korisniciCol;

	@FXML
	private TableColumn<Prodaja, LocalDate> datumCol;
	
	public void initialize() {
		try {
			ObservableList<Artikl> l_artikli = BazaPodataka.dohvatiSveArtikle();
			artikli.setItems(l_artikli);
		} catch (BazaPodatakaException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}

		try {
			ObservableList<Korisnik> l_korisnika = BazaPodataka.dohvatiSveKorisnike();
			korisnici.setItems(l_korisnika);
		} catch (BazaPodatakaException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		
		artikliCol.setCellValueFactory(new PropertyValueFactory<Prodaja, Artikl>("artikl"));
		korisniciCol.setCellValueFactory(new PropertyValueFactory<Prodaja, Korisnik>("korisnik"));
		datumCol.setCellValueFactory(new PropertyValueFactory<Prodaja, LocalDate>("datumObjave"));

		prikaziTablicu();
	}

	public void prikaziTablicu() {
		Artikl tmpArtikl = null;
		Korisnik tmpKorisnik = null;
		LocalDate tmpDatum = null;
		
		if (artikli.getSelectionModel().isEmpty() == false)
			tmpArtikl = artikli.getValue();
		if (korisnici.getSelectionModel().isEmpty() == false)
			tmpKorisnik = korisnici.getValue();
		if (datum.getValue() != null)
			tmpDatum = datum.getValue();
		
		Prodaja prodaja = new Prodaja(tmpArtikl, tmpKorisnik, tmpDatum, -1);
		
		try {
			List<Prodaja> prodaje = BazaPodataka.dohvatiProdajuPremaKriterijima(prodaja);
			table.getItems().clear();
			table.getItems().addAll(prodaje);
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
