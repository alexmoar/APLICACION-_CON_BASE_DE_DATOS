package vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelo.FAV;
import modelo.UsuarioDTO;
import javafx.scene.Scene;


public class Principal extends Application {
	
	
	public static void main(String[] args) {
		
		
        Application.launch(Principal.class, args);
    }
	
	@Override
	public void start(Stage stage) throws Exception  {
		
		UsuarioDTO user1 = new UsuarioDTO("David","David21","20","123","david@ufps");
		
		UsuarioDTO user2 = new UsuarioDTO("Alex","Alex21","21","124","david@ufps");
		UsuarioDTO user3 = new UsuarioDTO("Fabian","Fabian21","20","125","david@ufps");
		UsuarioDTO user4 = new UsuarioDTO("Vladimir","Vlacho","20","126","david@ufps");
		UsuarioDTO user5 = new UsuarioDTO("qwe","qwe","qwe","qwe","qwe@ufps");
		user1.agregarAmigos(user4);
		user1.agregarAmigos(user3);
		user1.agregarAmigos(user2);
		user1.agregarAmigos(user5);
		
		FAV fav =FAV.getInstance();
		
		fav.creartablas();
		fav.agregarUsuario(user1);
		fav.agregarUsuario(user2);
		fav.agregarUsuario(user3);
		fav.agregarUsuario(user4);
		fav.agregarUsuario(user5);
		
		
 		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
    	
        stage.setTitle("Bienvenido");
        stage.setScene(new Scene(loader.load()));
        stage.show();
		
		
	}
	
}
