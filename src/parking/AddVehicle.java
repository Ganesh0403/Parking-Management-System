package parking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.sql.*;
import java.util.Calendar;
import Jdbc.ConnectionProvider;
import java.awt.Color;

public class AddVehicle {

	private JFrame frame;
	private JTextField name_text;
	private JTextField phone_no_text;
	private JTextField vehicle_no_text;
	private JTextField entry_time_text;
	private JTextField entry_date_text;
	private static JTextField Parking_Id_text;
	public static boolean status;

	/**
	 * Launch the application.
	 */
	public void Search() {
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			int id;
			ResultSet rs = st.executeQuery("select max(parking_id) from parking");
			rs.next();
			rs.getString("Max(parking_id)");

			if (rs.getString("Max(parking_id)") == null) {
				Parking_Id_text.setText("1");
			} else {
				id = rs.getInt("Max(parking_id)");
				id++;
				String str = String.valueOf(id);
				Parking_Id_text.setText(str);

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}

	}

	public boolean AddVehicles(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
		if (!s1.equals("") && !s2.equals("") && !s3.equals("") && !s4.equals("") && !s4.equals("") && !s5.equals("")
				&& !s6.equals("") && !s7.equals("") && !s8.equals("")) {
			try {
				Connection con = ConnectionProvider.getCon();
				Statement st = con.createStatement();
				st.executeUpdate("insert into parking values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5
						+ "','" + s6 + "','" + s7 + "','" + s8 + "')");
				JOptionPane.showMessageDialog(null, "VEHICLE ADDED TO PARKING");
				con.close();
				return true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "VEHICLE NOT ADDEDs");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "PLEASE FILL ALL FIELDS");
			return false;
		}

	}

	public static void AddD() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehicle window = new AddVehicle();
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
	public AddVehicle() {
		initialize();
		// Search();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		// frame.getContentPane().setBackground(new Color(255, 228, 181));
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override

			public void componentShown(ComponentEvent e) {

			}
		});

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());

		frame.setBounds(100, 100, 550, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel Title = new JLabel("ADD VEHICLE");
		Title.setFont(new Font("Tahoma", Font.BOLD, 15));
		Title.setBounds(200, 11, 118, 25);
		frame.getContentPane().add(Title);

		JLabel Parking_Id_label = new JLabel("Parking ID");
		Parking_Id_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Parking_Id_label.setBounds(35, 58, 110, 14);
		frame.getContentPane().add(Parking_Id_label);

		Parking_Id_text = new JTextField();
		Parking_Id_text.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Parking_Id_text.setBounds(126, 56, 86, 20);
		frame.getContentPane().add(Parking_Id_text);
		Parking_Id_text.setColumns(10);

		JLabel Name_label = new JLabel("Name");
		Name_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Name_label.setBounds(35, 90, 110, 14);
		frame.getContentPane().add(Name_label);

		JLabel vehicle_no_label = new JLabel("Vehicle No");
		vehicle_no_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		vehicle_no_label.setBounds(280, 90, 110, 14);
		frame.getContentPane().add(vehicle_no_label);

		JLabel payment_mode_label = new JLabel("Payment Mode");
		payment_mode_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		payment_mode_label.setBounds(35, 155, 110, 14);
		frame.getContentPane().add(payment_mode_label);

		JLabel entry_date_label = new JLabel("Entry Date");
		entry_date_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		entry_date_label.setBounds(280, 155, 110, 14);
		frame.getContentPane().add(entry_date_label);

		JLabel hours_parked_label = new JLabel("Hours Parked");
		hours_parked_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		hours_parked_label.setBounds(35, 123, 110, 14);
		frame.getContentPane().add(hours_parked_label);

		JLabel Entry_time_label = new JLabel("Entry Time");
		Entry_time_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Entry_time_label.setBounds(280, 123, 110, 14);
		frame.getContentPane().add(Entry_time_label);

		JLabel phone_no_label = new JLabel("Phone No");
		phone_no_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phone_no_label.setBounds(35, 190, 110, 14);
		frame.getContentPane().add(phone_no_label);

		String[] payment_modes = { "NetBanking", "UPI", "Cash" };
		JComboBox<String> payment_modes_comboBox = new JComboBox<String>(payment_modes);
		payment_modes_comboBox.setToolTipText("");
		payment_modes_comboBox.setBounds(126, 152, 110, 22);
		frame.getContentPane().add(payment_modes_comboBox);

		String[] hours_parked = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24" };
		JComboBox<String> hours_parked_comboBox = new JComboBox<String>(hours_parked);
		hours_parked_comboBox.setToolTipText("");
		hours_parked_comboBox.setBounds(126, 121, 110, 22);
		frame.getContentPane().add(hours_parked_comboBox);

		name_text = new JTextField();
		name_text.setBounds(126, 88, 110, 20);
		frame.getContentPane().add(name_text);
		name_text.setColumns(10);

		phone_no_text = new JTextField();
		phone_no_text.setBounds(126, 188, 110, 20);
		frame.getContentPane().add(phone_no_text);
		phone_no_text.setColumns(10);

		vehicle_no_text = new JTextField();
		vehicle_no_text.setBounds(370, 88, 110, 20);
		frame.getContentPane().add(vehicle_no_text);
		vehicle_no_text.setColumns(10);

		entry_time_text = new JTextField();
		entry_time_text.setBounds(370, 121, 110, 20);
		entry_time_text.setEditable(false);
		entry_time_text.setText(sqlTime.toString());
		frame.getContentPane().add(entry_time_text);
		entry_time_text.setColumns(10);

		entry_date_text = new JTextField();
		entry_date_text.setBounds(370, 153, 110, 20);
		entry_date_text.setEditable(false);
		entry_date_text.setText(sqlDate.toString());
		frame.getContentPane().add(entry_date_text);
		entry_date_text.setColumns(10);

		JButton searchButton = new JButton("SEARCH");
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// SEARCH
				String id = Parking_Id_text.getText();
				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from parking where parking_id='" + id + "' ");
					if (rs.next()) {

						searchButton.setText("DELETE");
						Parking_Id_text.setText(rs.getString(1));
						name_text.setText(rs.getString(2));
						vehicle_no_text.setText(rs.getString(3));
						entry_time_text.setText(rs.getString(4));
						entry_date_text.setText(rs.getString(5));
						payment_modes_comboBox.setSelectedItem(rs.getString(6));
						hours_parked_comboBox.setSelectedItem(rs.getString(7));
						phone_no_text.setText(rs.getString(8));

						Parking_Id_text.setEditable(false);
						name_text.setEditable(false);
						vehicle_no_text.setEditable(false);
						entry_time_text.setEditable(false);
						entry_date_text.setEditable(false);
						payment_modes_comboBox.setEnabled(false);
						hours_parked_comboBox.setEnabled(false);
						phone_no_text.setEditable(false);

						searchButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								String id = Parking_Id_text.getText();
								try {
									Connection con = ConnectionProvider.getCon();
									Statement st = con.createStatement();

									String parking_id = Parking_Id_text.getText();
									String person_name = name_text.getText();
									String vehicle_num = vehicle_no_text.getText();
									String time_of_entry = entry_time_text.getText();
									String date_of_entry = entry_date_text.getText();
									String payment_method = (String) payment_modes_comboBox.getSelectedItem();
									String hours_parked = (String) hours_parked_comboBox.getSelectedItem();
									String phone_num = phone_no_text.getText();

									try {
										Connection con1 = ConnectionProvider.getCon();
										Statement st1 = con1.createStatement();
										st1.executeUpdate("insert into history values('" + parking_id + "','"
												+ person_name + "','" + vehicle_num + "','" + time_of_entry + "','"
												+ date_of_entry + "','" + payment_method + "','" + hours_parked + "','"
												+ phone_num + "')");

										JOptionPane.showMessageDialog(null, "TRANSACTION ADDED");

									} catch (Exception e) {
										JOptionPane.showMessageDialog(null, "TRANSACTION ADDITON FAILED");
										return;
									}

									int del_rs = st.executeUpdate("delete from parking where parking_id='" + id + "' ");

									if (del_rs > 0) {
										JOptionPane.showMessageDialog(null, "DELETED");
										searchButton.setText("SEARCH");
										name_text.setText("");
										vehicle_no_text.setText("");
										entry_time_text.setText(sqlTime.toString());
										entry_date_text.setText(sqlDate.toString());
										payment_modes_comboBox.setSelectedItem("");
										hours_parked_comboBox.setSelectedItem("");
										phone_no_text.setText("");
									}
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, "DELETION FAILED");
									return;
								}
							}
						});

					} else {
						JOptionPane.showMessageDialog(null, "PARKING IS EMPTY");
						searchButton.setText("SEARCH");
						name_text.setText("");
						vehicle_no_text.setText("");
						entry_time_text.setText(sqlTime.toString());
						entry_date_text.setText(sqlDate.toString());
						payment_modes_comboBox.setSelectedItem("");
						hours_parked_comboBox.setSelectedItem("");
						phone_no_text.setText("");

						Parking_Id_text.setEditable(true);
						name_text.setEditable(true);
						vehicle_no_text.setEditable(true);
						payment_modes_comboBox.setEnabled(true);
						hours_parked_comboBox.setEnabled(true);
						phone_no_text.setEditable(true);

					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);

				}

			}
		});
		searchButton.setBounds(256, 55, 89, 23);
		frame.getContentPane().add(searchButton);

		JButton close_button = new JButton("CLOSE");
		close_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// CLOSE
				frame.setVisible(false);
			}
		});
		close_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		close_button.setBounds(225, 239, 89, 23);
		frame.getContentPane().add(close_button);

		JButton back_button = new JButton("BACK");
		back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// BACK
				HomePage.Home();
				frame.dispose();
			}
		});

		back_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		back_button.setBounds(350, 239, 89, 23);
		frame.getContentPane().add(back_button);

		JButton save_button = new JButton("SAVE");
		save_button.setFont(new Font("Tahoma", Font.BOLD, 13));
		save_button.setBounds(100, 239, 89, 23);
		frame.getContentPane().add(save_button);

		save_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// SAVE
				String parking_id = Parking_Id_text.getText();
				String person_name = name_text.getText();
				String vehicle_num = vehicle_no_text.getText();
				String time_of_entry = entry_time_text.getText();
				String date_of_entry = entry_date_text.getText();
				String payment_method = (String) payment_modes_comboBox.getSelectedItem();
				String hours_parked = (String) hours_parked_comboBox.getSelectedItem();
				String phone_num = phone_no_text.getText();

				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into parking values('" + parking_id + "','" + person_name + "','"
							+ vehicle_num + "','" + time_of_entry + "','" + date_of_entry + "','" + payment_method
							+ "','" + hours_parked + "','" + phone_num + "')");
					JOptionPane.showMessageDialog(null, "VEHICLE ADDED TO PARKING");
					frame.setVisible(false);
					new AddVehicle().frame.setVisible(true);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}

}
