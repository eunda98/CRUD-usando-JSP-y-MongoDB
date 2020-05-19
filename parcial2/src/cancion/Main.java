package cancion;

import java.net.UnknownHostException;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Main {

	public static void main(String args[]) {

		ArrayList<Cancion> Can = new ArrayList<Cancion>(); 
		ArrayList<Album> alb = new ArrayList<Album>();
		ArrayList<Interprete> inter = new ArrayList<Interprete>();
		
		Can.add(new Cancion(1,"un ratico","Español","balada",00,03,51));
		Can.add(new Cancion(2," Lo mejor que hay en mi vida","Español","balada",00,04,00));
		Can.add(new Cancion(3," Voy a extrañarte","Español","balada",00,03,20));
		Can.add(new Cancion(4," A Dios le pido","Español"," pop",00,05,06));
		Can.add(new Cancion(5," Recuerdame","Español"," Vallenato", 00,03,15));
		Can.add(new Cancion(6," Bonita ","Español"," Vallenato ", 00,03,15));
		Can.add(new Cancion(7," A Dios le pido","Español"," Vallenato ",00,04,51));
		
		
		inter.add(new Interprete(11," Andres cepeda"," Colombia "));
		inter.add(new Interprete(22," Juan Vásquez","Colombia"));
		inter.add(new Interprete(33," Pablo Alborán"," España"));
		
		alb.add(new Album(111,5,33," Pablo Alborán"));
		alb.add(new Album(222,2,11," Lo mejor que hay en mi vida"));
		alb.add(new Album (333,6,22," Loco de amor"));
		

		
		try {
		//Conexion al Server de MongoDB Pasandole el host y el puerto

			MongoClient mongoClient = new MongoClient("localhost", 27017);

		//Conexion a la base de datos

			DB db = mongoClient.getDB("cancion");

		//Obtenemos una coleccion para trabajar con ella

			DBCollection collection = db.getCollection("Cancion");
			DBCollection collection1 = db.getCollection("Interprete");
			DBCollection collection2 = db.getCollection("Album");

			
		// CRUD ( Create - Read - Update - Delete )

			// "CREATE" -> Metemos los objetos del Concierto (o documentos en Mongo) en la coleccion 
/*
			for (Cancion Ca : Can) {
				collection.insert(Ca.dBObjectCancion());
			}
			for (Interprete In : inter) {
				collection1.insert(In.dBObjectInterprete());
			}
			for (Album al : alb) {
				collection2.insert(al.dBObjectAlbum());
			}
			
*/
			
//--------------------------------------------------------------------------------------------------------------------------------------------------
			// "READ" 

			int num = (int) collection.getCount();
			System.out.println("Numero de Documentos en la coleccion Cancion: " + num + "\n");
			DBCursor cursor = collection.find();
			try {
				while (cursor.hasNext()) {
					System.out.println(cursor.next().toString());
				}
			} finally {
				cursor.close();
			}
			
			int num1 = (int) collection1.getCount();
			System.out.println("Numero de Documentos en la coleccion Interprete: " + num1 + "\n");
			DBCursor cursor1 = collection1.find();
			try {
				while (cursor1.hasNext()) {
					System.out.println(cursor1.next().toString());
				}
			} finally {
				cursor1.close();
			}
			
			int num2 = (int) collection2.getCount();
			System.out.println("Numero de Documentos en la coleccion Album: " + num2 + "\n");
			DBCursor cursor2 = collection2.find();
			try {
				while (cursor2.hasNext()) {
					System.out.println(cursor2.next().toString());
				}
			} finally {
				cursor2.close();
			}
			

			
			// "READ" 
			

			System.out.println("\n Canciones disponibles en Español");
			DBObject query = new BasicDBObject("genero", new BasicDBObject("$regex", "balada"));
			cursor = collection.find(query);
			try {
				while (cursor.hasNext()) {
					Cancion Can1 = new Cancion((BasicDBObject) cursor.next());
					System.out.println(Can1.toString());
				}
			} finally {
				cursor.close();
			}
 
  


			// "UPDATE" 
			
			DBObject find = new BasicDBObject("nombre", new BasicDBObject("$regex", " Recuerdame"));
			DBObject updated = new BasicDBObject().append("$set", new BasicDBObject().append("nombre", "holaa"));
			collection.update(find, updated, false, true);
			try {
				while (cursor.hasNext()) {
					System.out.println(cursor.next().toString());
				}
			} finally {
				cursor.close();
			} 
 
			//"DELETE" 

			DBObject con = new BasicDBObject("nombre", new BasicDBObject("$regex", " Bonita "));
			collection.remove(con); 
 

		// Cerrar la conexion
		//	mongoClient.close();

		} catch (Exception ex) {
			System.out.println("Exception al conectar al server de Mongo: " + ex.getMessage());
		}

	}

}

