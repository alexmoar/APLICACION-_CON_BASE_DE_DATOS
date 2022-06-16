package control;

import java.io.IOException;
import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.FAV;
import modelo.UsuarioDTO;
import utilidades.Utilidad;

public class BuscarAmigosController {
	private FAV fav;
	private Utilidad u = new Utilidad();
	
	
	public BuscarAmigosController() {
		fav = FAV.getInstance();
	}
	@FXML
	private TextField nombreUsuario;
	@FXML
	private TextArea txtArea;
	
	@FXML
	protected void atras(ActionEvent e) {
		Stage stage = Utilidad.obtenerStage(e);
		stage.close();
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Home.fxml"));
			Pane root = loader.load();			
			
			Scene scene = new Scene(root);
		    stage.setScene(scene);
		    
		    stage.show();		    		    

		} catch (IOException ev) {
			ev.printStackTrace();
		
	}

}
	@FXML
	protected void mostrarAmigos(ActionEvent e) {
		UsuarioDTO us = fav.getUsuarioPrincipal();
		
		txtArea.setText(us.mostrarAmigos());	
			
		}
	
	@FXML 
	protected void agregar(ActionEvent e) {
		for (int i = 0; i < fav.getUsuarios().size(); i++) {
			if(nombreUsuario.getText().equals(fav.getUsuarios().get(i).getNick())) {
				fav.getUsuarioPrincipal().agregarAmigos(fav.getUsuarios().get(i));
			}
		}
		
	}
	}
