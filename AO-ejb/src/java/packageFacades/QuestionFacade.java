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

/**
 *
 * @author 3099709
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question> implements QuestionFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionFacade() {
        super(Question.class);
    }

    @Override
    public List <Question> RetournerQuestion() {
        List<Question> listeQuestion;
        Question q = null;
        String txt = "SELECT q FROM Question as q order by q.numquestion asc";
        Query req = getEntityManager().createQuery(txt);
        listeQuestion = req.getResultList();
        return listeQuestion;
    }

    @Override
    public Question CreerQuestion(int num, String quest) {
        Question q = new Question();
        q.setNumquestion(num);
        q.setQuestion(quest);
        em.persist(q);
        return q;
    }
    
    
}
