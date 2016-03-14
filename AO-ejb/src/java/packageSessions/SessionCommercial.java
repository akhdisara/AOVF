/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageSessions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import packageFacades.ClientFacadeLocal;

/**
 *
 * @author 3092790
 */
@Stateless
public class SessionCommercial implements SessionCommercialLocal {
    @EJB
    private ClientFacadeLocal clientFacade;

    @Override
    public void CreerClient(String num, String mdp, String nom, String prenom) {
        clientFacade.CreerClient(num, mdp, nom, prenom);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
