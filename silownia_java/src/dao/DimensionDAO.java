package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import silownia_java.DBConnection;
import model.Dimension;



public class DimensionDAO {
	
	
	public static Dimension getLastDimension(int userId, int dimension_id ) throws SQLException{
		Connection dbConn = null;
		Dimension dimension =  new Dimension(); 
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
	            String query = "Select * From user_dimension_view WHERE USER_USER_ID = "+ userId+ " and DIMENSIONS_DIMENSION_ID =" 
	            + dimension_id+" Order By CREATED_ON DESC LIMIT 1";
	            		
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	
	            	dimension.setUser_id(rs.getInt(1));
	            	dimension.setName(rs.getString(2));
	            	dimension.setValue(rs.getInt(3));
	            	dimension.setUnit(rs.getString(4));
	            	dimension.setCreated_on(rs.getDate(5));
	            	dimension.setDimension_id(rs.getInt(6));   
	            	dimension.setUser_dimension_id(rs.getInt(7));
	            	
	            
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
		 return dimension;	
	}
	
	public static ArrayList<Dimension> getAllDimension(int userId, int dimension_id ) throws SQLException{
		Connection dbConn = null;
		ArrayList<Dimension> dimensions =  new ArrayList<Dimension>(); 
		Dimension dimension = null; 
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
	            String query = "Select * From user_dimension_view WHERE USER_USER_ID = "+ userId+ " and DIMENSIONS_DIMENSION_ID =" 
	            + dimension_id+" Order By CREATED_ON DESC";
	            		
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	dimension= new Dimension();
	            	dimension.setUser_id(rs.getInt(1));
	            	dimension.setName(rs.getString(2));
	            	dimension.setValue(rs.getInt(3));
	            	dimension.setUnit(rs.getString(4));
	            	dimension.setCreated_on(rs.getDate(5));
	            	dimension.setDimension_id(rs.getInt(6));   
	            	dimension.setUser_dimension_id(rs.getInt(7));
	            	dimensions.add(dimension);
	            	  
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
		 return dimensions;
		
	}
	
	
public static void addUserDimmension(Dimension dimension) throws SQLException{
		
		Connection dbConn = null;
		String sql = "call add_user_dimmension(?, ?, ?, ?);";
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
	    	 	ps.setInt(1, dimension.getUser_id());
	    	 	ps.setInt(2, dimension.getDimension_id());
	    	 	ps.setInt(3, dimension.getValue());
	    	 	ps.setDate(4, dimension.getCreated_on());
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
