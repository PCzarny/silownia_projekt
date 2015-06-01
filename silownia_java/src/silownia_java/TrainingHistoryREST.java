package silownia_java;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.DoneExerciseDAO;
import dao.TrainingHistoryDAO;
import model.DoneExercise;
import model.TrainingHistory;



@Path("/trainingHistory")
public class TrainingHistoryREST {
	
	
	
	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/getUserHistory")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
	// http://localhost:8080/silownia_java/rest/trainingHistory/getUserHistory?userId=1
	// JSON  
	
	public TrainingHistory getTrainingHistory(@QueryParam("userId")int uID) throws SQLException{
		
		return TrainingHistoryDAO.getTrainingHistory(uID);
		
		
	}
	
	
	@POST
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/addDoneExercise")
    // Produces JSON as response
    @Consumes(MediaType.APPLICATION_JSON) 
	// http://localhost:8080/silownia_java/rest/trainingHistory/getUserHistory?userId=1
	// JSON  

	public Response addExercise(DoneExercise doneExercise) throws SQLException{
		
		DoneExerciseDAO.addDoneExercise(doneExercise);
		return Response.status(200).entity("Powodzenie").build();
		
	}

}
