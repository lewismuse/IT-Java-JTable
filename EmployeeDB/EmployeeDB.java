import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {
	public static List<Employee> getAll() throws DBException {
		String sql = "SELECT * FROM Employee ORDER BY employee_id";
		List<Employee> employees = new ArrayList<>();
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double salary = rs.getDouble("salary");
				String dob = rs.getString("dob");
				int territoryId = rs.getInt("territory_id");
				int addressId = rs.getInt("address_id");
				
				Employee emp = new Employee();
				emp.setEmployeeId(employeeId);
				emp.setEmployeeFirstName(firstName);
				emp.setEmployeeLastName(lastName);
				emp.setEmployeeSalary(salary);
				emp.setEmployeeDob(dob);
				emp.setEmployeeTerritoryId(territoryId);
				emp.setEmployeeAddressId(addressId);
				employees.add(emp);
				//System.out.println("creating emp " + employeeId + " " + firstName);

					
			}
			return employees;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}
}
