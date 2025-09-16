package banque.infrastructure.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

	private static DatabaseConfig instance;
	private Connection connection;


	private static final String URL = "jdbc:postgresql://localhost:5432/banko";
	private static final String USER = "younes";
	private static final String PASSWORD = "test123";


	private DatabaseConfig() {
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Postgres Driver not found", e);
		}
	}

	public static DatabaseConfig getInstance() {
	    try {
	        if (instance == null || instance.getConnection().isClosed()) {
	            instance = new DatabaseConfig();
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Database connection error", e);
	    }
	    return instance;
	}

	public Connection getConnection() {
		return this.connection;
	}
}
