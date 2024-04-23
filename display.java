package travel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class display{
static JFrame frame;
static JFrame frame1;
JTextField textbox;
JLabel label;
JButton button;
JPanel panel;
static JTable table;

static String driverName = "com.mysql.jdbc.Driver";
static String url = "jdbc:mysql://localhost:3306/admin";
static String userName = "root";
static String password = "Bhuvanesh@172629";
static String[] columnNames = {"Name", "Day", "Description", "Price", "Code"};

public static void createUI()
{
frame = new JFrame("Database Search Result");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(null);
frame.setVisible(true);
frame.setSize(500, 400); 
JButton btnNewButton = new JButton("NEXT");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		data.show();
		frame.setVisible(false);
	}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
btnNewButton.setBounds(32, 10, 115, 38);
frame.getContentPane().add(btnNewButton);
} 


public static void showTableData()
{

frame1 = new JFrame("Database Search Result");
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame1.setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
String name = "";
String day= "";
String description= "";
int salary;
int code;
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection(url, userName, password);
String sql = "select * from packages";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
while(rs.next())
{
name = rs.getString("name");
day = rs.getString("day");
description= rs.getString("description");
salary = rs.getInt("price"); 
code=rs.getInt("code");
model.addRow(new Object[]{name, day, description, salary, code});
i++; 
}
if(i <1)
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
	JOptionPane.showMessageDialog(null, "PLEASE NOTE THE CODE THAT WAS WRITTEN TO THE TOUR",
			"SUCCESS", JOptionPane.ERROR_MESSAGE);
}
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
frame1.add(scroll);
frame1.setVisible(true);
frame1.setSize(400,300);
}

public static void main(String args[])
{ 
}
}