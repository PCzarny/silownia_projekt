package silownia_java;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.ExerciseTarget;

import dao.ExerciseTargetDAO;

@Path("/ExerciseTarget")
public class ExerciseTargetREST {
	
	
	@GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/Info")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
  
    public ArrayList<ExerciseTarget> userExerciseTarget(@QueryParam("userId") int userId) throws SQLException{
		
		return ExerciseTargetDAO.getUserExerciseTarget(userId);
		
	}

}
