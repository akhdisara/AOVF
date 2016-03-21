/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.AgentCommercial;

/**
 *
 * @author 3092790
 */
@Local
public interface AgentCommercialFacadeLocal {

    void create(AgentCommercial agentCommercial);

    void edit(AgentCommercial agentCommercial);

    void remove(AgentCommercial agentCommercial);

    AgentCommercial find(Object id);

    List<AgentCommercial> findAll();

    List<AgentCommercial> findRange(int[] range);

    int count();

    void CreerCommercial(String nom, String prenom, String login, String motdepasse);
    
}
