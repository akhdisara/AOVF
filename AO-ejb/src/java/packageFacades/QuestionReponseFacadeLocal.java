/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.QuestionProposition;
import packageEntites.QuestionReponse;

/**
 *
 * @author 3099709
 */
@Local
public interface QuestionReponseFacadeLocal {

    void create(QuestionReponse questionReponse);

    void edit(QuestionReponse questionReponse);

    void remove(QuestionReponse questionReponse);

    QuestionReponse find(Object id);

    List<QuestionReponse> findAll();

    List<QuestionReponse> findRange(int[] range);

    int count();

    QuestionReponse RechercherReponseParID(long idrep);

    void AjouterReponse(QuestionProposition proposition);
    
}
