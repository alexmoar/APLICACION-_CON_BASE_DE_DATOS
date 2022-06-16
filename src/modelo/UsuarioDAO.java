package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.Coneccion;



public class UsuarioDAO {

	public void creaTabla() {
		
		StringBuffer sbCreateTableSQL = new StringBuffer();
		sbCreateTableSQL.append("create table users (id int primary key auto_increment, ");
		sbCreateTableSQL.append("nombre varchar(20), nikname varchar(20),edad varchar(50), email varchar(20),"
				+ "amigos int,chat int, ");
		sbCreateTableSQL.append("password varchar(20))");

		System.out.println(sbCreateTableSQL);
		try (Connection connection = Coneccion.getConnection();
				Statement statement = connection.createStatement();) {

			statement.execute(sbCreateTableSQL.toString());

		} catch (SQLException e) {
			
			System.err.println(e);
		} finally {
	}
	}
	
	public void crearTablaAmigos() {
		StringBuffer sbCreateTableSQL = new StringBuffer();
		sbCreateTableSQL.append("create table amigos (id int primary key, ");
		sbCreateTableSQL.append("idUser int, nikname varchar(20))");
	

		System.out.println(sbCreateTableSQL);
		try (Connection connection = Coneccion.getConnection();
				Statement statement = connection.createStatement();) {

			statement.execute(sbCreateTableSQL.toString());

		} catch (SQLException e) {
			System.err.println("Ya está creada la tabla");
		} finally {
	}
		
	}
	
	public void crearTablaChats() {
		
		StringBuffer sbCreateTableSQL = new StringBuffer();
		sbCreateTableSQL.append("create table chats (id int primary key , ");
		sbCreateTableSQL.append("mensajes int, idUsuario int)");
	

		System.out.println(sbCreateTableSQL);
		try (Connection connection = Coneccion.getConnection();
				Statement statement = connection.createStatement();) {

			statement.execute(sbCreateTableSQL.toString());

		} catch (SQLException e) {
			System.err.println("Ya está creada la tabla");
		} finally {
	}
		
	}
}
