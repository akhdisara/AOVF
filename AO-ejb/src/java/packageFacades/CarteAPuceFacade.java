/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import packageEntites.CarteAPuce;
;

/**
 *
 * @author 3092790
 */
@Stateless
public class CarteAPuceFacade extends AbstractFacade<CarteAPuce> implements CarteAPuceFacadeLocal {

    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarteAPuceFacade() {
        super(CarteAPuce.class);
    }

    @Override
    public CarteAPuce CreerCarteAPuce(Date dateAttribution, Date dateLimite) {
        CarteAPuce c = new CarteAPuce();
        c.setDateDebutValidite(dateAttribution);
        c.setDateFinValidite(dateLimite);
        em.persist(c);
        return c;
    }

    @Override
    public CarteAPuce RechercherCarteParId(long id) {
        try {
            CarteAPuce c;
            String txt = "SELECT c FROM CarteAPuce AS c WHERE c.id=:id";
            Query req = getEntityManager().createQuery(txt);
            req = req.setParameter("id", id);
            c = (CarteAPuce) req.getSingleResult();
            return c;
        } catch (NoResultException e) {
            return null;
        }
    }

}
