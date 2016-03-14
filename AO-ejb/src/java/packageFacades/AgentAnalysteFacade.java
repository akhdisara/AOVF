/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import packageEntites.AgentAnalyste;

/**
 *
 * @author 3092790
 */
@Stateless
public class AgentAnalysteFacade extends AbstractFacade<AgentAnalyste> implements AgentAnalysteFacadeLocal {
    @PersistenceContext(unitName = "AO-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentAnalysteFacade() {
        super(AgentAnalyste.class);
    }
    
}
