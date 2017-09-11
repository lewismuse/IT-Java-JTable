import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class EmployeeTableModelDemo {
	public static void main(String[] args) {
		EmployeeTableModel employeeTableModel = new EmployeeTableModel();
		JTable employeeTable = new JTable(employeeTableModel);
		employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		employeeTable.setBorder(null);
		
		//int rowIndex = employeeTable.getSelectedRow();
		//if (rowIndex != -1 ) {
		//	Employee employee = employeeTableModel.getEmployee(rowIndex);
		//}
		
		JFrame frame = new JFrame("Employee Table");
		//frame.setSize(600, 400);
		
		JScrollPane scrollPane = new JScrollPane(employeeTable);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.add(scrollPane);
        JPanel buttonPanel = new JPanel();
		frame.pack();
		frame.setVisible(true);
	
	}
}
