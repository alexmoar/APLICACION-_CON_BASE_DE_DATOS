package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class FAV {
	
	
	private ArrayList<UsuarioDTO> usuarios;
	private static FAV instance;
	private UsuarioDTO usuarioPrincipal;
	private UsuarioDTO usuarioSession;
	
	
	private FAV() {
		usuarios=new ArrayList<UsuarioDTO>();
		
	}
	
	
	public static FAV getInstance() {
		if(instance==null)
			instance = new FAV();
		
		return instance;
	}
	
	
	public  void setUsuarioPrincipal(UsuarioDTO us) 
	{
		usuarioPrincipal = us;
	}
	public  UsuarioDTO getUsuarioPrincipal() {
		return this.usuarioPrincipal;
	}
	
	

	public  UsuarioDTO getUsuarioSession() {
		return this.usuarioSession;
	}
	
	
	
	
	public boolean crearUsuario(String nombre, String edad, String nick, String correo, String clave  ) 
	{
		UsuarioDAO user = new UsuarioDAO();
		user.creaTabla();
		user.crearTablaAmigos();
		user.registrarUser(nombre, nick, edad, correo, clave);
		
			UsuarioDTO us = new UsuarioDTO(nombre, nick, edad, clave, correo);
			this.usuarios.add(us);
			for (int i = 0; i < usuarios.size(); i++) {
				System.out.println(usuarios.get(i).getClave()+ "---"+ usuarios.get(i).getNick());
				
			}
			return true;
		
	}

    public UsuarioDAO getUserSession() {
    	UsuarioDAO user = new UsuarioDAO();
    	
    	// user.odtenerUsuario(nick);
    	return user;
    }
	public boolean validarInfo(String nick, String password) {
	//	UsuarioDTO us;
		UsuarioDAO user = new UsuarioDAO();
		user.ingresarUser(nick, password);
		this.usuarioSession = new UsuarioDTO(nick);
		
	/*	for (int i =0; i<this.usuarios.size();i++) {
			us =this.usuarios.get(i);
			if (us.getNick().equals(nick) &&us.getClave().equals(password)) {
				this.setUsuarioPrincipal(us);
				return true;
				}
			else {
				System.out.println("**************************************");
			}
			}
		*/
		return true;
		
	}
	
	
	
	public void agregarUsuario(UsuarioDTO us) {
		UsuarioDAO user = new UsuarioDAO();
		user.creaTabla();
		user.crearTablaAmigos();
		this.usuarios.add(us);
	}


	public ArrayList<UsuarioDTO> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(ArrayList<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	


	
	
	

}
