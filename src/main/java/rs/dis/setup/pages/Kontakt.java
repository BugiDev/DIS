/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.dis.setup.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import rs.dis.setup.components.Border;
import rs.dis.setup.services.SendMail;



/**
 *
 * @author Bogdan Begovic
 */
@Import(library={"context:js/jquery-1.6.js","context:js/maps.js","context:js/tabs.js"})
public class Kontakt {
    @Environmental 
private JavaScriptSupport javaScriptSupport; 
    
   void setupRender(){
    javaScriptSupport.importJavaScriptLibrary("http://maps.google.com/maps/api/js?sensor=true");
   
}
   
   private String bojaSlanja;
   private String poslatoTrue = "Email has been sent!!!";
   private String poslatoFalse = "An error occurred while sending the email. Please try again later.";
   
   @Validate("required")
   @Property 
   private String name;
   @Validate("required")
   @Property 
   private String company;
   @Validate("required,email")
   @Property 
   private String foreignEmail;
   @Validate("required")
   @Property 
   private String text;
   @InjectComponent
   private Zone poslatEmail;
   @Inject
   private Request request;
   @Inject
    private Block emailBlockTrue;
   @Inject
    private Block emailBlockFalse;
   
   
   public Object onSubmit(){
       SendMail email = new SendMail("Kontakt od strane : " + name +" "+ company,"Kontakt od strane : " + name +". \n Ime kompanije: "+ company +". \n Email kompanije je " + foreignEmail + "\n \n" + text, "bogdanbegovic@gmail.com");
        
       if (email.isPoslat()){
          
                                if (Index.getJezik().equals("rs") || Border.getJezik().equals("rs"))
                                setPoslatoTrue("Email je uspešno poslat!!!");
                                
       setBojaSlanja("background-color: #60b000;");
       return emailBlockTrue;
       }
       else{
           if (Index.getJezik().equals("rs") || Border.getJezik().equals("rs"))
           setPoslatoFalse("Dogodila se greška pri slanju email-a. Molimo vas pokušajte ponovo kasnije.");
           
           setBojaSlanja("background-color: #FF3333;");
       }
       return request.isXHR() ? emailBlockFalse : null; 
   } 
       
   Object onActionFromReset() {
     this.name = null;
     this.company = null;
     this.foreignEmail = null;
     this.text = null;
     return null;
     }

   

    /**
     * @return the bojaSlanja
     */
    public String getBojaSlanja() {
        return bojaSlanja;
    }

    /**
     * @param bojaSlanja the bojaSlanja to set
     */
    public void setBojaSlanja(String bojaSlanja) {
        this.bojaSlanja = bojaSlanja;
    }

    /**
     * @return the poslatoTrue
     */
    public String getPoslatoTrue() {
        return poslatoTrue;
    }

    /**
     * @param poslatoTrue the poslatoTrue to set
     */
    public void setPoslatoTrue(String poslatoTrue) {
        this.poslatoTrue = poslatoTrue;
    }

    /**
     * @return the poslatoFalse
     */
    public String getPoslatoFalse() {
        return poslatoFalse;
    }

    /**
     * @param poslatoFalse the poslatoFalse to set
     */
    public void setPoslatoFalse(String poslatoFalse) {
        this.poslatoFalse = poslatoFalse;
    }
   
   
   
}
