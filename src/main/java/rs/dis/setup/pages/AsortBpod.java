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
import rs.dis.setup.entities.Bpod;


/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/gridAsortiman.css"})
public class AsortBpod {
    
    @Persist
    @Property
    private Bpod bpod;
    @Property
    @Persist
    private Bpod bpodGrid;
    @Inject
    private Session hibernate;

    

    public List<Bpod> getBpodlist() {
        return hibernate.createCriteria(Bpod.class).add(Restrictions.eq("bpodActive", true)).list();
    }
    
    public void onProgressiveDisplay() {
            getBpodlist();
	}
}
