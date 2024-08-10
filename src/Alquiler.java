package ejercicio01;

public class Alquiler {
	
	private Socio socio;
	private Pelicula pelicula;
	private Ejemplar ejemplar;
	
	private boolean estado; // Devuelto o pendiente
	
	//Constructor
	public Alquiler (Socio socio, Pelicula pelicula, Ejemplar ejemplar) {
		this.socio = socio;
		this.pelicula = pelicula;
		this.ejemplar = ejemplar;
		
		this.estado = false; // Pendiente una vez creado
	}
	
	//Getters
	public Ejemplar getEjemplar () {
		return ejemplar;
	}
	
	public Socio getSocio () {
		return socio;
	}
	
	public Pelicula getPelicula () {
		return pelicula;
	}
	
	public boolean getEstado () {
		return estado;
	}
	
	//Setters
	public void setEstadoDevuelto () {
		this.estado = true;
	}
	
	//Metodos
	public String toString () {
		String result = "";
		
		result += ("Numero de ejemplar: " + ejemplar.getNro());
		result += "\n";
		result += ("Socio: " + socio.getNombre());
		result += " ";
		result += (socio.getApellido());
		result += "\n";
		result += ("Numero de socio: " + socio.getNroSocio());
		result += "\n";
		result += ("Pelicula: " + pelicula.getTitulo());
		result += "\n";
		result += ("Devuelto: " + this.getEstado());
		
		return result;
	}
}