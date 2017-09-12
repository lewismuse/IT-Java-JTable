import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel {
	private List<Employee> employees;
	private final String[] COLUMN_NAMES = {"Employee Id", "First Name", "Last Name", "Salary", "Date of Birth", "TerritoryID", "AddressID"};
	
	public EmployeeTableModel() {
		try {
			employees = EmployeeDB.getAll();
		} catch (DBException e) {
			System.out.println(e);
		}
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return employees.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLUMN_NAMES.length;
	}

	public String getColumnName(int columnIndex) {
		return COLUMN_NAMES[columnIndex];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0:
			return employees.get(rowIndex).getEmployeeId();
		case 1:
			return employees.get(rowIndex).getEmployeeFirstName();
		case 2:
			return employees.get(rowIndex).getEmployeeLastName();
		case 3:
			return employees.get(rowIndex).getEmployeeSalary();
		case 4:
			return employees.get(rowIndex).getEmployeeDob();
		case 5:
			return employees.get(rowIndex).getEmployeeTerritoryId();
		case 6:
			return employees.get(rowIndex).getEmployeeAddressId();
		default:
			return null;		
		}
	
	}

	Employee getEmployee(int rowIndex) {
		return employees.get(rowIndex);
	}
	
	void databaseUpdated() {
		try {
			employees = EmployeeDB.getAll();
			fireTableDataChanged();
		} catch (DBException e) {
			System.out.println(e);
		}
	}
}
