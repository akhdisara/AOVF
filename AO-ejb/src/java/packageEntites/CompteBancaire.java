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

/**
 *
 * @author 3092790
 */
@Entity
public class CompteBancaire implements Serializable {
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
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "packageEntites.CompteBancaire[ id=" + id + " ]";
    }
    
    private int numCompte;

    /**
     * Get the value of numCompte
     *
     * @return the value of numCompte
     */
    public int getNumCompte() {
        return numCompte;
    }

    /**
     * Set the value of numCompte
     *
     * @param numCompte new value of numCompte
     */
    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    private String titulaire;

    /**
     * Get the value of titulaire
     *
     * @return the value of titulaire
     */
    public String getTitulaire() {
        return titulaire;
    }

    /**
     * Set the value of titulaire
     *
     * @param titulaire new value of titulaire
     */
    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    private String nomBanque;

    /**
     * Get the value of nomBanque
     *
     * @return the value of nomBanque
     */
    public String getNomBanque() {
        return nomBanque;
    }

    /**
     * Set the value of nomBanque
     *
     * @param nomBanque new value of nomBanque
     */
    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    private int codeGuichet;

    /**
     * Get the value of codeGuichet
     *
     * @return the value of codeGuichet
     */
    public int getCodeGuichet() {
        return codeGuichet;
    }

    /**
     * Set the value of codeGuichet
     *
     * @param codeGuichet new value of codeGuichet
     */
    public void setCodeGuichet(int codeGuichet) {
        this.codeGuichet = codeGuichet;
    }

    @ManyToOne
    private Client leClient;

    /**
     * Get the value of leClient
     *
     * @return the value of leClient
     */
    public Client getLeClient() {
        return leClient;
    }

    /**
     * Set the value of leClient
     *
     * @param leClient new value of leClient
     */
    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

}
