/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.pages;

import rs.dis.setup.pages.admin.AdminPanel;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import java.util.List;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import rs.dis.setup.entities.Korisnik;
/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/screen.css", "context:css/fixed.css", "context:css/theme/blue.css"}, library={"context:js/jquery-1.4.1.min.js","context:js/jquery.visualize.js",
    "context:js/jquery.styleswitcher.js","context:js/jquery-ui-1.8.13.custom.min.js","context:js/jquery.poshytip.min.js","context:js/jquery.quicksand.js","context:js/jquery.dataTables.min.js",
    "context:js/custom.js"})
public class LogIn {
    
    @Persist
   @Validate("required")
   @Property 
   private String userName;
   @Validate("required")
   @Persist
   @Property 
   private String password;
   
  
    @SessionState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;

    @Inject
    private Session hibernate;
    
    @InjectPage
    private AdminPanel admPan;
   
   public Object onSubmit(){
      List listaRezultata = hibernate.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikIme", userName)).add(Restrictions.eq("korisnikPass", password)).add(Restrictions.eq("korisnikActive", true)).list();
        if(listaRezultata.size() > 0){
            Korisnik temp = (Korisnik) listaRezultata.get(0);
            asoKorisnik = temp;            
        }
return admPan;
   }
   
}
