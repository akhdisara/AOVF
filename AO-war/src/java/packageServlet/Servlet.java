/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
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
import webservice.Abonnement;
import webservice.Arret;
import webservice.DistanceGare;
import webservice.FicheHoraire;
import webservice.Gare;
import webservice.Horaire;
import webservice.Ligne;
import webservice.LigneSTR;
import webservice.Periode;
import webservice.PlageHoraire;
import webservice.PositionArretLigne;
import webservice.Reduction;
import webservice.Trajet;

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
        } else if (act.equals("Accueil")) {
            jspClient = "/Accueil.jsp";
            //request.setAttribute("message", "");
        } /* else if (act.equals("MenuAuthentifier")) {
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
             
         */ else if (act.equals("AfficherClients")) {
            jspClient = "/ClientAfficher.jsp";
            List<Client> list = sessionCommercial.RetournerClients();
            request.setAttribute("listeclients", list);
            request.setAttribute("message", "");
        } else if (act.equals("CreationClient")) {
            jspClient = "/ClientCreer.jsp";
            request.setAttribute("message", "");
        } else if (act.equals("ClientAjouter")) {
            jspClient = "/ClientAfficher.jsp";
            doActionAjouterClient(request, response);
        } else if (act.equals("ModificationClient")) {
            jspClient = "/ClientModifier.jsp";
            doActionAfficherModifClient(request, response);
        } else if (act.equals("ModifierClient")) {
            jspClient = "/ClientAfficher.jsp";
            doActionModifierClient(request, response);
        } else if (act.equals("GererCompte")) {
            jspClient = "/CompteGerer.jsp";
            doActionAfficherGestionCompteClient(request, response);
        } else if (act.equals("CompteAjouter")) {
            jspClient = "/CompteGerer.jsp";
            doActionAjouterCompte(request, response);
        } else if (act.equals("ModificationCompte")) {
            jspClient = "/CompteModifier.jsp";
            doActionAfficherModifCompte(request, response);
        } else if (act.equals("ModifierCompte")) {
            jspClient = "/CompteGerer.jsp";
            doActionModifierCompte(request, response);
        } else if (act.equals("GererAbonnement")) {
            jspClient = "/AbonnementGerer.jsp";
            doActionAfficherGestionAbonnementClient(request, response);
        } else if (act.equals("AbonnementAjouter")) {
            jspClient = "/AbonnementGerer.jsp";
            doActionAjouterAbonnement(request, response);
        } else if (act.equals("Trajet")) {
            jspClient = "/TrajetRechercher.jsp";
            request.setAttribute("message", "");
        } else if (act.equals("ChercherTrajet")) {
            jspClient = "/TrajetRechercher.jsp";
            doActionChercherTrajet(request, response);
        } else if (act.equalsIgnoreCase("lignesSTR")) {
            lignesSTR(request, response);
            jspClient = "/lignesSTR.jsp";
        } else if (act.equals("listReductionsSTR")) {
            jspClient = "/listReductionsSTR.jsp";
            listReductionsSTR(request, response);
        } else if (act.equals("AfficherLignesSTF")) {
            jspClient = "/lignesSTF.jsp";
            AfficherLignesSTF(request, response);
        } else if (act.equals("listAbonnementsSTF")) {
            jspClient = "/listAbonnementsSTF.jsp";
            listAbonnementsSTF(request, response);
        } else if (act.equals("ficheHoraireSTF")) {
            jspClient = "/ficheHoraireSTF.jsp";
            ficheHoraireSTF(request, response);
        } else if (act.equals("ficheTarifaireSTF")) {
            jspClient = "/ficheTarifaireSTF.jsp";
            ficheTarifaireSTF(request, response);
        } else if (act.equals("RechercherLigneSTF")) {
            jspClient = "/lignesSTF.jsp";
            RechercherLigneSTF(request, response);
        } else if (act.equals("chercherLigneSTR")) {
            jspClient = "/lignesSTR.jsp";
            chercherLigneSTR(request, response);
        } else if (act.equalsIgnoreCase("ficheTarifaire")) {
            ficheTarifaire(request, response);
            jspClient = "/ficheTarifaire.jsp";
        } else if (act.equalsIgnoreCase("ficheHoraire")) {
            ficheHoraire(request, response);
            jspClient = "/ficheHoraire.jsp";
        } else if (act.equals("ficheHoraireSTF")) {
            jspClient = "/ficheHoraireSTF.jsp";
            ficheHoraireSTF(request, response);
        } else if (act.equals("ficheTarifaireSTF")) {
            jspClient = "/ficheTarifaireSTF.jsp";
            ficheTarifaireSTF(request, response);
        }

        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
    }

    protected void ficheHoraireSTF(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTF_Service service = new webservice.WebServiceSTF_Service();
        webservice.WebServiceSTF port = service.getWebServiceSTFPort();
        List<Gare> listeGares = port.retournerGaresSTF();
        request.setAttribute("listeGares", listeGares);

        String id = request.getParameter("IdLigne");
        Long idligne = Long.valueOf(id);
        Ligne ligne = port.rechercherLigneSTFParId(idligne);
        List<Horaire> listeHoraires = port.rechercherHoraireSTFParLigne(ligne);
        request.setAttribute("listeHoraires", listeHoraires);

        List<DistanceGare> lesDistances = port.retournerDistanceGareParLigne(ligne);
        request.setAttribute("lesDistances", lesDistances);

    }

    protected void ficheTarifaireSTF(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTF_Service service = new webservice.WebServiceSTF_Service();
        webservice.WebServiceSTF port = service.getWebServiceSTFPort();
        String id = request.getParameter("IdLigne");
        Long idligne = Long.valueOf(id);
        Ligne ligne = port.rechercherLigneSTFParId(idligne);
        String message = "Liste des tarif pour la ligne n°" + ligne.getNumLigne();
        request.setAttribute("message", message);
        request.setAttribute("ligne", ligne);
        List<DistanceGare> lesDistances = port.retournerDistanceGareParLigne(ligne);
        request.setAttribute("lesDistances", lesDistances);
        double prix = port.getPrixilometre();
        request.setAttribute("prixKM", prix);
    }

    protected void ficheHoraire(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();
        String id = request.getParameter("id");
        LigneSTR ligne = port.rechercheLigneParId(Long.parseLong(id));
        //Preparer la liste des plages horaires à afficher
        List<Object> fichesBlanche = port.rechercheFicheHoraireParLignePeriode(ligne, Periode.BLANCHE);
        for (Object o : fichesBlanche) {
            FicheHoraire fich = (FicheHoraire) o;
            List<PlageHoraire> listePlages = new ArrayList(port.recherchePlagesHorairesParFicheHoraire(fich));
            request.setAttribute("PlageHoraireFichB" + fich.getId(), listePlages);
        }
        request.setAttribute("collectionFichesHorairesBlanche", fichesBlanche);

        Collection<Object> fichesJaune = port.rechercheFicheHoraireParLignePeriode(ligne, Periode.JAUNE);
        for (Object o : fichesJaune) {
            FicheHoraire fich = (FicheHoraire) o;
            List<PlageHoraire> listePlages = new ArrayList(port.recherchePlagesHorairesParFicheHoraire(fich));
            request.setAttribute("PlageHoraireFichJ" + fich.getId(), listePlages);
        }
        request.setAttribute("collectionFichesHorairesJaune", fichesJaune);
        request.setAttribute("ligne", ligne);
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

    protected void ficheTarifaire(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();

        String id = request.getParameter("id");
        LigneSTR ligne = port.rechercheLigneParId(Long.parseLong(id));
        request.setAttribute("ligne", ligne);

        List<PositionArretLigne> PositionsArretLigne = new ArrayList(port.recherchePositionParLigne(ligne));
        request.setAttribute("PositionsArretLigne", PositionsArretLigne);

        for (Object o : port.rechercheTrajetParLigne(ligne)) {
            Trajet t = (Trajet) o;

            String arretDebut = t.getDebut().getNom();
            String arretFin = t.getFin().getNom();

            double tarifBase = port.tarifBaseParArrets(ligne, t.getDebut(), t.getFin());
            request.setAttribute("tarif_" + arretDebut + "_" + arretFin, String.valueOf(tarifBase));

            double tarifMensuel = port.tarifMensuelParArrets(ligne, t.getDebut(), t.getFin());
            request.setAttribute("tarifM_" + arretDebut + "_" + arretFin, String.valueOf(tarifMensuel));

            double tarifHebdomadaire = port.tarifHebdomadaireParArrets(ligne, t.getDebut(), t.getFin());
            request.setAttribute("tarifH_" + arretDebut + "_" + arretFin, String.valueOf(tarifHebdomadaire));

        }
    }

    protected void chercherLigneSTR(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();
        String identifiant = request.getParameter("identifiant");
        LigneSTR ligne = port.rechercheLigneSTRParIdentifiant(identifiant);
        Collection<LigneSTR> coll = new ArrayList<LigneSTR>();
        coll.add(ligne);
        request.setAttribute("collectionLignes", coll);
        request.setAttribute("message", "");
    }

    protected void RechercherLigneSTF(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTF_Service service = new webservice.WebServiceSTF_Service();
        webservice.WebServiceSTF port = service.getWebServiceSTFPort();
        String numLigne = request.getParameter("NumLigne");
        Ligne ligne = port.rechercherLigneSTFParNum(Integer.parseInt(numLigne));
        List<Ligne> list = new ArrayList<Ligne>();
        list.add(ligne);
        request.setAttribute("listelignes", list);
        request.setAttribute("message", "");
    }

    protected void listAbonnementsSTF(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTF_Service service = new webservice.WebServiceSTF_Service();
        webservice.WebServiceSTF port = service.getWebServiceSTFPort();
        List<Abonnement> listeabonnements = port.retournerAbonnementSTF();
        request.setAttribute("listeabonnements", listeabonnements);
    }

    protected void AfficherLignesSTF(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTF_Service service = new webservice.WebServiceSTF_Service();
        webservice.WebServiceSTF port = service.getWebServiceSTFPort();
        List<Object> listResult = port.retournerLignesSTF();
        List<Ligne> list = new ArrayList<Ligne>();
        for (Object o : listResult) {
            Ligne l = (Ligne) o;
            list.add(l);
        }
        request.setAttribute("listelignes", list);
        request.setAttribute("message", "");
    }

    private List<Ligne> retournerLignesSTF() {
        webservice.WebServiceSTF_Service service = new webservice.WebServiceSTF_Service();
        webservice.WebServiceSTF port = service.getWebServiceSTFPort();
        List<Object> listResult = port.retournerLignesSTF();
        List<Ligne> list = new ArrayList<Ligne>();
        for (Object o : listResult) {
            Ligne l = (Ligne) o;
            list.add(l);
        }
        return list;
    }

    private List<Gare> retournerGaresSTF() {
        webservice.WebServiceSTF_Service service = new webservice.WebServiceSTF_Service();
        webservice.WebServiceSTF port = service.getWebServiceSTFPort();
        return port.retournerGaresSTF();
    }

    private List<Abonnement> retournerAbonnementsSTF() {
        webservice.WebServiceSTF_Service service = new webservice.WebServiceSTF_Service();
        webservice.WebServiceSTF port = service.getWebServiceSTFPort();
        return port.retournerAbonnementSTF();
    }

    private List<LigneSTR> retournerlignesSTR() {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();
        List<Object> listResult = port.listeLignesSTR();
        List<LigneSTR> list = new ArrayList<LigneSTR>();
        for (Object o : listResult) {
            LigneSTR l = (LigneSTR) o;
            list.add(l);
        }
        return list;
    }

    private List<Arret> retournerArretsSTR() {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();
        return port.afficherListeArretsSTR();
    }

    private List<Abonnement> retournerAbonnementsSTR() {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();
        List<Object> listResult = port.listeLignesSTR();
        List<Abonnement> list = new ArrayList<Abonnement>();
        for (Object o : listResult) {
            Abonnement a = (Abonnement) o;
            list.add(a);
        }
        return list;
    }

    protected void lignesSTR(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();
        //webservice.WebServiceSTR port2 = service.getWebServiceSTRPort();
        // TODO process result here
        port.invokeLigne();
        java.util.List<Object> result = port.listeLignesSTR();
        Collection<LigneSTR> coll = (Collection) result;
        request.setAttribute("collectionLignes", coll);
        request.setAttribute("message", "");
    }

    protected void listReductionsSTR(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();
        List<Object> listResult = port.afficherListeReductions();
        Collection<Reduction> lesReductions = new ArrayList<Reduction>();
        for (Object o : listResult) {
            Reduction r = (Reduction) o;
            lesReductions.add(r);
        }
        request.setAttribute("lesReductions", lesReductions);
    }

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
            
            sessionCommercial.CreerPorteMonnaieElectronique(carte);
        }

        request.setAttribute("message", message);
        List<Client> list = sessionCommercial.RetournerClients();
        request.setAttribute("listeclients", list);
    }

    protected void doActionAfficherModifClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("modif");
        Long idclient = Long.valueOf(c);

        Client client = sessionCommercial.RechercherClientParId(idclient);

        String message = "Modifier les informations du client N°" + client.getNumClient() + ", " + client.getPrenom() + " " + client.getNom();
        request.setAttribute("message", message);
        request.setAttribute("client", client);
    }

    protected void doActionModifierClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String c = request.getParameter("client");
        Long idclient = Long.valueOf(c);
        Client client = sessionCommercial.RechercherClientParId(idclient);

        String num = request.getParameter("num");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        if (num.trim().isEmpty()) {
            num = client.getNumClient();
        }
        if (nom.trim().isEmpty()) {
            nom = client.getNom();
        }
        if (prenom.trim().isEmpty()) {
            prenom = client.getPrenom();
        }

        sessionCommercial.ModifierClient(idclient, num, nom, prenom);

        String message = "<div class='msg_success'>Client modifié avec succès !</div>";
        request.setAttribute("message", message);

        List<Client> listc = sessionCommercial.RetournerClients();
        request.setAttribute("listeclients", listc);
    }

    protected void doActionAfficherGestionCompteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("client");
        Long idclient = Long.valueOf(c);

        Client client = sessionCommercial.RechercherClientParId(idclient);

        String message = "Informations bancaires du client N°" + client.getNumClient() + ", " + client.getPrenom() + " " + client.getNom();
        request.setAttribute("message", message);
        request.setAttribute("client", client);
    }

    protected void doActionAjouterCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("client");
        Long idclient = Long.valueOf(c);
        Client client = sessionCommercial.RechercherClientParId(idclient);

        String num = request.getParameter("num");
        String titulaire = request.getParameter("titulaire");
        String banque = request.getParameter("banque");
        String guichet = request.getParameter("guichet");

        String message;

        if (num.trim().isEmpty() || titulaire.trim().isEmpty() || banque.trim().isEmpty() || guichet.trim().isEmpty()) {
            message = "<div class='msg_error'>Erreur - Vous n'avez pas rempli tous les champs obligatoires.</div>";
        } else {
            int numcompte = Integer.parseInt(num);
            int numguichet = Integer.parseInt(guichet);

            sessionCommercial.CreerCompte(numcompte, titulaire, banque, numguichet, client);

            message = "<div class='msg_success'>Le compte est ajouté avec succès !</div>";
        }

        request.setAttribute("message", message);
        request.setAttribute("client", client);
    }

    protected void doActionAfficherModifCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpt = request.getParameter("compte");
        Long idcompte = Long.valueOf(cpt);
        String c = request.getParameter("client");
        Long idclient = Long.valueOf(c);

        CompteBancaire compte = sessionCommercial.RechercherCompteParId(idcompte);
        Client client = sessionCommercial.RechercherClientParId(idclient);

        String message = "Modifier les informations du compte N°" + compte.getNumCompte();
        request.setAttribute("message", message);
        request.setAttribute("compte", compte);
        request.setAttribute("client", client);
    }

    protected void doActionModifierCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpt = request.getParameter("compte");
        Long idcompte = Long.valueOf(cpt);
        CompteBancaire compte = sessionCommercial.RechercherCompteParId(idcompte);

        String cli = request.getParameter("client");
        Long idclient = Long.valueOf(cli);
        Client client = sessionCommercial.RechercherClientParId(idclient);

        String num = request.getParameter("num");
        String titulaire = request.getParameter("titulaire");
        String banque = request.getParameter("banque");
        String guichet = request.getParameter("guichet");

        if (num.trim().isEmpty()) {
            num = Integer.toString(compte.getNumCompte());
        }
        if (titulaire.trim().isEmpty()) {
            titulaire = compte.getTitulaire();
        }
        if (banque.trim().isEmpty()) {
            banque = compte.getNomBanque();
        }
        if (guichet.trim().isEmpty()) {
            guichet = Integer.toString(compte.getCodeGuichet());
        }

        sessionCommercial.ModifierCompte(idcompte, Integer.parseInt(num), titulaire, banque, Integer.parseInt(guichet));

        String message = "<div class='msg_success'>Compte modifié avec succès !</div>";
        request.setAttribute("message", message);

        request.setAttribute("client", client);
    }

    protected void doActionAfficherGestionAbonnementClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("client");
        Long idclient = Long.valueOf(c);

        Client client = sessionCommercial.RechercherClientParId(idclient);

        String message = "Abonnements du client N°" + client.getNumClient() + ", " + client.getPrenom() + " " + client.getNom();
        request.setAttribute("message", message);
        request.setAttribute("client", client);
    }

    protected void doActionAjouterAbonnement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("client");
        Long idclient = Long.valueOf(c);
        Client client = sessionCommercial.RechercherClientParId(idclient);
        
        String reseau = request.getParameter("reseau");
        String num = request.getParameter("num");
        String typeabo = request.getParameter("type");
        String ligne = request.getParameter("ligne");
        String depart = request.getParameter("depart");
        String arrivee = request.getParameter("arrivee");
        String message;

        if (reseau.trim().isEmpty() || num.trim().isEmpty() || typeabo.trim().isEmpty() || ligne.trim().isEmpty() || depart.trim().isEmpty() || arrivee.trim().isEmpty()) {
            message = "<div class='msg_error'>Erreur - Vous n'avez pas rempli tous les champs obligatoires.</div>";
        } else {
            Double montant = null;

            //Appel de la couche service: 
            //montant = MethodeRechercherTarif(String reseau, String typeabo, String ligne, String depart, String arrivee);
            //recherche de la ligne et des arrets de la ligne, récupère le tarif associé, recherche l'abonnement et applique le taux de réduction au tarif trouvé
            sessionCommercial.CreerAbonnement(num, typeabo, montant, client.getLaCarteAPuce());

            message = "<div class='msg_success'>L'abonnement est ajouté avec succès !</div>";
        }

        request.setAttribute("message", message);
        request.setAttribute("client", client);
    }

    protected void doActionChercherTrajet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String depart = request.getParameter("depart");
        String arrivee = request.getParameter("arrivee");

        /*
         //Appel de la couche service
        
         //Traitements de la couche service:
        
         //Trouver les arrêts STR à partir des Strings
         Arret a = RechercherArretParNom(String depart);
         Arret b = RechercherArretParNom(String arrivee);
        
         //Trouver les gares STF à partir des Strings
         Gare a = RechercherGareParNom(String depart);
         Gare b = RechercherGareParNom(String arrivee);
        
         //Trouver les lignes STR qui contiennent au moins 1 des 2 arrêts
         List<Ligne> lesLignesSTR = RechercherLignesParArrets(Arret a, Arret b);
         if (!lesLignesSTR.isempty()) {
         List<Ligne> lignesSTRDirectes = new ArrayList();
         for (Ligne l: lesLignesSTR) {
         if (l.getLesArrets().contains(a) && l.getLesArrets().contains(b)) {
         lignesSTRDirectes.add(l);
         }
         }
         }
        
         //Trouver les lignes STF qui contiennent au moins 1 des 2 gares
         List<Ligne> lesLignesSTF = RechercherLignesParArrets(Gare a, Gare b);
         if (!lesLignesSTF.isempty()) {
         List<Ligne> lignesSTFDirectes = new ArrayList();
         for (Ligne l: lesLignesSTF) {
         if (l.getLesGares().contains(a) && l.getLesGares().contains(b)) {
         lignesSTFDirectes.add(l);
         }
         }
         }
        
         //Si des lignes directes ont été trouvées (au moins une par réseau)
         if (!lignesSTRDirectes.isempty() && !lignesSTFDirectes.isempty()) {
         //Retourner une des lignes?
         }
        
         //Sinon si des lignes STR sont directes, on les retourne
         else if (!lignesSTRDirectes.isempty()) {
         return lignesSTRDirectes;
         }
        
         //Sinon si des lignes STF sont directes, on les retourne
         else if (!lignesSTFDirectes.isempty()) {
         return lignesSTFDirectes;
         }
        
         //Sinon (si aucune ligne directe n'est trouvée), on tri les lignes qui contiennent le départ, les lignes qui contiennent l'arrivée, et on cherche les arrêts communs entre ces lignes)
         else {
         List<Ligne> lesLignesSTRDepart = RechercherLignesParArretDepart(Arret a);
         List<Ligne> lesLignesSTFDepart = RechercherLignesParGareDepart(Gare a);
         List<Ligne> lesLignesSTRArrivee = RechercherLignesParArretArrivee(Arret b);
         List<Ligne> lesLignesSTFArrivee = RechercherLignesParGareArrivee(Gare b);
        
         Pour chaque ligne depart (STR puis STF), parcourir les lignes arrivee  et les lignes stf trouvées (si non null), et vérifier si elles contiennent 
         }
        
        
        
        
        
         */
        request.setAttribute("message", "message");

    }
}
