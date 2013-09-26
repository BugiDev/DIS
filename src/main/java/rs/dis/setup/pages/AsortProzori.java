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
import rs.dis.setup.entities.Prozori;

/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AsortProzori {
    
    @Persist
    @Property
    private Prozori prozori;
    @Property
    @Persist
    private Prozori prozoriGrid;
    @Inject
    private Session hibernate;
    
     public List<Prozori> getProzorilist() {
        return hibernate.createCriteria(Prozori.class).add(Restrictions.eq("prozoriActive", true)).list();
    }
     
    public void onProgressiveDisplay() {
            getProzorilist();
	}
}
