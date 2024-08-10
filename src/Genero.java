package ejercicio01;

public class Genero {

	private String nombre;
	
	//Constructor
	public Genero (String nombre) {
		this.nombre = nombre;
	}
	
	//Getters
	public String getNombre () {
		return nombre;
	}
	
	//Métodos
	public String toString () {
		String result = "";
		
		result += ("Genero: " + this.getNombre());
		
		return result;
	}
}