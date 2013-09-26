/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.pages;



import rs.dis.setup.pages.admin.AdminDodatniMAT;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.hibernate.Session;
import rs.dis.setup.entities.DodatniMAT;
import rs.dis.setup.entities.TipKorisnika;
import rs.dis.setup.services.ProtectedPage;

/**
 *
 * @author Bogdan Begovic
 */
@ProtectedPage(getRole=TipKorisnika.ADMIN)
public class GenPageDodatni {
     
    @SessionState
    private DodatniMAT dodatniMAT;
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
   private String namena;
  
   @Validate("required, maxLength=50") 
   private String materijal;
   
   @Validate("required, maxLength=300") 
   private String opis;
   
   @Validate("required, maxLength=50") 
   private String cena;
   
   @Inject
   private Request request;

   @CommitAfter
   public Object onSubmit(){ 
       
       dodatniMAT.setDodatniMATActive(true);
       dodatniMAT.setDodatniMATCena(getCena());
       dodatniMAT.setDodatniMATDimenzije(getDimenzije());
       dodatniMAT.setDodatniMATMaterijal(getMaterijal());
       dodatniMAT.setDodatniMATNaziv(getNaziv());
       dodatniMAT.setDodatniMATOpis(getOpis());
       dodatniMAT.setDodatniMATProizvodjac(getProizvodjac());
       dodatniMAT.setDodatniMATTip(getTip()); 
       hibernate.update(dodatniMAT);
       
           return AdminDodatniMAT.class; 
       }
      
   @SetupRender   
   public void postaviPodatke(){
   setCena(dodatniMAT.getDodatniMATCena());
   setDimenzije(dodatniMAT.getDodatniMATDimenzije());
   setMaterijal(dodatniMAT.getDodatniMATMaterijal());
   setNaziv(dodatniMAT.getDodatniMATNaziv());
   setOpis(dodatniMAT.getDodatniMATOpis());
   setProizvodjac(dodatniMAT.getDodatniMATProizvodjac());
   setTip(dodatniMAT.getDodatniMATTip());
   setNamena(dodatniMAT.getDodatniMATNamena());
   }   
   
   public void pocisti(){
        dodatniMAT = new DodatniMAT();
                
        setCena(null);
        setDimenzije(null);
        setMaterijal(null);
        setNaziv(null);
        setOpis(null);
        setProizvodjac(null);
        setTip(null);
        setNamena(null);
        
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

    /**
     * @return the namena
     */
    public String getNamena() {
        return namena;
    }

    /**
     * @param namena the namena to set
     */
    public void setNamena(String namena) {
        this.namena = namena;
    }

   
    
  

    

    
   
   
}
