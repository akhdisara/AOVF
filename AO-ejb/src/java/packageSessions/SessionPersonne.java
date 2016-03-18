/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageSessions;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import packageEntites.Question;
import packageEntites.QuestionProposition;
import packageEntites.QuestionReponse;
import packageFacades.QuestionFacadeLocal;
import packageFacades.QuestionPropositionFacadeLocal;
import packageFacades.QuestionReponseFacadeLocal;

/**
 *
 * @author 3099709
 */
@Stateless
public class SessionPersonne implements SessionPersonneLocal {
    @EJB
    private QuestionFacadeLocal questionFacade;
    @EJB
    private QuestionPropositionFacadeLocal questionPropositionFacade;
    @EJB
    private QuestionReponseFacadeLocal questionReponseFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void AjouterPropositionAReponse(long idP, long idR) {
        QuestionReponse r = questionReponseFacade.RechercherReponseParID(idR);
        QuestionProposition p = questionPropositionFacade.RechercherPropositionParID(idP);
        //questionReponseFacade.AjouterListPropositionAReponse(p, r);
    }

    @Override
    public List<Question> RetournerQuestion() {
        return questionFacade.RetournerQuestion();
    }

    @Override
    public List<QuestionProposition> RetournerProposition() {
        return questionPropositionFacade.RetournerProposition();
    }

    @Override
    public void AjouterReponse(QuestionProposition proposition) {
        questionReponseFacade.AjouterReponse(proposition);
    }

    @Override
    public QuestionProposition RechercherPropositionParId(long id) {
        QuestionProposition p = questionPropositionFacade.RechercherPropositionParID(id);
        return p;
    }
    
    
    
}
