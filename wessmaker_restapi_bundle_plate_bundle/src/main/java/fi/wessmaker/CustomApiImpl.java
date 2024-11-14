package fi.wessmaker;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class CustomApiImpl implements CustomApiService {
   CustomPOJO customPOJO;

   @Override
   public Response customApiGET() {
      if (this.customPOJO == null) {
         this.customPOJO = new CustomPOJO();
      }
      return Response.status(Status.OK).entity(this.customPOJO).build();
   }

   @Override
   public Response customApiPOST(int statusCode) {
      if (this.customPOJO == null) {
         this.customPOJO = new CustomPOJO();
      }
      this.customPOJO.setStatusCode(statusCode);
      return Response.status(Status.OK).entity(this.customPOJO).build();
   }
}
