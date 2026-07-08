package controller_view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// Daksh

public class JukeboxGUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	LoginCreateAccountPane loginPane;
	BorderPane everything;

	@Override
	public void start(Stage primaryStage) throws Exception {
		LayoutGUI();
		Scene scene = new Scene(everything, 500, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void LayoutGUI() {
		everything = new BorderPane();
		loginPane = new LoginCreateAccountPane();
		everything.setBottom(loginPane);

	}

}
