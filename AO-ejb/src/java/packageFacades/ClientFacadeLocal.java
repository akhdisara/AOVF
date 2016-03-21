/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.CarteAPuce;
import packageEntites.Client;

/**
 *
 * @author 3092790
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();

    Client CreerClient(String numClient, String mdp, String nom, String prenom, CarteAPuce carte);

    List<Client> RetournerClients();

    Client RechercherClientParId(long id);

    void ModifierClient(long id, String num, String nom, String prenom);

    Client AuthentifierClient(String login, String password);
    
}
