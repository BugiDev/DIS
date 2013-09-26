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
import rs.dis.setup.entities.DodatniMAT;


/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AsortDodatniMAT {
    
    @Persist
    @Property
    private DodatniMAT dodatniMAT;
    @Property
    @Persist
    private DodatniMAT dodatniMATGrid;
    @Inject
    private Session hibernate;

    

    public List<DodatniMAT> getDodatniMATlist() {
        return hibernate.createCriteria(DodatniMAT.class).add(Restrictions.eq("dodatniMATActive", true)).list();
    }
    
    public void onProgressiveDisplay() {
            getDodatniMATlist();
	}
}
