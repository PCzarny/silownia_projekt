package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import model.TrainingCategory;
import model.TrainingPlan;
import model.UserTraining;
import silownia_java.DBConnection;

public class UserTrainingDAO {

	// Pobieranie planów z tabeli user_has_training_plan po parametrze byXXX zgodnie z ConstantsDAO oraz o wartosci value
	public static ArrayList<TrainingPlan> getTrainingPlans(int byXXX, int value, int limit,boolean short_version) throws SQLException{
		
			Boolean b = true;
			Connection dbConn = null;
			String sql = "SELECT * FROM uniqe_training_plan WHERE ";
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

		    	 	if(limit!=0)
		    	 		sql += " LIMIT ?";
		    	 	java.sql.PreparedStatement ps = dbConn.prepareStatement(sql);
		    	 	if(byXXX!=ConstantsDAO.ACTIVE)
				    	ps.setInt(1, value);
		    	 	else
		    	 	{
		    	 		if(value==0)
				    		b=false;
		    	 		ps.setBoolean(1, b);
		    	 	}
		    	 	if(limit!=0)
		    	 		ps.setInt(2, limit);

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
		            	if (short_version!=true)
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
	
	// Pobieranie planów z tabeli user_has_training_plan po parametrze byXXX zgodnie z ConstantsDAO oraz o wartosci value
		public static ArrayList<TrainingPlan> getPlansByCat(int catId, int limit,boolean short_version) throws SQLException{
			
				Connection dbConn = null;
				String sql = "SELECT * FROM uniqe_training_plan WHERE training_category_id = ?";
				if(limit!=0)
					sql+=" LIMIT ?";
				
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
			    	 
			    	 	java.sql.PreparedStatement ps = dbConn.prepareStatement(sql);
			    	 	
					    ps.setInt(1, catId);
			    	 	if(limit!=0)
			    	 		ps.setInt(2, limit);

			    	 	System.out.println(ps.toString());
			    	 	ResultSet rs = ps.executeQuery();
			            while (rs.next()) {
			            	trainingPlan = new TrainingPlan();
			            	trainingPlan.setPeriod(rs.getInt(5));
			            	trainingPlan.setTraining_plan_id(rs.getInt(3));
			            	trainingPlan.setOwner(rs.getInt(4));  
			            	trainingPlan.setCategoryId(rs.getInt(2));
			            	trainingPlan.setCategoryName(rs.getString(1));
			            	trainingPlan.setName(rs.getString(6));
			            	if (short_version!=true)
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
			
	public static ArrayList<TrainingPlan> getPlansByNameAndCat(String name, String catName, int limit,boolean short_version) throws SQLException{
		
		Connection dbConn = null;
		String a = "%";
		a+=name;
		a+="%";
		name=a;
		String sql = "SELECT * FROM uniqe_training_plan WHERE name1 LIKE ? ";
		if(!catName.equals("any"))
			sql+=" and cat_name = ? ";
		if(limit!=0)
			sql+=" LIMIT ?";
		
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
	    	 
	    	 	java.sql.PreparedStatement ps = dbConn.prepareStatement(sql);
	    	 	
			    ps.setString(1, name);
	    	 	if(!catName.equals("any"))
	    			ps.setString(2, catName);
	    	 	if(limit!=0 && catName.equals("any"))
	    	 		ps.setInt(2, limit);
	    	 	else if(limit!=0)
	    	 		ps.setInt(3, limit);
	    	 	
	    	 	
	    	 	System.out.println(ps.toString());
	    	 	ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	trainingPlan = new TrainingPlan();
	            	trainingPlan.setPeriod(rs.getInt(5));
	            	trainingPlan.setTraining_plan_id(rs.getInt(3));
	            	trainingPlan.setOwner(rs.getInt(4));  
	            	trainingPlan.setCategoryId(rs.getInt(2));
	            	trainingPlan.setCategoryName(rs.getString(1));
	            	trainingPlan.setName(rs.getString(6));
	            	if (short_version!=true)
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
	
	// Pobieranie planów z tabeli user_has_training_plan po parametrze byXXX zgodnie z ConstantsDAO oraz o wartosci value
	public static ArrayList<TrainingPlan> getOwnerPlans(int ownerId, int limit,boolean short_version) throws SQLException{
		
			Connection dbConn = null;
			String sql = "SELECT * FROM uniqe_training_plan WHERE owner_user_id = ?";
			if(limit!=0)
				sql+=" LIMIT ?";
			
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
		    	 
		    	 	java.sql.PreparedStatement ps = dbConn.prepareStatement(sql);
		    	 	
				    ps.setInt(1, ownerId);
		    	 	if(limit!=0)
		    	 		ps.setInt(2, limit);

		    	 	System.out.println(ps.toString());
		    	 	ResultSet rs = ps.executeQuery();
		            while (rs.next()) {
		            	trainingPlan = new TrainingPlan();
		            	trainingPlan.setPeriod(rs.getInt(5));
		            	trainingPlan.setTraining_plan_id(rs.getInt(3));
		            	trainingPlan.setOwner(rs.getInt(4));  
		            	trainingPlan.setCategoryId(rs.getInt(2));
		            	trainingPlan.setCategoryName(rs.getString(1));
		            	trainingPlan.setName(rs.getString(6));
		            	if (short_version!=true)
		            		trainingPlan.setTrainingDays(TrainingDayDAO.getTrainingDays(rs.getInt(3)));
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
	
	// Pobieranie planów z tabeli user_has_training_plan po parametrze byXXX zgodnie z ConstantsDAO oraz o wartosci value
	public static ArrayList<TrainingPlan> getUsersPlans(int userId, int limit, int active,boolean short_version) throws SQLException{
		
			Connection dbConn = null;
			String sql = "SELECT * FROM training_plan_view WHERE ";
			if(active == 0)
				sql+="is_active = false and ";
			else if(active == 1)
				sql+="is_active = true and ";
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
		    	 	sql += "user_user_id = ?";
		    	 	if(limit!=0)
		    	 		sql += " LIMIT ?";
		    	 	
		    	 	java.sql.PreparedStatement ps = dbConn.prepareStatement(sql);
		    	 	
				    ps.setInt(1, userId);
		    	 	if(limit!=0)
		    	 		ps.setInt(2, limit);

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
		            	if (short_version!=true)
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
	
	// Pobieranie planów z tabeli user_has_training_plan po parametrze byXXX zgodnie z ConstantsDAO oraz o wartosci value
	public static ArrayList<TrainingCategory> getCategories() throws SQLException{
		
			Connection dbConn = null;
			String sql = "SELECT distinct cat_name, training_category_id FROM `uniqe_training_plan`";
			
			TrainingCategory category = new TrainingCategory(); 
			ArrayList<TrainingCategory> categories = new ArrayList<TrainingCategory>();
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
		    	 	
		    	 	System.out.println(ps.toString());
		    	 	ResultSet rs = ps.executeQuery();
		            while (rs.next()) {
		            	category = new TrainingCategory();
		            	category.setName(rs.getString(1));
		            	category.setId(rs.getInt(2));
		            	categories.add(category);
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
			 
			 return categories;
		}
	
	public static void addTrainingPlanToUser(UserTraining plan) throws SQLException{
			
			Connection dbConn = null;
			String sql = "call add_training_to_user(?, ?, ?, ?, ?);";
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
		    	 	ps.setInt(1, plan.getUserId());
		    	 	ps.setInt(2, plan.getTrainingPlanId());
		    	 	ps.setDate(3, plan.getStartDate());
		    	 	ps.setInt(4, plan.getCurrentDay());
		    	 	ps.setInt(5, plan.getIsActive());
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
	public static void deleteTrainingPlanToUser(UserTraining plan) throws SQLException{
		
		Connection dbConn = null;
		String sql = "DELETE  FROM `user_has_training_plan` WHERE user_user_id=? and training_plan_training_plan_id=?";
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
	    	 	ps.setInt(1, plan.getUserId());
	    	 	ps.setInt(2, plan.getTrainingPlanId());
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
