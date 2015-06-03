package silownia_java;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.User;
import model.UserLogin;
import dao.UserDAO;

@Path("/login")
public class LoginREST {

	  @POST
	    // Path: http://localhost/<appln-folder-name>/rest/plan
	    @Path("/auth")
	    // Consumes JSON
	    @Consumes(MediaType.APPLICATION_JSON) 
	    // Wywo³anie: http://localhost:8080/silownia_java/rest/user/updateProfile
		//JSON format :{"userId":2,"name":"Micha³","surname":"Sztuka","login":"tracer","password":"haslo","email":"nowy@email","create_on":"2015-04-14"}
	    public Response loginUser(UserLogin loginUser) throws SQLException{

	    	User user = new User(); 
	    	user = UserDAO.login(loginUser);
	    	if(user.getUserId()>0)
	    		return Response.status(200).entity("{\"login\":\""+user.getLogin()+"\",\"id\":\""+user.getUserId()+"\"}").build();
	    	else
	    		return Response.status(403).entity("{\"status\":\"B³¹d logowania\"}").build();
		}
	
	
}
