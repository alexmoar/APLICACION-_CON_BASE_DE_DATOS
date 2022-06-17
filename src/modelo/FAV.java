package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


import utilidades.Conexion;

public class FAV {

	private ArrayList<UsuarioDTO> usuarios;
	private static FAV instance;
	private UsuarioDTO usuarioPrincipal;
	private UsuarioDTO usuarioSession;

	private UsuarioDAO user = new UsuarioDAO();
	private ChatDAO chat = new ChatDAO();
	private Connection conn;

	private FAV() {
		usuarios = new ArrayList<UsuarioDTO>();
		conn = Conexion.getConnection();
	}

	

	public static FAV getInstance() {
		if (instance == null)
			instance = new FAV();

		return instance;
	}
	
	public void llenarUsuarios() {
		
		Statement statementOb = null;
		
		try {
			statementOb = conn.createStatement();
	        ResultSet rs = statementOb.executeQuery("SELECT * FROM USERS");
	        
	        while (rs.next()) {
	        	UsuarioDTO us= new UsuarioDTO();
	        	us.setNick(rs.getString("NIKNAME"));
	        	us.setNombre(rs.getString("NOMBRE"));
	        	us.setEdad(rs.getString("EDAD"));
	        	us.setCorreo(rs.getString("EMAIL"));
	        	
	        	this.usuarios.add(us);
	        	
	        }}catch(Exception e) {
				System.err.println("Se presentó un error ejecutando la consulta. "+e.getMessage());
			}finally {
				// Close the connection            
	            try {
	            	statementOb.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	}

	public void setUsuarioPrincipal(String nick) {
		this.usuarioPrincipal= user.obtenerUsuario(nick);
	}

	public UsuarioDTO getUsuarioPrincipal() {
		return this.usuarioPrincipal;
	}

	public UsuarioDTO getUsuarioSession() {
		return this.usuarioSession;
	}

	public boolean crearUsuario(String nombre, String edad, String nick, String correo, String clave) {

		user.registrarUser(nombre, nick, edad, correo, clave);

		UsuarioDTO us = new UsuarioDTO(nombre, nick, edad, clave, correo);
		this.usuarios.add(us);
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(usuarios.get(i).getClave() + "---" + usuarios.get(i).getNick());

		}
		return true;

	}

	public UsuarioDAO getUserSession() {

		return user;
	}

	public boolean validarInfo(String nick, String password) {
		boolean exito=false;
		UsuarioDTO us;
		UsuarioDAO user = new UsuarioDAO();
		
		this.usuarioSession = new UsuarioDTO(nick);
		exito= user.ingresarUser(nick, password);
		this.setUsuarioPrincipal(nick);

//		for (int i = 0; i < this.usuarios.size(); i++) {
//			us = this.usuarios.get(i);
//			if (us.getNick().equals(nick) && us.getClave().equals(password)) {
//				
//				return true;
//			} else {
//				
//			}
//		}

		return exito;

	}

	public void agregarUsuario(UsuarioDTO us) {

		
		this.usuarios.add(us);
	}

	public ArrayList<UsuarioDTO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void creartablas() {
		user.crearTablaAmigos();
		
		chat.crearTablaChats();
		user.creaTabla();
		user.creaTabla();
		user.creaTabla();
		user.creaTabla();
		user.creaTabla();
		user.creaTabla();
		
		user.creaTabla();
	}
	public UsuarioDAO getUser() {
		return user;
	}

	public void setUser(UsuarioDAO user) {
		this.user = user;
	}

}
