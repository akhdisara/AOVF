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
import packageEntites.Employe;

/**
 *
 * @author 3092790
 */
@Stateless
public class EmployeFacade extends AbstractFacade<Employe> implements EmployeFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeFacade() {
        super(Employe.class);
    }

    @Override
    public Employe AuthentifierCommercial(String login, String password) {
        Employe e = null;
        String txt = "SELECT e FROM Employe as e WHERE e.login=:login and e.motDePasse=:password";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("login", login);
        req = req.setParameter("password", password);

        List<Employe> list = req.getResultList();
        for (Employe e1 : list) {
            e = e1;
        }

        return e;
    }
    
}
