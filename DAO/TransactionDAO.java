package com.capg.Banking.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capg.Banking.AccountDetails;
import com.capg.Banking.TransactionDetails;
import com.capg.Banking.userdefinedexceptions.InsufficientFundException;
import com.capg.Banking.userdefinedexceptions.InvalidToAccountException;

public class TransactionDAO implements ITransactionDAO {
AccountDetails a1=new AccountDetails();
TransactionDetails td=new TransactionDetails();
	public AccountDetails deposit(AccountDetails a) {
		
		double bal = a1.getBalance();
		bal += a1.getAmount();
		if (bal >= a1.getAmount()) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CAPGEMINI"," oracle123");
            
		
			PreparedStatement stmt = con.prepareStatement("update customer_details set balance = ? where account_no = ?");
			stmt.setInt(1, (int) bal);
			stmt.setInt(2, a1.getAccountNo());
			stmt.executeUpdate();
			a.setBalance(bal);
			stmt.executeUpdate();
			con.close();
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			try {
				throw new InsufficientFundException();
			} catch (InsufficientFundException e) {
			}
		}

		
			return a;
		
		
	}

	public AccountDetails withdraw(AccountDetails a) {
	
		double bal = a1.getBalance();
		bal -= a1.getAmount();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CAPGEMINI"," oracle123");
            
		
			PreparedStatement stmt = con.prepareStatement("update customer_details set balance = ? where account_no = ?");
			stmt.setInt(2, (int) bal);
			stmt.setInt(1, a1.getAccountNo());
			stmt.executeUpdate();
			a.setBalance(bal);
			stmt.executeUpdate();
			con.close();
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
		
	}
	
	

	public AccountDetails showBalance(AccountDetails balance) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CAPGEMINI"," oracle123");
            
		
			PreparedStatement stmt = con.prepareStatement("select balance from customer_details where account_no=?");
			
			stmt.setInt(1, balance.getAccountNo());
			ResultSet resultSet = stmt.executeQuery();
			resultSet.next();
			balance.setBalance(resultSet.getInt(1));
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return balance;
		
	}
		

	
	public AccountDetails fundtransfer(AccountDetails amounttransfer) {
		int j = 0;
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CAPGEMINI"," oracle123");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select account_no from customer_details");
			while (rs.next()) {
				if (rs.getInt(1) == amounttransfer.getAccountNo())
					j++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (j == 1) {
			int i = 0;
			amounttransfer= withdraw(amounttransfer);
			if (amounttransfer != null) {
				amounttransfer = deposit(amounttransfer);
				PreparedStatement preparedStatement;
				try {

					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CAPGEMINI"," oracle123");
					preparedStatement = con.prepareStatement(
							"insert into transaction_details (transaction_id, from_account_no, to_account_no, amount_transferred) values(transaction_id_seq.nextval,?,?,?)");
					preparedStatement.setInt(1, amounttransfer.getAccountNo());
					preparedStatement.setInt(2, amounttransfer.getToAccountNo());
					preparedStatement.setInt(3, (int) amounttransfer.getAmount());
					i = preparedStatement.executeUpdate();
				} catch (SQLException e) {
				
		} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (i == 1)
					return amounttransfer;
				else
					return null;
			} else {
				try {
					throw new InvalidToAccountException();
				} catch (Exception e) {
				}
				
			}

		
	}
		return null;
	}

	
}

