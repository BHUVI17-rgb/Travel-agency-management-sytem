package travel;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class add_page{
private static JTextField textField;
private static JTextField textField_1;
private static JTextField textField_2;
private static JTextField textField_3;
private static JTextField textField_4;
public static void show1() {
final JFrame f=new JFrame();
f.setTitle("TRAVEL AGENCY");
f.getContentPane().setBackground(new Color(240, 248, 255));
f.setSize(500,500);
f.getContentPane().setLayout(null);
JLabel na = new JLabel("NAME");
na.setBackground(Color.BLUE);
na.setHorizontalAlignment(SwingConstants.CENTER);
na.setFont(new Font("Tahoma", Font.BOLD, 18));
na.setBounds(44, 58, 103, 29);
f.getContentPane().add(na);
textField = new JTextField();
textField.setBounds(180, 56, 264, 29);
f.getContentPane().add(textField);
textField.setColumns(10);
JLabel day = new JLabel("DAY");
day.setHorizontalAlignment(SwingConstants.CENTER);
day.setFont(new Font("Tahoma", Font.BOLD, 18));
day.setBounds(44, 132, 103, 29);
f.getContentPane().add(day);
textField_1 = new JTextField();
textField_1.setBounds(180, 135, 264, 29);
f.getContentPane().add(textField_1);
textField_1.setColumns(10);
JLabel desc = new JLabel("DESCRIPTION");
desc.setHorizontalAlignment(SwingConstants.CENTER);
desc.setFont(new Font("Tahoma", Font.BOLD, 18));
desc.setBounds(23, 210, 141, 29);
f.getContentPane().add(desc);
textField_2 = new JTextField();
textField_2.setBounds(180, 218, 276, 56);
f.getContentPane().add(textField_2);
textField_2.setColumns(10);
JLabel price = new JLabel("PRICE");
price.setFont(new Font("Tahoma", Font.BOLD, 18));
price.setHorizontalAlignment(SwingConstants.CENTER);
price.setBounds(47, 306, 100, 29);
f.getContentPane().add(price);
textField_3 = new JTextField();
textField_3.setBounds(180, 309, 170, 29);
f.getContentPane().add(textField_3);
textField_3.setColumns(10);

textField_4 = new JTextField();
textField_4.setBounds(184, 378, 170, 19);
f.getContentPane().add(textField_4);
textField_4.setColumns(10);
f.setVisible(true);

JButton sudm = new JButton("SUBMIT");
sudm.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String name=String.valueOf(textField.getText());
		String day=String.valueOf(textField_1.getText());
		String description=String.valueOf(textField_2.getText());
		String price=String.valueOf(textField_3.getText());
		String code=String.valueOf(textField_4.getText());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","Bhuvanesh@172629");
			System.out.println("Inserting records");
			System.out.println(name+day+description+price);
			String sql="Insert into packages (name,day,description,price,code) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, day);
			ps.setString(3, description);
			ps.setString(4, price);
			ps.setString(5, code);
			ps.execute();
		}catch(Exception e1) {
			System.out.println(e1);
		}
	}
});
sudm.setFont(new Font("Tahoma", Font.BOLD, 18));
sudm.setBounds(170, 407, 110, 33);
f.getContentPane().add(sudm);
JButton btnNewButton = new JButton("BACK");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		add.show();
		f.setVisible(false);
	}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
btnNewButton.setBounds(32, 10, 115, 38);
f.getContentPane().add(btnNewButton);
JLabel lblNewLabel = new JLabel("CODE");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setBounds(47, 369, 85, 29);
f.getContentPane().add(lblNewLabel);

}
public static void main(String[] args) {
show1();
}
}