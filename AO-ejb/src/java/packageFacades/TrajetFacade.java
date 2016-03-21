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
import packageEntites.SousTrajet;
import packageEntites.Trajet;

/**
 *
 * @author 3092790
 */
@Stateless
public class TrajetFacade extends AbstractFacade<Trajet> implements TrajetFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrajetFacade() {
        super(Trajet.class);
    }
    
    
    @Override
    public Trajet CreerTrajet(String d, String a,double tarifSTF,double tarifSTR) {
        Trajet t = new Trajet();
        t.setArretArrivee(a);
        t.setArretDepart(d);
        t.setDateTrajet(new Date());
        t.setTarifTotalSTF(tarifSTF);
        t.setTarifTotalSTR(tarifSTR);
        em.persist(t);
        return t;
    }
}
