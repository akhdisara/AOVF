/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import packageEntites.Abonnement;
import packageEntites.CarteAPuce;
import packageEntites.Question;
import packageEntites.SousTrajet;

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
    public Abonnement CreerAbonnement(String num, String type, Double montant, CarteAPuce carte, SousTrajet st) {
        Abonnement a = new Abonnement ();
        a.setNumAbonnement(num);
        a.setType(type);
        a.setMontant(montant);
        a.setLaCarteAPuce(carte);
        a.setLeSousTrajet(st);
        em.persist(a);
        return a;
    }
    
    @Override
    public List<Abonnement> RecherheAbonnementParCarte(CarteAPuce carte) {
        List<Abonnement> listeAbonnements;
        String txt = "SELECT a FROM Abonnement AS a WHERE a.laCarteAPuce=:carte";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("carte", carte);
        listeAbonnements = req.getResultList();
        return listeAbonnements;
    }

    
}
