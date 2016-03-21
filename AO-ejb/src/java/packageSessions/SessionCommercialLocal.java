/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageSessions;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import packageEntites.Abonnement;
import packageEntites.CarteAPuce;
import packageEntites.Client;
import packageEntites.CompteBancaire;
import packageEntites.Personne;
import packageEntites.SousTrajet;

/**
 *
 * @author 3092790
 */
@Local
public interface SessionCommercialLocal {

    Client CreerClient(String num, String mdp, String nom, String prenom, CarteAPuce carte);

    List<Client> RetournerClients();

    List<CompteBancaire> RetournerComptes();

    void CreerCompte(int num, String titulaire, String banque, int guichet, Client client);

    CarteAPuce CreerCarteAPuce(Date datedebut, Date datefin);

    Client RechercherClientParId(long id);

    void ModifierClient(Long id, String num, String nom, String prenom);

    CompteBancaire RechercherCompteParId(long id);

    void ModifierCompte(long id, int num, String titulaire, String banque, int guichet);

    Abonnement CreerAbonnement(String num, String type, Double montant, CarteAPuce carte, SousTrajet st);

    void CreerPorteMonnaieElectronique(CarteAPuce carte);
    
    SousTrajet CreerSousTrajet(String depart, String arrivee, String ligne, double tarif);

    List<SousTrajet> RetournerSousTrajets();
    
    public List<Abonnement> RecherheAbonnementParCarte(CarteAPuce carte);
}
