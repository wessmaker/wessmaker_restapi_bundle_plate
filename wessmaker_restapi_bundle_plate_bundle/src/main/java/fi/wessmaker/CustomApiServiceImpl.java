package fi.wessmaker;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class CustomApiServiceImpl implements CustomApiServiceInterface {

   CustomPOJO customPOJO = new CustomPOJO();

   @Override
   public Response customApiGET() {
      return Response.status(Status.OK).entity(customPOJO).build();
   }

   @Override
   public Response customApiPOST(int statusCode) {
      customPOJO.setStatusCode(statusCode);
      return Response.status(Status.OK).entity(customPOJO).build();
   }

}