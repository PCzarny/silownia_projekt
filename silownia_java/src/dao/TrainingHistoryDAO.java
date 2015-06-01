package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import silownia_java.DBConnection;
import model.TrainingHistory;


public class TrainingHistoryDAO {
	
	
	
	public static TrainingHistory  getTrainingHistory(int uID) throws SQLException{
		
		Connection dbConn = null;
	 	TrainingHistory trainingPlan = new TrainingHistory(); 
		String sql = "Select training_history.DONE_ON ,training_history.TRAINING_HISTORY_ID From training_history where training_history.USER_USER_ID = ?";
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
	            	
	            	trainingPlan.setCreate_on(rs.getDate(1));
	            	trainingPlan.setHistory_id(rs.getInt(2));
	            	trainingPlan.setUserID(uID);
	            	trainingPlan.setDoneExercises(DoneExerciseDAO.getUserDoneExercise(uID));
	            	
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
		 
		 return trainingPlan;
	
		
	}
	
	
	
	
	

}
