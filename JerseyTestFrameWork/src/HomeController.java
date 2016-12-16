import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/home")
public class HomeController {

	 @GET
		@Path("/api")
		public Response getData(){
	    	System.out.println("from api !!! ");
	    	return Response.status(Status.OK).entity("Hellooo World !!!").build();
		}
	
}
