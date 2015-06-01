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

import model.TrainingPlan;
import model.User;
import dao.TrainingPlanDAO;
import dao.UserDAO;
@Path("/user")
public class UserREST {
	
	 // HTTP Get Method
    @GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/info")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost:8080/silownia_java/rest/user/info?userId=1
    public User userInfo(@QueryParam("userId") int uId) throws SQLException{
    //    String response = "";
       // User_dao.getUser(uId);
       // if(checkCredentials(uname, pwd)){
         //   response = Utility.
        //}else{
         //   response = Utility.constructJSON("login", false, "Incorrect Email or Password");
       // }
    	System.out.println("IUD"+uId);
    	return UserDAO.getUser(uId);       
    }
 
    @POST
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/updateProfile")
    // Consumes JSON
    @Consumes(MediaType.APPLICATION_JSON) 
    // Wywo³anie: http://localhost:8080/silownia_java/rest/user/updateProfile
	//JSON format :{"userId":2,"name":"Micha³","surname":"Sztuka","login":"tracer","password":"haslo","email":"nowy@email","create_on":"2015-04-14"}
    public Response updateProfile(User user) throws SQLException{

		UserDAO.updateProfile(user);
		
		return Response.status(200).entity("Powodzenie").build();
		
	}
    
    @POST
    // Path: http://localhost/<appln-folder-name>/rest/plan
    @Path("/registerUser")
    // Consumes JSON
    @Consumes(MediaType.APPLICATION_JSON) 
    // Wywo³anie: http://localhost:8080/silownia_java/rest/user/updateProfile
	//JSON format :{"userId":2,"name":"Micha³","surname":"Sztuka","login":"tracer","password":"haslo","email":"nowy@email","create_on":"2015-04-14"}
    public Response registerUser(User user) throws SQLException{

		UserDAO.registerUser(user);
		
		return Response.status(200).entity("Powodzenie").build();
		
	}

}
