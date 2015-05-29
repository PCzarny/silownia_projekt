package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import silownia_java.DBConnection;
import model.Exercise;

public class Exercise_dao {

	
	public static Exercise getExercise(int id) throws SQLException{
	
		Connection dbConn = null;
		Exercise exercise = new Exercise(); 
		
	     try {
	    	 try{
	    		 dbConn = DBConnection.createConnection();
	             System.out.println(dbConn);
	            } 
	    	 	catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            Statement stmt = dbConn.createStatement();
	            String query = "SELECT * FROM exercise WHERE exercise_id = '" + id+"'";
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	exercise.setExercise_id(rs.getInt(1));
	            	exercise.setName(rs.getString(2));
	            	exercise.setDesription(rs.getString(3));
	            	exercise.setUrl(rs.getString(4));
	            	exercise.setPermission(rs.getInt(5));
	            	exercise.setUser_id(rs.getInt(6));   
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
		 
		 return exercise;
		
		
		
		
		
		
	}
	
}
