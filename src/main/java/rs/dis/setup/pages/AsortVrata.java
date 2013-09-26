/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.pages;

import java.util.List;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import rs.dis.setup.entities.Vrata;

/**
 *
 * @author Bogdan Begovic
 */
@Import(stylesheet={"context:css/lightbox.css","context:css/gridAsortiman.css"}, library={"context:js/jquery-1.7.2.min.js","context:js/lightbox.js"})
public class AsortVrata {
    
    @Persist
    @Property
    private Vrata vrata;
    @Property
    @Persist
    private Vrata vrataGrid;
    @Inject
    private Session hibernate;
    @Inject
    private Block gridBlock;

    

    public List<Vrata> getVratalist() {
        return hibernate.createCriteria(Vrata.class).add(Restrictions.eq("vrataActive", true)).list();
    }
    
    
    public void onProgressiveDisplay() {
            getVratalist();
	}
    
    @OnEvent(EventConstants.PROGRESSIVE_DISPLAY)
    public Object vratiProg()  throws InterruptedException{
        return gridBlock;
    };
    
}
