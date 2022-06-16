package utilidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Utilidad  {
	public static Stage obtenerStage(ActionEvent event) {
		Node node = (Node) event.getSource();
		
		Stage stage = (Stage) node.getScene().getWindow();
		
		
		return stage;
	}
	
	public  Stage buscarStage(String direccion, Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(direccion));
			Pane root = loader.load();			
			
			Scene scene = new Scene(root);
		    stage.setScene(scene);
		    
		    stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return stage;
	}
	public static String obtenerFecha() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");
		return dtf.format(LocalDateTime.now());
	}

	
}
