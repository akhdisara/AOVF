/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.Employe;

/**
 *
 * @author 3092790
 */
@Local
public interface EmployeFacadeLocal {

    void create(Employe employe);

    void edit(Employe employe);

    void remove(Employe employe);

    Employe find(Object id);

    List<Employe> findAll();

    List<Employe> findRange(int[] range);

    int count();

    Employe AuthentifierCommercial(String login, String password);
    
}
