package travel;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class data {
private static JTextField atpass;
private static JTextField textField;
private static JTextField textField_1;
public static void show() {
final JFrame f=new JFrame();
f.setTitle("TRAVEL AGENCY");
f.getContentPane().setBackground(new Color(240, 248, 255));
f.setSize(500,500);
f.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("PLEASE ENTER THE FOLLOWING DETAILS TO CONFIRM YOUR BOOKING");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setBounds(23, 55, 453, 51);
f.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("PH NO");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setBounds(69, 169, 97, 33);
f.getContentPane().add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("CODE");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_2.setBounds(69, 253, 97, 33);
f.getContentPane().add(lblNewLabel_2);
textField = new JTextField();
textField.setBounds(194, 178, 113, 24);
f.getContentPane().add(textField);
textField.setColumns(10);
textField_1 = new JTextField();
textField_1.setBounds(194, 253, 113, 24);
f.getContentPane().add(textField_1);
textField_1.setColumns(10);
JButton btnNewButton = new JButton("SUBMIT");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String phno=String.valueOf(textField.getText());
		String code=String.valueOf(textField_1.getText());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","Bhuvanesh@172629");
			System.out.println("Inserting records");
			System.out.println(phno+code);
			String sql="Insert into orders (phno,code) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, phno);
			ps.setString(2, code);
			ps.execute();
		}catch(Exception e1) {
			System.out.println(e1);
		}
	}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
btnNewButton.setBounds(180, 336, 104, 33);
f.getContentPane().add(btnNewButton);
f.setVisible(true);

}
public static void main(String[] args) {
show();
}
}