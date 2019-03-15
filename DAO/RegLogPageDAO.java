package com.capg.Banking.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capg.Banking.AccountDetails;

public class RegLogPageDAO implements IRegLogPageDAO{

		
public AccountDetails login( AccountDetails accountdetails) {
	int i = 0;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CAPGEMINI"," oracle123");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customer_details");
		
		while (rs.next()) {
			if (rs.getInt(1) == accountdetails.getAccountNo() && rs.getString(5).equals(accountdetails.getPassward())) {
				accountdetails.setBalance(rs.getInt(10));
				accountdetails.setFirstName(rs.getString(2));
				i++;
				break;
			}
		}

		
		// connection.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (i != 1) {
		return accountdetails;
	}
	else
	return null;

	}
public int register(AccountDetails details) {
	int i=-1, accno = 0;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CAPGEMINI"," oracle123");
        
		
		PreparedStatement preparedstatement=con.prepareStatement("insert into customer_details(account_no,first_name, last_name, email_id, password, pancard_no, aadhar_no, address, mobile_no, balance)"+" values( accountno_sequence.nextval,?,?,?,?,?,?,?,?,0)");
		preparedstatement.setString(1,details.getFirstName());
		preparedstatement.setString(2,details.getLastName());
		preparedstatement.setString(3,details.getEmailId());
		preparedstatement.setString(4,details.getPassward());
		preparedstatement.setString(5,details.getPancardNo());
		preparedstatement.setString(6,details.getAadharcardNo());
		preparedstatement.setString(7,details.getAddress());
		preparedstatement.setLong(8,details.getMobileNo());
		//preparedstatement.setInt(9,ad.getBalance());
		
		
		int j=preparedstatement.executeUpdate();
		if(j==1) {
			System.out.println("registered");
			
		}
		con.close();
	
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


if(i == 1) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CAPGEMINI"," oracle123");
		PreparedStatement preparedStatement = con.prepareStatement("select account_no from customer_details where aadhaar_no = ?");
		preparedStatement.setString(1,details.getAadharcardNo());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		accno = resultSet.getInt(1);
	} catch (SQLException e) {
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	return accno;	
	
}
	
}


