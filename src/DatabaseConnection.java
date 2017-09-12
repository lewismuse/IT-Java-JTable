import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection connection;
	//create an object of SingleObject
	private static DatabaseConnection instance = new DatabaseConnection();
	
	//make the constructor private so that this class cannot be
	//instantiated
	private DatabaseConnection(){
		try {
			String dbURL = "jdbc:mysql://localhost:3306/mysqltest1?autoReconnect=true&useSSL=false";
			String username = "ConnectionTestUser";
			String password = "";
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(dbURL, username, password);
		} catch(Exception e) {
			//for(Throwable t : e) {
				System.out.println(e);
			//}	
		}
	}
	
	//Get the only object available
	public static DatabaseConnection getInstance() {
		if(instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}
	public static Connection getConnection() {
		return connection;
	}
}
