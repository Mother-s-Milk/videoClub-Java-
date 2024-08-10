package ejercicio01;

public class Ejemplar {

	private int nro;
	private boolean estado; //true libre o false alquilado
	
	//Constructor
	public Ejemplar (int nro) {
		this.nro = nro;
		this.estado = true; // Una vez creado está disponible
	}
	
	//Getters
	public int getNro () {
		return nro;
	}
	
	//Metodos
	public boolean estasLibre () {
		return estado;
	}
	
	public void setEstadoOcupado () {
		this.estado = false;
	}
	
	public void setEstadoDisponible () {
		this.estado = true;
	}
}

/*Puedo agregar la funcionalidad para retirar ejemplares rotos o perdidos
 * y hacer la reasignación de números*/