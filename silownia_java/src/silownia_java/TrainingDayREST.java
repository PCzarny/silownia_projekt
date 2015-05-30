package silownia_java;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.TrainingDay;
import dao.TrainingDayDAO;

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
	
}
