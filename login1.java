package travel;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class login1 {
	public static String s;
	public static String pass;
	private static JTextField textField_1;
	private static JTextField textField_2;
	public static void show() {
		final JFrame f=new JFrame();
		f.setSize(500,500);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		JLabel lblNewLabel = new JLabel("User login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(155, 48, 173, 44);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("USER ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(64, 183, 87, 32);
		f.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(20, 373, 131, 32);
		f.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		
		textField_1.setBounds(257, 194, 131, 19);
		f.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(186, 384, 131, 19);
		f.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usid=String.valueOf(textField_1.getText());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/travel","root","Bhuvanesh@172629");
					System.out.println("Inserting records");
					System.out.println(pass+usid);
					String sql="Select password from login where usid=? ";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, usid);
					ResultSet rs=ps.executeQuery();
					rs.next();
				    s=rs.getString("password");
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(184, 271, 116, 32);
		f.getContentPane().add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(363, 383, 85, 21);
		f.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				front.show();
			}
		});
		btnNewButton_2.setBounds(33, 28, 99, 32);
		f.getContentPane().add(btnNewButton_2);
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textField_2.getText().contentEquals(s)) {
					btnNewButton_1.setEnabled(true);
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				display.createUI();
				display.showTableData();
				
			}
		});
		
	}
	public static void main(String[] args) {
		show();

	}
}
