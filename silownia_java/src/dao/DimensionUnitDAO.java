package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import silownia_java.DBConnection;
import model.Dimension;
import model.DimensionUnit;

public class DimensionUnitDAO {
	
	public static ArrayList<DimensionUnit> getAllUnit() throws SQLException{
		
		Connection dbConn = null;
		ArrayList<DimensionUnit> dimensionUnits = new  ArrayList<DimensionUnit>();
		DimensionUnit dimensionUnit =  null; 
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
	            String query = "Select distinct * from  dimensions";
	            		
	            System.out.println(query);
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	dimensionUnit =  new DimensionUnit();
	            	dimensionUnit.setDimensionId(rs.getInt(1));
	            	dimensionUnit.setName(rs.getString(2));
	            	dimensionUnit.setUnit(rs.getString(3));
	            	dimensionUnits.add(dimensionUnit);
	            	
	            
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
		 return dimensionUnits;	
		
		
	}
	

}
