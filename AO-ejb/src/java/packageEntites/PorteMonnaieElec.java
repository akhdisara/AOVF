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
import javax.persistence.OneToOne;

/**
 *
 * @author 3092790
 */
@Entity
public class PorteMonnaieElec extends Paiement implements Serializable {
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
        if (!(object instanceof PorteMonnaieElec)) {
            return false;
        }
        PorteMonnaieElec other = (PorteMonnaieElec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.PorteMonnaieElec[ id=" + id + " ]";
    }
    
    @OneToOne
    private CarteAPuce laCarteAPuce;

    /**
     * Get the value of laCarteAPuce
     *
     * @return the value of laCarteAPuce
     */
    public CarteAPuce getLaCarteAPuce() {
        return laCarteAPuce;
    }

    /**
     * Set the value of laCarteAPuce
     *
     * @param laCarteAPuce new value of laCarteAPuce
     */
    public void setLaCarteAPuce(CarteAPuce laCarteAPuce) {
        this.laCarteAPuce = laCarteAPuce;
    }

    private double solde;

    /**
     * Get the value of solde
     *
     * @return the value of solde
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Set the value of solde
     *
     * @param solde new value of solde
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

}
