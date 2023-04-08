package dal;

import java.sql.SQLException;
import java.util.List;

import model.Course;

public interface CourseDAO {
	public List<Course> getAllCourses() throws SQLException;
	public void addCourses(Course course) throws SQLException;
	public void updateCourses(Course course) throws SQLException;
	public void deleteCourses(Course course) throws SQLException;

}
