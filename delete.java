package travel;
import javax.swing.*;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class delete {
private static JTextField atdelete;
public static void show2() {
final JFrame f=new JFrame();
f.setTitle("TRAVEL AGENCY");
f.getContentPane().setBackground(new Color(240, 248, 255));
f.setSize(500,500);
f.getContentPane().setLayout(null);
JLabel adelete = new JLabel("ENTER THE TOUR CODE WHICH IS TO BE DELETED");
adelete.setFont(new Font("Tahoma", Font.BOLD, 16));
adelete.setHorizontalAlignment(SwingConstants.CENTER);
adelete.setBounds(10, 149, 466, 57);
f.getContentPane().add(adelete);
atdelete = new JTextField();
atdelete.setBounds(101, 243, 267, 28);
f.getContentPane().add(atdelete);
atdelete.setColumns(10);
JButton adelesub = new JButton("SUBMIT");
adelesub.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String name=String.valueOf(atdelete.getText());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","Bhuvanesh@172629");
			System.out.println("deleting");
			System.out.println(name);
			PreparedStatement st = con.prepareStatement("DELETE FROM packages WHERE code = ?");
			st.setString(1,name);
			st.executeUpdate(); 

			
			
		}catch(Exception e1) {
			System.out.println(e1);
		}
	}
});
adelesub.setFont(new Font("Tahoma", Font.BOLD, 18));
adelesub.setBounds(174, 326, 126, 40);
f.getContentPane().add(adelesub);
JButton btnNewButton = new JButton("BACK");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		add.show();
		f.setVisible(false);
	}
});
btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
btnNewButton.setBounds(33, 23, 134, 40);
f.getContentPane().add(btnNewButton);
f.setVisible(true);
}
public static void main(String[] args) {
show2();
}
}