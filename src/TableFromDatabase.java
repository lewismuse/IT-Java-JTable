
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;



@SuppressWarnings("serial")
public class TableFromDatabase extends JFrame {

    public TableFromDatabase() {
    
        Vector<Object> columnNames = new Vector<>();
        Vector<Object> data = new Vector<>();

        try
        {
          
        		//  Change username and password per user
        	    // Added disable SSL link
        		String dbURL = "jdbc:mysql://localhost:3306/mysqltest1?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "";

            Connection connection = DriverManager.getConnection( dbURL, username, password );

            //  Read data from a table

            String sql = "Select * from Employee";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }

            //  Get row data

            while (rs.next())
            {
                Vector<Object> row = new Vector<>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Create table with database data

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        
        	@Override
            public Class getColumnClass(int column) {
            
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

		JTable table = new JTable( model );
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
    }
 
    // main 
    
    public static void main(String[] args) {
    
        TableFromDatabase frame = new TableFromDatabase();
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}