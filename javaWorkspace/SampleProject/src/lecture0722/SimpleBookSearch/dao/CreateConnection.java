package lecture0722.SimpleBookSearch.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface CreateConnection {
	public Connection newConnection() throws ClassNotFoundException, SQLException;
}
