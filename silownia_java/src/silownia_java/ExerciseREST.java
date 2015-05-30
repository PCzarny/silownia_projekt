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

import dao.ExerciseDAO;
import model.Exercise;


@Path("/exercise")
public class ExerciseREST {
	
	@GET
    
    @Path("/info")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters:
	//http://localhost:8080/silownia_java/rest/exercise/info?exerciseId=2
    public Exercise exerciseInfo(@QueryParam("exerciseId") int id) throws SQLException{
		
		return ExerciseDAO.getExercise(id);
		
		
	}
	
	
	@POST
    // Path: 
    @Path("/addExercise")
    // Produces JSON as response
    @Consumes(MediaType.APPLICATION_JSON) 
    // wywolanie http://localhost:8080/silownia_java/rest/exercise/addexercise 
	// json {"exercise_id":null,"name":"Rozpi�tki","desription":"Mi�sie� czw�rg�owy","url":null,"permission":0,"user_id":2}
	
	public Response addExercise(Exercise exercise) throws SQLException{
		
		
		ExerciseDAO.addExercise(exercise);
		
		return Response.status(200).entity("Powodzenie").build();
		
	}
	
	
	
	

}
