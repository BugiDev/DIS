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
public class Prozori implements Serializable {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "PROZORI_ID")
    private Long prozoriId;
    @Basic(optional = false)
    @Column(name = "PROZORI_NAZIV")
    private String prozoriNaziv;
    @Basic(optional = false)
    @Column(name = "PROZORI_PROIZVODJAC")
    private String prozoriProizvodjac;
    @Column(name = "PROZORI_DIMENZIJE")
    private String prozoriDimenzije;
    @Basic(optional = false)
    @Column(name = "PROZORI_TIP")
    private String prozoriTip;
    @Basic(optional = false)
    @Column(name = "PROZORI_MATERIJAL")
    private String prozoriMaterijal;
    @Basic(optional = false)
    @Column(name = "PROZORI_OPIS")
    private String prozoriOpis;
    @Basic(optional = false)
    @Column(name = "PROZORI_CENA")
    private String prozoriCena;
    @Basic(optional = false)
    @Column(name = "PROZORI_ACTIVE")
    private boolean prozoriActive;

    public Prozori() {
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getProzoriId() != null ? getProzoriId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prozori)) {
            return false;
        }
        Prozori other = (Prozori) object;
        if ((this.getProzoriId() == null && other.getProzoriId() != null) || (this.getProzoriId() != null && !this.prozoriId.equals(other.prozoriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.dis.setup.entities.Prozori[prozoriId=" + getProzoriId() + "]";
    }

    /**
     * @return the prozoriId
     */
    @NonVisual
    public Long getProzoriId() {
        return prozoriId;
    }

    /**
     * @param prozoriId the prozoriId to set
     */
    public void setProzoriId(Long prozoriId) {
        this.prozoriId = prozoriId;
    }

    /**
     * @return the prozoriNaziv
     */
    public String getProzoriNaziv() {
        return prozoriNaziv;
    }

    /**
     * @param prozoriNaziv the prozoriNaziv to set
     */
    public void setProzoriNaziv(String prozoriNaziv) {
        this.prozoriNaziv = prozoriNaziv;
    }

    /**
     * @return the prozoriProizvodjac
     */
    public String getProzoriProizvodjac() {
        return prozoriProizvodjac;
    }

    /**
     * @param prozoriProizvodjac the prozoriProizvodjac to set
     */
    public void setProzoriProizvodjac(String prozoriProizvodjac) {
        this.prozoriProizvodjac = prozoriProizvodjac;
    }

    /**
     * @return the prozoriDimenzije
     */
    public String getProzoriDimenzije() {
        return prozoriDimenzije;
    }

    /**
     * @param prozoriDimenzije the prozoriDimenzije to set
     */
    public void setProzoriDimenzije(String prozoriDimenzije) {
        this.prozoriDimenzije = prozoriDimenzije;
    }

    /**
     * @return the prozoriTip
     */
    public String getProzoriTip() {
        return prozoriTip;
    }

    /**
     * @param prozoriTip the prozoriTip to set
     */
    public void setProzoriTip(String prozoriTip) {
        this.prozoriTip = prozoriTip;
    }

    /**
     * @return the prozoriMaterijal
     */
    public String getProzoriMaterijal() {
        return prozoriMaterijal;
    }

    /**
     * @param prozoriMaterijal the prozoriMaterijal to set
     */
    public void setProzoriMaterijal(String prozoriMaterijal) {
        this.prozoriMaterijal = prozoriMaterijal;
    }

    /**
     * @return the prozoriOpis
     */
    public String getProzoriOpis() {
        return prozoriOpis;
    }

    /**
     * @param prozoriOpis the prozoriOpis to set
     */
    public void setProzoriOpis(String prozoriOpis) {
        this.prozoriOpis = prozoriOpis;
    }

    /**
     * @return the prozoriCena
     */
    public String getProzoriCena() {
        return prozoriCena;
    }

    /**
     * @param prozoriCena the prozoriCena to set
     */
    public void setProzoriCena(String prozoriCena) {
        this.prozoriCena = prozoriCena;
    }

    /**
     * @return the prozoriActive
     */
    public boolean isProzoriActive() {
        return prozoriActive;
    }

    /**
     * @param prozoriActive the prozoriActive to set
     */
    public void setProzoriActive(boolean prozoriActive) {
        this.prozoriActive = prozoriActive;
    }

    
}
