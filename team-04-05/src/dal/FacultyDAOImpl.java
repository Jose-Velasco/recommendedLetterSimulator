package dal;

import java.sql.Connection;
import java.sql.SQLException;

import model.Faculty;

public class FacultyDAOImpl implements FacultyDAO {
	private Connection connction;
	
//	make DB connection a singleton?
	public FacultyDAOImpl(Connection connection) {
		this.connction = connection;
	}

	@Override
	public void updateFaculty() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Faculty getFaculty() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
