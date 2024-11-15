package fi.wessmaker;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/custompath")
public interface CustomApiServiceInterface {

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   Response customApiGET();

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   Response customApiPOST(int statusCode);
}
