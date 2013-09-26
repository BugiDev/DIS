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
import rs.dis.setup.entities.Laminat;


/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AsortLaminat {
    
    @Persist
    @Property
    private Laminat laminat;
    @Property
    @Persist
    private Laminat laminatGrid;
    @Inject
    private Session hibernate;

    

    public List<Laminat> getLaminatlist() {
        return hibernate.createCriteria(Laminat.class).add(Restrictions.eq("laminatActive", true)).list();
    }
    
    public void onProgressiveDisplay() {
            getLaminatlist();
	}
}
