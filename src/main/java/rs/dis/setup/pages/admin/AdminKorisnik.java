/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.pages.admin;

import java.util.Date;
import java.util.List;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import rs.dis.setup.entities.Korisnik;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.pages.GenPage3;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AdminKorisnik {
    
    @SessionState
    @Property
    private Korisnik korisnik;
    @Property
    @Persist
    private Korisnik korisnikGrid;
    @Inject
    private Session hibernate;
    @SessionState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;
    
   @Validate("required, maxLength=50")
   @Property 
   private String ime;
   @Validate("required, maxLength=50")
   @Property 
   private String pass;

   
   @Inject
   private Request request;
   @InjectComponent
    private Zone lista;
   
   @InjectPage
   private GenPage3 genPage;

    public List<Korisnik> getKorisniklist() {
        return hibernate.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikActive", true)).list();
    }
    
    
    public void onProgressiveDisplay() {
            getKorisniklist();
	}

   @CommitAfter
   public Object onSubmit(){
      
       Korisnik kor = new Korisnik();     
       kor.setKorisnikActive(true);
       kor.setKorisnikIme(ime);
       kor.setKorisnikPass(pass);
       kor.setKorisnikRola(TipKorisnika.ADMIN);
       kor.setKorisnikTs(new Date());
       kor.setKorisnikUser(ime);
       hibernate.save(kor);
       
        kor = new Korisnik();
        ime = null;
        pass = null;
       return lista;
       }

       
     
   

   @CommitAfter
    public Zone onActionFromObrisi(long sifra) {
        Korisnik delKorisnik = (Korisnik) hibernate.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikId", sifra)).list().get(0);
        delKorisnik.setKorisnikActive(false);
        hibernate.saveOrUpdate(delKorisnik);
        return lista;
    }
   @CommitAfter
    public Object onActionFromPromeni(long sifra) {
       Korisnik changeKorisnik = (Korisnik) hibernate.createCriteria(Korisnik.class).add(Restrictions.eq("korisnikId", sifra)).list().get(0);
       korisnik = changeKorisnik;
       return genPage;
    }
   

}
