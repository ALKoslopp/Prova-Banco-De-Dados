package Aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conexao;
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/experimento";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "adlan";
	
	private  static final String TPCONEXAO = "com.mysql.jdbc.Driver";
	
	public static Connection abrir() {
		try {
			Class.forName(TPCONEXAO);
			conexao = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Funcionou");
		} catch (ClassNotFoundException  | SQLException ex) {
			ex.printStackTrace();
		}
		return conexao;
	}
	
	public void fechar() {
		if (conexao != null) {
			try {
				conexao.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
