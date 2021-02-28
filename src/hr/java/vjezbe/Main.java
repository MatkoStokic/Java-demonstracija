package hr.java.vjezbe;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.niti.DatumObjaveNit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private static Stage curStage;
	private Logger log = LoggerFactory.getLogger(Main.class);

	@Override
	public void start(Stage primaryStage) {

		curStage = primaryStage;

		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("main.fxml"));
			Scene scene = new Scene(root, 600, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Doslo je do greske\n", e);
		}

		Timeline prikazZadnjeProdaje = new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.runLater(new DatumObjaveNit());
			}
		}));

		prikazZadnjeProdaje.setCycleCount(Timeline.INDEFINITE);
		prikazZadnjeProdaje.play();
	}

	public static void setCenterPane(BorderPane root) {
		Scene scene = new Scene(root, 600, 500);
		curStage.setScene(scene);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getMainStage() {
		return curStage;
	}

}
