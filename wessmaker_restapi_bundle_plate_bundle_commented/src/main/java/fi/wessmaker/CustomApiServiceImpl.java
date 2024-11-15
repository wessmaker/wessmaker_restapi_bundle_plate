package fi.wessmaker;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class CustomApiServiceImpl implements CustomApiServiceInterface {

   CustomPOJO customPOJO = new CustomPOJO();

   /**
    * These methods will now implement (override)
    * methods of CustomApiServiceInterface
    * Annotations like @GET, @Produces, @Path, etc are inherited
    * so there is no need to declare them again here
    */
   @Override
   public Response customApiGET() {
      return Response.status(Status.OK).entity(customPOJO).build();
   }

   /**
    * The int statusCode can be set by
    * POST HTTP call to the address http://localhost:8080/custompath
    * 
    * For example:
    * {
    * "statusCode" : "123"
    * }
    * 
    * The statusCode will then be directed to method customApiPOST()
    * and 123 will be passed to the (int statuscode) and then it can be
    * handled just like a normal java method call
    */
   @Override
   public Response customApiPOST(int statusCode) {
      customPOJO.setStatusCode(statusCode);

      /**
       * This will also return the customPOJO as "echo"
       * Echoing is done that the caller (client)
       * doesn't have to do GET call after setting POJO
       * (Echoed POJO can be ignored in client's end)
       */
      return Response.status(Status.OK).entity(customPOJO).build();
   }

}
