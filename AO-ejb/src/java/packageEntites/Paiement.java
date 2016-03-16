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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 *
 * @author 3092790
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Paiement implements Serializable {
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
        if (!(object instanceof Paiement)) {
            return false;
        }
        Paiement other = (Paiement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.Paiement[ id=" + id + " ]";
    }
    
    @OneToOne
    private SousTrajet leSousTrajet;

    /**
     * Get the value of leSousTrajet
     *
     * @return the value of leSousTrajet
     */
    public SousTrajet getLeSousTrajet() {
        return leSousTrajet;
    }

    /**
     * Set the value of leSousTrajet
     *
     * @param leSousTrajet new value of leSousTrajet
     */
    public void setLeSousTrajet(SousTrajet leSousTrajet) {
        this.leSousTrajet = leSousTrajet;
    }

    private double montant;

    /**
     * Get the value of montant
     *
     * @return the value of montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Set the value of montant
     *
     * @param montant new value of montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }

}
