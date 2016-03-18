/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import packageEntites.QuestionProposition;
import packageEntites.QuestionReponse;

/**
 *
 * @author 3099709
 */
@Stateless
public class QuestionReponseFacade extends AbstractFacade<QuestionReponse> implements QuestionReponseFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionReponseFacade() {
        super(QuestionReponse.class);
    }


    @Override
    public QuestionReponse RechercherReponseParID(long idrep) {
        QuestionReponse r;
        String txt = "SELECT r FROM QuestionReponse AS r WHERE r.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", idrep);
        r = (QuestionReponse) req.getSingleResult();
        return r;
    }

    @Override
    public void AjouterReponse(QuestionProposition proposition) {
        QuestionReponse r = new QuestionReponse();
        r.setLaProposition(proposition);
        em.persist(r);
    }

    
}
