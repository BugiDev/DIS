/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.dis.setup.entities;

import java.util.Date;
import javax.persistence.*;
import org.apache.tapestry5.beaneditor.NonVisual;


/**
 *
 * @author mateja
 */
@Entity
public class Korisnik {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "KORISNIK_ID")
    private Long korisnikId;
    @Basic(optional = false)
    @Column(name = "KORISNIK_IME")
    private String korisnikIme;
    @Basic(optional = false)
    @Column(name = "KORISNIK_PASS")
    private String korisnikPass;
        @Basic(optional = false)
    @Column(name = "KORISNIK_ACTIVE")
    private boolean korisnikActive;
    @Basic(optional = false)
    @Column(name = "KORISNIK_USER")
    private String korisnikUser;
    @Basic(optional = true)
    @Column(name = "KORISNIK_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date korisnikTs;
    @Basic(optional = false)
    @Column(name = "KORISNIK_ROLA")
    @Enumerated(EnumType.STRING)
    private TipKorisnika korisnikRola;

    public Korisnik() {
    }

    @NonVisual
    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getKorisnikIme() {
        return korisnikIme;
    }

    public void setKorisnikIme(String korisnikIme) {
        this.korisnikIme = korisnikIme;
    }

    public String getKorisnikPass() {
        return korisnikPass;
    }

    public void setKorisnikPass(String korisnikPass) {
        this.korisnikPass = korisnikPass;
    }
    @NonVisual
    public boolean isKorisnikActive() {
        return korisnikActive;
    }

    public void setKorisnikActive(boolean korisnikActive) {
        this.korisnikActive = korisnikActive;
    }

    @NonVisual
    public Date getKorisnikTs() {
        return korisnikTs;
    }

    public void setKorisnikTs(Date korisnikTs) {
        this.korisnikTs = korisnikTs;
    }

    @NonVisual
    public String getKorisnikUser() {
        return korisnikUser;
    }

    public void setKorisnikUser(String korisnikUser) {
        this.korisnikUser = korisnikUser;
    }

     /**
     * @return the korisnikRola
     */
    @NonVisual
    public TipKorisnika getKorisnikRola() {
        return korisnikRola;
    }

    /**
     * @param korisnikRola the korisnikRola to set
     */
    public void setKorisnikRola(TipKorisnika korisnikRola) {
        this.korisnikRola = korisnikRola;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisnikId != null ? korisnikId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisnikId == null && other.korisnikId != null) || (this.korisnikId != null && !this.korisnikId.equals(other.korisnikId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.dis.setup.entities.Korisnik[korisnikId=" + korisnikId + "]";
    }
}

   
