/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.pages.admin;

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
import rs.dis.setup.entities.Lamperija;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.pages.GenPage1;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AdminLamperija {
    
    @SessionState
    @Property
    private Lamperija lamperija;
    @Property
    @Persist
    private Lamperija lamperijaGrid;
    @Inject
    private Session hibernate;
    @SessionState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;
    
   @Validate("required, maxLength=50")
   @Property 
   private String naziv;
   @Validate("required, maxLength=50")
   @Property 
   private String proizvodjac;
   @Validate("required, maxLength=50")
   @Property 
   private String dimenzije;
   @Validate("required, maxLength=50")
   @Property 
   private String tip;
   @Validate("required, maxLength=50")
   @Property 
   private String materijal;
   @Validate("required, maxLength=300")
   @Property 
   private String opis;
   @Validate("required, maxLength=50")
   @Property 
   private String cena;
   
   @Inject
   private Request request;
   @InjectComponent
    private Zone lista;
   
   @InjectPage
   private GenPage1 genPage;

    public List<Lamperija> getLamperijalist() {
        return hibernate.createCriteria(Lamperija.class).add(Restrictions.eq("lamperijaActive", true)).list();
    }
    
    
    public void onProgressiveDisplay() {
            getLamperijalist();
	}

   @CommitAfter
   public Object onSubmit(){
      
       Lamperija lamp = new Lamperija();     
       lamp.setLamperijaActive(true);
       lamp.setLamperijaCena(cena);
       lamp.setLamperijaDimenzije(dimenzije);
       lamp.setLamperijaMaterijal(materijal);
       lamp.setLamperijaNaziv(naziv);
       lamp.setLamperijaOpis(opis);
       lamp.setLamperijaProizvodjac(proizvodjac);
       lamp.setLamperijaTip(tip);
       hibernate.save(lamp);
       
        lamp = new Lamperija();
        cena = null;
        dimenzije = null;
        materijal = null;
        naziv = null;
        opis = null;
        proizvodjac = null;
        tip = null;
       return lista;
       }

       
     
   

   @CommitAfter
    public Zone onActionFromObrisi(long sifra) {
        Lamperija delLamperija = (Lamperija) hibernate.createCriteria(Lamperija.class).add(Restrictions.eq("lamperijaId", sifra)).list().get(0);
        delLamperija.setLamperijaActive(false);
        hibernate.saveOrUpdate(delLamperija);
        return lista;
    }
   @CommitAfter
    public Object onActionFromPromeni(long sifra) {
       Lamperija changeLamperija = (Lamperija) hibernate.createCriteria(Lamperija.class).add(Restrictions.eq("lamperijaId", sifra)).list().get(0);
       lamperija = changeLamperija;
       GenPage1.setTipStrane("lamperija");
       return genPage;
    }
   

}
