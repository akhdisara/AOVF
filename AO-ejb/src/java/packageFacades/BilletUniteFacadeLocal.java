/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.BilletUnite;

/**
 *
 * @author 3092790
 */
@Local
public interface BilletUniteFacadeLocal {

    void create(BilletUnite billetUnite);

    void edit(BilletUnite billetUnite);

    void remove(BilletUnite billetUnite);

    BilletUnite find(Object id);

    List<BilletUnite> findAll();

    List<BilletUnite> findRange(int[] range);

    int count();
    
}
