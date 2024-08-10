package ejercicio01;

import java.util.ArrayList;
import java.util.Iterator;

public class Socio extends Persona {
	
	private int dni;
	private String telefono;
	private String correo;
	
	private int nroSocio;
	private ArrayList<Alquiler> alquileres;
	
	private boolean estado; //Activo o dado de baja
	
	//Constructor
	public Socio (String nombre, String apellido, int dni, String telefono, String correo) {
		super(nombre, apellido);
		
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
		
		this.nroSocio = 0; // Al crearlo en el main no le asigno nro hasta agregarlo como socio
		this.alquileres = new ArrayList<Alquiler>();
		
		this.estado = true; //Al ser creada la cuenta está activa
	}
	
	//Getters
	public int getDni () {
		return dni;
	}
	
	public String getTelefono () {
		return telefono;
	}
	
	public String getCorreo () {
		return correo;
	}
	
	public int getNroSocio () {
		return nroSocio;
	}
	
	public ArrayList<Alquiler> getAlquileres () {
		return alquileres;
	}
	
	public boolean getEstado () {
		return estado;
	}
	
	//Setters
	public void setDni (int dni) {
		this.dni = dni;
	}
	
	public void setTelefono (String telefono) {
		this.telefono = telefono;
	}
	
	public void setCorreo (String correo) {
		this.correo = correo;
	}
	
	public void setNroSocio (int nroSocio) {
		this.nroSocio = nroSocio;
	}
	
	//Metodos
	/*
	 * Agrega el alquiler pasado por parámetro a la lista
	 * de alquileres del socio
	 */
	public void agregarAlquiler (Alquiler alquiler) {
		alquileres.add(alquiler);
	}
	
	/*
	 * Devuelve un ArrayList con todos los alquileres devueltos
	 */
	public ArrayList<Alquiler> alquileresDevueltos () {
		ArrayList<Alquiler> devueltos = new ArrayList<Alquiler>();
		Alquiler currentAlquiler;
		
		Iterator<Alquiler> it = alquileres.iterator();
		while (it.hasNext()) {
			currentAlquiler = it.next();
			
			if (currentAlquiler.getEstado()) {
				devueltos.add(currentAlquiler);
			}
		}
		
		return devueltos;
	}
	
	/*
	 * Devuelve un ArrayList con todos los alquileres pendientes
	 * a ser devueltos
	 */
	public ArrayList<Alquiler> alquileresNoDevueltos () {
		ArrayList<Alquiler> pendientes = new ArrayList<Alquiler>();
		Alquiler currentAlquiler;
		
		Iterator<Alquiler> it = alquileres.iterator();
		while (it.hasNext()) {
			currentAlquiler = it.next();
			
			if (!currentAlquiler.getEstado()) {
				pendientes.add(currentAlquiler);
			}
		}
		
		return pendientes;
	}
	
	/*
	 * Se reactiva la cuenta
	 */
	public void activarCuenta () {
		this.estado = true;
	}
	
	/*
	 * Se desactiva la cuenta
	 */
	public void desactivarCuenta () {
		this.estado = false;
	}
	
	//Abstract methods
	public String toString () {
		String result = "";
		
		result += ("Nombre: " + this.getNombre());
		result += " ";
		result += (this.getApellido());
		result += "\n";
		result += ("Dni: " + this.getDni());
		result += "\n";
		result += ("Telefono: " + this.getTelefono());
		result += "\n";
		result += ("Correo electronico: " + this.getCorreo());
		result += "\n";
		result += ("Numero de socio: " + this.getNroSocio());
		
		return result;
	}
}