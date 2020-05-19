package cancion;

import com.mongodb.BasicDBObject;

public class Interprete {
	private int int_Id;
	private String int_nombre;
    private String pais;
    
public Interprete() {
}
public Interprete(int int_Id, String int_nombre, String pais) {
    this.int_Id = int_Id;
    this.int_nombre = int_nombre;
    this.pais = pais;
}

public int getInt_Id() {
    return int_Id;
}

public void setInt_Id(int int_Id) {
    this.int_Id = int_Id;
}

public String getInt_nombre() {
    return int_nombre;
}

public void setInt_nombre(String int_nombre) {
    this.int_nombre = int_nombre;
}

public String getPais() {
    return pais;
}

public void setPais(String pais) {
    this.pais = pais;
}


		public Interprete(BasicDBObject dBObjectInterprete) {
			
			this.int_Id = dBObjectInterprete.getInt("int_Id");
			this.int_nombre = dBObjectInterprete.getString("int_nombre");
			this.pais = dBObjectInterprete.getString("pais");
		}

		public BasicDBObject dBObjectInterprete() {

			BasicDBObject dBObjectInterprete = new BasicDBObject();
			dBObjectInterprete.append("int_Id", this.getInt_Id());
			dBObjectInterprete.append("int_nombre", this.getInt_nombre());
			dBObjectInterprete.append("pais", this.getPais());

			return dBObjectInterprete;
		}
		    

		@Override
		public String toString() {
			return "Id: " + getInt_Id() + " / Nombre: " + getInt_nombre() + " / Pais: " + getPais();
		}

}
