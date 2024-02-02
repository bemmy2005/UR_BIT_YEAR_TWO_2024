package com.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class User {
	private int userID;
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String email;
	public User(int userID, String username, String password, String fname, String lname, String email) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	public User() {

	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//connect to the database
	public void registertwo() {
		String host = "jdbc:mysql://localhost/urbityeartwo";
		String user = "root";
		String password = "";
		String sql = "INSERT INTO user (UserID, Username, Password, FirstName, LastName, Email) VALUES (?, ?, ?, ?, ?, ?)";

		String sqlQuery = "SELECT Username FROM user";

		try (Connection con = DriverManager.getConnection(host, user, password);
				PreparedStatement pstmCheck = con.prepareStatement(sqlQuery);
				PreparedStatement pstm = con.prepareStatement(sql);
				ResultSet resultSet = pstmCheck.executeQuery()) {

			ArrayList<String> existingUsernames = new ArrayList<>();

			// Collect existing usernames
			while (resultSet.next()) {
				String existingUsername = resultSet.getString("Username");
				existingUsernames.add(existingUsername);
			}

			// Check if the entered username already exists
			if (existingUsernames.contains(this.username)) {
				System.out.println("The username you entered is already in use.");
			} else {
				// Insert new user
				pstm.setInt(1, this.userID);
				pstm.setString(2, this.username);
				pstm.setString(3, this.password);
				pstm.setString(4, this.fname);
				pstm.setString(5, this.lname);
				pstm.setString(6, this.email);

				int rowsAffected = pstm.executeUpdate();

				if (rowsAffected > 0) {
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Failed to insert data.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void displayInformation() {
		String url = "jdbc:mysql://localhost/urbityeartwo";
		String user = "root";
		String password = "";
		// SQL query to retrieve data
		String sql = "SELECT * from user";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);

				// Execute the query and get the result set
				ResultSet resultSet = stm.executeQuery();
				){
			// Get the number of rows in the result set
			resultSet.last();
			int rowCount = resultSet.getRow();
			resultSet.beforeFirst();

			// Define a 2D array of objects
			Object[][] data = new Object[rowCount][3];

			// Process the result set and save data into the array
			int row = 0;
			while (resultSet.next()) {
				String column1Value = resultSet.getString("id");
				//int column1Value = resultSet.getInt("id");
				String column2Value = resultSet.getString("username");
				String column3Value = resultSet.getString("password");
				String column4Value = resultSet.getString("fname");
				String column5Value = resultSet.getString("lname");
				String column6Value = resultSet.getString("email");
				// Save data into the 2D array
				data[row][0] = column1Value;
				data[row][1] = column2Value;
				data[row][2] = column3Value;
				data[row][3] = column4Value;
				data[row][4] = column5Value;
				data[row][5] = column6Value;

				row++;
			}

			// Print or use the data from the 2D array
			for (Object[] rowArray : data) {
				for (Object value : rowArray) {
					System.out.print(value + " ");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void displaytwo() {
		String url = "jdbc:mysql://localhost/urbityeartwo";
		String user = "root";
		String password = "";
		// SQL query to retrieve data
		String sql = "SELECT * from user";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);

				// Execute the query and get the result set
				ResultSet resultSet = stm.executeQuery();
				)
		{
			// Process the result set
			while (resultSet.next()) {
				int column1Value = resultSet.getInt("id");
				String column2Value = resultSet.getString("username");
				String column3Value = resultSet.getString("password");
				String column4Value = resultSet.getString("fname");
				String column5Value = resultSet.getString("lname");
				String column6Value = resultSet.getString("email");


				System.out.println("id: " + column1Value + ", username: " + column2Value 
						+ ", password: " + column3Value+" , First name: "+column4Value
						+", Last name "+column5Value+", email "+column6Value);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatedata(int id, String username, String passwords, String fname, String lname, String email) {
		String url = "jdbc:mysql://localhost/urbityeartwo";
        String user = "root";
        String password = "";

        // SQL query to update data
        //String sql = "UPDATE user SET username = ?, password = ? where id='"+id+"'";
        String sql ="UPDATE user set username=?, passwords?, fname=?, lname=?, email=?where id='"+id+"'";
        try (
            // Establish the con
            Connection con = DriverManager.getConnection(url, user, password);

            // Create a prepared statement
            PreparedStatement stm = con.prepareStatement(sql);
        ) {
            // Set the new values for the update
            stm.setString(1, username);
            stm.setString(2, passwords);
            stm.setString(3, fname);
            stm.setString(4, lname);
            stm.setString(5, email);
            
            
            int result = JOptionPane.showConfirmDialog(null, "Do you really want to update the user with idd"+id+"\n?", "Question", JOptionPane.YES_NO_OPTION);
            
            // Check the user's choice
            if (result == JOptionPane.YES_OPTION) {
            	// Execute the update
                int rowsAffected = stm.executeUpdate();

                // Check the result
                if (rowsAffected > 0) {
                   // System.out.println("Data updated successfully!");
                    JOptionPane.showMessageDialog(null, "Data updated successfully!");

                } else {
                    System.out.println("Failed to update data. No matching record found.");
                    JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                //System.out.println("User clicked No");
                JOptionPane.showMessageDialog(null, "We will not delete your data");

            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public void deletedatas(int id) {
		String url = "jdbc:mysql://localhost/urbityeartwo";
		String user = "root";
		String password = "";
		//String userInput = JOptionPane.showInputDialog(null, "Enter id:");
		//id=Integer.parseInt(userInput);
		//System.out.println("User entered: " + userInput);
		// SQL query to delete data

		String sql = "DELETE FROM user WHERE userID = ?";
		if(id==0) 
			JOptionPane.showMessageDialog(null, "No id entered");
		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);
				) {
			// Set the value for the WHERE clause
			stm.setInt(1, userID); // Assuming there is a column named 'id' for the WHERE clause

			// Execute the delete

			int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete the user with id "+id+"\n?", "Question", JOptionPane.YES_NO_OPTION);

			// Check the user's choice
			if (result == JOptionPane.YES_OPTION) {
				//System.out.println("User clicked Yes");
				int rowsAffected = stm.executeUpdate();
				if (rowsAffected > 0) {
					JOptionPane.showMessageDialog(null, "The user with id: "+id+"\n was deleted!");

				} else {
					//System.out.println("Failed to delete data. No matching record found.");

					JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				//System.out.println("User clicked No");
				JOptionPane.showMessageDialog(null, "We can't delete the user");


			}
			// Check the result


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public DefaultTableModel populateTable() {
		String host = "jdbc:mysql://localhost/urbityeartwo";
		String user = "root";
		String password = "";

		String sql = "SELECT * FROM user"; // replace your_table with the actual table name
		DefaultTableModel tableModel = null;// = new DefaultTableModel(data, columnNames);
		try (Connection connection = DriverManager.getConnection(host, user, password);

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			// Get column names
			int columnCount = resultSet.getMetaData().getColumnCount();

			Vector<String> columnNames = new Vector<>();
			for (int i = 1; i <= columnCount; i++) {
				columnNames.add(resultSet.getMetaData().getColumnName(i));
			}

			// Get data rows
			Vector<Vector<Object>> data = new Vector<>();
			while (resultSet.next()) {
				Vector<Object> row = new Vector<>();
				for (int i = 1; i <= columnCount; i++) {
					row.add(resultSet.getObject(i));
				}
				data.add(row);
			}

			// Create DefaultTableModel and set data
			tableModel = new DefaultTableModel(data, columnNames);
			//table.setModel(tableModel);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	public void deletedata(int id) {
	    String url = "jdbc:mysql://localhost/urbityeartwo";
	    String user = "root";
	    String password = "";

	    try (Connection con = DriverManager.getConnection(url, user, password)) {
	        // Check if the user exists before proceeding with deletion
	        if (checkUserExists(con, id)) {
	            int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete the user with id " + id + "\n?", "Question", JOptionPane.YES_NO_OPTION);

	            if (result == JOptionPane.YES_OPTION) {
	                // Delete associated records from userrole table
	                deleteAssociatedUserRoleRecords(con, id);

	                // Now delete the user record
	                String sql = "DELETE FROM user WHERE userID = ?";
	                try (PreparedStatement stm = con.prepareStatement(sql)) {
	                    stm.setInt(1, id);
	                    int rowsAffected = stm.executeUpdate();

	                    if (rowsAffected > 0) {
	                        JOptionPane.showMessageDialog(null, "The user with id: " + id + "\n was deleted!");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Failed to delete user. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "User chose not to delete the user.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "User with id: " + id + " not found.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private boolean checkUserExists(Connection con, int userId) throws SQLException {
	    String sql = "SELECT * FROM user WHERE userID = ?";
	    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	        preparedStatement.setInt(1, userId);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            return resultSet.next();
	        }
	    }
	}

	private void deleteAssociatedUserRoleRecords(Connection con, int userId) throws SQLException {
	    String sql = "DELETE FROM userrole WHERE UserID = ?";
	    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	        preparedStatement.setInt(1, userId);
	        preparedStatement.executeUpdate();
	    }
	}

}
