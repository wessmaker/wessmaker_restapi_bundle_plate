package fi.wessmaker;

/**
 * Custom Plain Old Java Object,
 * POJO is basically object with
 * only basic variables and methods
 */
public class CustomPOJO {
   /**
    * This "statusCode" is value which can be
    * set by POST and get by GET using the api
    */
   private int statusCode;

   public int getStatusCode() {
      return statusCode;
   }

   public void setStatusCode(int statusCode) {
      this.statusCode = statusCode;
   }

}
