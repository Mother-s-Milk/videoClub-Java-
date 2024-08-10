package ejercicio01;

import java.util.ArrayList;
import java.util.Iterator;

public class Pelicula {

	private String titulo;
	private int duracion;
	private String genero;
	
	private int lanzamiento;
	private String pais;
	
	private Director director;
	private Actor protagonista;
	
	private ArrayList<Ejemplar> ejemplares;
	private int cantidadEjemplares;
	
	private boolean enCartelera; //Para saber si está disponible o no
	
	//Constructor
	public Pelicula (String titulo, int duracion, String genero, int lanzamiento, String pais, Director director, Actor protagonista) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		
		this.lanzamiento = lanzamiento;
		this.pais = pais;
		
		this.director = director;
		this.protagonista = protagonista;
		
		this.ejemplares = new ArrayList<Ejemplar>();
		this.cantidadEjemplares = 0;
		
		this.enCartelera = true; //Suponemos que al crearse se encuentra en cartelera
	}
	
	//Getters
	public String getTitulo () {
		return titulo;
	}
	
	public int getDuracion () {
		return duracion;
	}

	public String getGenero () {
		return genero;
	}
	
	public int getLanzamiento () {
		return lanzamiento;
	}
	
	public String getPais () {
		return pais;
	}
	
	public Director getDirector () {
		return director;
	}
	
	public Actor getProtagonista () {
		return protagonista;
	}
	
	public ArrayList<Ejemplar> getEjemplares () {
		return ejemplares;
	}
	
	public int getCantidadEjemplares () {
		return cantidadEjemplares;
	}
	
	public boolean getEnCartelera () {
		return enCartelera;
	}
	
	//Setters
	public void setTitulo (String titulo) {
		this.titulo = titulo;
	}
	
	public void setDuracion (int duracion) {
		this.duracion = duracion;
	}
	
	public void setGenero (String genero) {
		this.genero = genero;
	}
	
	public void setLanzamiento (int lanzamiento) {
		this.lanzamiento = lanzamiento;
	}
	
	public void setPais (String pais) {
		this.pais = pais;
	}
	
	public void setDirector (Director director) {
		this.director = director;
	}
	
	public void setProtagonista (Actor protagonista) {
		this.protagonista = protagonista;
	}
	
	public void setCantidadEjemplares (int cantidad) {
		this.cantidadEjemplares = cantidad;
	}
	
	public void setEnCartelera (boolean enCartelera) {
		this.enCartelera = enCartelera;
	}
	
	//Metodos
	/*
	 * Agrega la cantidad de ejemplares especificada por el parámetro
	 * */
	public void agregarEjemplares (int cantidad) {
		for (int i = 1; i <= cantidad; i++) {
			this.setCantidadEjemplares(this.getCantidadEjemplares() + 1);
			ejemplares.add(new Ejemplar(this.getCantidadEjemplares()));
		}
	}
	
	/*
	 * Busca un ejemplar libre y si hay alguno lo devuelve. En caso
	 * contrario devuelve un valor nulo
	 * */
	public Ejemplar buscarEjemplarLibre () {
		Ejemplar ejemplar;
		
		Iterator<Ejemplar> it = ejemplares.iterator();
		while (it.hasNext()) {
			ejemplar = it.next();
			
			if (ejemplar.estasLibre()) {
				return ejemplar;
			}
		}
		
		return null;
	}
	
	/*
	 * Agrega la película a la cartelera como disponible para
	 * ser alquilada
	 */
	public void agregarACartelera () {
		this.enCartelera = true;
	}
	
	/*
	 * Retirar la película de la cartelera y pasa a no
	 * estar disponible para su alquiler
	 */
	public void retirarDeCartelera () {
		this.enCartelera = false;
	}
	
	public String toString () {
		String result = "";
		
		result += ("Titulo: " + this.getTitulo());
		result += "\n";
		result += ("Duracion: " + this.getDuracion() + " min");
		result += "\n";
		result += ("Genero: " + this.getGenero());
		result += "\n";
		result += ("Fecha de lanzamiento: " + this.getLanzamiento());
		result += "\n";
		result += ("Pais: " + this.getPais());
		result += "\n";
		result += ("Director: " + director.toString());
		result += "\n";
		result += ("Protagonista: " + protagonista.toString());
		result += "\n";
		result += ("Cantidad de ejemplares: " + this.getCantidadEjemplares());
		
		return result;
	}
}