package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.Coneccion;

public class ChatDAO {
	
public void crearTablaChats() {
		
		StringBuffer sbCreateTableSQL = new StringBuffer();
		sbCreateTableSQL.append("create table chats (id int primary key , ");
		sbCreateTableSQL.append("mensajes int, idUsuario int)");
	

		System.out.println(sbCreateTableSQL);
		try (Connection connection = Coneccion.getConnection();
				Statement statement = connection.createStatement();) {

			statement.execute(sbCreateTableSQL.toString());

		} catch (SQLException e) {
			System.err.println("Ya est� creada la tabla");
		} finally {
	}
		
	}

}
