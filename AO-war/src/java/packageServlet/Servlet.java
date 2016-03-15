/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import packageEntites.CarteAPuce;
import packageEntites.Client;
import packageEntites.CompteBancaire;
import packageSessions.SessionCommercialLocal;

/**
 *
 * @author 3092790
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
    @EJB
    private SessionCommercialLocal sessionCommercial;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String jspClient = null;
            String act = request.getParameter("action");
            if ((act == null) || (act.equals("null"))) {
                jspClient = "/Accueil.jsp";
            }
            else if (act.equals("Accueil")) {
                jspClient = "/Accueil.jsp";
                //request.setAttribute("message", "");
            }    
            
            /* else if (act.equals("MenuAuthentifier")) {
                int i;
                i = doActionAuthentifier(request, response);
                if (i == 1) {
                    jspClient = "/MenuCouturier.jsp";
                } else if (i == 2) {
                    jspClient = "/MenuMannequin.jsp";
                } else if (i == 3) {
                    jspClient = "/MenuOrganisateur.jsp";
                } else if (i == 4) {
                    jspClient = "/Authentifier.jsp";
                }
             
            */
            else if (act.equals("AfficherClients")) {
                jspClient = "/ClientAfficher.jsp";
                List<Client> list = sessionCommercial.RetournerClients();
                request.setAttribute("listeclients", list);
                request.setAttribute("message", "");
                //System.out.println("WWWWW"+list.get(0).getLaCarteAPuce().getDateDebutValidite());
            }
            
            else if (act.equals("CreationClient")) {
                jspClient = "/ClientCreer.jsp";
                request.setAttribute("message", "");
            }
            else if (act.equals("ClientAjouter")) {
                jspClient = "/ClientAfficher.jsp";
                doActionAjouterClient(request, response);
            } 
            
    
            RequestDispatcher Rd;
            Rd = getServletContext().getRequestDispatcher(jspClient);
            Rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void doActionAjouterClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mdp = request.getParameter("mdp");
        
        String message;

        if (num.trim().isEmpty() || nom.trim().isEmpty() || prenom.trim().isEmpty() || mdp.trim().isEmpty()) {
            message = "<div class='msg_error'>Erreur - Vous n'avez pas rempli tous les champs obligatoires.</div>";
        } else {
            //Creation d'une carte à puce pour le client
            Date dateDebutValidite = new Date();
 
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateDebutValidite);
            cal.add(Calendar.YEAR, 1); 

            Date dateFinValidite = cal.getTime();

            CarteAPuce carte = sessionCommercial.CreerCarteAPuce(dateDebutValidite, dateFinValidite);
            
            Client client = sessionCommercial.CreerClient(num, mdp, nom, prenom, carte);
            message = "<div class='msg_success'>Le client est créé avec succès !</div>";

        }
        
        request.setAttribute("message", message);
        List<Client> list = sessionCommercial.RetournerClients();
        request.setAttribute("listeclients", list);
    }
    
}
