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
	
// Pobieranie planów z bazy po parametrze byXXX zgodnie z ConstantsDAO oraz o wartosci value
	public static ArrayList<TrainingPlan> getTrainingPlans(int byXXX, int value) throws SQLException{
	
		Boolean b = true;
		Connection dbConn = null;
		String sql = "SELECT * FROM training_plan_view WHERE ";
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
	    	 	if(byXXX == ConstantsDAO.USER_ID )
	    	 	{
	    	 		sql += "user_user_id = ?";
	    	 	}
	    	 	else if(byXXX == ConstantsDAO.OWNER_ID )
	    	 		sql += "owner_user_id = ?";
	    	 	else if(byXXX == ConstantsDAO.ACTIVE)
    	 		{
	    	 		sql += "is_active = ?";
	    	 		
	    	 	}
	    	 	else if(byXXX == ConstantsDAO.TRAINING_CATEGORY_ID )
	    	 		sql += "training_category_id = ?";
	    	 	else if(byXXX == ConstantsDAO.TRAINING_PLAN_ID )
	    	 		sql += "training_plan_id = ?";

	    	 	java.sql.PreparedStatement ps = dbConn.prepareStatement(sql);
	    	 	if(byXXX!=ConstantsDAO.ACTIVE)
			    	ps.setInt(1, value);
	    	 	else
	    	 	{
	    	 		if(value==0)
			    		b=false;
	    	 		ps.setBoolean(1, b);
	    	 	}

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
