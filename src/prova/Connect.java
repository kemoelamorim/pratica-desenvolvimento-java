package prova;
import java.sql.*;
public class Connect {
	
	public Connection getConnection() {	
	
		try	{
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_prova","root","aluno");
		
		}catch(SQLException	e){
			throw new RuntimeException(e + " Deu erro de conexão.");
		}
	}
	
}
