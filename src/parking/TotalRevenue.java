package parking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import Jdbc.ConnectionProvider;

import javax.swing.JTextField;
import java.awt.Color;

public class TotalRevenue {

	private JFrame frame;
	private JTextField Fees_per_hour_text;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void all() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalRevenue window = new TotalRevenue();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int getTotalRevenue(Integer Fees_per_hour_text) {
		try {
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt = con.prepareStatement("select sum(hours_parked) from history");
			PreparedStatement stmt1 = con.prepareStatement("select sum(hours_parked) from parking");

			ResultSet rs = stmt.executeQuery();
			ResultSet rs1 = stmt1.executeQuery();

			Integer total_hours = 0;
			while (rs.next()) {
				total_hours = rs.getInt(1);
			}
			while (rs1.next()) {
				total_hours += rs1.getInt(1);
			}

			JOptionPane.showMessageDialog(null, "Total Hours Parked: " + total_hours + " \n\n Total Amount Recieved:"
					+ total_hours * Fees_per_hour_text);
			return total_hours * Fees_per_hour_text;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return -1;
		}
	}

	/**
	 * Create the application.
	 */
	public TotalRevenue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		// frame.getContentPane().setBackground(new Color(255, 228, 196));
		frame.setBounds(100, 100, 510, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel Fees_per_hour_label = new JLabel("Enter Fees Per Hour");
		Fees_per_hour_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Fees_per_hour_label.setBounds(35, 60, 110, 22);
		frame.getContentPane().add(Fees_per_hour_label);

		Fees_per_hour_text = new JTextField();
		Fees_per_hour_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Fees_per_hour_text.setBounds(180, 60, 110, 22);
		frame.getContentPane().add(Fees_per_hour_text);
		Fees_per_hour_text.setColumns(10);

		JButton btnNewButton = new JButton("TOTAL AMOUNT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ALL DETAILS
				try {
					Connection con = ConnectionProvider.getCon();
					PreparedStatement stmt = con.prepareStatement("select sum(hours_parked) from history");
					PreparedStatement stmt1 = con.prepareStatement("select sum(hours_parked) from parking");

					ResultSet rs = stmt.executeQuery();
					ResultSet rs1 = stmt1.executeQuery();

					Integer total_hours = 0;
					while (rs.next()) {
						total_hours = rs.getInt(1);
					}
					while (rs1.next()) {
						total_hours += rs1.getInt(1);
					}

					JOptionPane.showMessageDialog(null,
							"Total Hours Parked: " + total_hours + " \n\n Total Amount Recieved:"
									+ total_hours * Integer.valueOf(Fees_per_hour_text.getText()));

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(150, 11, 250, 23);
		frame.getContentPane().add(btnNewButton);

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






























