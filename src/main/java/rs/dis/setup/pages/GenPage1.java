/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.pages;



import rs.dis.setup.pages.admin.AdminBpod;
import rs.dis.setup.pages.admin.AdminProzori;
import rs.dis.setup.pages.admin.AdminLamperija;
import rs.dis.setup.pages.admin.AdminPanel;
import rs.dis.setup.pages.admin.AdminVrata;
import rs.dis.setup.pages.admin.AdminLaminat;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.hibernate.Session;
import rs.dis.setup.entities.Bpod;
import rs.dis.setup.entities.Laminat;
import rs.dis.setup.entities.Lamperija;
import rs.dis.setup.entities.Prozori;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.entities.Vrata;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
public class GenPage1 {

    /**
     * @return the tipStrane
     */
    public static String getTipStrane() {
        return tipStrane;
    }

    /**
     * @param aTipStrane the tipStrane to set
     */
    public static void setTipStrane(String aTipStrane) {
        tipStrane = aTipStrane;
    }
     
    @SessionState
    private Vrata vrata;
    @SessionState
    @Property
    private Bpod bpod;
    @SessionState
    @Property
    private Laminat laminat;
    @SessionState
    @Property
    private Lamperija lamperija;
    @SessionState
    @Property
    private Prozori prozori;
    @Property
    @Inject
    private Session hibernate;
    
   
   @Validate("required, maxLength=50") 
   private String naziv;
   
   @Validate("required, maxLength=50") 
   private String proizvodjac;
   
   @Validate("required, maxLength=50") 
   private String dimenzije;
   
   @Validate("required, maxLength=50") 
   private String tip;
  
   @Validate("required, maxLength=50") 
   private String materijal;
   
   @Validate("required, maxLength=300") 
   private String opis;
   
   @Validate("required, maxLength=50") 
   private String cena;

   
   
   private static String tipStrane;
   
   @Inject
   private Request request;

   
   public Object onSubmit(){ 
       
            if (getTipStrane().equals("vrata")){vrataChange(); pocisti(); return AdminVrata.class;}
            else if (getTipStrane().equals("prozori")){prozoriChange(); pocisti(); return AdminProzori.class;}
            else if (getTipStrane().equals("bpod")){bpodChange(); pocisti(); return AdminBpod.class;}
            else if (getTipStrane().equals("lamperija")){lamperijaChange(); pocisti(); return AdminLamperija.class;}
            else if (getTipStrane().equals("laminat")){laminatChange(); pocisti(); return AdminLaminat.class;}
       
           return AdminPanel.class; 
       }
    
    @CommitAfter
   public void vrataChange(){ 
       vrata.setVrataActive(true);
       vrata.setVrataCena(getCena());
       vrata.setVrataDimenzije(getDimenzije());
       vrata.setVrataMaterijal(getMaterijal());
       vrata.setVrataNaziv(getNaziv());
       vrata.setVrataOpis(getOpis());
       vrata.setVrataProizvodjac(getProizvodjac());
       vrata.setVrataTip(getTip()); 
       hibernate.update(vrata);
       
   }
    
    @CommitAfter
   public void prozoriChange(){     
       prozori.setProzoriActive(true);
       prozori.setProzoriCena(getCena());
       prozori.setProzoriDimenzije(getDimenzije());
       prozori.setProzoriMaterijal(getMaterijal());
       prozori.setProzoriNaziv(getNaziv());
       prozori.setProzoriOpis(getOpis());
       prozori.setProzoriProizvodjac(getProizvodjac());
       prozori.setProzoriTip(getTip());
       hibernate.update(prozori);
   }
   
    @CommitAfter
   public void bpodChange(){     
       bpod.setBpodActive(true);
       bpod.setBpodCena(getCena());
       bpod.setBpodDimenzije(getDimenzije());
       bpod.setBpodMaterijal(getMaterijal());
       bpod.setBpodNaziv(getNaziv());
       bpod.setBpodOpis(getOpis());
       bpod.setBpodProizvodjac(getProizvodjac());
       bpod.setBpodTip(getTip());
       hibernate.update(bpod);
   }
    
    @CommitAfter
   public void laminatChange(){     
       laminat.setLaminatActive(true);
       laminat.setLaminatCena(getCena());
       laminat.setLaminatDimenzije(getDimenzije());
       laminat.setLaminatMaterijal(getMaterijal());
       laminat.setLaminatNaziv(getNaziv());
       laminat.setLaminatOpis(getOpis());
       laminat.setLaminatProizvodjac(getProizvodjac());
       laminat.setLaminatTip(getTip());
       hibernate.update(laminat);
   }
    
      @CommitAfter
   public void lamperijaChange(){     
       lamperija.setLamperijaActive(true);
       lamperija.setLamperijaCena(getCena());
       lamperija.setLamperijaDimenzije(getDimenzije());
       lamperija.setLamperijaMaterijal(getMaterijal());
       lamperija.setLamperijaNaziv(getNaziv());
       lamperija.setLamperijaOpis(getOpis());
       lamperija.setLamperijaProizvodjac(getProizvodjac());
       lamperija.setLamperijaTip(getTip());
       hibernate.update(lamperija);
   }
      
   @SetupRender   
   public void postaviPodatke(){
  if (getTipStrane().equals("vrata")){postaviVrata();}
            else if (getTipStrane().equals("prozori")){postaviProzore();}
            else if (getTipStrane().equals("bpod")){postaviBpod();}
            else if (getTipStrane().equals("lamperija")){postaviLamperiju();}
            else if (getTipStrane().equals("laminat")){postaviLaminat();}
   }   
      
   public void postaviVrata(){
       setCena(vrata.getVrataCena());
   setDimenzije(vrata.getVrataDimenzije());
   setMaterijal(vrata.getVrataMaterijal());
   setNaziv(vrata.getVrataNaziv());
   setOpis(vrata.getVrataOpis());
   setProizvodjac(vrata.getVrataProizvodjac());
   setTip(vrata.getVrataTip());
   }
   
   public void postaviProzore(){
       setCena(prozori.getProzoriCena());
   setDimenzije(prozori.getProzoriDimenzije());
   setMaterijal(prozori.getProzoriMaterijal());
   setNaziv(prozori.getProzoriNaziv());
   setOpis(prozori.getProzoriOpis());
   setProizvodjac(prozori.getProzoriProizvodjac());
   setTip(prozori.getProzoriTip());
   }
   
   public void postaviBpod(){
       setCena(bpod.getBpodCena());
   setDimenzije(bpod.getBpodDimenzije());
   setMaterijal(bpod.getBpodMaterijal());
   setNaziv(bpod.getBpodNaziv());
   setOpis(bpod.getBpodOpis());
   setProizvodjac(bpod.getBpodProizvodjac());
   setTip(bpod.getBpodTip());
   }
   
   public void postaviLamperiju(){
       setCena(lamperija.getLamperijaCena());
   setDimenzije(lamperija.getLamperijaDimenzije());
   setMaterijal(lamperija.getLamperijaMaterijal());
   setNaziv(lamperija.getLamperijaNaziv());
   setOpis(lamperija.getLamperijaOpis());
   setProizvodjac(lamperija.getLamperijaProizvodjac());
   setTip(lamperija.getLamperijaTip());
   }
   
   public void postaviLaminat(){
       setCena(laminat.getLaminatCena());
   setDimenzije(laminat.getLaminatDimenzije());
   setMaterijal(laminat.getLaminatMaterijal());
   setNaziv(laminat.getLaminatNaziv());
   setOpis(laminat.getLaminatOpis());
   setProizvodjac(laminat.getLaminatProizvodjac());
   setTip(laminat.getLaminatTip());
   }
   
   public void pocisti(){
        vrata = new Vrata();
        bpod = new Bpod();
        laminat = new Laminat();
        lamperija = new Lamperija();
        prozori = new Prozori();
                
        setCena(null);
        setDimenzije(null);
        setMaterijal(null);
        setNaziv(null);
        setOpis(null);
        setProizvodjac(null);
        setTip(null);
        setTipStrane(null);
        
   }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * @return the proizvodjac
     */
    public String getProizvodjac() {
        return proizvodjac;
    }

    /**
     * @param proizvodjac the proizvodjac to set
     */
    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    /**
     * @return the dimenzije
     */
    public String getDimenzije() {
        return dimenzije;
    }

    /**
     * @param dimenzije the dimenzije to set
     */
    public void setDimenzije(String dimenzije) {
        this.dimenzije = dimenzije;
    }

    /**
     * @return the tip
     */
    public String getTip() {
        return tip;
    }

    /**
     * @param tip the tip to set
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * @return the materijal
     */
    public String getMaterijal() {
        return materijal;
    }

    /**
     * @param materijal the materijal to set
     */
    public void setMaterijal(String materijal) {
        this.materijal = materijal;
    }

    /**
     * @return the opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     * @param opis the opis to set
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * @return the cena
     */
    public String getCena() {
        return cena;
    }

    /**
     * @param cena the cena to set
     */
    public void setCena(String cena) {
        this.cena = cena;
    }

   
    
  

    

    
   
   
}
