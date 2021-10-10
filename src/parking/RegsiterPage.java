package parking;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Jdbc.ConnectionProvider;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegsiterPage {

	private JFrame frame;
	private JTextField ftextField;
	private JTextField dtextField_1;
	private JTextField ctextField_2;
	private JTextField etextField_3;
	private JTextField ltextField_4;
	private JTextField gtextField_5;
	private JTextField ptextField_6;
	private JTextField utextField_7;
	private JPasswordField passwordField;
	public static boolean status1;


	/**
	 * Launch the application.
	 */
	
	public static void Register() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegsiterPage window = new RegsiterPage();
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
	public RegsiterPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 228, 181));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setBounds(100, 100, 565, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(223, 11, 113, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(54, 60, 113, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(279, 60, 80, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DOB");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(54, 136, 72, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(279, 136, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Number");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(279, 173, 95, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("City");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(54, 174, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email Id");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(54, 212, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		ftextField = new JTextField();
		ftextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ftextField.setBounds(141, 58, 86, 20);
		frame.getContentPane().add(ftextField);
		ftextField.setColumns(10);
		
		dtextField_1 = new JTextField();
		dtextField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtextField_1.setBounds(141, 134, 86, 20);
		frame.getContentPane().add(dtextField_1);
		dtextField_1.setColumns(10);
		
		ctextField_2 = new JTextField();
		ctextField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ctextField_2.setBounds(141, 171, 86, 20);
		frame.getContentPane().add(ctextField_2);
		ctextField_2.setColumns(10);
		
		etextField_3 = new JTextField();
		etextField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etextField_3.setBounds(141, 210, 86, 20);
		frame.getContentPane().add(etextField_3);
		etextField_3.setColumns(10);
		
		ltextField_4 = new JTextField();
		ltextField_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ltextField_4.setBounds(369, 60, 86, 20);
		frame.getContentPane().add(ltextField_4);
		ltextField_4.setColumns(10);
		
		gtextField_5 = new JTextField();
		gtextField_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gtextField_5.setBounds(369, 136, 86, 20);
		frame.getContentPane().add(gtextField_5);
		gtextField_5.setColumns(10);
		
		ptextField_6 = new JTextField();
		ptextField_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ptextField_6.setBounds(369, 173, 86, 20);
		frame.getContentPane().add(ptextField_6);
		ptextField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Username");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(54, 97, 88, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Password");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(279, 97, 80, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		utextField_7 = new JTextField();
		utextField_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		utextField_7.setBounds(141, 94, 86, 20);
		frame.getContentPane().add(utextField_7);
		utextField_7.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(369, 95, 88, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//SUBMIT
				boolean result;
				
				String fname = ftextField.getText();
				String lname = ltextField_4.getText();
				String uname = utextField_7.getText();
				String pass = passwordField.getText();
				String dob =dtextField_1.getText();
				String gender =gtextField_5.getText();
				String city =ctextField_2.getText();
				String phone =ptextField_6.getText();
				String email =etextField_3.getText();
		if(!fname.equals("") && !lname.equals("") && !uname.equals("") && !pass.equals("") && !dob.equals("") && !gender.equals(""))
		{
				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();		
					st.executeUpdate("insert into register values('"+fname+"','"+lname+"','"+uname+"','"+pass+"','"+dob+"','"+gender+"','"+city+"','"+phone+"','"+email+"')");
					st.executeUpdate("insert into Login values('"+uname+"','"+pass+"')");
					JOptionPane.showMessageDialog(null, "SUCESSFULLY REGISTERD");
					LoginPage.Login();
					frame.dispose();
					con.close();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}	
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "PLEASE ENTER DATA");
		}
		
		}
			
		});
		btnNewButton.setBounds(223, 260, 113, 33);
		frame.getContentPane().add(btnNewButton);
	}
	
	
	public static boolean regactivity(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9)
	{
		String name = "";
		String email = "";
		if(!s1.equals("") && !s2.equals("") && !s3.equals("") && !s4.equals("") && !s5.equals("") && !s6.equals(""))
		{
			try {
				Connection con = ConnectionProvider.getCon();
				Statement st = con.createStatement();		
				st.executeUpdate("insert into register values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"')");
				st.executeUpdate("insert into Login values('"+s3+"','"+s4+"')");
				JOptionPane.showMessageDialog(null, "SUCESSFULLY REGISTERD");
				con.close();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}	
			
			try {
				Connection con = ConnectionProvider.getCon();
				Statement st = con.createStatement();		
				String sql = "Select uname,email from register where uname='"+s3+"' and email='"+s9+"' ";
				ResultSet rs=st.executeQuery(sql);
				while(rs.next())  
				{
					name = rs.getString(1);
					email = rs.getString(2);
				}
				
				con.close();
				
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null, ee);
			}	
		}
		if(s3.equals(name) && s9.equals(email))
		{
			status1 = true;
		}
		else
		{
			status1 = false;
		}
		return status1;
  }
}
