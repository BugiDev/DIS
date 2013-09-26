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
public class Laminat implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "LAMINAT_ID")
    private Long laminatId;
    @Basic(optional = false)
    @Column(name = "LAMINAT_NAZIV")
    private String laminatNaziv;
    @Basic(optional = false)
    @Column(name = "LAMINAT_PROIZVODJAC")
    private String laminatProizvodjac;
    @Column(name = "LAMINAT_DIMENZIJE")
    private String laminatDimenzije;
    @Basic(optional = false)
    @Column(name = "LAMINAT_TIP")
    private String laminatTip;
    @Basic(optional = false)
    @Column(name = "LAMINAT_MATERIJAL")
    private String laminatMaterijal;
    @Basic(optional = false)
    @Column(name = "LAMINAT_OPIS")
    private String laminatOpis;
    @Basic(optional = false)
    @Column(name = "LAMINAT_CENA")
    private String laminatCena;
    @Basic(optional = false)
    @Column(name = "LAMINAT_ACTIVE")
    private boolean laminatActive;

    public Laminat() {
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getLaminatId() != null ? getLaminatId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laminat)) {
            return false;
        }
        Laminat other = (Laminat) object;
        if ((this.getLaminatId() == null && other.getLaminatId() != null) || (this.getLaminatId() != null && !this.laminatId.equals(other.laminatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.dis.setup.entities.Laminat[laminatId=" + getLaminatId() + "]";
    }

    /**
     * @return the laminatId
     */
    @NonVisual
    public Long getLaminatId() {
        return laminatId;
    }

    /**
     * @param laminatId the laminatId to set
     */
    public void setLaminatId(Long laminatId) {
        this.laminatId = laminatId;
    }

    /**
     * @return the laminatNaziv
     */
    public String getLaminatNaziv() {
        return laminatNaziv;
    }

    /**
     * @param laminatNaziv the laminatNaziv to set
     */
    public void setLaminatNaziv(String laminatNaziv) {
        this.laminatNaziv = laminatNaziv;
    }

    /**
     * @return the laminatProizvodjac
     */
    public String getLaminatProizvodjac() {
        return laminatProizvodjac;
    }

    /**
     * @param laminatProizvodjac the laminatProizvodjac to set
     */
    public void setLaminatProizvodjac(String laminatProizvodjac) {
        this.laminatProizvodjac = laminatProizvodjac;
    }

    /**
     * @return the laminatDimenzije
     */
    public String getLaminatDimenzije() {
        return laminatDimenzije;
    }

    /**
     * @param laminatDimenzije the laminatDimenzije to set
     */
    public void setLaminatDimenzije(String laminatDimenzije) {
        this.laminatDimenzije = laminatDimenzije;
    }

    /**
     * @return the laminatTip
     */
    public String getLaminatTip() {
        return laminatTip;
    }

    /**
     * @param laminatTip the laminatTip to set
     */
    public void setLaminatTip(String laminatTip) {
        this.laminatTip = laminatTip;
    }

    /**
     * @return the laminatMaterijal
     */
    public String getLaminatMaterijal() {
        return laminatMaterijal;
    }

    /**
     * @param laminatMaterijal the laminatMaterijal to set
     */
    public void setLaminatMaterijal(String laminatMaterijal) {
        this.laminatMaterijal = laminatMaterijal;
    }

    /**
     * @return the laminatOpis
     */
    public String getLaminatOpis() {
        return laminatOpis;
    }

    /**
     * @param laminatOpis the laminatOpis to set
     */
    public void setLaminatOpis(String laminatOpis) {
        this.laminatOpis = laminatOpis;
    }

    /**
     * @return the laminatCena
     */
    public String getLaminatCena() {
        return laminatCena;
    }

    /**
     * @param laminatCena the laminatCena to set
     */
    public void setLaminatCena(String laminatCena) {
        this.laminatCena = laminatCena;
    }

    /**
     * @return the laminatActive
     */
    public boolean isLaminatActive() {
        return laminatActive;
    }

    /**
     * @param laminatActive the laminatActive to set
     */
    public void setLaminatActive(boolean laminatActive) {
        this.laminatActive = laminatActive;
    }

   

}
