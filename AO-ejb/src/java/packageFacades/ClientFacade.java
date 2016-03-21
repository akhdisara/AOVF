/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import packageEntites.CarteAPuce;
import packageEntites.Client;

/**
 *
 * @author 3092790
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public Client CreerClient(String numClient, String mdp, String nom, String prenom, CarteAPuce carte) {
        Client c = new Client();
        c.setNumClient(numClient);
        c.setMotDePasse(mdp);
        c.setNom(nom);
        c.setPrenom(prenom);
        c.setLaCarteAPuce(carte);
        em.persist(c);
        return c;
    }

    @Override
    public List<Client> RetournerClients() {
        List<Client> listeC;
        Client c = null;
        String txt = "SELECT c FROM Client as c";
        Query req = getEntityManager().createQuery(txt);
        listeC = req.getResultList();
        return listeC;
    }

    @Override
    public Client RechercherClientParId(long id) {
        Client c;
        String txt = "SELECT c FROM Client AS c WHERE c.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);
        c = (Client) req.getSingleResult();
        return c;
    }

    @Override
    public void ModifierClient(long id, String num, String nom, String prenom) {
        Client c = RechercherClientParId(id);
        c.setNumClient(num);
        c.setNom(nom);
        c.setPrenom(prenom);
        em.merge(c);
    }

    @Override
    public Client AuthentifierClient(String login, String password) {
        Client c = null;
        String txt = "SELECT c FROM Client as c WHERE c.numClient=:login and c.motDePasse=:password";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("login", login);
        req = req.setParameter("password", password);

        List<Client> list = req.getResultList();
        for (Client c1 : list) {
            c = c1;
        }

        return c;
    }
    
}
