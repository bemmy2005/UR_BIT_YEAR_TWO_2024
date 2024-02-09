package com.ourform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainForm implements ActionListener {
	JFrame frame;
	JMenu home, user, role, userrole, more;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,userDelete,userUpdate,userRead;

	MainForm() {
		createWindow();
		componentsOnFrame();
		addactionEvent();
	}

	private void addactionEvent() {
		userRead.addActionListener(this);

	}

	private void componentsOnFrame() {
		home = new JMenu("Home");
		user = new JMenu("User");
		role = new JMenu("Role");
		userrole = new JMenu("User Role");
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		user.add(i2);
		user.add(i3);
		user.add(i4);
		role.add(i2);
		role.add(i3);
		role.add(i4);
		userrole.add(i2);
		userrole.add(i3);
		userrole.add(i4);
	}

	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		user = new JMenu("User");
		role = new JMenu("Role");
		userrole = new JMenu("User Role");

		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		userRead = new JMenuItem("User Read");
		userUpdate = new JMenuItem("User Update");
		userDelete = new JMenuItem("User Delete");
		user.add(userRead);
		user.add(userUpdate);
		user.add(userDelete);

		JMenuItem roleRead = new JMenuItem("Role Read");
		JMenuItem roleUpdate = new JMenuItem("Role Update");
		JMenuItem roleDelete = new JMenuItem("Role Delete");
		role.add(roleRead);
		role.add(roleUpdate);
		role.add(roleDelete);

		userrole.add(i2);
		userrole.add(i3);
		userrole.add(i4);

		mb.add(home);
		mb.add(user);
		mb.add(role);
		mb.add(userrole);

		frame.setJMenuBar(mb); // Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==userRead) {
			UserForm userForm=new UserForm();
			frame.dispose();
		}
	}

	public static void main(String[] args) {
		new MainForm();
	}
}
