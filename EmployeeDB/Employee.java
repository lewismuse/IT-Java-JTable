
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	private String dob;
	private int territoryId;
	private int addressId;
	
	public Employee() {
	}
	
	public void setEmployeeId(int id) {
		this.employeeId = id;
	}
	public int getEmployeeId() {
		return this.employeeId;
	}
	
	public void setEmployeeFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmployeeFirstName() {
		return this.firstName;
	}
	
	public void setEmployeeLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmployeeLastName() {
		return this.lastName;
	}
	
	public void setEmployeeSalary(Double salary) {
		this.salary = salary;
	}
	public Double getEmployeeSalary() {
		return this.salary;
	}
	
	public void setEmployeeDob(String dob) {
		this.dob = dob;
	}
	public String getEmployeeDob() {
		return this.dob;
	}
	
	public void setEmployeeTerritoryId(int territoryId) {
		this.territoryId = territoryId;
	}
	public int getEmployeeTerritoryId() {
		return this.territoryId;
	}
	
	public void setEmployeeAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getEmployeeAddressId() {
		return this.addressId;
	}
}
