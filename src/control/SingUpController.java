package control;

import java.io.IOException;
import java.util.Iterator;

import javax.swing.JPasswordField;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.FAV;

import utilidades.Utilidad;

public class SingUpController {

	FAV fav;
	private Utilidad u = new Utilidad();

	@FXML
	private TextField txtNombre;

	@FXML
	private PasswordField txtClave;

	@FXML
	private TextField txtNick;

	@FXML
	private TextField txtEdad;

	@FXML
	private TextField txtCorreo;
	@FXML
	private Label error;

	public SingUpController() {
		fav = FAV.getInstance();
	}

	@FXML

	protected void crearCuentaAction(ActionEvent e) {
		if (txtNick.getText().isEmpty() || txtNombre.getText().isEmpty() || txtCorreo.getText().isEmpty()
				|| txtEdad.getText().isEmpty() || txtClave.getText().isEmpty()) {

			error.setText("Porfavor ingresa tu informacion");

		}

		else if (fav.crearUsuario(txtNombre.getText().toString(), txtEdad.getText().toString(),
				txtNick.getText().toString(), txtCorreo.getText().toString(), this.txtClave.getText().toString())) {
			Stage stage = Utilidad.obtenerStage(e);
			stage.close();
			u.buscarStage("/vista/Login.fxml", stage);

		}
	}

	@FXML
	protected void atrasAction(ActionEvent e) {

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
