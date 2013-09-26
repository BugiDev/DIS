/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.pages;



import rs.dis.setup.pages.admin.AdminKorisnik;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.hibernate.Session;
import rs.dis.setup.entities.Korisnik;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
public class GenPage3 {
     
    @SessionState
    private Korisnik korisnik;
    @Property
    @Inject
    private Session hibernate;
    
   
   @Validate("required, maxLength=50") 
   private String ime;
   
   @Validate("required, maxLength=50") 
   private String pass;
   
   @Inject
   private Request request;

   @CommitAfter
   public Object onSubmit(){ 
       
       korisnik.setKorisnikIme(getIme());
       korisnik.setKorisnikPass(getPass()); 
       hibernate.update(korisnik);
           return AdminKorisnik.class; 
       }
    
   
      
   @SetupRender   
   public void postaviPodatke(){
    setIme(korisnik.getKorisnikIme());
   setPass(korisnik.getKorisnikPass());
   }   
      
   
   public void pocisti(){
        korisnik = new Korisnik();
        
        setIme(null);
        setPass(null);
        
   }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    

   
    
  

    

    
   
   
}
