/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import packageEntites.CarteAPuce;
import packageEntites.Personne;

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
    
}
