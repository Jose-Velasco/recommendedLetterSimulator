package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Course {
	private int courseId;
	private SimpleStringProperty name;
	private SimpleStringProperty prefix;
	private SimpleIntegerProperty prefixNumber;
	
	public Course(int courseId, String courseName, String prefix, int prefixNumber) {
		this.courseId = courseId;
		this.name = new SimpleStringProperty(courseName);
		this.prefix = new SimpleStringProperty(prefix);
		this.prefixNumber = new SimpleIntegerProperty(prefixNumber);
	}
	
	public String getName() {
		return name.get();
	}
	
	public void seteName(String courseName) {
		this.name.set(courseName);
	}
	
	public String getPrefix() {
		return prefix.get();
	}
	
	public void setPrefix(String prefix) {
		this.prefix.set(prefix);
	}
	
	public int getPrefixNumber() {
		return prefixNumber.get();
	}
	
	public void setPrefixNumber(int prefixNumber) {
		this.prefixNumber.set(prefixNumber);
	}

	public int getCourseId() {
		return courseId;
	}
}
