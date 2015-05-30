package silownia_java;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.TrainingPlan;
import dao.TrainingPlanDAO;

@Path("/plan")
public class TrainingPlanREST {

	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/plansByID")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/plansByID?userId=1
    public ArrayList<TrainingPlan> AllTrainingPlans(@QueryParam("userId") int userId) throws SQLException{
		
		return TrainingPlanDAO.getTrainingPlansByUserID(userId);
		
	}
	
	@POST
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/addPlanRow")
    // Consumes JSON
    @Consumes(MediaType.APPLICATION_JSON) 
    // Wywo³anie: http://localhost:8080/silownia_java/rest/plan/addPlanRow
	//JSON format : {"trainingDays":null,"start_time":null,"is_active":null,"current_day":1,"period":2,"user_id":1,"training_plan_id":1,"owner":1,"name":null,"categoryId":0,"categoryName":null}
    public Response addPlanRow(TrainingPlan plan) throws SQLException{
		

		TrainingPlanDAO.addTreningPlanRow(plan);
		//System.out.println("hehehe");
		/* StringBuilder crunchifyBuilder = new StringBuilder();
	        try {
	            BufferedReader in = new BufferedReader(new InputStreamReader(data));
	            String line = null;
	            while ((line = in.readLine()) != null) {
	                crunchifyBuilder.append(line);
	            }
	        } catch (Exception e) {
	            System.out.println("Error Parsing: - ");
	        }
	        System.out.println("Data Received: " + crunchifyBuilder.toString());
	 
	        // return HTTP response 200 in case of success*/
	       return Response.status(200).entity("Powodzenie").build();
		
	}
	
}
