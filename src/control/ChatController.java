package control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import modelo.Chat;
import modelo.FAV;
import modelo.Mensaje;
import modelo.UsuarioDTO;
import utilidades.Utilidad;

public class ChatController implements Initializable {

	private FAV fav;
	@FXML
	private TextArea txtMiembros, txtMensajes;
	@FXML
	private ComboBox<Chat> cBox;
	@FXML
	private Label user;
	@FXML
	private TextField mensaje;
	@FXML
	private Button btnEnviar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		fav = FAV.getInstance();
		UsuarioDTO us = fav.getUsuarioPrincipal();
	//	ArrayList<Chat> list = us.getChats();

		//cBox.getItems().addAll(list);
		cBox.setConverter(new StringConverter<Chat>() {

			@Override
			public String toString(Chat chat) {
				// TODO Auto-generated method stub
				return chat.getNombre() + " :)";
			}

			@Override
			public Chat fromString(String arg0) {

				return null;
			}
		});

	}

	@FXML
	protected void cBoxEvent(ActionEvent evt) {

		user.setText(cBox.getSelectionModel().getSelectedItem().getNombre());
		txtMiembros.setText(cBox.getSelectionModel().getSelectedItem().toString());
		if (!cBox.getSelectionModel().getSelectedItem().getMensajes().isEmpty()) {
			txtMensajes.setText(cBox.getSelectionModel().getSelectedItem().mostrarMensajes());
		}else {
			txtMensajes.setText("");
		}

	}

	@FXML
	protected void enviarEvent(ActionEvent evt) {
		if(!mensaje.getText().isEmpty()||!cBox.getSelectionModel().isEmpty()) {
			
		Mensaje m = new Mensaje(mensaje.getText(),fav.getUsuarioPrincipal().getNick());
		Chat chat = cBox.getSelectionModel().getSelectedItem();
		
		chat.getMiembros().get(0).enviarMensaje(chat.getId(), m);
		txtMensajes.setText(chat.mostrarMensajes());
		
//		cBox.getSelectionModel().getSelectedItem().getMiembros().get(0).getChats().g
	}else {
		
	}
		mensaje.setText("");
		
		}
	
	@FXML
	protected void atrasEvent(ActionEvent evt) {
		
		Stage stage = Utilidad.obtenerStage(evt);
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

}
