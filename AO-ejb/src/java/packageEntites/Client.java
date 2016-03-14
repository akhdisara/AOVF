/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageEntites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author 3092790
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Client extends Personne implements Serializable {
    @OneToMany(mappedBy = "leClient")
    private List<CompteBancaire> lesComptesBancaires;

    public List<CompteBancaire> getLesComptesBancaires() {
        return lesComptesBancaires;
    }

    public void setLesComptesBancaires(List<CompteBancaire> lesComptesBancaires) {
        this.lesComptesBancaires = lesComptesBancaires;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.Client[ id=" + id + " ]";
    }
    
    @Column(unique = true)
    private String numClient;

    /**
     * Get the value of numClient
     *
     * @return the value of numClient
     */
    public String getNumClient() {
        return numClient;
    }

    /**
     * Set the value of numClient
     *
     * @param numClient new value of numClient
     */
    public void setNumClient(String numClient) {
        this.numClient = numClient;
    }

    private String motDePasse;

    /**
     * Get the value of motDePasse
     *
     * @return the value of motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Set the value of motDePasse
     *
     * @param motDePasse new value of motDePasse
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
