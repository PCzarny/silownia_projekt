package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.TrainingPlan;
import silownia_java.DBConnection;

public class TrainingPlanDAO {
	
	
	public static TrainingPlan getTrainingPlan(int planId) throws SQLException{
		
		Connection dbConn = null;
		TrainingPlan trainingPlan = new TrainingPlan(); 
		
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
	            String query = "SELECT * FROM training_plan_view WHERE training_plan_id = "  + planId;
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	trainingPlan.setIs_active(rs.getInt(1));
	            	trainingPlan.setCurrent_day(rs.getInt(2));
	            	trainingPlan.setStart_time(rs.getDate(3));
	            	trainingPlan.setUser_id(rs.getInt(4));
	            	trainingPlan.setPeriod(rs.getInt(5));
	            	trainingPlan.setTraining_plan_id(rs.getInt(6));
	            	trainingPlan.setOwner(rs.getInt(7));  
	            	trainingPlan.setTrainingDays(TrainingDayDAO.getTrainingDays(planId));
	            
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
