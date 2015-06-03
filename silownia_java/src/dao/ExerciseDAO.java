package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import silownia_java.DBConnection;
import model.Exercise;

public class ExerciseDAO {

	
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
	
public static ArrayList<Exercise> getFavouriteExercise(int uid) throws SQLException{
		
		Connection dbConn = null;
		ArrayList<Exercise> exercises = new ArrayList<>();
		Exercise exercise = null;
		
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
	            String query = "SELECT * FROM favourite_exercise_view WHERE user_id = '" + uid+"'";
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	exercise = new Exercise(); 
	            	exercise.setExercise_id(rs.getInt(8));
	            	exercise.setName(rs.getString(1));
	            	exercise.setDesription(rs.getString(2));
	            	exercise.setUrl(rs.getString(3));
	            	exercise.setPermission(rs.getInt(5));
	            	exercise.setUser_id(rs.getInt(4));   
	            	exercises.add(exercise);
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
		 
		 return exercises;
	}
	

public static void addToFavourite(int uid , int exercise_id) throws SQLException{
	
	Connection dbConn = null;
	String sql = "INSERT INTO `silownia`.`favourite_exercise` (`user_id`, `exercise_id`) VALUES (?, ?)";

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
    	 	
    	 	ps.setInt(1, uid);
    	 	ps.setInt(2, exercise_id);
    	 	
    	 		
    	 	ps.execute();
    	 
        } catch (SQLException sqle) {
            try {
				throw sqle;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

public static ArrayList<Exercise> getAllExercise() throws SQLException{
	
	Connection dbConn = null;
	ArrayList<Exercise> exercises = new ArrayList<>();
	Exercise exercise = null;
	
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
            String query = "SELECT * FROM exercise";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	exercise = new Exercise(); 
            	exercise.setExercise_id(rs.getInt(1));
            	exercise.setName(rs.getString(2));
            	exercise.setDesription(rs.getString(3));
            	exercise.setUrl(rs.getString(4));
            	exercise.setPermission(rs.getInt(5));
            	exercise.setUser_id(rs.getInt(6));   
            	exercises.add(exercise);
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
	 
	 return exercises;
}



	
	public static ArrayList<Exercise> getUserExercise(int id) throws SQLException{
		
		Connection dbConn = null;
		ArrayList<Exercise> exercises = new ArrayList<>();
		Exercise exercise = null;
		
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
	            String query = "SELECT * FROM exercise WHERE user_user_id = '" + id+"'";
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	exercise = new Exercise(); 
	            	exercise.setExercise_id(rs.getInt(1));
	            	exercise.setName(rs.getString(2));
	            	exercise.setDesription(rs.getString(3));
	            	exercise.setUrl(rs.getString(4));
	            	exercise.setPermission(rs.getInt(5));
	            	exercise.setUser_id(rs.getInt(6));   
	            	exercises.add(exercise);
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
		 
		 return exercises;
	}
	
	
	public static void addExercise(Exercise exercise) throws SQLException{
		
		Connection dbConn = null;
		String sql = "call add_exercise(?, ?, ?, ?, ?);";
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
	    	 	
	    	 	ps.setString(1, exercise.getName());
	    	 	ps.setString(2, exercise.getDesription());
	    	 	
	    	 	if(exercise.getUrl()==null)
	    	 		ps.setNull(3, Types.VARCHAR);
	    	 	else
	    	 		ps.setString(3,exercise.getUrl());
	    	 	
	    	 	ps.setInt(4, exercise.getpermission());
	    	 	ps.setInt(5, exercise.getUser_id());    	 	
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
