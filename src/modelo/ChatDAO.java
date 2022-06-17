package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.Conexion;

public class ChatDAO {
	private Connection conn;
	
	public ChatDAO() {
		conn = Conexion.getConnection();
	}
public void crearTablaChats() {
		
	StringBuffer sbCreateTableSQL = new StringBuffer();
	sbCreateTableSQL.append("create table chats (id int primary key auto_increment , ");
	sbCreateTableSQL.append(" idUsuario int)");
	String sql = "ALTER TABLE chats ADD FOREIGN KEY (id) REFERENCES mensajes(idchat)";

	try (Statement statement = conn.createStatement();) {

		statement.execute(sbCreateTableSQL.toString());
		statement.execute(sql);

	} catch (SQLException e) {

		System.err.println(e);
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

}
