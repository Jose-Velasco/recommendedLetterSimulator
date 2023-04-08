package dal;

import java.sql.SQLException;
import java.util.List;

import model.AcademicCharacteristic;

public interface AcademicCharacteristicDAOInt {
	public List<AcademicCharacteristic> getAllAcademicCharacteristics() throws SQLException;
	public void addAcademicCharacteristic(AcademicCharacteristic academicCharacteristic) throws SQLException;
	public void updateAcademicCharacteristic(AcademicCharacteristic academicCharacteristic) throws SQLException;
	public void deleteAcademicCharacteristic(int academicCharacteristicId) throws SQLException;
}
