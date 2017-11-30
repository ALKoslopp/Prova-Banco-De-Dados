package Aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Testando.Conexao;

public class ManipulaDadoDao {
	
	private Connection conection;
	private Aplicacao.Conexao conexao;
	
	public ManipulaDadoDao(Aplicacao.Conexao conexao2) {
		this.conexao = conexao2;
		this.conection = conexao2.abrir();
	}
	
	public void salva(String file, ManipulaDado mDado) {
		String sql = ("INSERT INTO dados(idTaxi, dataTime, longitude, latitude)VALUES(?,?,?,?)");
		PreparedStatement stmt;
	
		try {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				stmt = conection.prepareStatement(sql);
			
				while(br.ready()) {
					String linha = br.readLine();
					BufferedReader l1 = new BufferedReader(new FileReader("C:\\Users\\Adlan\\eclipse-workspace\\Mongo-VS-Java\\src\\" + linha));
		        	while(l1.ready()) {
		        		String ler = l1.readLine();
		        		String[] s = ler.split(",");
		        		mDado.setIdTaxi(s[0]);
		        		mDado.setDataTime(s[1]);
		        		mDado.setLongitude(s[2]);
		        		mDado.setLatitude(s[3]);
		        		
						stmt.setString(1, mDado.getIdTaxi());
						stmt.setString(2, mDado.getDataTime());
						stmt.setString(3, mDado.getLongitude());
						stmt.setString(4, mDado.getLatitude());
						stmt.executeUpdate();
		        	}
		        	l1.close();
					
				}
				br.close();
			} catch(IOException e) {
			     e.printStackTrace();
				
			}
					
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		  } finally {
			  conexao.fechar();
		  	}		
	}
	
	public ManipulaDado buscar(String tabela, String valor) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.conection.prepareStatement("select * from dados where " + tabela + " = " + valor);
		ResultSet rs = (ResultSet) stmt.executeQuery();
		ManipulaDado mDado = new ManipulaDado();
		
		while(rs.next()) {
			mDado.setIdTaxi(rs.getString("idTaxi"));
			mDado.setDataTime(rs.getString("dataTime"));
			mDado.setLatitude(rs.getString("latitude"));
			mDado.setLongitude(rs.getString("longitude"));
		}
		return mDado;
	}

}
