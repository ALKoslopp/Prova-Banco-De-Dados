package TestesEperimento;

import java.net.UnknownHostException;

import com.mongodb.MongoException;

public class Testador {

	public static void main(String[] args) throws UnknownHostException, MongoException {
		ManipulaDado mDado = new ManipulaDado();
		
		Conexao conexao = new Conexao();
		//conexao.salva("C:\\Users\\Adlan\\eclipse-workspace\\Mongo-VS-SQL\\src\\Arquivos\\Ler.txt", mDado);
		
		conexao.buscar("idTaxi : 1");

	}

}
