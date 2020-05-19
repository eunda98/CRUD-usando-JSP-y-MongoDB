package cancion;
import com.mongodb.BasicDBObject;
public class Cancion {

	private int cod;
	private String nombre;
	private String idioma;
	private String genero;
	private int durah;
	private int duram;
	private int duras;
	public Cancion() {
	}
 
	public Cancion(int cod,String nombre,String idioma,String genero,int durah,int duram,int duras) {
		this.cod= cod;
		this.nombre = nombre;
		this.idioma = idioma;
		this.genero = genero;
		this.durah = durah;
		this.duram = duram;
		this.duras=duras;
	}

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Cancion(BasicDBObject dBObjectCancion) {
		 
		this.cod = dBObjectCancion.getInt("cod");
		this.nombre = dBObjectCancion.getString("nombre");
		this.idioma = dBObjectCancion.getString("idioma");
		this.genero = dBObjectCancion.getString("genero");
		this.durah = dBObjectCancion.getInt("durah");
		this.duram = dBObjectCancion.getInt("duram");
		this.duras = dBObjectCancion.getInt("duram");
	}

	public BasicDBObject dBObjectCancion() {

		// Creamos una instancia BasicDBObject

		BasicDBObject dBObjectCancion = new BasicDBObject();
		dBObjectCancion.append("cod", this.getCod());
		dBObjectCancion.append("nombre", this.getNombre());
		dBObjectCancion.append("idioma", this.getIdioma());
		dBObjectCancion.append("genero", this.getGenero());
		dBObjectCancion.append("durah", this.getDurah());
		dBObjectCancion.append("duram", this.getDuram());
		dBObjectCancion.append("duras", this.getDuras());

		return dBObjectCancion;
	}


    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDurah() {
        return durah;
    }

    public void setDurah(int durah) {
        this.durah = durah;
    }

    public int getDuram() {
        return duram;
    }

    public void setDuram(int duram) {
        this.duram = duram;
    }

    public int getDuras() {
        return duras;
    }

    public void setDuras(int duras) {
        this.duras = duras;
    }
		    

	@Override
	public String toString() {
		return "Cod cancion: " + getCod() + " / Nombre: " + getNombre() + " / Idioma: " + getIdioma() + " / Genero: " + getGenero() + " / Duracion: " + getDurah()+":"+ getDuram() +":"+getDuras();
	}
}


