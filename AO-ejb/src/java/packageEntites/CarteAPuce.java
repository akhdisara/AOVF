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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author 3092790
 */
@Entity
public class CarteAPuce implements Serializable {
    @OneToMany(mappedBy = "laCarteAPuce")
    private List<Trajet> lesTrajets;

    public List<Trajet> getLesTrajets() {
        return lesTrajets;
    }

    public void setLesTrajets(List<Trajet> lesTrajets) {
        this.lesTrajets = lesTrajets;
    }
    
    @OneToOne(mappedBy = "laCarteAPuce")
    private PorteMonnaieElec lePorteMonnaie;

    public PorteMonnaieElec getLePorteMonnaie() {
        return lePorteMonnaie;
    }

    public void setLePorteMonnaie(PorteMonnaieElec lePorteMonnaie) {
        this.lePorteMonnaie = lePorteMonnaie;
    }
    
    @OneToMany(mappedBy = "laCarteAPuce")
    private List<Abonnement> lesAbonnements;

    public List<Abonnement> getLesAbonnements() {
        return lesAbonnements;
    }

    public void setLesAbonnements(List<Abonnement> lesAbonnements) {
        this.lesAbonnements = lesAbonnements;
    }
    @OneToOne (mappedBy = "laCarteAPuce")
    private Personne laPersonne;

    public Personne getLaPersonne() {
        return laPersonne;
    }

    public void setLaPersonne(Personne laPersonne) {
        this.laPersonne = laPersonne;
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
        if (!(object instanceof CarteAPuce)) {
            return false;
        }
        CarteAPuce other = (CarteAPuce) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.CarteAPuce[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutValidite;

    /**
     * Get the value of dateDebutValidite
     *
     * @return the value of dateDebutValidite
     */
    public Date getDateDebutValidite() {
        return dateDebutValidite;
    }

    /**
     * Set the value of dateDebutValidite
     *
     * @param dateDebutValidite new value of dateDebutValidite
     */
    public void setDateDebutValidite(Date dateDebutValidite) {
        this.dateDebutValidite = dateDebutValidite;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinValidite;

    /**
     * Get the value of dateFinValidite
     *
     * @return the value of dateFinValidite
     */
    public Date getDateFinValidite() {
        return dateFinValidite;
    }

    /**
     * Set the value of dateFinValidite
     *
     * @param dateFinValidite new value of dateFinValidite
     */
    public void setDateFinValidite(Date dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

}
