/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.Personne;

/**
 *
 * @author 3092790
 */
@Local
public interface PersonneFacadeLocal {

    void create(Personne personne);

    void edit(Personne personne);

    void remove(Personne personne);

    Personne find(Object id);

    List<Personne> findAll();

    List<Personne> findRange(int[] range);

    int count();

    String MD5(String input);
    
}
