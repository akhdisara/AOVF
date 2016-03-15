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
import packageEntites.Client;
import packageEntites.CompteBancaire;

/**
 *
 * @author 3092790
 */
@Stateless
public class CompteBancaireFacade extends AbstractFacade<CompteBancaire> implements CompteBancaireFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteBancaireFacade() {
        super(CompteBancaire.class);
    }

    @Override
    public List<CompteBancaire> RetournerComptes() {
        List<CompteBancaire> listeC;
        CompteBancaire c = null;
        String txt = "SELECT c FROM CompteBancaire as c";
        Query req = getEntityManager().createQuery(txt);
        listeC = req.getResultList();
        return listeC;
    }

    @Override
    public void CreerCompte(int num, String titulaire, String banque, String guichet, Client client) {
        CompteBancaire c = new CompteBancaire();
        c.setNumCompte(num);
        c.setTitulaire(titulaire);
        c.setNomBanque(banque);
        c.setCodeGuichet(num);
        c.setLeClient(client);
        em.persist(c);
    }
    
}
