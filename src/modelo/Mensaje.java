package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import utilidades.Utilidad;

public class Mensaje {

	
	private String message;
	private String send;
	private String date;

	public Mensaje() {
	}

	public Mensaje(String message, String send) {

		
		this.message = message;
		this.send = send;
		this.date = this.getDate();
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	
	public String toString() {
		return send+": "+message;
	}

	public String getDate() {
		

		return Utilidad.obtenerFecha();
	}

	public void setDate(String date) {
		this.date = date;
	}

}
