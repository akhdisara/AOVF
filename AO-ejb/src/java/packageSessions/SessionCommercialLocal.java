/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageSessions;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import packageEntites.CarteAPuce;
import packageEntites.Client;
import packageEntites.CompteBancaire;
import packageEntites.Personne;

/**
 *
 * @author 3092790
 */
@Local
public interface SessionCommercialLocal {

    Client CreerClient(String num, String mdp, String nom, String prenom, CarteAPuce carte);

    List<Client> RetournerClients();

    List<CompteBancaire> RetournerComptes();

    void CreerCompte(int num, String titulaire, String banque, String guichet, Client client);

    CarteAPuce CreerCarteAPuce(Date datedebut, Date datefin);
    
}
