package ejercicio01;

import java.util.ArrayList;
import java.util.Iterator;

public class VideoClub {
	
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	
	private ArrayList<Pelicula> peliculas;
	
	private ArrayList<Socio> socios;
	private int contadorSocios; //Lo utilizo para crear los números de socio
	
	private ArrayList<Alquiler> alquileres;
	
	//Constructor
	public VideoClub (String nombre, String direccion, String telefono, String correo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		
		this.socios = new ArrayList<Socio>();
		this.contadorSocios = 0;
		
		this.peliculas = new ArrayList<Pelicula>();
		
		this.alquileres = new ArrayList<Alquiler>();
		
		cargarDatosDePrueba(); // Cargo socios, películas y ejemplares de prueba
	}
	
	//Getters
	public String getNombre () {
		return nombre;
	}
	
	public String getDireccion () {
		return direccion;
	}
	
	public String getTelefono () {
		return telefono;
	}
	
	public String getCorreo () {
		return correo;
	}
	
	public ArrayList<Pelicula> getPeliculas () {
		return peliculas;
	}
	
	public ArrayList<Socio> getSocios () {
		return socios;
	}
	
	public int getContadorSocios () {
		return contadorSocios;
	}
	
	public ArrayList<Alquiler> getAlquileres () {
		return alquileres;
	}
	
	//Setters
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setDireccion (String direccion) {
		this.direccion = direccion;
	}
	
	public void setTelefono (String telefono) {
		this.telefono = telefono;
	}
	
	public void setCorreo (String correo) {
		this.correo = correo;
	}
	
	//Metodos
	/*
	 * Recibe como parámetro una película y la agrega al catálogo del
	 * videoclub en caso de no existir en el mismo
	 * */
	public void agregarPelicula (Pelicula pelicula) {
		String titulo = pelicula.getTitulo();
		
		if (buscarPelicula(titulo) == null) {
			peliculas.add(pelicula);
		}
	}
	
	/*
	 * Agrega la cantidad establecida de ejemplares para la película
	 * especificada por su título si existe
	 * */
	public void agregarEjemplares (String titulo, int cantidad) {
		Pelicula pelicula = buscarPelicula(titulo);
		
		if (pelicula != null) {
			pelicula.agregarEjemplares(cantidad);
		}
	}
	
	/*
	 * Busca una película por su título en el catálogo de películas y la
	 * devuelve. Si no la encuentra devuelve un valor nulo
	 */
	private Pelicula buscarPelicula (String titulo) {
		Pelicula currentMovie;
		
		Iterator<Pelicula> it = peliculas.iterator();
		while (it.hasNext()) {
			currentMovie = it.next();
			
			if (currentMovie.getTitulo() == titulo) {
				return currentMovie;
			}
		}
		
		return null;
	}
	
	/*
	 * Agrega a la cartelera de películas disponibles la película especificada
	 * por su título si ésta existe dentro del catálogo y si no está ya
	 * disponible
	 */
	public void agregarACartelera (String titulo) {
		Pelicula pelicula = buscarPelicula(titulo);
		
		if ((pelicula != null) && (!pelicula.getEnCartelera())) {
			pelicula.agregarACartelera();
		}
	}
	
	/*
	 * Retira de la cartelera la película especificada si es que existe en
	 * el catálogo del videoclub y está disponible
	 * */
	public void retirarDeCartelera (String titulo) {
		Pelicula pelicula = buscarPelicula(titulo);
		
		if ((pelicula != null) && (pelicula.getEnCartelera())) {
			pelicula.retirarDeCartelera();
		}
	}
	
	/*
	 * Devuelve un array con todas las películas que se encuentren en la
	 * cartelera, es decir, las que estén disponibles para alquilar
	 * */
	public ArrayList<Pelicula> peliculasEnCartelera () {
		ArrayList<Pelicula> carteleraActual = new ArrayList<Pelicula>();
		Pelicula currentMovie;
		
		Iterator<Pelicula> it = peliculas.iterator();
		while (it.hasNext()) {
			currentMovie = it.next();
			
			if (currentMovie.getEnCartelera()) {
				carteleraActual.add(currentMovie);
			}
		}
		
		return carteleraActual;
	}
	
	/*
	 * Recibe como parámetro un socio y lo agrega a la lista de socios
	 * del video club en caso de no tener una cuenta asociada.
	 */
	public void agregarSocio (Socio socio) {
		int dni = socio.getDni();
		
		if (!cuentaAsociada(dni)) {
			contadorSocios++;
			socio.setNroSocio(contadorSocios); // Acá recién se le asigna nro de socio
			socios.add(socio);
		}
	}
	
	/*
	 * Devuelve verdadero si existe una cuenta asociada al dni pasado
	 * por parámetro o falso en caso contrario
	 */
	private boolean cuentaAsociada (int dni) {
		boolean existe = false;
		Socio currentSocio;
		
		Iterator<Socio> it = socios.iterator();
		while ((it.hasNext()) && !existe) {
			currentSocio = it.next();
			
			if (currentSocio.getDni() == dni) {
				existe = true;
			}
		}
		
		return existe;
	}
	
	/*
	 * Busca un socio por su número de socio y lo devuelve si lo
	 * encuentra. En caso contrario devuelve un valor nulo
	 */
	private Socio buscarSocio (int nroSocio) {
		Socio currentSocio;
		
		Iterator<Socio> it = socios.iterator();
		while (it.hasNext()) {
			currentSocio = it.next();
			
			if (currentSocio.getNroSocio() == nroSocio) {
				return currentSocio;
			}
		}
		
		return null;
	}
	
	/*
	 * Devuelve una ArrayList<Socio> con todos los socios morosos
	 */
	/*public ArrayList<Socio> sociosMorosos () {
		ArrayList<Socio> morosos = new ArrayList<Socio>();
		return morosos;
	}*/

	/*
	 * Reactiva la cuenta con el número de socio especificado si es
	 * que ésta existe y está desactivada
	 */
	public void activarCuentaSocio (int nroSocio) {
		Socio socio = buscarSocio(nroSocio);
		
		if ((socio != null) && (!socio.getEstado())) {
			socio.activarCuenta();
		}
	}
	
	/*
	 * Da de baja, pero no borra, la cuenta correspondiente al número de
	 * socio especificado
	 */
	public void desactivarCuentaSocio (int nroSocio) {
		Socio socio = this.buscarSocio(nroSocio);
		
		if ((socio != null) && (socio.getEstado())) {
			socio.desactivarCuenta();
		}
	}
	
	/*
	 * Devuelve un ArraList<Socio> con todas las cuentas que se
	 * encuentren en estado activo
	 */
	public ArrayList<Socio> cuentasActivas () {
		ArrayList<Socio> sociosActivos = new ArrayList<Socio>();
		Socio currentSocio;
		
		Iterator<Socio> it = socios.iterator();
		while (it.hasNext()) {
			currentSocio = it.next();
			
			if (currentSocio.getEstado()) {
				sociosActivos.add(currentSocio);
			}
		}
		
		return sociosActivos;
	}
	
	/*
	 * Devuelve un ArrayList<Socio> con todas las cuentas que
	 * estén inhabilitadas
	 */
	public ArrayList<Socio> cuentasInactivas () {
		ArrayList<Socio> cuentasInactivas = new ArrayList<Socio>();
		Socio currentSocio;
		
		Iterator<Socio> it = socios.iterator();
		while (it.hasNext()) {
			currentSocio = it.next();
			
			if (!currentSocio.getEstado()) {
				cuentasInactivas.add(currentSocio);
			}
		}
		
		return cuentasInactivas;
	}
	
	/*
	 * Agrega un nuevo alquiler a la lista del videoclub si la
	 * película se encuentra en cartelera y si hay algún
	 * ejemplar disponible. También al historial de la cuenta del
	 * socio especificado si ésta se encuentra activa.
	 * Además, descuenta un ejemplar disponible de la película
	 */
	public void realizarAlquiler (int nroSocio, String titulo) {
		Socio socio = buscarSocio(nroSocio);
		
		if ((socio != null) && (socio.getEstado())) {
			Pelicula pelicula = buscarPelicula(titulo);
			
			if ((pelicula != null) && (pelicula.getEnCartelera())) {
				Ejemplar ejemplar = pelicula.buscarEjemplarLibre();
				
				if (ejemplar != null) {
					Alquiler alquiler = new Alquiler(socio, pelicula, ejemplar);
					socio.agregarAlquiler(alquiler);
					ejemplar.setEstadoOcupado();
					alquileres.add(alquiler);
				}
			}
		}
	}
	
	/*
	 * Procesa la devolución del alquiler correspondiente al
	 * título de la película y el número de ejemplar. El estado del
	 * alquiler pasa a ser devuelto y se repone un ejemplar
	 */
	public void devolverAlquiler (String titulo, int nroEjemplar) {
		Alquiler alquiler = buscarAlquiler(titulo, nroEjemplar);
		
		if (alquiler != null) {
			Ejemplar ejemplar = alquiler.getEjemplar();
			ejemplar.setEstadoDisponible();
			alquiler.setEstadoDevuelto();
		}
	}
	
	/*
	 * Busca en la lista de alquileres el que corresponda al título
	 * y número de ejemplar especificado por parámetro y lo devuelve.
	 * En caso contrario se devuelve el valor nulo
	 */
	private Alquiler buscarAlquiler (String titulo, int nroEjemplar) {
		Alquiler alquiler;
		Pelicula pelicula;
		Ejemplar ejemplar;
		
		Iterator<Alquiler> it = alquileres.iterator();
		while (it.hasNext()) {
			alquiler = it.next();
			pelicula = alquiler.getPelicula();
			
			if (pelicula.getTitulo() == titulo) {
				ejemplar = alquiler.getEjemplar();
				
				if (ejemplar.getNro() == nroEjemplar) {
					return alquiler;
				}
			}
		}
		
		return null;
	}
	
	/*
	 * Devuelve un ArrayList con todos los alquileres que no
	 * fueron devueltos
	 */
	public ArrayList<Alquiler> devolucionesPendientes () {
		ArrayList<Alquiler> devolucionesPendientes = new ArrayList<Alquiler>();
		Alquiler currentAlquiler;
		
		Iterator<Alquiler> it = alquileres.iterator();
		while (it.hasNext()) {
			currentAlquiler = it.next();
			
			if (!currentAlquiler.getEstado()) {
				devolucionesPendientes.add(currentAlquiler);
			}
		}
		
		return devolucionesPendientes;
	}

	/*Crear un método para realizar alquileres con fecha de lanzamiento y otro
	 * que no*/
	
	public String toString () {
		String result = "";
		
		result += ("Nombre: " + this.getNombre());
		result += "\n";
		result += ("Direccion: " + this.getDireccion());
		result += "\n";
		result += ("Telefono: " + this.getTelefono());
		result += "\n";
		result += ("Correo: " + this.getCorreo());
		result += "\n";
		result += ("Cantidad de socios: " + this.getContadorSocios());
		
		return result;
	}
	
	/*
	 * Carga datos de prueba
	 */
	private void cargarDatosDePrueba () {
		//Socios
		this.agregarSocio(new Socio("Sebastian", "Bermudez", 41958741, "297-5986619", "sebaBermudez@gmail.com"));
		this.agregarSocio(new Socio("Franco", "Vera", 39584741, "297-4855998", "franVera@gmail.com"));
		this.agregarSocio(new Socio("Maria", "Soler", 40265897, "297-5858744", "marSoler@gmail.com"));
		this.agregarSocio(new Socio("Fabian", "Marquez", 38584744, "297-5200365", "fabiMarquez@gmail.com"));
		this.agregarSocio(new Socio("Rosario", "Zarate", 37852669, "297-4112585", "roZarate@gmail.com"));
		this.agregarSocio(new Socio("Paula", "Perez", 34852998, "297-4522369", "pauPerez@gmail.com"));
		this.agregarSocio(new Socio("Rosa", "Quiroz", 36569875, "297-4788920", "roQuiroz@gmail.com"));
		//Peliculas
		this.agregarPelicula(new Pelicula("Suenos de Libertad", 142, "Drama", 1994, "Estados Unidos", new Director("Frank", "Darabont"), new Actor("Tim", "Robbins")));
		this.agregarPelicula(new Pelicula("El Padrino", 175, "Crimen", 1972, "Estados Unidos", new Director("Francis", "Ford Coppola"), new Actor("Marlon", "Brando")));
		this.agregarPelicula(new Pelicula("El Caballero de la Noche", 152, "Accion", 2008, "Estados Unidos", new Director("Christopher", "Nolan"), new Actor("Christian", "Bale")));
		this.agregarPelicula(new Pelicula("Pulp Fiction", 154, "Crimen", 1994, "Estados Unidos", new Director("Quentin", "Tarantino"), new Actor("John", "Travolta")));
		this.agregarPelicula(new Pelicula("Forrest Gump", 142, "Drama", 1994, "Estados Unidos", new Director("Robert", "Zemeckis"), new Actor("Tom", "Hanks")));
		this.agregarPelicula(new Pelicula("El Origen", 148, "Ciencia Ficcion", 2010, "Estados Unidos", new Director("Christopher", "Nolan"), new Actor("Leonardo", "DiCaprio")));
		this.agregarPelicula(new Pelicula("The Matrix", 136, "Ciencia Ficcion", 1999, "Estados Unidos", new Director("Lana", "Wachowski"), new Actor("Keanu", "Reeves")));
		this.agregarPelicula(new Pelicula("Gladiador", 155, "Accion", 2000, "Estados Unidos", new Director("Ridley", "Scott"), new Actor("Russell", "Crowe")));
		this.agregarPelicula(new Pelicula("Titanic", 195, "Romance", 1997, "Estados Unidos", new Director("James", "Cameron"), new Actor("Leonardo", "DiCaprio")));
		this.agregarPelicula(new Pelicula("El Club de la Pelea", 139, "Drama", 1999, "Estados Unidos", new Director("David", "Fincher"), new Actor("Edward", "Norton")));
		//Ejemplares
		this.agregarEjemplares("Suenos de Libertad", 3);
		this.agregarEjemplares("El Padrino", 5);
		this.agregarEjemplares("El Caballero de la Noche", 1);
		this.agregarEjemplares("Pulp Fiction", 4);
		this.agregarEjemplares("Forrest Gump", 3);
		this.agregarEjemplares("El Origen", 8);
		this.agregarEjemplares("The Matrix", 1);
		this.agregarEjemplares("Gladiador", 5);
		this.agregarEjemplares("Titanic", 4);
		this.agregarEjemplares("El Club de la Pelea", 7);
	}
}