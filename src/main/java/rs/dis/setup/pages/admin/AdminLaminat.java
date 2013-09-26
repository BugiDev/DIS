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
import rs.dis.setup.entities.Laminat;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.pages.GenPage1;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AdminLaminat {
    
    @SessionState
    @Property
    private Laminat laminat;
    @Property
    @Persist
    private Laminat laminatGrid;
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

    public List<Laminat> getLaminatlist() {
        return hibernate.createCriteria(Laminat.class).add(Restrictions.eq("laminatActive", true)).list();
    }
    
    
    public void onProgressiveDisplay() {
            getLaminatlist();
	}

   @CommitAfter
   public Object onSubmit(){
      
       Laminat lam = new Laminat();     
       lam.setLaminatActive(true);
       lam.setLaminatCena(cena);
       lam.setLaminatDimenzije(dimenzije);
       lam.setLaminatMaterijal(materijal);
       lam.setLaminatNaziv(naziv);
       lam.setLaminatOpis(opis);
       lam.setLaminatProizvodjac(proizvodjac);
       lam.setLaminatTip(tip);
       hibernate.save(lam);
       
        lam = new Laminat();
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
        Laminat delLaminat = (Laminat) hibernate.createCriteria(Laminat.class).add(Restrictions.eq("laminatId", sifra)).list().get(0);
        delLaminat.setLaminatActive(false);
        hibernate.saveOrUpdate(delLaminat);
        return lista;
    }
   @CommitAfter
    public Object onActionFromPromeni(long sifra) {
       Laminat changeLaminat = (Laminat) hibernate.createCriteria(Laminat.class).add(Restrictions.eq("laminatId", sifra)).list().get(0);
       laminat = changeLaminat;
       GenPage1.setTipStrane("laminat");
       return genPage;
    }
   

}
