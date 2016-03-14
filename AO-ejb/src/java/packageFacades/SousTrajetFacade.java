/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import packageEntites.SousTrajet;

/**
 *
 * @author 3092790
 */
@Stateless
public class SousTrajetFacade extends AbstractFacade<SousTrajet> implements SousTrajetFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SousTrajetFacade() {
        super(SousTrajet.class);
    }
    
}
