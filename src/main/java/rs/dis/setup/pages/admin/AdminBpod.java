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
import rs.dis.setup.entities.Bpod;
import rs.dis.setup.entities.Korisnik;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.pages.GenPage1;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AdminBpod {
    
    @SessionState
    @Property
    private Bpod bpod;
    @Property
    @Persist
    private Bpod bpodGrid;
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

    public List<Bpod> getBpodlist() {
        return hibernate.createCriteria(Bpod.class).add(Restrictions.eq("bpodActive", true)).list();
    }
    
    
    public void onProgressiveDisplay() {
            getBpodlist();
	}

   @CommitAfter
   public Object onSubmit(){
      
       Bpod bp = new Bpod();     
       bp.setBpodActive(true);
       bp.setBpodCena(cena);
       bp.setBpodDimenzije(dimenzije);
       bp.setBpodMaterijal(materijal);
       bp.setBpodNaziv(naziv);
       bp.setBpodOpis(opis);
       bp.setBpodProizvodjac(proizvodjac);
       bp.setBpodTip(tip);
       hibernate.save(bp);
       
        bp = new Bpod();
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
        Bpod delBpod = (Bpod) hibernate.createCriteria(Bpod.class).add(Restrictions.eq("bpodId", sifra)).list().get(0);
        delBpod.setBpodActive(false);
        hibernate.saveOrUpdate(delBpod);
        return lista;
    }
   @CommitAfter
    public Object onActionFromPromeni(long sifra) {
       Bpod changeBpod = (Bpod) hibernate.createCriteria(Bpod.class).add(Restrictions.eq("bpodId", sifra)).list().get(0);
       bpod = changeBpod;
       GenPage1.setTipStrane("bpod");
       return genPage;
    }
   

}
