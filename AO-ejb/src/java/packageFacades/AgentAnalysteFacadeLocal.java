/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.AgentAnalyste;

/**
 *
 * @author 3092790
 */
@Local
public interface AgentAnalysteFacadeLocal {

    void create(AgentAnalyste agentAnalyste);

    void edit(AgentAnalyste agentAnalyste);

    void remove(AgentAnalyste agentAnalyste);

    AgentAnalyste find(Object id);

    List<AgentAnalyste> findAll();

    List<AgentAnalyste> findRange(int[] range);

    int count();
    
}
