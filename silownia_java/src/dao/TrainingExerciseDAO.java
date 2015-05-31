package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import model.TrainingExercise;
import silownia_java.DBConnection;

public class TrainingExerciseDAO {

	public static ArrayList<TrainingExercise> getTrainingExercises(int trainingDayId) throws SQLException{
		
		Connection dbConn = null;
		TrainingExercise exercise = new TrainingExercise(); 
		ArrayList<TrainingExercise> exercises = new ArrayList<TrainingExercise>();
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
	            String query = "SELECT * FROM training_exercise_view WHERE TRAINING_DAY_TRAINING_DAY_ID = '" + trainingDayId+"'";
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	exercise = new TrainingExercise();
	            	exercise.setExercise_id(rs.getInt(8));
	            	exercise.setName(rs.getString(1));
	            	exercise.setDesription(rs.getString(2));
	            	exercise.setUrl(rs.getString(5));
	            	exercise.setPermission(rs.getInt(6));
	            	exercise.setUser_id(rs.getInt(7));   
	            	exercise.setSeries(rs.getInt(3));
	            	exercise.setRepeats(rs.getInt(4));
	            	exercise.setTrainingDayID(rs.getInt(9));
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
	
public static void  addExercises(ArrayList<TrainingExercise> exercises) throws SQLException{
		
		Connection dbConn = null;
   	 	String sql = "call add_exercise_to_training_day(?, ?, ?, ?);";
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
			for (TrainingExercise trainingExercise : exercises) {
				ps.setInt(2, trainingExercise.getTrainingDayID());
	    	 	ps.setInt(1, trainingExercise.getExercise_id());
	    	 	ps.setInt(3, trainingExercise.getSeries());
	    	 	ps.setInt(4, trainingExercise.getRepeats());
	    	 	ps.execute();
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
	}
	
}
