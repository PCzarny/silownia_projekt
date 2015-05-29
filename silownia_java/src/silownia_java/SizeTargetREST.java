package silownia_java;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.SizeTarget;
import dao.SizeTargetDAO;

@Path("/target")
public class SizeTargetREST {

	
	@GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/info")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/target/info?userId=1&dimensionName=waga
    public SizeTarget TargetInfo(@QueryParam("userId") int userId,  @QueryParam("dimensionName") String dimensionName) throws SQLException{
		
		return SizeTargetDAO.getTarget(userId, dimensionName);
		
	}
	
	@GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/allTargets")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/allTargets/info?userId=1
    public ArrayList<SizeTarget> AllTargetsInfo(@QueryParam("userId") int userId) throws SQLException{
		
		return SizeTargetDAO.getAllTargets(userId);
		
	}
}
