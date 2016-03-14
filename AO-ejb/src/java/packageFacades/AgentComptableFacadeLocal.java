/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.util.List;
import javax.ejb.Local;
import packageEntites.AgentComptable;

/**
 *
 * @author 3092790
 */
@Local
public interface AgentComptableFacadeLocal {

    void create(AgentComptable agentComptable);

    void edit(AgentComptable agentComptable);

    void remove(AgentComptable agentComptable);

    AgentComptable find(Object id);

    List<AgentComptable> findAll();

    List<AgentComptable> findRange(int[] range);

    int count();
    
}
