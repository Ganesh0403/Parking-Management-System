package parking;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import Jdbc.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.Color;

public class AllTransactions {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void all() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllTransactions window = new AllTransactions();
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
	public AllTransactions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		// frame.getContentPane().setBackground(new Color(255, 228, 181));
		frame.setBounds(100, 100, 568, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ALL TRANSACTIONS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(150, 11, 250, 23);
		frame.getContentPane().add(lblNewLabel);

		try {
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt = con.prepareStatement("select * from history");

			ResultSet rs = stmt.executeQuery();
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 45, 532, 205);
			frame.getContentPane().add(scrollPane);

			table = new JTable();
			scrollPane.setViewportView(table);

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage.Home();
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(109, 281, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("CLOSE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.setVisible(false);

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(344, 281, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

	}
}
