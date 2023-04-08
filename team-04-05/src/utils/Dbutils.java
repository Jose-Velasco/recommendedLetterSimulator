package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dbutils {

	public boolean tableExists(Connection connection, String tableName) throws SQLException {
		String sqlCheckIfEmpty = String.format("SELECT name FROM sqlite_master WHERE type='table' AND name='%s'", tableName);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlCheckIfEmpty);
		
		return resultSet.next();
	}
	
	public void createTable(Connection connection, String tableName, List<String> tableColumnsAndTypes) throws SQLException {
		Statement statement = connection.createStatement();
		String sqlCreateCourseTable = String.format("CREATE TABLE %s (", tableName);
		
//		build query from given column and type EX. 'id INTEGER PRIMARY KEY', 'fullName TEXT'
		for (int i = 0; i < tableColumnsAndTypes.size(); i++) {
			if (i != 0) {
				sqlCreateCourseTable = sqlCreateCourseTable + ", ";
			}
			sqlCreateCourseTable = sqlCreateCourseTable + tableColumnsAndTypes.get(i);
		}
		sqlCreateCourseTable = sqlCreateCourseTable + ")";
		
		
		System.out.println("Created Table with sql query:");
		System.out.println(sqlCreateCourseTable);
		
		statement.executeUpdate(sqlCreateCourseTable);
		statement.close();
	}
	
	/**
	 * Example prepare statement: INSERT INTO %s (name, prefix, prefixNumber) VALUES (?, ?, ?)
	 * 
	 * @param preparedStatement
	 * @param NumOfValuesPerRow number of values in the preparedStatement EX. (?, ?, ?) NumOfValuesPerRow would be 3
	 * @param rowEntries values that will be inserted into row
	 * @throws SQLException
	 */
	public void insertDefaultStringOnlyGivenTableData(PreparedStatement preparedStatement, int NumOfValuesPerRow, ArrayList<ArrayList<String>> rowEntries) throws SQLException {
		for (ArrayList<String>  row : rowEntries) {
			for (int i = 1; i <= NumOfValuesPerRow; i++) {
				preparedStatement.setString(i, row.get(i - 1));
				preparedStatement.executeUpdate();
			}
		}
		System.out.println("inital/default Data inserted successfully, NumOfValuesPerRow = " + NumOfValuesPerRow);
	}
}
