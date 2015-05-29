package silownia_java;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.ExerciseDAO;
import model.Exercise;


@Path("/exercise")
public class ExerciseInfo {
	
	@GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/info")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public Exercise exerciseInfo(@QueryParam("exerciseId") int id) throws SQLException{
		
		return ExerciseDAO.getExercise(id);
		
		
	}
	
	
	
	
	

}
