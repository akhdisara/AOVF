/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.Trajet;

/**
 *
 * @author 3092790
 */
@Local
public interface TrajetFacadeLocal {

    void create(Trajet trajet);

    void edit(Trajet trajet);

    void remove(Trajet trajet);

    Trajet find(Object id);

    List<Trajet> findAll();

    List<Trajet> findRange(int[] range);

    int count();
    
    Trajet CreerTrajet(String d, String a,double tarifSTF,double tarifSTR);
  
}
