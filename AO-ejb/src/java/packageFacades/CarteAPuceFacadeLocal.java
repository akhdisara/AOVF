/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import packageEntites.CarteAPuce;
import packageEntites.Personne;

/**
 *
 * @author 3092790
 */
@Local
public interface CarteAPuceFacadeLocal {

    void create(CarteAPuce carteAPuce);

    void edit(CarteAPuce carteAPuce);

    void remove(CarteAPuce carteAPuce);

    CarteAPuce find(Object id);

    List<CarteAPuce> findAll();

    List<CarteAPuce> findRange(int[] range);

    int count();

    CarteAPuce CreerCarteAPuce(Date dateAttribution, Date dateLimite);
    
    CarteAPuce RechercherCarteParId(long id);
    
}
