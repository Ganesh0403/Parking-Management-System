package parking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import Jdbc.ConnectionProvider;

import java.sql.*;

public class LoginPage {

	private static JFrame frame;
	private JTextField uname;
	private JPasswordField passwordField;
	public static boolean status;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void Login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		// this.setLocationRelativeTo(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setBounds(100, 100, 394, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("LOGIN ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(160, 27, 89, 20);
		frame.getContentPane().add(lblNewLabel);

		uname = new JTextField();
		uname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		uname.setBounds(197, 77, 86, 20);
		frame.getContentPane().add(uname);
		uname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(83, 80, 69, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBackground(Color.CYAN);
		lblNewLabel_2.setBounds(83, 122, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(197, 119, 86, 20);
		frame.getContentPane().add(passwordField);

		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// LOGIN BUTTON
				/*
				 * if(e.getSource()==btnNewButton_1) { String s1 = uname.getText(); String s2 =
				 * passwordField.getText().toString(); loginactivity(s1,s2); }
				 */
				try {

					String s1 = uname.getText();
					String s2 = passwordField.getText().toString();
					if (loginactivity(s1, s2) == true) {
						HomePage.Home();
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Credentials");
					}

				} catch (Exception exe) {
					System.out.print(exe);
				}

			}
		});
		btnNewButton_1.setBounds(83, 175, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

	}

	public boolean loginactivity(String s1, String s2) {

		try {

			if (s1.equals("admin") && s2.equals("admin")) {
				JOptionPane.showMessageDialog(null, "Login Sucessfull!!");
				return true;
			} else {
				if (s1.equals("") && s2.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Username and Password");
				} else if (s2.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Password");
				} else if (s1.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter Username");
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Username and password");
				}

				return false;
			}

		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

}
