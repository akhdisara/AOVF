/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageSessions;

import java.util.List;
import javax.ejb.Local;
import packageEntites.QuestionProposition;
import packageEntites.QuestionReponse;

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
    
}
