/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageEntites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author 3092790
 */
@Entity
public class Trajet implements Serializable {
    @ManyToMany(mappedBy = "lesTrajets")
    private List<SousTrajet> lesSousTrajets;

    public List<SousTrajet> getLesSousTrajets() {
        return lesSousTrajets;
    }

    public void setLesSousTrajets(List<SousTrajet> lesSousTrajets) {
        this.lesSousTrajets = lesSousTrajets;
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
        if (!(object instanceof Trajet)) {
            return false;
        }
        Trajet other = (Trajet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.Trajet[ id=" + id + " ]";
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

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateTrajet;
    
    public Date getDateTrajet() {
        return dateTrajet;
    }
    
    public void setDateTrajet(Date dateTrajet) {
        this.dateTrajet = dateTrajet;
    }

    @Temporal(javax.persistence.TemporalType.TIME)
    private Date heureDepart;

    /**
     * Get the value of heureDepart
     *
     * @return the value of heureDepart
     */
    public Date getHeureDepart() {
        return heureDepart;
    }

    /**
     * Set the value of heureDepart
     *
     * @param heureDepart new value of heureDepart
     */
    public void setHeureDepart(Date heureDepart) {
        this.heureDepart = heureDepart;
    }

    @Temporal(javax.persistence.TemporalType.TIME)
    private Date heureArrivee;

    /**
     * Get the value of heureArrivee
     *
     * @return the value of heureArrivee
     */
    public Date getHeureArrivee() {
        return heureArrivee;
    }

    /**
     * Set the value of heureArrivee
     *
     * @param heureArrivee new value of heureArrivee
     */
    public void setHeureArrivee(Date heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    @ManyToOne
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

    @OneToOne
    private packageEntites.Facture laFacture;

    /**
     * Get the value of laFacture
     *
     * @return the value of laFacture
     */
    public packageEntites.Facture getLaFacture() {
        return laFacture;
    }

    /**
     * Set the value of laFacture
     *
     * @param laFacture new value of laFacture
     */
    public void setLaFacture(packageEntites.Facture laFacture) {
        this.laFacture = laFacture;
    }

    private double tarifTotalSTF;

    /**
     * Get the value of tarifTotalSTF
     *
     * @return the value of tarifTotalSTF
     */
    public double getTarifTotalSTF() {
        return tarifTotalSTF;
    }

    /**
     * Set the value of tarifTotalSTF
     *
     * @param tarifTotalSTF new value of tarifTotalSTF
     */
    public void setTarifTotalSTF(double tarifTotalSTF) {
        this.tarifTotalSTF = tarifTotalSTF;
    }

    private double tarifTotalSTR;

    /**
     * Get the value of tarifTotalSTR
     *
     * @return the value of tarifTotalSTR
     */
    public double getTarifTotalSTR() {
        return tarifTotalSTR;
    }

    /**
     * Set the value of tarifTotalSTR
     *
     * @param tarifTotalSTR new value of tarifTotalSTR
     */
    public void setTarifTotalSTR(double tarifTotalSTR) {
        this.tarifTotalSTR = tarifTotalSTR;
    }

}
