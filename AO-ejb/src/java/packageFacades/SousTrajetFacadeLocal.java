/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.SousTrajet;

/**
 *
 * @author 3092790
 */
@Local
public interface SousTrajetFacadeLocal {

    void create(SousTrajet sousTrajet);

    void edit(SousTrajet sousTrajet);

    void remove(SousTrajet sousTrajet);

    SousTrajet find(Object id);

    List<SousTrajet> findAll();

    List<SousTrajet> findRange(int[] range);

    int count();
    
    SousTrajet CreerSousTrajet(String d, String a, String l,double tarif);
    
}
