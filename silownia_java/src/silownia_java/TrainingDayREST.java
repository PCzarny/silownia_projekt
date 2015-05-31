package silownia_java;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.TrainingDay;
import dao.TrainingDayDAO;

import javax.ws.rs.core.Response;
@Path("/trainingDay")
public class TrainingDayREST {

	@GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/allDays")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/trainingDay/allDays?trainingPlanId=1
    public ArrayList<TrainingDay> AllTrainingDays(@QueryParam("trainingPlanId") int trainingPlanId) throws SQLException{
		
		return TrainingDayDAO.getTrainingDays(trainingPlanId);
		
	}
	
	
	@POST
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/addDay")
    // Produces JSON as response
    @Consumes(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/trainingDay/addDay
	// JSON {"exercises":null,"trainingDayID":null,"dayNr":4,"trainingPlanID":1} 
	
	
	public Response addTrainingDay(TrainingDay trainingDay) throws SQLException{
		
		System.out.println("ok");
		TrainingDayDAO.addTrainingDay(trainingDay);
		
		return Response.status(200).entity("Powodzenie").build();
		
	}
	
	
	
	
}





