/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.pages;

import java.util.List;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import rs.dis.setup.entities.OstalaDG;


/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AsortOstalaDG {
    
    @Persist
    @Property
    private OstalaDG ostalaDG;
    @Property
    @Persist
    private OstalaDG ostalaDGGrid;
    @Inject
    private Session hibernate;

    

    public List<OstalaDG> getOstalaDGlist() {
        return hibernate.createCriteria(OstalaDG.class).add(Restrictions.eq("ostalaDGActive", true)).list();
    }
    
    public void onProgressiveDisplay() {
            getOstalaDGlist();
	}
}
