package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.TrainingDay;
import silownia_java.DBConnection;

public class TrainingDayDAO {

public static ArrayList<TrainingDay> getTrainingDays(int trainingPlanId) throws SQLException{
		
		Connection dbConn = null;
		
		TrainingDay day = new TrainingDay();
		ArrayList<TrainingDay> days = new ArrayList<TrainingDay>();
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
	            String query = "Select training_day.TRAINING_DAY_ID, training_day.DAY_NR, "
	            		+ "training_day.TRAINING_PLAN_TRAINING_PLAN_ID From "
	            		+ "training_day where TRAINING_PLAN_TRAINING_PLAN_ID = " + trainingPlanId;
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	day.setDayNr(rs.getInt(2));
	            	day.setTrainingDayID(rs.getInt(1));
	            	day.setTrainingPlanID(rs.getInt(3));
	        	    day.setExercises(TrainingExerciseDAO.getTrainingExercises(day.getTrainingDayID()));
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
		 return days;
	}
	
	
}
