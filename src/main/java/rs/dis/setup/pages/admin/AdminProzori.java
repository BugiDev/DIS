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
import rs.dis.setup.entities.Prozori;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.pages.GenPage1;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AdminProzori {
    
    @SessionState
    @Property
    private Prozori prozori;
    @Property
    @Persist
    private Prozori prozoriGrid;
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

    public List<Prozori> getProzorilist() {
        return hibernate.createCriteria(Prozori.class).add(Restrictions.eq("prozoriActive", true)).list();
    }
    
    
    public void onProgressiveDisplay() {
            getProzorilist();
	}

   @CommitAfter
   public Object onSubmit(){
      
       Prozori pr = new Prozori();     
       pr.setProzoriActive(true);
       pr.setProzoriCena(cena);
       pr.setProzoriDimenzije(dimenzije);
       pr.setProzoriMaterijal(materijal);
       pr.setProzoriNaziv(naziv);
       pr.setProzoriOpis(opis);
       pr.setProzoriProizvodjac(proizvodjac);
       pr.setProzoriTip(tip);
       hibernate.save(pr);
       
        pr = new Prozori();
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
        Prozori delProzori = (Prozori) hibernate.createCriteria(Prozori.class).add(Restrictions.eq("prozoriId", sifra)).list().get(0);
        delProzori.setProzoriActive(false);
        hibernate.saveOrUpdate(delProzori);
        return lista;
    }
   @CommitAfter
    public Object onActionFromPromeni(long sifra) {
       Prozori changeProzori = (Prozori) hibernate.createCriteria(Prozori.class).add(Restrictions.eq("prozoriId", sifra)).list().get(0);
       prozori = changeProzori; 
       GenPage1.setTipStrane("prozori");
       return genPage;
    }
   

}
