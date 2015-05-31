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
import dao.UserTrainingDAO;

@Path("/plan")
public class TrainingPlanREST {

	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/getPlans")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/getPlans?byXXX=1&value=1&active=2&short=false
	// Parametr byXXX zgodny z klasa ConstanstDAO, value to wartosc np. id, powyzszy przyklad wyszukuje po id=1, nie wazne czy aktywne czy nie, active=0->nieaktywne, active=1->aktywne, acitve>1->obojetnie
    // parametr short dodany w celu wyswietlania skroconego treningu 
    
    public ArrayList<TrainingPlan> AllTrainingPlans(@QueryParam("byXXX") int byXXX, @QueryParam("value") int value, @QueryParam("active") int active,@QueryParam("short") boolean short_version) throws SQLException{
		
		return UserTrainingDAO.getTrainingPlans(byXXX,value,active,short_version);
	
	}
	
	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/getPlanByID")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/getPlanByID?planId=1
	// Zwraca plan o konkretnym ID
    public TrainingPlan getTrainingPlan(@QueryParam("planId") int planId) throws SQLException{
		
		return TrainingPlanDAO.getTrainingPlans(planId);
	
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
