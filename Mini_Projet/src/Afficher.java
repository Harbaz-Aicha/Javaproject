import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Afficher {

	private JFrame frame;
	private JTextField txtemail;
	private JTextField txtpass;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Afficher window = new Afficher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Afficher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 596, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-mail:");
		lblNewLabel.setBounds(39, 75, 91, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de Passe:");
		lblNewLabel_1.setBounds(39, 226, 91, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtemail = new JTextField();
		txtemail.setBounds(216, 72, 269, 20);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setBounds(216, 223, 269, 20);
		frame.getContentPane().add(txtpass);
		txtpass.setColumns(10);
		
		btnNewButton = new JButton("Afficher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "meryem");
					java.sql.Statement st= conn.createStatement();
					ResultSet rs = st.executeQuery("select * from personne where email='"+txtemail.getText()+"'and motpass='"+txtpass.getText()+"'");
					if(rs.next()) {
						String nom=rs.getString(1);
						String prenom=rs.getString(2);
						JOptionPane.showMessageDialog(null,"le nom est : " + nom +"   le prenom est : " + prenom );
					}
					else {
						JOptionPane.showMessageDialog(null,"Invalid UserName and Password....!");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex);
			}
	
			}
		});
		btnNewButton.setBounds(446, 316, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Afficher les Information des personnes");
		lblNewLabel_2.setBounds(136, 11, 228, 14);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
