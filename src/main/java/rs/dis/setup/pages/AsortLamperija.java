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
import rs.dis.setup.entities.Lamperija;


/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AsortLamperija {
    
    @Persist
    @Property
    private Lamperija lamperija;
    @Property
    @Persist
    private Lamperija lamperijaGrid;
    @Inject
    private Session hibernate;

    

    public List<Lamperija> getLamperijalist() {
        return hibernate.createCriteria(Lamperija.class).add(Restrictions.eq("lamperijaActive", true)).list();
    }
    
    public void onProgressiveDisplay() {
            getLamperijalist();
	}
}
