package travel;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class add {
public static void show() {
final JFrame f=new JFrame();
f.setTitle("TRAVEL AGENCY");
f.getContentPane().setBackground(new Color(240, 248, 255));
f.setSize(500,500);
f.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("ADMIN");
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
lblNewLabel.setBounds(154, 58, 151, 36);
f.getContentPane().add(lblNewLabel);
JButton ainsert = new JButton("ADD");
ainsert.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		add_page.show1();
		f.setVisible(false);
	}
});
ainsert.setFont(new Font("Tahoma", Font.BOLD, 18));
ainsert.setBounds(167, 152, 134, 36);
f.getContentPane().add(ainsert);
JButton adel = new JButton("DELETE");
adel.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		delete.show2();
		f.setVisible(false);
	}
});
adel.setFont(new Font("Tahoma", Font.BOLD, 18));
adel.setBounds(167, 236, 138, 36);
f.getContentPane().add(adel);
JButton aorder = new JButton("ORDERS");
aorder.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		orders.createUI(); 
		orders.showTableData();
	}
});
aorder.setFont(new Font("Tahoma", Font.BOLD, 18));
aorder.setBounds(172, 326, 133, 36);
f.getContentPane().add(aorder);
f.setVisible(true);
}
public static void main(String[] args) {
show();

}
}