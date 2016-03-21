/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.Abonnement;
import packageEntites.CarteAPuce;

/**
 *
 * @author 3092790
 */
@Local
public interface AbonnementFacadeLocal {

    void create(Abonnement abonnement);

    void edit(Abonnement abonnement);

    void remove(Abonnement abonnement);

    Abonnement find(Object id);

    List<Abonnement> findAll();

    List<Abonnement> findRange(int[] range);

    int count();

    void CreerAbonnement(String num, String type, Double montant, CarteAPuce carte);
    
    List<Abonnement> RecherheAbonnementParCarte(CarteAPuce carte);
    
}
