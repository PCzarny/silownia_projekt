package silownia_java;

import java.sql.SQLException;
import dao.DimensionUnitDAO;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import dao.DimensionDAO;;
@Path("/dimension")
public class DimensionREST {

	 // HTTP Get Method
    @GET
    // Path: http://localhost:8080/silownia_java/rest/dimension/lastDimension?userId=1&dimensionId=1
    @Path("/lastDimension")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public Dimension getLastDimension(@QueryParam("userId") int uId,@QueryParam("dimensionId") int dimensionId) throws SQLException{
    	return DimensionDAO.getLastDimension(uId, dimensionId);       
    }
 
    
    
    // HTTP Get Method
    @GET
    // Path: 
    @Path("/allDimension")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public ArrayList<Dimension> getaAllDimension(@QueryParam("userId") int uId,@QueryParam("dimensionId") int dimensionId) throws SQLException{
    
 
    	return DimensionDAO.getAllDimension(uId, dimensionId);       
    }
	
 // HTTP Get Method
    @GET
    // Path: 
    @Path("/dimensionUnit")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
  
    public ArrayList<DimensionUnit> getAllDimension()  throws SQLException{
		
    	return DimensionUnitDAO.getAllUnit();

    	
    }
	
    
 
    @POST
    @Path("/addUserDimension")
    @Consumes(MediaType.APPLICATION_JSON)
    
    //JSON {"user_dimension_id":null,"dimension_id":1,"name":"waga","value":120,"unit":"kg","user_id":1,"created_on":"2015-04-30"}
    // http://localhost:8080/silownia_java/rest/dimension/addUserDimension
    
    
    public Response addUserDimension(Dimension dimension) throws SQLException{
    	
    	
    	DimensionDAO.addUserDimmension(dimension);
    	
    	return Response.status(200).entity("{\"status\":\"Success\"}").build();
    }
    
    
	
}
