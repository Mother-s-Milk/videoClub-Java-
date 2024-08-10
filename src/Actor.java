package ejercicio01;

public class Actor extends Persona {
	
	//Constructor
	public Actor (String nombre, String apellido) {
		super(nombre, apellido);
	}
	
	//Abstract methods
	public String toString () {
		String result = "";
		
		result += this.getNombre();
		result += " ";
		result += this.getApellido();
		
		return result;
	}
}