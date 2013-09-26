/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.components;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.runtime.Component;
import rs.dis.setup.entities.Korisnik;
import rs.dis.setup.pages.LogIn;

/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/screen.css", "context:css/fixed.css", "context:css/theme/blue.css"}, library={"context:js/jquery-1.4.1.min.js","context:js/jquery.visualize.js",
    "context:js/custom.js","context:js/jquery-ui-1.8.13.custom.min.js","context:js/jquery.poshytip.min.js","context:js/jquery.quicksand.js","context:js/jquery.dataTables.min.js"})
public class BorderAdmin {
    
     @Inject
    private ComponentResources resources;
    @Parameter(required = true, defaultPrefix = "literal")
    private String pageTitle;
    @SessionState
    @Property
    private Korisnik asoKorisnik;
    @Property
    private boolean asoKorisnikExists;
    @Property
    private String active1 = "", active2 = "", active3 = "", active4 = "", active5 = "";
    @InjectPage
    private LogIn login;
    @Property
    private String postaviLink;
    
    private String getPageName() {
        Component page = resources.getContainer();
        return page.getClass().getName();
    }
    
    @SetupRender
     void aktivnaStrana(){
         if (getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminPanel")){
             active1="active";
             
         }
         else if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminProzvodi")){ 
             active2="active";
             
         }
         else if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminAdmini")){ 
             active3="active";
             
         }
         else if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminEmail")) {
             active4="active";
             
         }
         
         
     }
    
    public String getPageTitle() {
        return pageTitle;
    }

     

    public Object onActionFromLogout() {
        asoKorisnik = null;
        return login;
    }
    
    public boolean getTestAdminPanel(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminPanel"))
                return true;
        return false;
    }
    
    public boolean getTestAdminProizvodi(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminProizvodi"))
                return true;
        return false;
    }
    
    public boolean getTestAdminAdmini(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminKorisnik"))
                return true;
        return false;
    }
    
    public boolean getTestAdminEmail(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminEmail"))
                return true;
        return false;
    }
    
    public boolean getTestAdminVrata(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminVrata"))
                return true;
        return false;
    }
    
    public boolean getTestAdminProzori(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminProzori"))
                return true;
        return false;
    }
    
    public boolean getTestAdminLamperija(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminLamperija"))
                return true;
        return false;
    }
    
    public boolean getTestAdminLaminat(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminLaminat"))
                return true;
        return false;
    }
    
    public boolean getTestAdminBpod(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminBpod"))
                return true;
        return false;
    }
    
    public boolean getTestAdminOstalaDG(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminOstalaDG"))
                return true;
        return false;
    }
    
    public boolean getTestAdminDodatniMAT(){
        if(getPageName().equalsIgnoreCase("rs.dis.setup.pages.AdminDodatniMAT"))
                return true;
        return false;
    }
    
}
