/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void CreerClient(String numClient, String mdp, String nom, String prenom) {
        Client c = new Client();
        c.setNumClient(numClient);
        c.setMotDePasse(mdp);
        c.setNom(nom);
        c.setPrenom(prenom);
        em.persist(c);
    }
    
}
