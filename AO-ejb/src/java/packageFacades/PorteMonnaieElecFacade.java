/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import packageEntites.CarteAPuce;
import packageEntites.PorteMonnaieElec;

/**
 *
 * @author 3092790
 */
@Stateless
public class PorteMonnaieElecFacade extends AbstractFacade<PorteMonnaieElec> implements PorteMonnaieElecFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PorteMonnaieElecFacade() {
        super(PorteMonnaieElec.class);
    }

    @Override
    public void CreerPorteMonnaieElec(CarteAPuce laCarte) {
        PorteMonnaieElec p = new PorteMonnaieElec();
        p.setLaCarteAPuce(laCarte);
        p.setSolde(0);
        em.persist(p);
    }
    
}
