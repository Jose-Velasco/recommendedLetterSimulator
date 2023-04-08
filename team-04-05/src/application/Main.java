package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Course;
import model.Faculty;
import utils.Dbutils;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.CourseDAOImpl;
import dal.DbSqlite;
import dal.FacultyDAOImpl;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			HBox root = (HBox)FXMLLoader.load(getClass().getClassLoader().getResource("view/Main.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("test program");
			
		
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		TODO:
//		Program names
//		personal characteristics
//		academic characteristics
//		
		
		DbSqlite db = new DbSqlite("");
		FacultyDAOImpl facultyDAO = new FacultyDAOImpl(db.getConnection(), "faculty");
		CourseDAOImpl courseDAO = new CourseDAOImpl(db.getConnection(), "course");
		
		try {
			
//			testing faculty stuff
			Faculty fac = facultyDAO.getFaculty();
			System.out.println(fac.toString());
			
			
//			testing Courses stuff
			System.out.println("### COURSES TEST ###");
			List<Course> SavedInDBCourses = courseDAO.getAllCourses();
			for (Course course : SavedInDBCourses) {
				System.out.println(course.toString());
			}
			
//			Testing DbUtils
			System.out.println("### Testing DbUtils ###");
			Dbutils dbUtils = new Dbutils();
			ArrayList<String> colAndTypes = new ArrayList<>();
			colAndTypes.add("id INTEGER PRIMARY KEY");
			colAndTypes.add("fullName TEXT");
			colAndTypes.add("title TEXT");
			colAndTypes.add("schoolName TEXT");
			colAndTypes.add("department TEXT");
			colAndTypes.add("email TEXT");
			colAndTypes.add("phoneNumber TEXT");
			
			dbUtils.createCourseTable(db.getConnection(), "course", colAndTypes);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		launch(args);
	}
}
