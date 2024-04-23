package travel;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class option {
public static void show() {
final JFrame f=new JFrame();
f.setTitle("TRAVEL AGENCY");
f.getContentPane().setBackground(new Color(240, 248, 255));
f.setSize(500,500);
f.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("CHOOSE YOUR ROLE");
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
lblNewLabel.setBounds(110, 58, 263, 36);
f.getContentPane().add(lblNewLabel);
JButton ainsert = new JButton("ADMIN");
ainsert.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		adn_log.show();
		f.setVisible(false);
	}
});
ainsert.setFont(new Font("Tahoma", Font.BOLD, 18));
ainsert.setBounds(167, 152, 134, 36);
f.getContentPane().add(ainsert);
JButton adel = new JButton("USER");
adel.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		front.show();
		f.setVisible(false);
	}
});
adel.setFont(new Font("Tahoma", Font.BOLD, 18));
adel.setBounds(167, 236, 138, 36);
f.getContentPane().add(adel);
f.setVisible(true);
}
public static void main(String[] args) {
show();

}
}