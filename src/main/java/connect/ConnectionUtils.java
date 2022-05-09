package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionUtils {
	public ConnectionUtils() {
		// TODO Auto-generated constructor stub
	}
	public static Connection getConnection() throws ClassNotFoundException,Exception{
		String hostName = "localhost";
		String dbName = "mywebapp";
		String userName="root";
		String passWord="";
		Class.forName("com.mysql.jdbc.Driver");
		String ConnectingURL = "jdbc:mysql://localhost:3306/mywebapp";
		Connection con = DriverManager.getConnection(ConnectingURL,userName,passWord);
		System.out.println("ket noi thanh cong csdl");
		return con;
	}
	public static void closeQuietly(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			
		}
	}
	public static void rollbackQuietly(Connection con) {
		try {
			con.rollback();
		}catch(Exception e) {
			
		}
	}
	public static void main(String args[]) {
		ConnectionUtils c = new ConnectionUtils();
		try {
		Connection con  = getConnection();
		}catch(Exception e) {
			
		}
	}
}
