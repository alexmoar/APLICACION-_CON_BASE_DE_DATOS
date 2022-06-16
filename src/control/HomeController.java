package control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modelo.FAV;
import modelo.UsuarioDTO;
import utilidades.Utilidad;

public class HomeController implements Initializable {
	
	private Utilidad u = new Utilidad();
	private FAV fav;
	
	@FXML
	private Label labelnick;
//	@FXML
//	private ComboBox<UsuarioDTO> cBox;
	
	
	
	public  HomeController() {
	fav = FAV.getInstance();
	}
	
	@FXML
	protected void chatAction(ActionEvent e) {
		
		try {
			Stage stage = Utilidad.obtenerStage(e);
			stage.close();
			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ChatView.fxml"));
				Pane root = loader.load();			
				
				Scene scene = new Scene(root);
			    stage.setScene(scene);
			    
			    stage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
	}
	@FXML
	protected void amigos(ActionEvent e) {
		try {
			Stage stage = Utilidad.obtenerStage(e);
			stage.close();
			
			u.buscarStage("/vista/BuscarAmigos.fxml", stage);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			// TODO: handle exception
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelnick.setText(fav.getUsuarioPrincipal().getNick());
		
		UsuarioDTO us = fav.getUsuarioPrincipal();
		 ArrayList<UsuarioDTO> list = us.getAmigos();
		 
//		 cBox.getItems().addAll(list);
//		 cBox.setConverter(new StringConverter<UsuarioDTO>() {
//			
//			@Override
//			public String toString(UsuarioDTO user) {
//				// TODO Auto-generated method stub
//				return user.getNick();
//			}
//			
//			@Override
//			public UsuarioDTO fromString(String arg0) {
//				
//				return null;
//			}
//		});
		
		
	}
	@FXML
	protected void cerrarSesion(ActionEvent e) {
		Stage stage = Utilidad.obtenerStage(e);
		stage.close();
		
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));
			Pane root = loader.load();			
			
			Scene scene = new Scene(root);
		    stage.setScene(scene);
		    
		    stage.show();		    		    

		} catch (IOException ev) {
			ev.printStackTrace();
		
	}
	}
	
}
	
	

