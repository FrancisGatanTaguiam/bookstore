/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */
package bookstore.services.ws.validation;

import java.math.BigInteger;
/**
 * <p>
 * User for validating information.
 * </p>
 *
 * @since June 29, 2016
 */
public class Validation {
    
    public boolean textOnly(String text) {
        return text.matches("^[a-zA-z]*$");
    }

    public boolean alphanumeric(String text) {
        return text.matches("^[a-zA-Z0-9 \\u00f1\\u00d1]*$");
    }

    public boolean numberOnly(String text) {
        return text.matches("^[0-9]*$");
    }

    public boolean numberOnly(BigInteger text) {
        return text.toString().matches("^[0-9]*$");
    }

    public boolean numberOnly(int text) {
        String b = "" + text;
        return b.matches("^[0-9]*$");
    }

    public boolean lowercase(String text) {
        return text.matches("^[a-z]*$");
    }

    public boolean uppercase(String text) {
        return text.matches("^[A-Z]*$");
    }

    public boolean date(String date) {
        return (date.matches("((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])"));
    }

    public boolean email(String email) {
        return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    public boolean vText(String text){
        return (text!=null &&  text.trim().isEmpty() == false && alphanumeric(text) );
    }
    public boolean vNum(String text){
        return (text!=null &&  text.trim().isEmpty() == false && numberOnly(text) );
    }
    public boolean vBigNum(BigInteger text){
        return (numberOnly(text) && text!=null && BigInteger.ZERO.compareTo(text) != 0);
    }
    public boolean vIntNum(int text){
        return (numberOnly(text) && text>0);
    }
    
    public boolean vEmail(String text){
        return (email(text) && text!=null);
    }
    
    public boolean vDate(String text){
        return (date(text) && text!=null);
    }
    
    public boolean lettersSpaceOnly(String text) {
        return text.matches("^[a-zA-Z \\u00f1\\u00d1]*$");
    }
     
    public boolean containsNumber(String text) {
        return text.matches(".*\\d+.*");
    }  

    public String trimName(String name) {    
        return name.replaceAll("\\s+", " ").trim();
    }    
    
    public String toUp(String text){
        return text.toUpperCase();
    }
}
