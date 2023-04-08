package dal;

import java.sql.SQLException;
import java.util.List;

import model.AcademicProgram;

public interface AcademicProgramDAO {
	public List<AcademicProgram> getAllAcademicPrograms() throws SQLException;
	public void addAcademicProgram(AcademicProgram academicProgram) throws SQLException;
	public void updateAcademicProgram(AcademicProgram academicProgram) throws SQLException;
	public void deleteAcademicProgram(int academicProgramId) throws SQLException;

}
