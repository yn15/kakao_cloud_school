package org.nullmaster.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import static org.junit.Assert.fail;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/board?serverTimezone=UTC", "root", "1234");
			log.info(conn);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}







