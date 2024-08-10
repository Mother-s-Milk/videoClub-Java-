package ejercicio01;

public abstract class Persona {
	
	protected String nombre;
	protected String apellido;
	
	public Persona (String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	//Getters
	public String getNombre () {
		return nombre;
	}
	
	public String getApellido () {
		return apellido;
	}
	
	//Setters
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido (String apellido) {
		this.apellido = apellido;
	}
	
	//Abstract methods
	public abstract String toString ();
}