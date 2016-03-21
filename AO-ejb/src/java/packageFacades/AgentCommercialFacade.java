/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import packageEntites.AgentCommercial;

/**
 *
 * @author 3092790
 */
@Stateless
public class AgentCommercialFacade extends AbstractFacade<AgentCommercial> implements AgentCommercialFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentCommercialFacade() {
        super(AgentCommercial.class);
    }

    @Override
    public void CreerCommercial(String nom, String prenom, String login, String motdepasse) {
        AgentCommercial ag = new AgentCommercial();
        ag.setNom(nom);
        ag.setPrenom(prenom);
        ag.setLogin(login);
        ag.setMotDePasse(motdepasse);
        em.persist(ag);
    }
    
}
