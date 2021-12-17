import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Ajouter {

	private JFrame frame;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtemail;
	private JTextField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajouter window = new Ajouter();
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
	public Ajouter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom:");
		lblNewLabel.setBounds(34, 46, 68, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom:");
		lblNewLabel_1.setBounds(34, 96, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(39, 154, 63, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mot de Passe:");
		lblNewLabel_3.setBounds(34, 219, 83, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Genre:");
		lblNewLabel_4.setBounds(39, 278, 63, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtnom = new JTextField();
		txtnom.setBounds(151, 43, 301, 20);
		frame.getContentPane().add(txtnom);
		txtnom.setColumns(10);
		
		txtprenom = new JTextField();
		txtprenom.setBounds(151, 93, 301, 20);
		frame.getContentPane().add(txtprenom);
		txtprenom.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(151, 151, 301, 20);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setBounds(151, 216, 301, 20);
		frame.getContentPane().add(txtpass);
		txtpass.setColumns(10);
		
		JComboBox comgenr = new JComboBox();
		comgenr.setModel(new DefaultComboBoxModel(new String[] {"", "Femme", "Homme"}));
		comgenr.setBounds(151, 274, 301, 22);
		frame.getContentPane().add(comgenr);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into personne values(?,?,?,?,?)";
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "meryem");
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, txtnom.getText());
					pst.setString(2, txtprenom.getText());
					pst.setString(3, txtemail.getText());
					pst.setString(4, txtpass.getText());
					pst.setString(5, comgenr.getSelectedItem().toString());
					pst.executeUpdate();
					
					JOptionPane.showInternalMessageDialog(null, "SUCCESSFULL");
		}catch(Exception ex) {
			JOptionPane.showInternalMessageDialog(null, ex);
		}
			
		}});
		btnNewButton.setBounds(383, 340, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Ajouter des Personnes");
		lblNewLabel_5.setBounds(185, 11, 149, 20);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
