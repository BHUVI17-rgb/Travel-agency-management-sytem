
package travel;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class adn_log {
private static JTextField atname;
private static JTextField atpass;
public static void show() {
final JFrame f=new JFrame();
f.setTitle("TRAVEL AGENCY");
f.getContentPane().setBackground(new Color(240, 248, 255));
f.setSize(500,500);
f.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("ADMIN");
lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
lblNewLabel.setBounds(159, 58, 151, 36);
f.getContentPane().add(lblNewLabel);
JLabel aname = new JLabel("USERNAME : ");
aname.setFont(new Font("Tahoma", Font.BOLD, 18));
aname.setHorizontalAlignment(SwingConstants.CENTER);
aname.setBounds(57, 154, 140, 28);
f.getContentPane().add(aname);
JLabel apass = new JLabel("PASSWORD : ");
apass.setHorizontalAlignment(SwingConstants.CENTER);
apass.setFont(new Font("Tahoma", Font.BOLD, 18));
apass.setBounds(57, 240, 140, 28);
f.getContentPane().add(apass);
atname = new JTextField();
atname.setBounds(242, 154, 208, 36);
f.getContentPane().add(atname);
atname.setColumns(10);
atpass = new JTextField();
atpass.setBounds(242, 238, 208, 39);
atpass.setColumns(10);
atname.addKeyListener(new KeyAdapter() {
	@Override
	public void keyReleased(KeyEvent e) {
		if(atname.getText().contentEquals("csbet")) {
			f.getContentPane().add(atpass);
		}
	}
});


final JButton asub = new JButton("SUBMIT");
asub.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		add.show();
		f.setVisible(false);
	}
});
asub.setFont(new Font("Tahoma", Font.BOLD, 18));
asub.setBounds(179, 351, 115, 36);
f.getContentPane().add(asub);
f.setVisible(true);
asub.setEnabled(false);
atpass.addKeyListener(new KeyAdapter() {
	@Override
	public void keyReleased(KeyEvent e) {
		if(atpass.getText().contentEquals("csbet_1720")) {
			asub.setEnabled(true);
		}
	}
});

}
public static void main(String[] args) {
show();
}
}