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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author 3092790
 */
@Entity
public class SousTrajet implements Serializable {
    @OneToOne(mappedBy = "leSousTrajet")
    private Paiement lePaiement;

    public Paiement getLePaiement() {
        return lePaiement;
    }

    public void setLePaiement(Paiement lePaiement) {
        this.lePaiement = lePaiement;
    }
    
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
        if (!(object instanceof SousTrajet)) {
            return false;
        }
        SousTrajet other = (SousTrajet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.SousTrajet[ id=" + id + " ]";
    }
    
    private String arretDepart;

    /**
     * Get the value of arretDepart
     *
     * @return the value of arretDepart
     */
    public String getArretDepart() {
        return arretDepart;
    }

    /**
     * Set the value of arretDepart
     *
     * @param arretDepart new value of arretDepart
     */
    public void setArretDepart(String arretDepart) {
        this.arretDepart = arretDepart;
    }

    private String arretArrivee;

    /**
     * Get the value of arretArrivee
     *
     * @return the value of arretArrivee
     */
    public String getArretArrivee() {
        return arretArrivee;
    }

    /**
     * Set the value of arretArrivee
     *
     * @param arretArrivee new value of arretArrivee
     */
    public void setArretArrivee(String arretArrivee) {
        this.arretArrivee = arretArrivee;
    }

    @ManyToOne
    private Trajet trajet;

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    private String ligne;

    /**
     * Get the value of ligne
     *
     * @return the value of ligne
     */
    public String getLigne() {
        return ligne;
    }

    /**
     * Set the value of ligne
     *
     * @param ligne new value of ligne
     */
    public void setLigne(String ligne) {
        this.ligne = ligne;
    }

    private double tarif;

    /**
     * Get the value of tarif
     *
     * @return the value of tarif
     */
    public double getTarif() {
        return tarif;
    }

    /**
     * Set the value of tarif
     *
     * @param tarif new value of tarif
     */
    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

}
