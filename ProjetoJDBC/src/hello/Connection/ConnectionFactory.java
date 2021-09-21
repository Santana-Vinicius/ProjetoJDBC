package hello.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:<PORTA>/<DBNAME>";
	private final String USER = "<USER>";
	private final String PASSWORD = "<PASSWORD>";
	private Connection conexao;
	public static final ConnectionFactory shared = new ConnectionFactory();

	private ConnectionFactory() {

		try {
			// Definiu o driver de conexão para o MYSQL
			Class.forName(DRIVER);

			// Criar uma conexão
			conexao = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection opened!");
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	public Connection getConexao() {
		return conexao;
	}


}
