package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DoneExercise;

import silownia_java.DBConnection;

public class DoneExerciseDAO {
	
	
	public static ArrayList<DoneExercise> getUserDoneExercise (int userId) throws SQLException{
		
		ArrayList<DoneExercise>  doneExercises = new ArrayList<>();
		Connection dbConn = null;
	 	DoneExercise doneExercise = null;
		String sql = "SELECT * FROM user_training_history_view WHERE user_id = ?";		
	     try {
	    	 try{
	    		 dbConn = DBConnection.createConnection();
	             System.out.println(dbConn);
	            } 
	    	 	catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }	    	 
	    	 	java.sql.PreparedStatement ps = dbConn.prepareStatement(sql);
	    	 	ps.setInt(1, userId);  	 	
	    	 	System.out.println(ps.toString());
	    	 	ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	doneExercise = new DoneExercise();
	            	doneExercise.setDone_exercise_id(rs.getInt(1));
	            	doneExercise.setExercise_id(rs.getInt(2));
	            	doneExercise.setExercise_name(rs.getString(3));
	            	doneExercise.setCreated_on(rs.getDate(4));
	            	doneExercise.setSeries(rs.getInt(5));
	            	doneExercise.setValues(rs.getInt(6));
	            	doneExercise.setTraining_plan_id(rs.getInt(7));  
	            	doneExercise.setTraining_plan_name(rs.getString(8));
	            	doneExercise.setUser_id(rs.getInt(9));
	            	doneExercises.add(doneExercise);  	
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
		 return  doneExercises;	
	}
}
