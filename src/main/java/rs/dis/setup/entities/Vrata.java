/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.dis.setup.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.tapestry5.beaneditor.NonVisual;

/**
 *
 * @author Aleksandar
 */
@Entity
public class Vrata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "VRATA_ID")
    private Long vrataId;
    @Basic(optional = false)
    @Column(name = "VRATA_NAZIV")
    private String vrataNaziv;
    @Basic(optional = false)
    @Column(name = "VRATA_PROIZVODJAC")
    private String vrataProizvodjac;
    @Column(name = "VRATA_DIMENZIJE")
    private String vrataDimenzije;
    @Basic(optional = false)
    @Column(name = "VRATA_TIP")
    private String vrataTip;
    @Basic(optional = false)
    @Column(name = "VRATA_MATERIJAL")
    private String vrataMaterijal;
    @Basic(optional = false)
    @Column(name = "VRATA_OPIS")
    private String vrataOpis;
    @Basic(optional = false)
    @Column(name = "VRATA_CENA")
    private String vrataCena;
    @Basic(optional = false)
    @Column(name = "VRATA_ACTIVE")
    private boolean vrataActive;
    @Basic(optional = true)
    @Column(name = "VRATA_URL")
    private String vrataURL;
    
    public Vrata() {
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getVrataId() != null ? getVrataId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vrata)) {
            return false;
        }
        Vrata other = (Vrata) object;
        if ((this.getVrataId() == null && other.getVrataId() != null) || (this.getVrataId() != null && !this.vrataId.equals(other.vrataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.dis.setup.entities.Vrata[vrataId=" + getVrataId() + "]";
    }

    /**
     * @return the vrataId
     */
    @NonVisual
    public Long getVrataId() {
        return vrataId;
    }

    /**
     * @param vrataId the vrataId to set
     */
    public void setVrataId(Long vrataId) {
        this.vrataId = vrataId;
    }

    /**
     * @return the vrataNaziv
     */
    public String getVrataNaziv() {
        return vrataNaziv;
    }

    /**
     * @param vrataNaziv the vrataNaziv to set
     */
    public void setVrataNaziv(String vrataNaziv) {
        this.vrataNaziv = vrataNaziv;
    }

    /**
     * @return the vrataProizvodjac
     */
    public String getVrataProizvodjac() {
        return vrataProizvodjac;
    }

    /**
     * @param vrataProizvodjac the vrataProizvodjac to set
     */
    public void setVrataProizvodjac(String vrataProizvodjac) {
        this.vrataProizvodjac = vrataProizvodjac;
    }

    /**
     * @return the vrataDimenzije
     */
    public String getVrataDimenzije() {
        return vrataDimenzije;
    }

    /**
     * @param vrataDimenzije the vrataDimenzije to set
     */
    public void setVrataDimenzije(String vrataDimenzije) {
        this.vrataDimenzije = vrataDimenzije;
    }

    /**
     * @return the vrataTip
     */
    public String getVrataTip() {
        return vrataTip;
    }

    /**
     * @param vrataTip the vrataTip to set
     */
    public void setVrataTip(String vrataTip) {
        this.vrataTip = vrataTip;
    }

    /**
     * @return the vrataMaterijal
     */
    public String getVrataMaterijal() {
        return vrataMaterijal;
    }

    /**
     * @param vrataMaterijal the vrataMaterijal to set
     */
    public void setVrataMaterijal(String vrataMaterijal) {
        this.vrataMaterijal = vrataMaterijal;
    }

    /**
     * @return the vrataOpis
     */
    public String getVrataOpis() {
        return vrataOpis;
    }

    /**
     * @param vrataOpis the vrataOpis to set
     */
    public void setVrataOpis(String vrataOpis) {
        this.vrataOpis = vrataOpis;
    }

    /**
     * @return the vrataCena
     */
    public String getVrataCena() {
        return vrataCena;
    }

    /**
     * @param vrataCena the vrataCena to set
     */
    public void setVrataCena(String vrataCena) {
        this.vrataCena = vrataCena;
    }

    /**
     * @return the vrataActive
     */
    public boolean isVrataActive() {
        return vrataActive;
    }

    /**
     * @param vrataActive the vrataActive to set
     */
    public void setVrataActive(boolean vrataActive) {
        this.vrataActive = vrataActive;
    }

    /**
     * @return the vrataURL
     */
    public String getVrataURL() {
        return vrataURL;
    }

    /**
     * @param vrataURL the vrataURL to set
     */
    public void setVrataURL(String vrataURL) {
        this.vrataURL = vrataURL;
    }
    
    
}
