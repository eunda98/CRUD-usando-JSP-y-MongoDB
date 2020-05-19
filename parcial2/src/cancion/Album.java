package cancion;

import com.mongodb.BasicDBObject;

public class Album {
	private int Id;
	private int can;
	private int inter;
	private String nombre;


	public Album() {
	}

    public Album(int Id, int can, int inter, String nombre) {
        this.Id = Id;
        this.can = can;
        this.inter = inter;
        this.nombre = nombre;
    }

	public Album(BasicDBObject dBObjectAlbum) {
		
		this.Id = dBObjectAlbum.getInt("Id");
        this.can = dBObjectAlbum.getInt("can");
        this.inter = dBObjectAlbum.getInt("inter");
        this.nombre = dBObjectAlbum.getString("nombre");
	}

	public BasicDBObject dBObjectAlbum() {

		BasicDBObject dBObjectAlbum = new BasicDBObject();
		dBObjectAlbum.append("Id", this.getId());
		dBObjectAlbum.append("can", this.getCan());
		dBObjectAlbum.append("inter", this.getInter());
		dBObjectAlbum.append("nombre", this.getNombre());

		return dBObjectAlbum;
	}

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public int getInter() {
        return inter;
    }

    public void setInter(int inter) {
        this.inter = inter;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
		    

	@Override
	public String toString() {
		return "Id: " + getId() + " / Can: " + getCan() + " / Inte: " + getInter() + " / Nombre: " + getNombre();
	}
}
