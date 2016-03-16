/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import packageEntites.Abonnement;
import packageEntites.CarteAPuce;

/**
 *
 * @author 3092790
 */
@Stateless
public class AbonnementFacade extends AbstractFacade<Abonnement> implements AbonnementFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbonnementFacade() {
        super(Abonnement.class);
    }

    @Override
    public void CreerAbonnement(String num, String type, Double montant, CarteAPuce carte) {
        Abonnement a = new Abonnement ();
        a.setNumAbonnement(num);
        a.setType(type);
        a.setMontant(montant);
        a.setLaCarteAPuce(carte);
        em.persist(a);
    }
    
}
