package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilidades.Conexion;

public class UsuarioDAO {

	private Connection conn;
	

	public UsuarioDAO() {
		conn = Conexion.getConnection();
		
	}

	public void agregarAmigo(String nickAmigo,String nickPrincipal) {
		
		Statement statementOb = null;
		Connection con = null;
		try {

			String sql;
			
			sql = "SELECT * FROM USERS WHERE NIKNAME='" + nickPrincipal + "'";
			con = Conexion.getConnection();
			
			statementOb = con.createStatement();
			
			
			ResultSet result = statementOb.executeQuery(sql);
			result.next();
			int id = result.getInt("ID");
			String sql2 = "INSERT INTO AMIGOS(IDUSER,NIKNAME ) "
					+ "VALUES ('"+id+"','"+nickAmigo+"')";
			
			statementOb.execute(sql2);
		
			this.actualizarTabla(id);
			
			
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaasdaSDasdaSDasdaSDASD");
			
			
		} catch (SQLException e) {
			System.err.println("el usuario ingresado no esta en la base de datos : " + e.getMessage());
		} finally {
			// Close the connection
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}}
	
	public void actualizarTabla(int id) {
		
		try {
			String sql ="SELECT * FROM AMIGOS WHERE IDUSER="+id+";";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			int idAmigo = rs.getInt("IDUSER");
			String sql3 ="UPDATE USERS SET AMIGOS="+idAmigo+")";
			
			st.execute(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void creaTabla() {

		StringBuffer sbCreateTableSQL = new StringBuffer();
		sbCreateTableSQL.append("create table users (id int primary key auto_increment, ");
		sbCreateTableSQL.append("nombre varchar(20), nikname varchar(20), edad varchar(50), email varchar(20)"
				+ ",password varchar(20))");
		
		String sql = "ALTER TABLE users ADD FOREIGN KEY (id) REFERENCES amigos(idUsers)";

		try  {
			Connection con = Conexion.getConnection();
			Statement statement = con.createStatement();

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

	public void crearTablaAmigos() {
		StringBuffer sbCreateTableSQL = new StringBuffer();
		sbCreateTableSQL.append("create table amigos (id int primary key auto_increment, ");
		sbCreateTableSQL.append("idUser int, nikname varchar(20))");

		try {
			Statement statement = conn.createStatement();
			statement.execute(sbCreateTableSQL.toString());

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

	public void registrarUser(String nombre, String nick, String edad, String correo, String clave) {
		Connection conn = null;
		Statement statementOb = null;
		boolean agregado = false;

		System.out.println(nombre);
		try {

			conn = Conexion.getConnection();
			statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO USERS(NOMBRE, NIKNAME, EDAD, EMAIL, PASSWORD ) ");
			sb.append("VALUES ('" + nombre + "', '" + nick + "', '" + edad + "', '" + correo + "','" + clave + "' )");

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

	public void registraAmigo(int id, String nick) {

		try {

			conn = Conexion.getConnection();
			Statement statementOb = conn.createStatement();

			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO AMIGOS(IDUSER, NIKNAME ) ");
			sb.append("VALUES ('" + id + "', '" + nick + "')");

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

	public boolean ingresarUser(String nickname, String clave) {

		boolean seguro = false;

		Statement statementOb = null;
		try {

			String sql;
			sql = "SELECT * FROM USERS WHERE NIKNAME='" + nickname + "'";

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

	public UsuarioDTO obtenerUsuario(String nickname) {
		
		UsuarioDTO us = new UsuarioDTO();
		
		Statement statementOb = null;
		Connection con = null;
		try {

			String sql;
			
			sql = "SELECT * FROM USERS WHERE NIKNAME='" + nickname + "'";
			con = Conexion.getConnection();
			
			statementOb = con.createStatement();
			
			
			ResultSet result = statementOb.executeQuery(sql);
			result.next();
//			
			
			
			us.setNombre(result.getString("NOMBRE"));
			us.setCorreo(result.getString("EMAIL"));
			us.setEdad(result.getString("EDAD"));
			us.setNick(result.getString("NIKNAME"));
			us.setClave(result.getString("PASSWORD"));
			System.out.println(us.getNick());
			
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
		return us;
	}
}

