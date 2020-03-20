package app.model;

public class Validator {
    String messageError;

   public String isValidName(String nameV) {
       if (nameV == null || nameV.isEmpty()) {
           messageError ="Your name of product is empty";
           return messageError;
       }
              return nameV;
       }

//    public Date validDate (Date d) {
//        if (d == null) {
//            d = Date.valueOf("");
//        }
//        return d;
//
//    }

}
