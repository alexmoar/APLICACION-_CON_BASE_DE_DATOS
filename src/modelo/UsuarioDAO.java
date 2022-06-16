package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.Coneccion;



public class UsuarioDAO {
	
	public Coneccion con;

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
			System.err.println("Ya est� creada la tabla");
		} finally {
	}
		
	}
	
	
	
	public void registrarUser(String nombre, String nick, String edad,  String correo,String clave)  {
		Connection conn = null;
		Statement statementOb = null;
		boolean agregado = false;
		int amigos = 0;
		System.out.println(nombre);
		try {
			
			conn = Coneccion.getConnection();
			statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO USERS(NOMBRE, NIKNAME, EDAD, EMAIL, AMIGOS, CHAT, PASSWORD ) ");
			sb.append("VALUES ('"+nombre+"', '"+nick+"', '"+edad+"', '"+correo+"','"+amigos	+"', '"+amigos+"','"+clave+"' )");
			
			
			statementOb.executeUpdate(sb.toString());

			agregado = true;

		} catch (SQLException e) {
			System.err.println("No se pudo agregar el estudiante debido al error: " + e.getMessage());
		} finally {
			// Close the connection
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	
	}


			
	public void registraAmigo(int id , String nick) {
		
		Connection conn = null;
		Statement statementOb = null;
		
		
		
		try {
			
			conn = Coneccion.getConnection();
			statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO AMIGOS(IDUSER, NIKNAME ) ");
			sb.append("VALUES ('"+id+"', '"+nick+"')");
			
			
			statementOb.executeUpdate(sb.toString());

			

		} catch (SQLException e) {
			System.err.println("No se pudo agregar el estudiante debido al error: " + e.getMessage());
		} finally {
			// Close the connection
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		
	}

			
			
			
		
	
	
	public boolean ingresarUser(String nickname,String clave) {
		
		boolean seguro = false;
		Connection conn = null;
		Statement statementOb = null;
		try {

			String sql;
			sql = "SELECT * FROM USUARIOS WHERE NICKNAME='" + nickname + "'";

			conn = Coneccion.getConnection();

			statementOb = conn.createStatement();

			ResultSet rs = statementOb.executeQuery(sql);
			rs.next();
			String contra = rs.getString("PASSWORD");

			if (contra.equals(clave)) {
				seguro = true;

				

			}

		} catch (SQLException e) {
			System.err.println("el usuario ingresado no esta en la base de datos : " + e.getMessage());
		} finally {
			// Close the connection
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return seguro;

	}
	
	public String odtenerUsuario(String nickname) {
		String usuario="";
		Connection conn = null;
		Statement statementOb = null;
		try {

			String sql;
			sql = "SELECT * FROM USUARIOS WHERE NICKNAME='" + nickname + "'";

			conn = Coneccion.getConnection();

			statementOb = conn.createStatement();

			ResultSet rs = statementOb.executeQuery(sql);
			rs.next();
			usuario = rs.getString("NICKNAME");


		} catch (SQLException e) {
			System.err.println("el usuario ingresado no esta en la base de datos : " + e.getMessage());
		} finally {
			// Close the connection
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return usuario;
		}
}
