package silownia_java;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.User;
import dao.UserDAO;
@Path("/user")
public class UserInfo {
	
	 // HTTP Get Method
    @GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/info")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
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
 

}
