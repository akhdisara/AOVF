/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageSessions;

import java.util.List;
import javax.ejb.Local;
import packageEntites.Client;
import packageEntites.Employe;
import packageEntites.Question;
import packageEntites.QuestionProposition;

/**
 *
 * @author 3099709
 */
@Local
public interface SessionPersonneLocal {

    void AjouterPropositionAReponse(long idP, long idR);

    List RetournerQuestion();

    List RetournerProposition();

    void AjouterReponse(QuestionProposition proposition);

    QuestionProposition RechercherPropositionParId(long id);

    Client AuthentifierClient(String login, String password);

    Employe AuthentifierCommercial(String login, String password);

    QuestionProposition CreerProposition(String proposition, Question idquestion);
    
}
