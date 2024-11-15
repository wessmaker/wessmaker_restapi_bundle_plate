package fi.wessmaker;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * "root path" of this interface endpoint will be
 * http://localhost:8080/custompath for all HTTP methods
 * The localhost:8080 part is set in CustomActivator.java class
 */
@Path("/custompath")
public interface CustomApiServiceInterface {

   /**
    * Will return a response as JSON and also a HTTP code of 200 if the call worked
    */
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   Response customApiGET();

   /**
    * A diffrent path could be declare for this
    * If set @Path("/subpath") then this POST method
    * endpoint would be http://localhost:8080/custompath/subpath
    */
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   Response customApiPOST(int statusCode);

}
