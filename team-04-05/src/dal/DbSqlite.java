package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSqlite implements DbConnectionInt {
	
	private Connection connection;
	
	public DbSqlite(String urlStr) {
		try {
			this.connection = DriverManager.getConnection(urlStr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void startTransaction() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endTransaction() throws SQLException {
		// TODO Auto-generated method stub

	}

}
