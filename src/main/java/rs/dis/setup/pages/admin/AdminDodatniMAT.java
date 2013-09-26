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
import rs.dis.setup.entities.DodatniMAT;
import rs.dis.setup.entities.Korisnik;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.pages.GenPageDodatni;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AdminDodatniMAT {
    
    @SessionState
    @Property
    private DodatniMAT dodatniMAT;
    @Property
    @Persist
    private DodatniMAT dodatniMATGrid;
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
   private String namena;
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
   private GenPageDodatni genPage;

    public List<DodatniMAT> getDodatniMATlist() {
        return hibernate.createCriteria(DodatniMAT.class).add(Restrictions.eq("dodatniMATActive", true)).list();
    }
    
    
    public void onProgressiveDisplay() {
            getDodatniMATlist();
	}

   @CommitAfter
   public Object onSubmit(){
      
       DodatniMAT dMAT = new DodatniMAT();     
       dMAT.setDodatniMATActive(true);
       dMAT.setDodatniMATCena(cena);
       dMAT.setDodatniMATDimenzije(dimenzije);
       dMAT.setDodatniMATMaterijal(materijal);
       dMAT.setDodatniMATNaziv(naziv);
       dMAT.setDodatniMATOpis(opis);
       dMAT.setDodatniMATProizvodjac(proizvodjac);
       dMAT.setDodatniMATTip(tip);
       dMAT.setDodatniMATNamena(namena);
       hibernate.save(dMAT);
       
        dMAT = new DodatniMAT();
        cena = null;
        dimenzije = null;
        materijal = null;
        naziv = null;
        opis = null;
        proizvodjac = null;
        tip = null;
        namena = null;
       return lista;
       }

       
     
   

   @CommitAfter
    public Zone onActionFromObrisi(long sifra) {
        DodatniMAT delDodatniMAT = (DodatniMAT) hibernate.createCriteria(DodatniMAT.class).add(Restrictions.eq("dodatniMATId", sifra)).list().get(0);
        delDodatniMAT.setDodatniMATActive(false);
        hibernate.saveOrUpdate(delDodatniMAT);
        return lista;
    }
   @CommitAfter
    public Object onActionFromPromeni(long sifra) {
       DodatniMAT changeDodatniMAT = (DodatniMAT) hibernate.createCriteria(DodatniMAT.class).add(Restrictions.eq("dodatniMATId", sifra)).list().get(0);
       dodatniMAT = changeDodatniMAT;
       return genPage;
    }
   

}
