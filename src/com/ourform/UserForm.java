package com.ourform;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.entities.User;

public class UserForm implements ActionListener{
	JFrame frame;

	JLabel userIDlb=new JLabel("User ID");
	JLabel usernamelb=new JLabel("Username");
	JLabel  passwordlb=new JLabel("Password");
	JLabel fnamelb=new JLabel("First name");
	JLabel  lnamelb=new JLabel("Last Name");
	JLabel email=new JLabel("Email");
	//Text field
	JTextField userIDtxf=new JTextField ();
	JTextField  usernametxf=new JTextField ();
	JPasswordField  passwordpsf=new JPasswordField();
	JTextField  fnametxf=new JTextField ();
	JTextField  lnametxf=new JTextField ();
	JTextField  emailtxf=new JTextField ();
	//buttons
	JButton loginButton=new JButton("Login");
	JButton resetButton=new JButton("Reset");
	JButton regButton=new JButton("Register");
	JButton redButton=new JButton("Display");
	JButton updButton=new JButton("Update");
	JButton delButton=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);

	public UserForm () {
		createwindow();
		SetlocationandSize();
		addcomponetToFrame();
		addActionEvent();


	}

	private void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		regButton.addActionListener(this);
		redButton.addActionListener(this);
		updButton.addActionListener(this);
		delButton.addActionListener(this);

	}


	private void addcomponetToFrame() {
		frame.add(userIDlb);
		frame.add(usernamelb);
		frame.add(passwordlb);
		frame.add(fnamelb);
		frame.add(lnamelb);
		frame.add(email);
		//Text field
		frame.add(userIDtxf);
		frame.add(usernametxf);
		frame.add(passwordpsf);
		frame.add(fnametxf);
		frame.add(lnametxf);
		frame.add(emailtxf);
		//buttons
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(regButton);
		frame.add(redButton);
		frame.add(updButton);
		frame.add(delButton);
		frame.add( table);

	}


	private void SetlocationandSize() {
		userIDlb.setBounds(5, 5, 150, 30);
		usernamelb.setBounds(5, 40, 150, 30);
		passwordlb.setBounds(5, 75, 150, 30);
		fnamelb.setBounds(5, 110, 150, 30);
		lnamelb.setBounds(5, 145, 150, 30);
		email.setBounds(5, 180, 150, 30);
		//Text field
		userIDtxf.setBounds(100, 5, 150, 30);
		usernametxf.setBounds(100, 40, 150, 30);
		passwordpsf.setBounds(100, 75, 150, 30);
		fnametxf.setBounds(100, 110, 150, 30);
		lnametxf.setBounds(100, 145, 150, 30);
		emailtxf.setBounds(100, 180, 150, 30);
		//buttons
		loginButton.setBounds(270, 5, 90, 30);
		resetButton.setBounds(270, 40, 90, 30);
		regButton.setBounds(270, 75, 90, 30);
		redButton.setBounds(270, 110, 90, 30);
		updButton.setBounds(270, 145, 90, 30);
		delButton.setBounds(270, 180, 90, 30);
		table.setBounds(5, 220, 350, 300);

	}


	private void createwindow() {
		frame=new JFrame();
		frame.setTitle("Main form for user");
		frame.setBounds(10,10,380,600);
		frame.getContentPane().setBackground(Color.gray);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		User myuser=new User();
		if(e.getSource()==regButton) {
			myuser.setUserID(Integer.parseInt(userIDtxf.getText()));
			myuser.setUsername(usernametxf.getText());
			myuser.setPassword(passwordpsf.getText());
			myuser.setFname(fnametxf.getText());
			myuser.setLname(lnametxf.getText());
			myuser.setEmail(emailtxf.getText());
			myuser.registertwo();
			DefaultTableModel tableModel=myuser.populateTable();
			table.setModel(tableModel);
		}else if(e.getSource()==redButton) {
			myuser.displaytwo();
			DefaultTableModel tableModel=myuser.populateTable();
			table.setModel(tableModel);
		}else if(e.getSource()==updButton) {
			String userInput = JOptionPane.showInputDialog(null, "Enter id:");
			String userInput1=usernametxf.getText();
			String userInput2=passwordpsf.getText();
			String userInput3=fnametxf.getText();
			String userInput4=lnametxf.getText();
			String userInput5=emailtxf.getText();
			myuser.updatedata(Integer.parseInt(userInput), userInput1, userInput2, userInput3, userInput4,userInput5);
		}else if (e.getSource()==delButton) {
			String userInput = JOptionPane.showInputDialog(null, "Enter id:");
			myuser.deletedata(Integer.parseInt(userInput));
		}

	}
	public static void main(String[] args) {
		UserForm usrfrm =new UserForm();
	}

}
