package silownia_java;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.*;
import dao.Dimension_dao;;
@Path("/dimension")
public class DimensionRest {

	 // HTTP Get Method
    @GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/lastDimension")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public Dimension getLastDimension(@QueryParam("userId") int uId,@QueryParam("dimensionId") int dimensionId) throws SQLException{
    
 
    	return Dimension_dao.getLastDimension(uId, dimensionId);       
    }
 
	
	
	
}
