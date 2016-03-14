/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageEntites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 3092790
 */
@Entity
public class Abonne extends Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abonne)) {
            return false;
        }
        Abonne other = (Abonne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.Abonne[ id=" + id + " ]";
    }
    
    private String numAbonne;

    /**
     * Get the value of numAbonne
     *
     * @return the value of numAbonne
     */
    public String getNumAbonne() {
        return numAbonne;
    }

    /**
     * Set the value of numAbonne
     *
     * @param numAbonne new value of numAbonne
     */
    public void setNumAbonne(String numAbonne) {
        this.numAbonne = numAbonne;
    }

}
