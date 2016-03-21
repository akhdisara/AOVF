/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.Abonne;

/**
 *
 * @author 3092790
 */
@Local
public interface AbonneFacadeLocal {

    void create(Abonne abonne);

    void edit(Abonne abonne);

    void remove(Abonne abonne);

    Abonne find(Object id);

    List<Abonne> findAll();

    List<Abonne> findRange(int[] range);

    int count();
    
    Abonne RechercherAbonneParId(long id);
    
}
