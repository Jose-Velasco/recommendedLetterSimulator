package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.AcademicCharacteristic;
import model.AcademicProgram;
import model.Course;
import model.Faculty;
import model.PersonalCharacteristic;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;

import java.sql.SQLException;
import java.util.List;

import dal.AcademicProgramDAOImpl;
import dal.CourseDAOImpl;
import dal.DbSqlite;
import dal.FacultyDAOImpl;
import dal.PersonalCharacteristicDAOImpl;
import dal.AcademicCharacteristicDAOImpl;

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
//		USER
//		Integrate with new repo's main
		
		DbSqlite db = new DbSqlite("");
		FacultyDAOImpl facultyDAO = new FacultyDAOImpl(db.getConnection(), "faculty");
		CourseDAOImpl courseDAO = new CourseDAOImpl(db.getConnection(), "course");
		AcademicProgramDAOImpl academicProgramDAO = new AcademicProgramDAOImpl(db.getConnection(), "academicProgram");
		
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
			
//			testing AcademicProgram stuff
			System.out.println("### AcademicProgram TEST ###");
			List<AcademicProgram> SavedInDBAcademicProgram = academicProgramDAO.getAllAcademicPrograms();
			for (AcademicProgram course : SavedInDBAcademicProgram) {
				System.out.println(course.toString());
			}
			
//			testing PersonalCharacteristic stuff
			System.out.println("### PersonalCharacteristic TEST ###");
			PersonalCharacteristicDAOImpl personalCharacteristicDAO = new PersonalCharacteristicDAOImpl(db.getConnection(), "personalCharacteristic");
			List<PersonalCharacteristic> SavedInDBPersonalCharacteristic = personalCharacteristicDAO.getAllPersonalCharacteristics();
			for (PersonalCharacteristic personalCharacteristic : SavedInDBPersonalCharacteristic) {
				System.out.println(personalCharacteristic.toString());
			}
			
//			testing AcademicCharacteristic stuff
			System.out.println("### AcademicCharacteristic TEST ###");
			AcademicCharacteristicDAOImpl academicCharacteristicDAO = new AcademicCharacteristicDAOImpl(db.getConnection(), "academicCharacteristic");
			List<AcademicCharacteristic> SavedInDBAcademicCharacteristic = academicCharacteristicDAO.getAllAcademicCharacteristics();
			for (AcademicCharacteristic academicCharacteristic : SavedInDBAcademicCharacteristic) {
				System.out.println(academicCharacteristic.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		launch(args);
	}
}
