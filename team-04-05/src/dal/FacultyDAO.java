package dal;

import java.sql.SQLException;

import model.Faculty;

public interface FacultyDAO {
	public void updateFaculty() throws SQLException;
	public Faculty getFaculty() throws SQLException;

}
