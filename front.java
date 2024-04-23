package travel;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class front {
	public static void show() {
		final JFrame f=new JFrame();
		f.setSize(500,500);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		JLabel lblNewLabel = new JLabel("EB TRAVEL AGENCY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(124, 29, 221, 60);
		f.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				login q=new login();
				q.show();
			}
		});
		btnNewButton.setBounds(195, 151, 114, 38);
		f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				login1.show();
			}
		});
		btnNewButton_1.setBounds(195, 224, 114, 38);
		f.getContentPane().add(btnNewButton_1);
	}
	public static void main(String[] args) {
		show();

	}
}
