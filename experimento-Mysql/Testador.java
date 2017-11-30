package Aplicacao;

import java.sql.SQLException;

public class Testador {

	public static void main(String[] args) throws SQLException {
		Conexao conexao = new Conexao();
		ManipulaDado mDado = new ManipulaDado();
		//System.out.println(mDado);
		ManipulaDadoDao mdDao = new ManipulaDadoDao(conexao);
		//mdDao.salva("C:\\Users\\Adlan\\eclipse-workspace\\Mongo-VS-Java\\src\\Arquivos\\Ler.txt", mDado);
		mdDao.buscar("idTaxi", "1");

	}

}
