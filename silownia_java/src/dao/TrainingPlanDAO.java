package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;


import model.TrainingPlan;
import silownia_java.DBConnection;

public class TrainingPlanDAO {
	
	// Pobieranie planu po planID
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
	            	trainingPlan.setCategoryId(rs.getInt(9));
	            	trainingPlan.setCategoryName(rs.getString(10));
	            	trainingPlan.setName(rs.getString(8));
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
	
	// Pobieranie planu po userID
	public static TrainingPlan getTrainingPlanByUserID(int userId) throws SQLException{
		
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
	            String query = "SELECT * FROM training_plan_view WHERE user_user_id = "  + userId;
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
	            	trainingPlan.setCategoryId(rs.getInt(9));
	            	trainingPlan.setCategoryName(rs.getString(10));
	            	trainingPlan.setName(rs.getString(8));
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
	
	//Pobieranie tablicy planów po userID
	public static ArrayList<TrainingPlan> getTrainingPlansByUserID(int userId) throws SQLException{
		
		Connection dbConn = null;
		TrainingPlan trainingPlan = new TrainingPlan(); 
		ArrayList<TrainingPlan> plans = new ArrayList<TrainingPlan>();
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
	            String query = "SELECT * FROM training_plan_view WHERE user_user_id = "  + userId;
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
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
	            	trainingPlan.setTrainingDays(TrainingDayDAO.getTrainingDays(rs.getInt(6)));
	            	plans.add(trainingPlan);
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
		 
		 return plans;
		
	}
	
	//Dodawanie planu treningowego
	public static void createTreningPlanRow(TrainingPlan plan) throws SQLException{
		
		Connection dbConn = null;
		String sql = "call silownia_baza.add_new_training_plan(?, ?, ?, ?);";
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
	    	 	ps.setInt(4, plan.getCategoryId());
	    	 	
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
