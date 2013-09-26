/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.components;

import java.util.Locale;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.runtime.Component;
import org.apache.tapestry5.services.PersistentLocale;
import org.apache.tapestry5.services.Request;
import org.hibernate.Session;

import rs.dis.setup.entities.Email;
import rs.dis.setup.pages.Index;

/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/layout.css", "context:css/reset.css", "context:css/style.css"})
public class Border {

    private static String jezik = "rs";
   
    @Inject
    private ComponentResources resources;
    @Parameter(required = true, defaultPrefix = "literal")
    private String pageTitle;
    
    @Parameter(required = true, defaultPrefix = "literal")
    private String tipStrane;
    
    @Validate("regexp")
    @Property 
    private String newsEmail = "Input your email address";
    
    @Property
    private String active1 = "", active2 = "", active3 = "", active4 = "", active5 = "";
    
    @Inject
    private PersistentLocale persistentLocale;
    
    @Persist
    @Property
    private Email email;
    @Property
    @Inject
    private Session hibernate;
    
    @InjectComponent
    private Zone pretplataEmail;
    @Inject
    private Request request;
    @Inject
    private Block emailSetovanTrue;
    @Inject
    private Block emailSetovanFalse; 
    
    private String bojaSlanja;
    private String mailSetTrue = "You have been subscribed. Thank you for following our work!!!";
    private String mailSetFalse = "An error occurred while saving the email. Please try again later.";
    
    public String getPageTitle() {
        return pageTitle;
    }
        
    public String getTipStrane() {
        return tipStrane;
    }

    private String getPageName() {
        Component page = resources.getContainer();
        return page.getClass().getName();
    }
    
    
     
     
     @SetupRender
     void aktivnaStrana(){
         if (getPageName().equalsIgnoreCase("rs.dis.setup.pages.Index")) active1="active";
         else if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.Reference")) active2="active";
         else if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.Partneri")) active3="active";
         else if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.Asortiman")) active4="active";
         else if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.Kontakt")) active5="active";

        if (jezik.equals("en"))
            newsEmail = "Input your email address";
        else
        newsEmail = "Unesite vašu email adresu";    
     }
     
  
     Object onActionFromLocaleRs() {
        persistentLocale.set(new Locale("rs"));
        setJezik("rs");
     newsEmail = "Unesite vašu email adresu";
     return null;
     }
     
     Object onActionFromLocaleEn() {
        persistentLocale.set(new Locale("en"));
        setJezik("en");
       
     newsEmail = "Input your email address";
     return null;
     }
     
     public boolean getTestJezika(){
        if(jezik.equals("rs"))
                return true;
        else if (jezik.equals("en"))
        return false;
        return false;
    }
     
     @CommitAfter
      Object onSubmit(){   
          try {
            Email em = new Email();
          em.setEmailVrednost(newsEmail);
        hibernate.save(em);
        
        if (Index.getJezik().equals("rs") || getJezik().equals("rs"))
                                setMailSetTrue("Uspešno ste se pretplatili. Hvala Vam što želite da pratite naš rad!!!");
                                
       setBojaSlanja("background-color: #60b000;");
       return emailSetovanTrue;
        } catch (Exception e) {
             if (Index.getJezik().equals("rs") || getJezik().equals("rs"))
           setMailSetFalse("Dogodila se greška pri čuvanju email-a. Molimo vas pokušajte ponovo kasnije.");
           
           setBojaSlanja("background-color: #FF3333;");
        }
          if (jezik.equals("en"))
            newsEmail = "Input your email address";
        else
        newsEmail = "Unesite vašu email adresu";
       return request.isXHR() ? emailSetovanFalse : null; 
   } 
   
      /**
     * @return the jezik
     */
    public static String getJezik() {
        return jezik;
    }

    /**
     * @param aJezik the jezik to set
     */
    public static void setJezik(String aJezik) {
        jezik = aJezik;
    }
    
    /**
     * @return the bojaSlanja
     */
    public String getBojaSlanja() {
        return bojaSlanja;
    }

    /**
     * @param bojaSlanja the bojaSlanja to set
     */
    public void setBojaSlanja(String bojaSlanja) {
        this.bojaSlanja = bojaSlanja;
    }

    /**
     * @return the mailSetTrue
     */
    public String getMailSetTrue() {
        return mailSetTrue;
    }

    /**
     * @param mailSetTrue the mailSetTrue to set
     */
    public void setMailSetTrue(String mailSetTrue) {
        this.mailSetTrue = mailSetTrue;
    }

    /**
     * @return the mailSetFalse
     */
    public String getMailSetFalse() {
        return mailSetFalse;
    }

    /**
     * @param mailSetFalse the mailSetFalse to set
     */
    public void setMailSetFalse(String mailSetFalse) {
        this.mailSetFalse = mailSetFalse;
    }

     
}
