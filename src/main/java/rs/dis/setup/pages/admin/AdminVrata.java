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
import rs.dis.setup.entities.Vrata;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.pages.GenPage1;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AdminVrata {

    
    @SessionState
    @Property
    private Vrata vrata;
    @Property
    @Persist
    private Vrata vrataGrid;
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

    public List<Vrata> getVratalist() {
        return hibernate.createCriteria(Vrata.class).add(Restrictions.eq("vrataActive", true)).list();
    }
    
    
    public void onProgressiveDisplay() {
            getVratalist();
	}

   @CommitAfter
   public Object onSubmit(){
      
       Vrata vr = new Vrata();     
       vr.setVrataActive(true);
       vr.setVrataCena(cena);
       vr.setVrataDimenzije(dimenzije);
       vr.setVrataMaterijal(materijal);
       vr.setVrataNaziv(naziv);
       vr.setVrataOpis(opis);
       vr.setVrataProizvodjac(proizvodjac);
       vr.setVrataTip(tip);
       hibernate.save(vr);
       
        vr = new Vrata();
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
        Vrata delVrata = (Vrata) hibernate.createCriteria(Vrata.class).add(Restrictions.eq("vrataId", sifra)).list().get(0);
        delVrata.setVrataActive(false);
        hibernate.saveOrUpdate(delVrata);
        return lista;
    }
   
   @CommitAfter
    public Object onActionFromPromeni(long sifra) {
       Vrata changeVrata = (Vrata) hibernate.createCriteria(Vrata.class).add(Restrictions.eq("vrataId", sifra)).list().get(0);    
       vrata = changeVrata;
       GenPage1.setTipStrane("vrata");
       return genPage;
    }

}
