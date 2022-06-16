package modelo;

import java.util.ArrayList;
import java.util.Iterator;

import utilidades.Utilidad;

public class UsuarioDTO implements MensajeInterface {

	private String nombre;
	private static int cont;

	private String nick;
	private String edad;
	private String clave;
	private String correo;
	
	private ArrayList<UsuarioDTO> amigos=new ArrayList<UsuarioDTO>();
	private ArrayList<Chat> chats= new ArrayList<Chat>();

	public UsuarioDTO(String nombre, String nick, String edad, String correo, String clave) {
		this.nombre = nombre;
		this.nick = nick;
		this.edad = edad;
		this.clave = clave;
		this.correo = correo;
		
		
	}

	public UsuarioDTO(String nick) {
		this.nick = nick;
	}

	public UsuarioDTO() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public ArrayList<UsuarioDTO> getAmigos() {
		return amigos;
	}
	
	

	public ArrayList<Chat> getChats() {
		return chats;
	}

	public void setChats(ArrayList<Chat> chats) {
		this.chats = chats;
	}

	public void setAmigos(ArrayList<UsuarioDTO> amigos) {
		this.amigos = amigos;
	}
	

	public void agregarAmigos(UsuarioDTO us) {
		cont++;
		this.amigos.add(us);
		us.amigos.add(this);
		
		
		Chat chat1 = new Chat(cont,us.nick,us,this);
		System.out.println(chat1.getId()+" ----1");
		
		Chat chat2 = new Chat(cont,this.nick,this,us);
		us.chats.add(chat2);
		this.chats.add(chat1);
		System.out.println(chat1.getId()+" ----1");
		System.out.println(chat2.getId()+" ----2");
		System.out.println("-----------------------");
	}
	
	
	public String mostrarAmigos() {
		String r = "";
		for (int i = 0; i < this.amigos.size(); i++) {
			r+= amigos.get(i).getNick()+"\n";
		}
		return r;
		
	}
	public void enviarMensaje(int id , Mensaje msj) {
		System.out.println(id);
		for (int i = 0; i < this.chats.size(); i++) {
			if (id==this.chats.get(i).getId()) {
				for (MensajeInterface m: this.chats.get(i).getX()) {
					m.update(msj, id);
					
				}
			}
		}
	}

	@Override
	public void update(Mensaje m, int id) {
		for (int i = 0; i <this.chats.size() ; i++) {
			if (id==this.chats.get(i).getId()) {
				this.chats.get(i).getMensajes().add(m);
				
				break;
			}
		}
		
	}



	
	
	

}
