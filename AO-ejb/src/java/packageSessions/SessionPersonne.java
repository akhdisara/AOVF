/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageSessions;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import packageEntites.Client;
import packageEntites.Employe;
import packageEntites.Question;
import packageEntites.QuestionProposition;
import packageEntites.QuestionReponse;
import packageFacades.ClientFacadeLocal;
import packageFacades.EmployeFacadeLocal;
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
    private QuestionPropositionFacadeLocal questionPropositionFacade1;
    @EJB
    private EmployeFacadeLocal employeFacade;
    @EJB
    private ClientFacadeLocal clientFacade;
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

    @Override
    public Client AuthentifierClient(String login, String password) {
        Client c = clientFacade.AuthentifierClient(login, password);
        return c;
    }

    @Override
    public Employe AuthentifierCommercial(String login, String password) {
        Employe e = employeFacade.AuthentifierCommercial(login, password);
        return e;
    }

    @Override
    public QuestionProposition CreerProposition(String proposition, Question idquestion) {
        return questionPropositionFacade.CreerProposition(proposition, idquestion);
        
    }
    
    
    
}
