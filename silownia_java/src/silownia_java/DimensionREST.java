package silownia_java;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.*;
import dao.DimensionDAO;;
@Path("/dimension")
public class DimensionREST {

	 // HTTP Get Method
    @GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/lastDimension")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public Dimension getLastDimension(@QueryParam("userId") int uId,@QueryParam("dimensionId") int dimensionId) throws SQLException{
    
 
    	return DimensionDAO.getLastDimension(uId, dimensionId);       
    }
 
    
    
    // HTTP Get Method
    @GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/allDimension")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public ArrayList<Dimension> getaAllDimension(@QueryParam("userId") int uId,@QueryParam("dimensionId") int dimensionId) throws SQLException{
    
 
    	return DimensionDAO.getAllDimension(uId, dimensionId);       
    }
	
	
	
}
