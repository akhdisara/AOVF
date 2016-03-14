/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageSessions;

import javax.ejb.Local;

/**
 *
 * @author 3092790
 */
@Local
public interface SessionCommercialLocal {

    void CreerClient(String num, String mdp, String nom, String prenom);
    
}
