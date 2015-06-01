package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ExerciseTarget;
import model.TrainingHistory;
import silownia_java.DBConnection;

public class ExerciseTargetDAO {

	public static ArrayList<ExerciseTarget> getUserExerciseTarget(int uID) throws SQLException{
		
			
		Connection dbConn = null;
		ArrayList<ExerciseTarget> exerciseTargets= new ArrayList<>();
		ExerciseTarget exerciseTarget = null;
	
		String sql = "Select * from training_target_view where user_id = ?";
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
	    	 	ps.setInt(1, uID);
	    	 	
	    	 	System.out.println(ps.toString());
	    	 	ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	            	exerciseTarget = new ExerciseTarget() ;
	            	exerciseTarget.setName(rs.getString(1));
	            	exerciseTarget.setValue(rs.getInt(2));
	            	exerciseTarget.setDeadline(rs.getDate(3));
	            	exerciseTarget.setUser_id(rs.getInt(4));  
	            	exerciseTarget.setUnit(rs.getString(5));
	            	exerciseTargets.add(exerciseTarget);
       	
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
		 
		 return exerciseTargets;
	
	
	} 
	
	
}
