package modelo;

import java.util.ArrayList;

public class Chat {
	
	private static int cont;
	private int id;

	private ArrayList<UsuarioDTO> miembros;
	private String nombre;
	private ArrayList<Mensaje> mensajes;
	private ArrayList<MensajeInterface> x= new ArrayList<>();
	
	
	public Chat(int id, String nombre, UsuarioDTO user,UsuarioDTO user2) {
		
		miembros = new ArrayList<>();
		
		miembros.add(user);
		miembros.add(user2);
		this.nombre = nombre;
		this.mensajes = new ArrayList<>();
		x.add(user);
		x.add(user2);
		
		this.id=id;
	}
	public ArrayList<MensajeInterface> getX() {
		return x;
	}
	public void setX(ArrayList<MensajeInterface> x) {
		this.x = x;
	}
	public void setMiembros(ArrayList<UsuarioDTO> miembros) {
		this.miembros = miembros;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}
	public void setMensajes(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	
	public ArrayList<UsuarioDTO> getMiembros() {
		return miembros;
	}
	
	@Override
	public String toString() {
		String r="";
		for (int i = 0; i < this.miembros.size(); i++) {
			r+=this.miembros.get(i).getNick()+"\n";
			
		}
		return r;
	}
	public String mostrarMensajes() {
		String r="";
		for (int i = 0; i < this.mensajes.size(); i++) {
			r+=this.mensajes.get(i).toString()+"\n";
		}
		return r;
	}
	
	
	
	
	

}
