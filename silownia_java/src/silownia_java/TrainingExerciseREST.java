package silownia_java;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.TrainingExercise;
import model.TrainingPlan;
import dao.TrainingExerciseDAO;
import dao.TrainingPlanDAO;

@Path("/trainingExercise")
public class TrainingExerciseREST {

	@POST
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/addExercises")
    // Consumes JSON
    @Consumes(MediaType.APPLICATION_JSON) 
    // Wywo³anie: http://localhost:8080/silownia_java/rest/trainingExercise/addExercises
	//JSON format : {["exercise_id":1,"name":null,"desription":null,"url":null,"permission":null,"user_id":1,"series":2,"repeats":3,"trainingDayID":2]}
    public Response addExercises(ArrayList<TrainingExercise> exercises) throws SQLException{


		TrainingExerciseDAO.addExercises(exercises);
	
	    return Response.status(200).entity("Powodzenie").build();
		
	}
	
}
