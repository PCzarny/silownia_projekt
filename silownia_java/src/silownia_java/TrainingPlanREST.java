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

import model.TrainingCategory;
import model.TrainingPlan;
import model.UserTraining;
import dao.TrainingPlanDAO;
import dao.UserTrainingDAO;

@Path("/plan")
public class TrainingPlanREST {

	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/getPlans")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/getPlans?byXXX=1&value=1&limit=2&active=2&short=true
	// Parametr byXXX zgodny z klasa ConstanstDAO, value to wartosc np. id, powyzszy przyklad wyszukuje po id=1, nie wazne czy aktywne czy nie, active=0->nieaktywne, active=1->aktywne, acitve>1->obojetnie
    // parametr short dodany w celu wyswietlania skroconego treningu 
    
    public ArrayList<TrainingPlan> AllTrainingPlans(@QueryParam("byXXX") int byXXX, @QueryParam("value") int value, @QueryParam("limit") int limit, @QueryParam("active") int active,@QueryParam("short") boolean short_version) throws SQLException{
		
		return UserTrainingDAO.getTrainingPlans(byXXX,value,limit,short_version);
	
	}
	
	@GET
    @Path("/getOwnerPlans")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/getOwnerPlans?ownerId=1&limit=1&short=true
    public ArrayList<TrainingPlan> OwnerTrainingPlans(@QueryParam("ownerId") int ownerId, @QueryParam("limit") int limit,@QueryParam("short") boolean short_version) throws SQLException{
		
		return UserTrainingDAO.getOwnerPlans(ownerId, limit, short_version);
	
	}
	
	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/getByCategory")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/getByCategory?catId=1&limit=1&short=true 
    public ArrayList<TrainingPlan> CategoryTrainingPlans(@QueryParam("catId") int catId, @QueryParam("limit") int limit,@QueryParam("short") boolean short_version) throws SQLException{
		
		return UserTrainingDAO.getPlansByCat(catId, limit, short_version);
	
	}
	
	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/getUsersPlans")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/getPlans?byXXX=1&value=1&limit=2&active=2&short=true
	// Parametr byXXX zgodny z klasa ConstanstDAO, value to wartosc np. id, powyzszy przyklad wyszukuje po id=1, nie wazne czy aktywne czy nie, active=0->nieaktywne, active=1->aktywne, acitve>1->obojetnie
    // parametr short dodany w celu wyswietlania skroconego treningu 
    
    public ArrayList<TrainingPlan> UsersTrainingPlans(@QueryParam("userId") int userId, @QueryParam("limit") int limit, @QueryParam("active") int active,@QueryParam("short") boolean short_version) throws SQLException{
		
		return UserTrainingDAO.getUsersPlans(userId,limit,active,short_version);
	
	}
	
	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/getPlanByID")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/getPlanByID?planId=1&shortVersion=true
	// Zwraca plan o konkretnym ID
    public TrainingPlan getTrainingPlan(@QueryParam("planId") int planId, @QueryParam("shortVersion") Boolean shortVersion) throws SQLException{
		
		return TrainingPlanDAO.getTrainingPlan(planId, shortVersion);
	
	}
	
	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/getPlansByNameAndCat")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/getPlansByNameAndCat?name=Trening brzucha&catName=Silowy&limit=0&shortVersion=true
	// Zwraca plan o konkretnym ID
    public ArrayList<TrainingPlan> getPlansByName(@QueryParam("name") String name,@QueryParam("catName") String catName, @QueryParam("limit") int limit, @QueryParam("shortVersion") Boolean shortVersion) throws SQLException{
		
		return UserTrainingDAO.getPlansByNameAndCat(name,catName, limit, shortVersion);
	
	}
	
	@GET
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/getCategories")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/plan/getPlansByName?name=Trening brzucha&limit=0&shortVersion=true
	// Zwraca plan o konkretnym ID
    public ArrayList<TrainingCategory> getCategories() throws SQLException{
		
		return UserTrainingDAO.getCategories();
	
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
	       return Response.status(200).entity("Powodzenie").build();
		
	}
	
	@POST
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/asignPlan")
    // Consumes JSON
    @Consumes(MediaType.APPLICATION_JSON) 
    // Wywo³anie: http://localhost:8080/silownia_java/rest/plan/addPlanRow
	//JSON format : {"trainingDays":null,"start_time":null,"is_active":null,"current_day":1,"period":2,"user_id":1,"training_plan_id":1,"owner":1,"name":null,"categoryId":0,"categoryName":null}
    public Response asignPlanToUser(UserTraining plan) throws SQLException{
		

		UserTrainingDAO.addTrainingPlanToUser(plan);
	    return Response.status(200).entity("Powodzenie").build();
		
	}
	
	@POST
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/removePlanFromUser")
    // Consumes JSON
    @Consumes(MediaType.APPLICATION_JSON) 
    // Wywo³anie: http://localhost:8080/silownia_java/rest/plan/addPlanRow
	//JSON format : {"trainingDays":null,"start_time":null,"is_active":null,"current_day":1,"period":2,"user_id":1,"training_plan_id":1,"owner":1,"name":null,"categoryId":0,"categoryName":null}
    public Response removePlanFromUser(UserTraining plan) throws SQLException{
		

		UserTrainingDAO.deleteTrainingPlanToUser(plan);
	    return Response.status(200).entity("Powodzenie").build();
		
	}
	
}
