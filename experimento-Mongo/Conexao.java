package TestesEperimento;

import java.io.*;
import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class Conexao {
	
	private Mongo conexao;
	DB db;
	
	/*public Conexao(String endereco) throws UnknownHostException, MongoException {
		this.conexao = new Mongo(endereco);
	}*/
	
	public void salva(String file, ManipulaDado mDado) throws UnknownHostException, MongoException {
		this.conexao = new Mongo("localhost");
		this.db = conexao.getDB("Experimento2");
		
		try {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				while(br.ready()) {
					String linha = br.readLine();
					BufferedReader l1 = new BufferedReader(new FileReader("C:\\Users\\Adlan\\eclipse-workspace\\Mongo-VS-SQL\\src\\Arquivos\\" + linha));
					
					while(l1.ready()) {
		        		String ler = l1.readLine();
		        		String[] s = ler.split(",");
		        		mDado.setIdTaxi(s[0]);
		        		mDado.setDataTime(s[1]);
		        		mDado.setLongitude(s[2]);
		        		mDado.setLatitude(s[3]);
		        		
		        		BasicDBObject dados = new BasicDBObject();
						dados.put("idTaxi", mDado.getIdTaxi());
						dados.put("dataTime", mDado.getDataTime());
						dados.put("longitude", mDado.getLongitude());
						dados.put("latitude", mDado.getLatitude());	
						
						DBCollection col = db.getCollection("Experimento2");
						col.insert(dados);
						
					}					
					
					l1.close();
				}
				br.close();
				
			} catch (IOException e){
				e.printStackTrace();
			}			
			
		} catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         }
	}
	
	public void buscar(String valor) throws UnknownHostException, MongoException {
		this.conexao = new Mongo("localhost");
		this.db = conexao.getDB("Experimento2");
		
		DBCursor cursor = (DBCursor) db.getCollection("Experimento2").findOne(valor);
		System.out.println("_______");
		//while( cursor.hasNext() ){
		        BasicDBObject pessoa = new BasicDBObject();
		        System.out.println( "idTaxi: "+pessoa.getString("idTaxi") );
		        System.out.println("dataTime: "+pessoa.getString("dataTime"));
		        System.out.println("Longitude: "+pessoa.getString("longitude"));
		        System.out.println("Latitude:"+pessoa.getString("latitude"));
		        
		        System.out.println("_______________________________________");
		                
		//}
	}

}
