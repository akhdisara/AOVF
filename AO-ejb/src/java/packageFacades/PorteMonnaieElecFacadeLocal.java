/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.CarteAPuce;
import packageEntites.PorteMonnaieElec;

/**
 *
 * @author 3092790
 */
@Local
public interface PorteMonnaieElecFacadeLocal {

    void create(PorteMonnaieElec porteMonnaieElec);

    void edit(PorteMonnaieElec porteMonnaieElec);

    void remove(PorteMonnaieElec porteMonnaieElec);

    PorteMonnaieElec find(Object id);

    List<PorteMonnaieElec> findAll();

    List<PorteMonnaieElec> findRange(int[] range);

    int count();

    void CreerPorteMonnaieElec(CarteAPuce laCarte);
    
}
