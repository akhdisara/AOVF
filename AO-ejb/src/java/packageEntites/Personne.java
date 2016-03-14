/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageEntites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 3092790
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {
    @OneToMany(mappedBy = "laPersonne")
    private List<Facture> lesFactures;

    public List<Facture> getLesFactures() {
        return lesFactures;
    }

    public void setLesFactures(List<Facture> lesFactures) {
        this.lesFactures = lesFactures;
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
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.Personne[ id=" + id + " ]";
    }
    
    private String nom;

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    private String prenom;

    /**
     * Get the value of prenom
     *
     * @return the value of prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Set the value of prenom
     *
     * @param prenom new value of prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

}
