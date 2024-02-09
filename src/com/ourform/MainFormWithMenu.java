package com.ourform;


import javax.swing.*;
import java.awt.event.*;

public class MainFormWithMenu implements ActionListener {
	JFrame frame;
	JMenu home, user, role, userrole;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2;

	MainFormWithMenu() {
		createWindow();
		componentsOnFrame();
	}

	private void componentsOnFrame() {
		// Define menu items and menus here as before
	}

	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		user = new JMenu("User");
		role = new JMenu("Role");
		userrole = new JMenu("User Role");

		// Create menu items
		JMenuItem userRead = new JMenuItem("User Read");
		JMenuItem userUpdate = new JMenuItem("User Update");
		JMenuItem userDelete = new JMenuItem("User Delete");

		// Add action listener to userRead menu item
		userRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open the user form here
				openUserForm();
			}
		});

		// Add menu items to user menu
		user.add(userRead);
		user.add(userUpdate);
		user.add(userDelete);

		// Add menus to menu bar
		mb.add(home);
		mb.add(user);
		mb.add(role);
		mb.add(userrole);

		// Set the menu bar to the frame
		frame.setJMenuBar(mb);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Method to open user form
	private void openUserForm() {
		// Implement logic to open the user form here
		// For example:
		UserForm userForm=new UserForm();
		//UserForm userForm = new UserForm();
		//userForm.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		new MainForm();
	}
}


