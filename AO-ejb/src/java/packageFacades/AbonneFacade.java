/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import packageEntites.Abonne;
import packageEntites.CarteAPuce;

/**
 *
 * @author 3092790
 */
@Stateless
public class AbonneFacade extends AbstractFacade<Abonne> implements AbonneFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbonneFacade() {
        super(Abonne.class);
    }
    
    @Override
    public Abonne RechercherAbonneParId(long id) {
        try {
            Abonne a;
            String txt = "SELECT a FROM Abonne AS a WHERE a.id=:id";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("id", id);
            a = (Abonne) req.getSingleResult();
            return a;
        } catch (NoResultException e) {
            return null;
        }
    }
}
