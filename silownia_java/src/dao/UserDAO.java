package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import silownia_java.DBConnection;
import model.User;

public class UserDAO {

	// Zwraca profil uzytkownika o zadanym id
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
	             user.setCreate_on(rs.getDate(7));
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
		

// Zmiana imienia
	public static int changeName(String login, String newName) throws SQLException{
		 Connection dbConn = null;
		 int result = 0;
		 String sql = "UPDATE user SET name = ? WHERE login = ?";
	        try {
	            try {
	                dbConn = DBConnection.createConnection();
	                System.out.println(dbConn);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            java.sql.PreparedStatement ps = dbConn.prepareStatement(sql);
	            ps.setString(1, newName);
	            ps.setString(2, login);
	            
	            System.out.println(ps);
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()) {
	            	System.out.println(rs);
	            }
	            result = 1;
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
		 
		 return result;
	}
	
	// Zmiana danych profilu u¿ytkownika identyfikowanego za pomoc¹ loginu
		public static int updateProfile(User user) throws SQLException{
			 Connection dbConn = null;
			 int result = 0;
			 String sql = "UPDATE user SET name = ?, login = ?, surname = ?, password = ?, email = ? WHERE user_id = ? ";
		        try {
		            try {
		                dbConn = DBConnection.createConnection();
		                System.out.println(dbConn);
		            } catch (Exception e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		            java.sql.PreparedStatement ps = dbConn.prepareStatement(sql);
		            ps.setString(1, user.getName());
		            ps.setString(2, user.getLogin());
		            ps.setString(3, user.getSurname());
		            ps.setString(4, user.getPassword());
		            ps.setString(5, user.getEmail());
		            ps.setInt(6, user.getUserId());
		            
		            System.out.println(ps);
		            ps.executeUpdate();
		            
		            result = 1;
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
			 
			 return result;
		}
	
	
}
