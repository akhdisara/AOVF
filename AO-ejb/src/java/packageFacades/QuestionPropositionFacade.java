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
import packageEntites.Question;
import packageEntites.QuestionProposition;

/**
 *
 * @author 3099709
 */
@Stateless
public class QuestionPropositionFacade extends AbstractFacade<QuestionProposition> implements QuestionPropositionFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionPropositionFacade() {
        super(QuestionProposition.class);
    }

    @Override
    public QuestionProposition RechercherPropositionParID(long id) {
        QuestionProposition p;
        String txt = "SELECT p FROM QuestionProposition AS p WHERE p.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);
        p = (QuestionProposition) req.getSingleResult();
        return p;
    }

    @Override
    public List <QuestionProposition> RetournerProposition() {
        List<QuestionProposition> listeProposition;
        QuestionProposition p = null;
        String txt = "SELECT p FROM QuestionProposition as p";
        Query req = getEntityManager().createQuery(txt);
        listeProposition = req.getResultList();
        return listeProposition;
    }

    @Override
    public QuestionProposition RechercherPropositionParId(long id) {
        QuestionProposition p;
        String txt = "SELECT p FROM QuestionProposition AS p WHERE p.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);
        p = (QuestionProposition) req.getSingleResult();
        return p;
    }

    @Override
    public QuestionProposition CreerProposition(String proposition, Question idquestion) {
        QuestionProposition p = new QuestionProposition();
        p.setProposition(proposition);
        p.setLaQuestion(idquestion);
        em.persist(p);
        return p;
    }
    
    
}
