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
public class OstalaDG implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "OSTALADG_ID")
    private Long ostalaDGId;
    @Basic(optional = false)
    @Column(name = "OSTALADG_NAZIV")
    private String ostalaDGNaziv;
    @Basic(optional = false)
    @Column(name = "OSTALADG_PROIZVODJAC")
    private String ostalaDGProizvodjac;
    @Column(name = "OSTALADG_DIMENZIJE")
    private String ostalaDGDimenzije;
    @Basic(optional = false)
    @Column(name = "OSTALADG_TIP")
    private String ostalaDGTip;
    @Basic(optional = false)
    @Column(name = "OSTALADG_VRSTA")
    private String ostalaDGVrsta;
    @Basic(optional = false)
    @Column(name = "OSTALADG_MATERIJAL")
    private String ostalaDGMaterijal;
    @Basic(optional = false)
    @Column(name = "OSTALADG_OPIS")
    private String ostalaDGOpis;
    @Basic(optional = false)
    @Column(name = "OSTALADG_CENA")
    private String ostalaDGCena;
    @Basic(optional = false)
    @Column(name = "OSTALADG_ACTIVE")
    private boolean ostalaDGActive;;

    public OstalaDG() {
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getOstalaDGId() != null ? getOstalaDGId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OstalaDG)) {
            return false;
        }
        OstalaDG other = (OstalaDG) object;
        if ((this.getOstalaDGId() == null && other.getOstalaDGId() != null) || (this.getOstalaDGId() != null && !this.ostalaDGId.equals(other.ostalaDGId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.dis.setup.entities.OstalaDG[ostalaDGId=" + getOstalaDGId() + "]";
    }

    /**
     * @return the ostalaDGId
     */
    @NonVisual
    public Long getOstalaDGId() {
        return ostalaDGId;
    }

    /**
     * @param ostalaDGId the ostalaDGId to set
     */
    public void setOstalaDGId(Long ostalaDGId) {
        this.ostalaDGId = ostalaDGId;
    }

    /**
     * @return the ostalaDGNaziv
     */
    public String getOstalaDGNaziv() {
        return ostalaDGNaziv;
    }

    /**
     * @param ostalaDGNaziv the ostalaDGNaziv to set
     */
    public void setOstalaDGNaziv(String ostalaDGNaziv) {
        this.ostalaDGNaziv = ostalaDGNaziv;
    }

    /**
     * @return the ostalaDGProizvodjac
     */
    public String getOstalaDGProizvodjac() {
        return ostalaDGProizvodjac;
    }

    /**
     * @param ostalaDGProizvodjac the ostalaDGProizvodjac to set
     */
    public void setOstalaDGProizvodjac(String ostalaDGProizvodjac) {
        this.ostalaDGProizvodjac = ostalaDGProizvodjac;
    }

    /**
     * @return the ostalaDGDimenzije
     */
    public String getOstalaDGDimenzije() {
        return ostalaDGDimenzije;
    }

    /**
     * @param ostalaDGDimenzije the ostalaDGDimenzije to set
     */
    public void setOstalaDGDimenzije(String ostalaDGDimenzije) {
        this.ostalaDGDimenzije = ostalaDGDimenzije;
    }

    /**
     * @return the ostalaDGTip
     */
    public String getOstalaDGTip() {
        return ostalaDGTip;
    }

    /**
     * @param ostalaDGTip the ostalaDGTip to set
     */
    public void setOstalaDGTip(String ostalaDGTip) {
        this.ostalaDGTip = ostalaDGTip;
    }

    /**
     * @return the ostalaDGVrsta
     */
    public String getOstalaDGVrsta() {
        return ostalaDGVrsta;
    }

    /**
     * @param ostalaDGVrsta the ostalaDGVrsta to set
     */
    public void setOstalaDGVrsta(String ostalaDGVrsta) {
        this.ostalaDGVrsta = ostalaDGVrsta;
    }

    /**
     * @return the ostalaDGMaterijal
     */
    public String getOstalaDGMaterijal() {
        return ostalaDGMaterijal;
    }

    /**
     * @param ostalaDGMaterijal the ostalaDGMaterijal to set
     */
    public void setOstalaDGMaterijal(String ostalaDGMaterijal) {
        this.ostalaDGMaterijal = ostalaDGMaterijal;
    }

    /**
     * @return the ostalaDGOpis
     */
    public String getOstalaDGOpis() {
        return ostalaDGOpis;
    }

    /**
     * @param ostalaDGOpis the ostalaDGOpis to set
     */
    public void setOstalaDGOpis(String ostalaDGOpis) {
        this.ostalaDGOpis = ostalaDGOpis;
    }

    /**
     * @return the ostalaDGCena
     */
    public String getOstalaDGCena() {
        return ostalaDGCena;
    }

    /**
     * @param ostalaDGCena the ostalaDGCena to set
     */
    public void setOstalaDGCena(String ostalaDGCena) {
        this.ostalaDGCena = ostalaDGCena;
    }

    /**
     * @return the ostalaDGActive
     */
    public boolean isOstalaDGActive() {
        return ostalaDGActive;
    }

    /**
     * @param ostalaDGActive the ostalaDGActive to set
     */
    public void setOstalaDGActive(boolean ostalaDGActive) {
        this.ostalaDGActive = ostalaDGActive;
    }

   
}
