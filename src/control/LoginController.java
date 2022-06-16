package control;


import javax.swing.JOptionPane;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.FAV;
import utilidades.Utilidad;

public class LoginController  {
	private Utilidad u = new Utilidad();
	private FAV fav;
	
	
	@FXML
	private TextField txtName;
	
	@FXML
	private PasswordField txtClave;
	
	@FXML
	private Button iniciar;
	
	@FXML
	private Label error;
	
	public LoginController() {
		fav = FAV.getInstance();
	}
	
	@FXML
	protected void iniciarAction(ActionEvent event) {
		
		if (fav.validarInfo(this.txtName.getText().toString(), this.txtClave.getText().toString())) {
		System.out.println("ENTRE");
			
		
			try {
				Stage stage = Utilidad.obtenerStage(event);
				stage.close();
				
				u.buscarStage("/vista/Home.fxml", stage);
				
				
			} catch (Exception e) {
				System.out.println("------------------");
				// TODO: handle exception
			}
			
		}else if(txtName.getText().isEmpty()|| txtClave.getText().isEmpty()) {
			
			error.setText("Rellena todas las casillas");
		}
		else {
			error.setText("Usuario o contrase�a equivocada");
		}
		
		
		
		
	}
	@FXML
	protected void CrearCuentaAction(ActionEvent event) {
		try {
			Stage stage = Utilidad.obtenerStage(event);
			stage.close();
			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/SingUp.fxml"));
				Pane root = loader.load();			
				
				Scene scene = new Scene(root);
			    stage.setScene(scene);
			    
			    stage.show();
			} catch (Exception e) {
				
			}
		} catch (Exception e) {
			
		}
		
	}
	
	

	

}
