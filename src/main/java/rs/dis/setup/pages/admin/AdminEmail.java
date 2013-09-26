/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.pages.admin;


import java.util.List;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

import org.apache.tapestry5.services.Request;
import org.hibernate.Session;
import rs.dis.setup.entities.Email;
import rs.dis.setup.entities.Korisnik;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.services.ProtectedPage;
import rs.dis.setup.services.SendMail;

@ProtectedPage(getRole=TipKorisnika.ADMIN)
@Import(stylesheet={"context:css/screen.css", "context:css/fixed.css", "context:css/theme/blue.css"}, library={"context:js/jquery-1.4.1.min.js","context:js/jquery.visualize.js",
    "context:js/custom.js","context:js/jquery-ui-1.8.13.custom.min.js","context:js/jquery.poshytip.min.js","context:js/jquery.quicksand.js","context:js/jquery.dataTables.min.js"})
public class AdminEmail {
    
   private String bojaSlanja;
   private String poslatoTrue = "Email je uspešno poslat!!!";
   private String poslatoFalse = "Dogodila se greška pri slanju email-a. Molimo vas pokušajte ponovo kasnije.";
   @SessionState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;
   
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
   
   @Persist
    @Property
    private Email email;
    @Property
    @Inject
    private Session hibernate;
    
    public List<Email> getEmaillist() {
        return hibernate.createCriteria(Email.class).list();
    }
   
   public Object onSubmit(){
        SendMail mailZaSlanje = null;
       
       for (int i = 0; i < getEmaillist().size(); i++) {
           Email trenutniMail = (Email) hibernate.createCriteria(Email.class).list().get(i); 
           mailZaSlanje = new SendMail("Kontakt od strane preduzeća D&S D.O.O ",text,trenutniMail.getEmailVrednost());  
           
       }
   
       if (mailZaSlanje.isPoslat()){   
       setBojaSlanja("background-color: #60b000;");
       return emailBlockTrue;
       }
       else{
           
           setBojaSlanja("background-color: #FF3333;");
       }
       return request.isXHR() ? emailBlockFalse : null; 
   } 
    
   
   
    Object onActionFromReset() {
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

