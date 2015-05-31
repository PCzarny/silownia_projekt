package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import silownia_java.DBConnection;
import model.User;

public class UserDAO {

	
	public static User getUser(int userId) throws SQLException{
		 Connection dbConn = null;
		 
		 User user = new User();
	        try {
	            try {
	                dbConn = DBConnection.createConnection();
	                System.out.println(dbConn);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            Statement stmt = dbConn.createStatement();
	            String query = "SELECT * FROM user WHERE user_id = '" + userId+"'";
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	             user.setUserId(rs.getInt(1));
	             user.setName(rs.getString(2));
	             user.setSurname(rs.getString(3));
	             user.setLogin(rs.getString(4));
	             user.setPassword(rs.getString(5));
	             user.setEmail(rs.getString(6));   
	            }
	        } catch (SQLException sqle) {
	            throw sqle;
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            if (dbConn != null) {
	                dbConn.close();
	            }
	            throw e;
	        } finally {
	            if (dbConn != null) {
	                dbConn.close();
	            }
	        }
		 
		 return user;
	}
		

	
	
}
