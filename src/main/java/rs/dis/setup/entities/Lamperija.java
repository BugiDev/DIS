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
public class Lamperija implements Serializable {

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "LAMPERIJA_ID")
    private Long lamperijaId;
    @Basic(optional = false)
    @Column(name = "LAMPERIJA_NAZIV")
    private String lamperijaNaziv;
    @Basic(optional = false)
    @Column(name = "LAMPERIJA_PROIZVODJAC")
    private String lamperijaProizvodjac;
    @Column(name = "LAMPERIJA_DIMENZIJE")
    private String lamperijaDimenzije;
    @Basic(optional = false)
    @Column(name = "LAMPERIJA_TIP")
    private String lamperijaTip;
    @Basic(optional = false)
    @Column(name = "LAMPERIJA_MATERIJAL")
    private String lamperijaMaterijal;
    @Basic(optional = false)
    @Column(name = "LAMPERIJA_OPIS")
    private String lamperijaOpis;
    @Basic(optional = false)
    @Column(name = "LAMPERIJA_CENA")
    private String lamperijaCena;
    @Basic(optional = false)
    @Column(name = "LAMPERIJA_ACTIVE")
    private boolean lamperijaActive;

    public Lamperija() {
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getLamperijaId() != null ? getLamperijaId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lamperija)) {
            return false;
        }
        Lamperija other = (Lamperija) object;
        if ((this.getLamperijaId() == null && other.getLamperijaId() != null) || (this.getLamperijaId() != null && !this.lamperijaId.equals(other.lamperijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.dis.setup.entities.Lamperija[lamperijaId=" + getLamperijaId() + "]";
    }

    /**
     * @return the lamperijaId
     */
    @NonVisual
    public Long getLamperijaId() {
        return lamperijaId;
    }

    /**
     * @param lamperijaId the lamperijaId to set
     */
    public void setLamperijaId(Long lamperijaId) {
        this.lamperijaId = lamperijaId;
    }

    /**
     * @return the lamperijaNaziv
     */
    public String getLamperijaNaziv() {
        return lamperijaNaziv;
    }

    /**
     * @param lamperijaNaziv the lamperijaNaziv to set
     */
    public void setLamperijaNaziv(String lamperijaNaziv) {
        this.lamperijaNaziv = lamperijaNaziv;
    }

    /**
     * @return the lamperijaProizvodjac
     */
    public String getLamperijaProizvodjac() {
        return lamperijaProizvodjac;
    }

    /**
     * @param lamperijaProizvodjac the lamperijaProizvodjac to set
     */
    public void setLamperijaProizvodjac(String lamperijaProizvodjac) {
        this.lamperijaProizvodjac = lamperijaProizvodjac;
    }

    /**
     * @return the lamperijaDimenzije
     */
    public String getLamperijaDimenzije() {
        return lamperijaDimenzije;
    }

    /**
     * @param lamperijaDimenzije the lamperijaDimenzije to set
     */
    public void setLamperijaDimenzije(String lamperijaDimenzije) {
        this.lamperijaDimenzije = lamperijaDimenzije;
    }

    /**
     * @return the lamperijaTip
     */
    public String getLamperijaTip() {
        return lamperijaTip;
    }

    /**
     * @param lamperijaTip the lamperijaTip to set
     */
    public void setLamperijaTip(String lamperijaTip) {
        this.lamperijaTip = lamperijaTip;
    }

    /**
     * @return the lamperijaMaterijal
     */
    public String getLamperijaMaterijal() {
        return lamperijaMaterijal;
    }

    /**
     * @param lamperijaMaterijal the lamperijaMaterijal to set
     */
    public void setLamperijaMaterijal(String lamperijaMaterijal) {
        this.lamperijaMaterijal = lamperijaMaterijal;
    }

    /**
     * @return the lamperijaOpis
     */
    public String getLamperijaOpis() {
        return lamperijaOpis;
    }

    /**
     * @param lamperijaOpis the lamperijaOpis to set
     */
    public void setLamperijaOpis(String lamperijaOpis) {
        this.lamperijaOpis = lamperijaOpis;
    }

    /**
     * @return the lamperijaCena
     */
    public String getLamperijaCena() {
        return lamperijaCena;
    }

    /**
     * @param lamperijaCena the lamperijaCena to set
     */
    public void setLamperijaCena(String lamperijaCena) {
        this.lamperijaCena = lamperijaCena;
    }

    /**
     * @return the lamperijaActive
     */
    public boolean isLamperijaActive() {
        return lamperijaActive;
    }

    /**
     * @param lamperijaActive the lamperijaActive to set
     */
    public void setLamperijaActive(boolean lamperijaActive) {
        this.lamperijaActive = lamperijaActive;
    }

}
