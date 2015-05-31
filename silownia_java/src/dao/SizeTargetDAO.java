package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.SizeTarget;
import silownia_java.DBConnection;

public class SizeTargetDAO {

	
	public static SizeTarget getTarget(int userId, String dimensionName ) throws SQLException{
		Connection dbConn = null;
		SizeTarget sizeTarget = new SizeTarget(); 
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
	            String query = "Select * FROM size_target_view where name = \"" + dimensionName + "\" and USER_USER_ID = " + userId +";";		
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	
	            	sizeTarget.setDeadline(rs.getDate(6));
	            	sizeTarget.setDimensionName(rs.getString(3));
	            	sizeTarget.setDimensionId(rs.getInt(7));
	            	sizeTarget.setTargetId(rs.getInt(1));
	            	sizeTarget.setUnit(rs.getString(5));
	            	sizeTarget.setUserId(rs.getInt(2));
	            	sizeTarget.setValue(rs.getInt(4));
	            
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
		 return sizeTarget;
		
	}
	
	public static ArrayList<SizeTarget> getAllTargets(int userId) throws SQLException{
		Connection dbConn = null;
		ArrayList<SizeTarget> sizeTargets = new ArrayList<SizeTarget>(); 
		SizeTarget sizeTarget = new SizeTarget();
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
	            String query = "Select * FROM size_target_view where USER_USER_ID = " + userId +";";		
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	
	            	sizeTarget.setDeadline(rs.getDate(6));
	            	sizeTarget.setDimensionName(rs.getString(3));
	            	sizeTarget.setDimensionId(rs.getInt(7));
	            	sizeTarget.setTargetId(rs.getInt(1));
	            	sizeTarget.setUnit(rs.getString(5));
	            	sizeTarget.setUserId(rs.getInt(2));
	            	sizeTarget.setValue(rs.getInt(4));
	            	sizeTargets.add(sizeTarget);
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
		 return sizeTargets;
		
	}
	
public static void addSizeTarget(SizeTarget sizeTarget) throws SQLException{
		
		Connection dbConn = null;
		String sql = "call add_size_target(?, ?, ?, ?);";
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
	    	 	ps.setInt(1, sizeTarget.getDimensionId());
	    	 	ps.setInt(2, sizeTarget.getUserId());
	    	 	ps.setInt(3, sizeTarget.getValue());
	    	 	ps.setDate(4, sizeTarget.getDeadline());
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
