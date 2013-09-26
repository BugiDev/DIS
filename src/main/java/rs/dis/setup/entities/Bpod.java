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
public class Bpod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "BPOD_ID")
    private Long bpodId;
    @Basic(optional = false)
    @Column(name = "BPOD_NAZIV")
    private String bpodNaziv;
    @Basic(optional = false)
    @Column(name = "BPOD_PROIZVODJAC")
    private String bpodProizvodjac;
    @Column(name = "BPOD_DIMENZIJE")
    private String bpodDimenzije;
    @Basic(optional = false)
    @Column(name = "BPOD_TIP")
    private String bpodTip;
    @Basic(optional = false)
    @Column(name = "BPOD_MATERIJAL")
    private String bpodMaterijal;
    @Basic(optional = false)
    @Column(name = "BPOD_OPIS")
    private String bpodOpis;
    @Basic(optional = false)
    @Column(name = "BPOD_CENA")
    private String bpodCena;
    @Basic(optional = false)
    @Column(name = "BPOD_ACTIVE")
    private boolean bpodActive;

    public Bpod() {
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getBpodId() != null ? getBpodId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bpod)) {
            return false;
        }
        Bpod other = (Bpod) object;
        if ((this.getBpodId() == null && other.getBpodId() != null) || (this.getBpodId() != null && !this.bpodId.equals(other.bpodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.dis.setup.entities.Bpod[bpodId=" + getBpodId() + "]";
    }

    /**
     * @return the bpodId
     */
    @NonVisual
    public Long getBpodId() {
        return bpodId;
    }

    /**
     * @param bpodId the bpodId to set
     */
    public void setBpodId(Long bpodId) {
        this.bpodId = bpodId;
    }

    /**
     * @return the bpodNaziv
     */
    public String getBpodNaziv() {
        return bpodNaziv;
    }

    /**
     * @param bpodNaziv the bpodNaziv to set
     */
    public void setBpodNaziv(String bpodNaziv) {
        this.bpodNaziv = bpodNaziv;
    }

    /**
     * @return the bpodProizvodjac
     */
    public String getBpodProizvodjac() {
        return bpodProizvodjac;
    }

    /**
     * @param bpodProizvodjac the bpodProizvodjac to set
     */
    public void setBpodProizvodjac(String bpodProizvodjac) {
        this.bpodProizvodjac = bpodProizvodjac;
    }

    /**
     * @return the bpodDimenzije
     */
    public String getBpodDimenzije() {
        return bpodDimenzije;
    }

    /**
     * @param bpodDimenzije the bpodDimenzije to set
     */
    public void setBpodDimenzije(String bpodDimenzije) {
        this.bpodDimenzije = bpodDimenzije;
    }

    /**
     * @return the bpodTip
     */
    public String getBpodTip() {
        return bpodTip;
    }

    /**
     * @param bpodTip the bpodTip to set
     */
    public void setBpodTip(String bpodTip) {
        this.bpodTip = bpodTip;
    }

    /**
     * @return the bpodMaterijal
     */
    public String getBpodMaterijal() {
        return bpodMaterijal;
    }

    /**
     * @param bpodMaterijal the bpodMaterijal to set
     */
    public void setBpodMaterijal(String bpodMaterijal) {
        this.bpodMaterijal = bpodMaterijal;
    }

    /**
     * @return the bpodOpis
     */
    public String getBpodOpis() {
        return bpodOpis;
    }

    /**
     * @param bpodOpis the bpodOpis to set
     */
    public void setBpodOpis(String bpodOpis) {
        this.bpodOpis = bpodOpis;
    }

    /**
     * @return the bpodCena
     */
    public String getBpodCena() {
        return bpodCena;
    }

    /**
     * @param bpodCena the bpodCena to set
     */
    public void setBpodCena(String bpodCena) {
        this.bpodCena = bpodCena;
    }

    /**
     * @return the bpodActive
     */
    public boolean isBpodActive() {
        return bpodActive;
    }

    /**
     * @param bpodActive the bpodActive to set
     */
    public void setBpodActive(boolean bpodActive) {
        this.bpodActive = bpodActive;
    }


   
}
