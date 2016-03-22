/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageFacades;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    @Override
    public String MD5(String input) {
        String md5 = null;
         
        if(null == input) return null;
         
        try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
 
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
 
            e.printStackTrace();
        }
        return md5;
    }
}
