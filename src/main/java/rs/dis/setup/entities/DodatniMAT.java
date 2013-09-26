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
public class DodatniMAT implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "DODATNIMAT_ID")
    private Long dodatniMATId;
    @Basic(optional = false)
    @Column(name = "DODATNIMAT_NAZIV")
    private String dodatniMATNaziv;
    @Basic(optional = false)
    @Column(name = "DODATNIMAT_PROIZVODJAC")
    private String dodatniMATProizvodjac;
    @Column(name = "DODATNIMAT_DIMENZIJE")
    private String dodatniMATDimenzije;
    @Basic(optional = false)
    @Column(name = "DODATNIMAT_TIP")
    private String dodatniMATTip;
    @Basic(optional = false)
    @Column(name = "DODATNIMAT_NAMENA")
    private String dodatniMATNamena;
    @Basic(optional = false)
    @Column(name = "DODATNIMAT_MATERIJAL")
    private String dodatniMATMaterijal;
    @Basic(optional = false)
    @Column(name = "DODATNIMAT_OPIS")
    private String dodatniMATOpis;
    @Basic(optional = false)
    @Column(name = "DODATNIMAT_CENA")
    private String dodatniMATCena;
    @Basic(optional = false)
    @Column(name = "DODATNIMAT_ACTIVE")
    private boolean dodatniMATActive;;

    public DodatniMAT() {
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getDodatniMATId() != null ? getDodatniMATId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DodatniMAT)) {
            return false;
        }
        DodatniMAT other = (DodatniMAT) object;
        if ((this.getDodatniMATId() == null && other.getDodatniMATId() != null) || (this.getDodatniMATId() != null && !this.dodatniMATId.equals(other.dodatniMATId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.dis.setup.entities.DodatniMAT[dodatniMATId=" + getDodatniMATId() + "]";
    }

    /**
     * @return the dodatniMATId
     */
    @NonVisual
    public Long getDodatniMATId() {
        return dodatniMATId;
    }

    /**
     * @param dodatniMATId the dodatniMATId to set
     */
    public void setDodatniMATId(Long dodatniMATId) {
        this.dodatniMATId = dodatniMATId;
    }

    /**
     * @return the dodatniMATNaziv
     */
    public String getDodatniMATNaziv() {
        return dodatniMATNaziv;
    }

    /**
     * @param dodatniMATNaziv the dodatniMATNaziv to set
     */
    public void setDodatniMATNaziv(String dodatniMATNaziv) {
        this.dodatniMATNaziv = dodatniMATNaziv;
    }

    /**
     * @return the dodatniMATProizvodjac
     */
    public String getDodatniMATProizvodjac() {
        return dodatniMATProizvodjac;
    }

    /**
     * @param dodatniMATProizvodjac the dodatniMATProizvodjac to set
     */
    public void setDodatniMATProizvodjac(String dodatniMATProizvodjac) {
        this.dodatniMATProizvodjac = dodatniMATProizvodjac;
    }

    /**
     * @return the dodatniMATDimenzije
     */
    public String getDodatniMATDimenzije() {
        return dodatniMATDimenzije;
    }

    /**
     * @param dodatniMATDimenzije the dodatniMATDimenzije to set
     */
    public void setDodatniMATDimenzije(String dodatniMATDimenzije) {
        this.dodatniMATDimenzije = dodatniMATDimenzije;
    }

    /**
     * @return the dodatniMATTip
     */
    public String getDodatniMATTip() {
        return dodatniMATTip;
    }

    /**
     * @param dodatniMATTip the dodatniMATTip to set
     */
    public void setDodatniMATTip(String dodatniMATTip) {
        this.dodatniMATTip = dodatniMATTip;
    }

    /**
     * @return the dodatniMATNamena
     */
    public String getDodatniMATNamena() {
        return dodatniMATNamena;
    }

    /**
     * @param dodatniMATNamena the dodatniMATNamena to set
     */
    public void setDodatniMATNamena(String dodatniMATNamena) {
        this.dodatniMATNamena = dodatniMATNamena;
    }

    /**
     * @return the dodatniMATMaterijal
     */
    public String getDodatniMATMaterijal() {
        return dodatniMATMaterijal;
    }

    /**
     * @param dodatniMATMaterijal the dodatniMATMaterijal to set
     */
    public void setDodatniMATMaterijal(String dodatniMATMaterijal) {
        this.dodatniMATMaterijal = dodatniMATMaterijal;
    }

    /**
     * @return the dodatniMATOpis
     */
    public String getDodatniMATOpis() {
        return dodatniMATOpis;
    }

    /**
     * @param dodatniMATOpis the dodatniMATOpis to set
     */
    public void setDodatniMATOpis(String dodatniMATOpis) {
        this.dodatniMATOpis = dodatniMATOpis;
    }

    /**
     * @return the dodatniMATCena
     */
    public String getDodatniMATCena() {
        return dodatniMATCena;
    }

    /**
     * @param dodatniMATCena the dodatniMATCena to set
     */
    public void setDodatniMATCena(String dodatniMATCena) {
        this.dodatniMATCena = dodatniMATCena;
    }

    /**
     * @return the dodatniMATActive
     */
    public boolean isDodatniMATActive() {
        return dodatniMATActive;
    }

    /**
     * @param dodatniMATActive the dodatniMATActive to set
     */
    public void setDodatniMATActive(boolean dodatniMATActive) {
        this.dodatniMATActive = dodatniMATActive;
    }

   
}
