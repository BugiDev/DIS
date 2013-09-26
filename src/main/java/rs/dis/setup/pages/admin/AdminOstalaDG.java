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
import rs.dis.setup.entities.OstalaDG;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.pages.GenPageOstala;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AdminOstalaDG {
    
    @SessionState
    @Property
    private OstalaDG ostalaDG;
    @Property
    @Persist
    private OstalaDG OstalaDGGrid;
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
   private String vrsta;
   @Validate("required, maxLength=200")
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
   private GenPageOstala genPage;

    public List<OstalaDG> getOstalaDGlist() {
        return hibernate.createCriteria(OstalaDG.class).add(Restrictions.eq("ostalaDGActive", true)).list();
    }
    
    
    public void onProgressiveDisplay() {
            getOstalaDGlist();
	}

   @CommitAfter
   public Object onSubmit(){
      
       OstalaDG oDG = new OstalaDG();     
       oDG.setOstalaDGActive(true);
       oDG.setOstalaDGCena(cena);
       oDG.setOstalaDGDimenzije(dimenzije);
       oDG.setOstalaDGMaterijal(materijal);
       oDG.setOstalaDGNaziv(naziv);
       oDG.setOstalaDGOpis(opis);
       oDG.setOstalaDGProizvodjac(proizvodjac);
       oDG.setOstalaDGTip(tip);
       oDG.setOstalaDGVrsta(vrsta);
       hibernate.save(oDG);
       
        oDG = new OstalaDG();
        cena = null;
        dimenzije = null;
        materijal = null;
        naziv = null;
        opis = null;
        proizvodjac = null;
        tip = null;
        vrsta = null;
       return lista;
       }

       
     
   

   @CommitAfter
    public Zone onActionFromObrisi(long sifra) {
        OstalaDG delOstalaDG = (OstalaDG) hibernate.createCriteria(OstalaDG.class).add(Restrictions.eq("ostalaDGId", sifra)).list().get(0);
        delOstalaDG.setOstalaDGActive(false);
        hibernate.saveOrUpdate(delOstalaDG);
        return lista;
    }
   @CommitAfter
    public Object onActionFromPromeni(long sifra) {
       OstalaDG changeOstalaDG = (OstalaDG) hibernate.createCriteria(OstalaDG.class).add(Restrictions.eq("ostalaDGId", sifra)).list().get(0);
       ostalaDG = changeOstalaDG;
       return genPage;
    }
   

}
