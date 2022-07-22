package lecture0722.step6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {
	
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
