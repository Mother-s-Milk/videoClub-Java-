package ejercicio01;

public class Director extends Persona {
	
	//Constructor
	public Director (String nombre, String apellido) {
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