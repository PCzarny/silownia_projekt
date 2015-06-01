package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.Types;
import java.util.ArrayList;





import com.mysql.jdbc.PreparedStatement;

import model.TrainingPlan;
import silownia_java.DBConnection;

public class TrainingPlanDAO {
	
// Pobieranie planów z tabeli training_plan po id planu 
	public static TrainingPlan getTrainingPlan(int planId, Boolean shortVersion) throws SQLException{
	
		Connection dbConn = null;
	 	TrainingPlan trainingPlan = new TrainingPlan(); 
		String sql = "SELECT * FROM training_plan_view WHERE training_plan_id = ? LIMIT 1";
		
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
	    	 	ps.setInt(1, planId);
	    	 	

	    	 	System.out.println(ps.toString());
	    	 	ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	trainingPlan = new TrainingPlan();
	            	trainingPlan.setIs_active(rs.getInt(1));
	            	trainingPlan.setCurrent_day(rs.getInt(2));
	            	trainingPlan.setStart_time(rs.getDate(3));
	            	trainingPlan.setUser_id(rs.getInt(4));
	            	trainingPlan.setPeriod(rs.getInt(5));
	            	trainingPlan.setTraining_plan_id(rs.getInt(6));
	            	trainingPlan.setOwner(rs.getInt(7));  
	            	trainingPlan.setCategoryId(rs.getInt(9));
	            	trainingPlan.setCategoryName(rs.getString(10));
	            	trainingPlan.setName(rs.getString(8));
	            	if (shortVersion!=true)
	            		trainingPlan.setTrainingDays(TrainingDayDAO.getTrainingDays(rs.getInt(6)));
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
	
	//Dodawanie planu treningowego
	public static void addTreningPlanRow(TrainingPlan plan) throws SQLException{
		
		Connection dbConn = null;
		String sql = "call add_new_training_plan(?, ?, ?, ?);";
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
	    	 	ps.setInt(1, plan.getOwner());
	    	 	ps.setInt(2, plan.getPeriod());
	    	 	ps.setString(3, plan.getName());
	    	 	if(plan.getCategoryId()!=0)
	    	 		ps.setInt(4, plan.getCategoryId());
	    	 	else
	    	 		ps.setNull(4, Types.INTEGER);
	    	 	ps.execute();
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
	}	
}
