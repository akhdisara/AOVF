/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.QuestionProposition;

/**
 *
 * @author 3099709
 */
@Local
public interface QuestionPropositionFacadeLocal {

    void create(QuestionProposition questionProposition);

    void edit(QuestionProposition questionProposition);

    void remove(QuestionProposition questionProposition);

    QuestionProposition find(Object id);

    List<QuestionProposition> findAll();

    List<QuestionProposition> findRange(int[] range);

    int count();

    QuestionProposition RechercherPropositionParID(long id);

    List RetournerProposition();

    QuestionProposition RechercherPropositionParId(long id);
    
}
