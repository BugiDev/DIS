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
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "EMAIL_ID")
    private Long emailId;
    @Basic(optional = false)
    @Column(name = "EMAIL_VREDNOST")
    private String emailVrednost;
    public Email() {
    }

    public Email(Long emailId, String emailVrednost) {
        this.emailId = emailId;
        this.emailVrednost = emailVrednost;
    }

 
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getEmailId() != null ? getEmailId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.getEmailId() == null && other.getEmailId() != null) || (this.getEmailId() != null && !this.emailId.equals(other.emailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.dis.setup.entities.Email[emailId=" + getEmailId() + "]";
    }

    /**
     * @return the emailId
     */
    @NonVisual
    public Long getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the emailVrednost
     */
    public String getEmailVrednost() {
        return emailVrednost;
    }

    /**
     * @param emailVrednost the emailVrednost to set
     */
    public void setEmailVrednost(String emailVrednost) {
        this.emailVrednost = emailVrednost;
    }

    
}
