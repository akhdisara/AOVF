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
import packageEntites.Personne;
import packageEntites.Question;
import packageEntites.QuestionProposition;
import packageFacades.AbonneFacadeLocal;
import packageFacades.AbonnementFacadeLocal;
import packageFacades.CarteAPuceFacadeLocal;
import packageFacades.SousTrajetFacadeLocal;
import packageSessions.SessionCommercialLocal;
import packageSessions.SessionPersonneLocal;
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
    private SousTrajetFacadeLocal sousTrajetFacade;
    @EJB
    private AbonnementFacadeLocal abonnementFacade;
    @EJB
    private AbonneFacadeLocal abonneFacade;

    @EJB
    private CarteAPuceFacadeLocal carteAPuceFacade;

    @EJB
    private SessionPersonneLocal sessionPersonne;

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
            jspClient = "/index.jsp";
            //trajet("Lyon", "Macon");
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
        } else if (act.equals("GererAbonnementSTR")) {
            jspClient = "/AbonnementSTRGerer.jsp";
            doActionAfficherGestionAbonnementSTRClient(request, response);
        } else if (act.equals("AbonnementSTRAjouter")) {
            jspClient = "/AbonnementSTRGerer.jsp";
            doActionAjouterAbonnementSTR(request, response);
        } else if (act.equals("GererAbonnementSTF")) {
            jspClient = "/AbonnementSTFGerer.jsp";
            doActionAfficherGestionAbonnementSTFClient(request, response);
        } else if (act.equals("AbonnementSTFAjouter")) {
            jspClient = "/AbonnementSTFGerer.jsp";
            doActionAjouterAbonnementSTF(request, response);
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
        } else if (act.equals("AfficherQuestionnaire")) {
            jspClient = "/Questionnaire.jsp";
            List<Question> listQ = sessionPersonne.RetournerQuestion();
            request.setAttribute("listequestions", listQ);
            request.setAttribute("message", "");
            System.out.println("--" + listQ);
        } else if (act.equals("AjouterReponse")) {
            jspClient = "/Questionnaire.jsp";
            List<Question> listQ = sessionPersonne.RetournerQuestion();
            request.setAttribute("listequestions", listQ);
            request.setAttribute("message", "");
            doActionAjouterReponse(request, response);
        } else if (act.equals("rechercherTrajet")) {
            jspClient = "/resultatTrajet.jsp";
            doActionRechercherTrajet(request, response);
        } else if (act.equals("AvoirTitreTransport")) {
            jspClient = "/AvoirTitreTransport.jsp";
            AvoirTitreTransport(request, response);
        } else if (act.equals("NCarteEtTitreTransport")) {
            String checkbox = request.getParameter("checkbox");
            String carte = request.getParameter("carte");
            if (checkbox != null) {
                CarteAPuce c = carteAPuceFacade.RechercherCarteParId(Integer.parseInt(carte));
                if (c == null) {
                    jspClient = "/AvoirTitreTransport.jsp";
                    AvoirTitreTransport(request, response);
                    request.setAttribute("message", "N°Carte invalide!");
                } else {
                    jspClient = "/NCarteEtTitreTransport.jsp";
                    NCarteEtTitreTransport(request, response);
                }
            } else {
                jspClient = "/AvoirTitreTransport.jsp";
                AvoirTitreTransport(request, response);
                request.setAttribute("message", "Veuillez accepter les générales d'utilisation !");
            }
        }

        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
    }

    protected void NCarteEtTitreTransport(HttpServletRequest request, HttpServletResponse response) {
        String carte = request.getParameter("carte");
        String l1 = request.getParameter("l1");
        String l2 = request.getParameter("l2");
        String D = request.getParameter("D");
        String A = request.getParameter("A");
        String C = request.getParameter("C");
        String t1 = request.getParameter("t1");
        String t2 = request.getParameter("t2");
        System.out.println("-->" + carte);
        CarteAPuce c = carteAPuceFacade.RechercherCarteParId(Integer.parseInt(carte));
        System.out.println("-->" + c);
        if (c == null) {
            request.setAttribute("message", "Erreur Carte !!");
        } else {
            List<packageEntites.Abonnement> listeAbn = abonnementFacade.RecherheAbonnementParCarte(c);
            System.out.println("-->" + listeAbn);
            if (listeAbn.isEmpty()) {
                System.out.println("n'est pas Abonné");
                request.setAttribute("message", "Non abonné : Titre de transport enregistré");
                sousTrajetFacade.CreerSousTrajet(D, C, l1, Double.valueOf(t1));
                if (!l2.equals("")) {
                    sousTrajetFacade.CreerSousTrajet(C, A, l2, Double.valueOf(t2));
                }
            } else {
                System.out.println("Est Abonné");
                request.setAttribute("message", "Abonné : Titre de transport enregistré");
                sousTrajetFacade.CreerSousTrajet(D, C, l1, Double.valueOf(t1) * 0.15);
                if (!l2.equals("")) {
                    sousTrajetFacade.CreerSousTrajet(C, A, l2, Double.valueOf(t2) * 0.15);
                }
            }

        }

    }

    protected void AvoirTitreTransport(HttpServletRequest request, HttpServletResponse response) {
        String l1 = request.getParameter("l1");
        String l2 = request.getParameter("l2");
        String D = request.getParameter("D");
        String A = request.getParameter("A");
        String C = request.getParameter("C");
        String t1 = request.getParameter("t1");
        String t2 = request.getParameter("t2");
        //
        request.setAttribute("l1", l1);
        request.setAttribute("l2", l2);
        request.setAttribute("D", D);
        request.setAttribute("A", A);
        request.setAttribute("C", C);
        request.setAttribute("t1", t1);
        request.setAttribute("t2", t2);
        request.setAttribute("message", "");
    }

    protected void doActionRechercherTrajet(HttpServletRequest request, HttpServletResponse response) {
        String arretD = request.getParameter("depart");
        String arretF = request.getParameter("arrivee");
        // WS STR
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();

        //WS STF
        webservice.WebServiceSTF_Service serviceSTF = new webservice.WebServiceSTF_Service();
        webservice.WebServiceSTF portSTF = serviceSTF.getWebServiceSTFPort();
        //
        request.setAttribute("depart", arretD);
        request.setAttribute("arrivee", arretF);
        //
        Arret ArretFin = port.rechercheArretSTRParNom(arretF);
        Gare gareFin = portSTF.rechercherGareParNom(arretF);
        Arret Arretdebut = port.rechercheArretSTRParNom(arretD);
        Gare gareDebut = portSTF.rechercherGareParNom(arretD);
        //
        request.setAttribute("ligne1", "");
        request.setAttribute("ligne2", "");
        //Chercher si l'arret d'arrivée existe dans le reseau STR
        if (arretD.equals(arretF)) {
            request.setAttribute("message", "L'arrêt de départ et d'arrivée doivent être différentes !");
        } else if (ArretFin == null && gareFin == null) {
            request.setAttribute("message", "L'arrêt d'arrivée n'existe ni dans STR,ni dans STF.");
        } //Chercher si l'arret d'arrivée existe dans le reseau STR        
        else if (Arretdebut == null && gareDebut == null) {
            request.setAttribute("message", "L'arrêt de départ n'existe ni dans STR,ni dans STF.");
        } else {
            //
            request.setAttribute("message", "");
            //
            List<String> lignesAD = new ArrayList<String>();
            List<String> lignesAF = new ArrayList<String>();
            //Lignes STR pour arrêts de début
            List<PositionArretLigne> listSTRADResult = port.recherchePositionSTRParArret(Arretdebut);

            for (PositionArretLigne pos : listSTRADResult) {
                lignesAD.add(pos.getLigne().getIdentifiant());
            }

            //Lignes STR pour arrêts de fin
            List<PositionArretLigne> listSTRAFResult = port.recherchePositionSTRParArret(ArretFin);
            for (PositionArretLigne pos : listSTRAFResult) {
                lignesAF.add(pos.getLigne().getIdentifiant());
            }
            //Gares STF pour arrêts de début
            List<DistanceGare> listSTFADResult = portSTF.retournerDistanceGareParGare(gareDebut);
            System.out.println("--" + listSTFADResult);
            System.out.println("--" + gareDebut.getNomGare());
            for (DistanceGare pos : listSTFADResult) {
                lignesAD.add(String.valueOf(pos.getLaLigne().getNumLigne()));
            }

            //Gares STF pour arrêts de fin
            List<DistanceGare> listSTFAFResult = portSTF.retournerDistanceGareParGare(gareFin);
            for (DistanceGare pos : listSTFAFResult) {
                lignesAF.add(String.valueOf(pos.getLaLigne().getNumLigne()));
            }

            List<String> l3 = new ArrayList<String>(lignesAD);
            l3.retainAll(lignesAF);
            System.out.println("Ligne communes ---->" + l3);
            if (!l3.isEmpty()) {
                System.out.println(l3.get(0) + " Vous permet de faire trajet");
                request.setAttribute("ligne1", l3.get(0));
                LigneSTR lr = port.rechercheLigneSTRParIdentifiant(l3.get(0));
                if (lr != null) {
                    request.setAttribute("reseau1", "STR");
                    request.setAttribute("ligne1Depart", lr.getDebut().getNom());
                    request.setAttribute("ligne1Arrivee", lr.getFin().getNom());
                    System.out.println("-->" + lr.getId());
                    System.out.println("-->" + Arretdebut.getId());
                    System.out.println("-->" + ArretFin.getId());
                    double t = port.tarifBaseParArrets(lr, Arretdebut, ArretFin);
                    request.setAttribute("tarif1", String.valueOf(t));
                } else {
                    Ligne lf = portSTF.rechercherLigneSTFParNum(Integer.parseInt(l3.get(0)));
                    request.setAttribute("reseau1", "STF");
                    request.setAttribute("ligne1Depart", lf.getGareDepart().getNomGare());
                    request.setAttribute("ligne1Arrivee", lf.getGareArrivee().getNomGare());
                    double t = portSTF.retournerDistanceLigneGare(lf, gareDebut);
                    System.out.println("-->" + gareFin);
                    System.out.println("-->" + gareFin.getNomGare());
                    request.setAttribute("tarif1", String.valueOf(t * portSTF.getPrixilometre()));
                }
                request.setAttribute("depart1", arretD);
                request.setAttribute("arrivee1", arretF);
                request.setAttribute("ligne2", "");
                request.setAttribute("reseau2", "");
                request.setAttribute("ligne2Depart", "");
                request.setAttribute("ligne2Arrivee", "");
                request.setAttribute("depart2", "");
                request.setAttribute("arrivee2", "");
            } else {
                for (DistanceGare posD : listSTFADResult) {
                    System.out.println("**********" + posD.getLaLigne().getNumLigne());
                    List<DistanceGare> l1 = portSTF.retournerDistanceGareParLigne(posD.getLaLigne());
                    for (DistanceGare pos1 : l1) {
                        {
                            System.out.println("------>" + pos1.getLaGare().getNomGare());
                            for (DistanceGare posF : listSTFAFResult) {
                                List<DistanceGare> l2 = portSTF.retournerDistanceGareParLigne(posF.getLaLigne());
                                for (DistanceGare pos2 : l2) {
                                    System.out.println("-->" + pos2.getLaGare().getNomGare());
                                    if (pos1.getLaGare().getNomGare().equals(pos2.getLaGare().getNomGare())) {
                                        //System.out.println("Correspondance STF" + pos2.getLaGare().getNomGare());
                                        System.out.println(arretD + "-->" + pos2.getLaGare().getNomGare() + "::" + posD.getLaLigne().getNumLigne());
                                        request.setAttribute("ligne1", String.valueOf(posD.getLaLigne().getNumLigne()));
                                        request.setAttribute("reseau1", "STF");
                                        request.setAttribute("ligne1Depart", posD.getLaLigne().getGareDepart().getNomGare());
                                        request.setAttribute("ligne1Arrivee", posD.getLaLigne().getGareArrivee().getNomGare());
                                        request.setAttribute("depart1", arretD);
                                        request.setAttribute("arrivee1", pos2.getLaGare().getNomGare());
                                        double t1 = portSTF.retournerDistanceLigneGare(posD.getLaLigne(), gareDebut);
                                        request.setAttribute("tarif1", String.valueOf(t1 * portSTF.getPrixilometre()));
                                        System.out.println(pos2.getLaGare().getNomGare() + "-->" + arretF + "::" + pos2.getLaLigne().getNumLigne());
                                        request.setAttribute("ligne2", String.valueOf(pos2.getLaLigne().getNumLigne()));
                                        request.setAttribute("reseau2", "STF");
                                        request.setAttribute("ligne2Depart", pos2.getLaLigne().getGareDepart().getNomGare());
                                        request.setAttribute("ligne2Arrivee", pos2.getLaLigne().getGareArrivee().getNomGare());
                                        request.setAttribute("depart2", pos2.getLaGare().getNomGare());
                                        request.setAttribute("arrivee2", arretF);
                                        double t2 = portSTF.retournerDistanceLigneGare(pos2.getLaLigne(), pos2.getLaGare());
                                        request.setAttribute("tarif2", String.valueOf(t2 * portSTF.getPrixilometre()));
                                        return;
                                    }
                                }
                            }
                            for (PositionArretLigne posF : listSTRAFResult) {
                                List<PositionArretLigne> l2 = new ArrayList(port.recherchePositionParLigne(posF.getLigne()));
                                for (PositionArretLigne pos2 : l2) {
                                    System.out.println("-->" + pos2.getArret().getNom());
                                    if (pos1.getLaGare().getNomGare().equals(pos2.getArret().getNom())) {
                                        //System.out.println("Correspondance STR " + pos2.getArret().getNom());
                                        System.out.println(arretD + "-->" + pos2.getArret().getNom() + "::" + posD.getLaLigne().getNumLigne());
                                        request.setAttribute("ligne1", String.valueOf(posD.getLaLigne().getNumLigne()));
                                        request.setAttribute("reseau1", "STF");
                                        request.setAttribute("ligne1Depart", posD.getLaLigne().getGareDepart().getNomGare());
                                        request.setAttribute("ligne1Arrivee", posD.getLaLigne().getGareArrivee().getNomGare());
                                        request.setAttribute("depart1", arretD);
                                        request.setAttribute("arrivee1", pos2.getArret().getNom());
                                        double t1 = portSTF.retournerDistanceLigneGare(posD.getLaLigne(), gareDebut);
                                        request.setAttribute("tarif1", String.valueOf(t1 * portSTF.getPrixilometre()));
                                        System.out.println(pos2.getArret().getNom() + "-->" + arretF + "::" + pos2.getLigne().getIdentifiant());
                                        request.setAttribute("ligne2", pos2.getLigne().getIdentifiant());
                                        request.setAttribute("reseau2", "STR");
                                        request.setAttribute("ligne2Depart", pos2.getLigne().getDebut().getNom());
                                        request.setAttribute("ligne2Arrivee", pos2.getLigne().getFin().getNom());
                                        request.setAttribute("depart2", pos2.getArret().getNom());
                                        request.setAttribute("arrivee2", arretF);
                                        double t = port.tarifBaseParArrets(pos2.getLigne(), pos2.getArret(), ArretFin);
                                        request.setAttribute("tarif2", String.valueOf(t));
                                        return;
                                    }
                                }
                            }
                        }

                    }
                }

                for (PositionArretLigne posD : listSTRADResult) {
                    List<PositionArretLigne> l1 = new ArrayList(port.recherchePositionParLigne(posD.getLigne()));
                    System.out.println("**********" + posD.getLigne().getIdentifiant());
                    for (PositionArretLigne pos1 : l1) {
                        {
                            System.out.println("----->" + pos1.getArret().getNom());
                            for (PositionArretLigne posF : listSTRAFResult) {
                                List<PositionArretLigne> l2 = new ArrayList(port.recherchePositionParLigne(posF.getLigne()));
                                for (PositionArretLigne pos2 : l2) {
                                    System.out.println("-->" + pos2.getArret().getNom());
                                    if (pos1.getArret().getNom().equals(pos2.getArret().getNom())) {
                                        //System.out.println("Correspondance STR " + pos2.getArret().getNom());
                                        System.out.println(arretD + "-->" + pos2.getArret().getNom() + "::" + posD.getLigne().getIdentifiant());
                                        request.setAttribute("ligne1", posD.getLigne().getIdentifiant());
                                        request.setAttribute("reseau1", "STR");
                                        request.setAttribute("ligne1Depart", posD.getLigne().getDebut().getNom());
                                        request.setAttribute("ligne1Arrivee", posD.getLigne().getFin().getNom());
                                        request.setAttribute("depart1", arretD);
                                        request.setAttribute("arrivee1", pos2.getArret().getNom());
                                        double t1 = port.tarifBaseParArrets(posD.getLigne(), Arretdebut, pos2.getArret());
                                        request.setAttribute("tarif1", String.valueOf(t1));
                                        System.out.println(pos2.getArret().getNom() + "-->" + arretF + "::" + pos2.getLigne().getIdentifiant());
                                        request.setAttribute("ligne2", pos2.getLigne().getIdentifiant());
                                        request.setAttribute("reseau2", "STR");
                                        request.setAttribute("ligne2Depart", pos2.getLigne().getDebut().getNom());
                                        request.setAttribute("ligne2Arrivee", pos2.getLigne().getFin().getNom());
                                        request.setAttribute("depart2", pos2.getArret().getNom());
                                        request.setAttribute("arrivee2", arretF);
                                        double t2 = port.tarifBaseParArrets(pos2.getLigne(), pos2.getArret(), ArretFin);
                                        request.setAttribute("tarif2", String.valueOf(t2));
                                        return;
                                    }
                                }
                            }
                            for (DistanceGare posF : listSTFAFResult) {
                                List<DistanceGare> l2 = portSTF.retournerDistanceGareParLigne(posF.getLaLigne());
                                for (DistanceGare pos2 : l2) {
                                    System.out.println("-->" + pos2.getLaGare().getNomGare());
                                    if (pos1.getArret().getNom().equals(pos2.getLaGare().getNomGare())) {
                                        //System.out.println("Correspondance STF " + pos2.getLaGare().getNomGare());
                                        System.out.println(arretD + "-->" + pos2.getLaGare().getNomGare() + "::" + posD.getLigne().getIdentifiant());
                                        request.setAttribute("ligne1", posD.getLigne().getIdentifiant());
                                        request.setAttribute("reseau1", "STR");
                                        request.setAttribute("ligne1Depart", posD.getLigne().getDebut().getNom());
                                        request.setAttribute("ligne1Arrivee", posD.getLigne().getFin().getNom());
                                        request.setAttribute("depart1", arretD);
                                        request.setAttribute("arrivee1", pos2.getLaGare().getNomGare());
                                        double t1 = port.tarifBaseParArrets(posD.getLigne(), Arretdebut, pos1.getArret());
                                        request.setAttribute("tarif1", String.valueOf(t1));
                                        System.out.println(pos2.getLaGare().getNomGare() + "-->" + arretF + "::" + pos2.getLaLigne().getNumLigne());
                                        request.setAttribute("ligne2", String.valueOf(pos2.getLaLigne().getNumLigne()));
                                        request.setAttribute("reseau2", "STF");
                                        request.setAttribute("ligne2Depart", pos2.getLaLigne().getGareDepart().getNomGare());
                                        request.setAttribute("ligne2Arrivee", pos2.getLaLigne().getGareArrivee().getNomGare());
                                        request.setAttribute("depart2", pos2.getLaGare().getNomGare());
                                        request.setAttribute("arrivee2", arretF);
                                        double t2 = portSTF.retournerDistanceLigneGare(pos2.getLaLigne(), pos2.getLaGare());
                                        request.setAttribute("tarif2", String.valueOf(t2 * portSTF.getPrixilometre()));
                                        return;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

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

        request.setAttribute("ligne", ligne);

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
        if (ligne != null) {
            coll.add(ligne);
            request.setAttribute("message", "Résultat de votre recherche :");
        } else {
            request.setAttribute("message", "Aucune ligne trouvée !");
        }
        request.setAttribute("collectionLignes", coll);
    }

    protected void RechercherLigneSTF(HttpServletRequest request, HttpServletResponse response) {

        try {
            String numLigne = request.getParameter("NumLigne");
            webservice.WebServiceSTF_Service service = new webservice.WebServiceSTF_Service();
            webservice.WebServiceSTF port = service.getWebServiceSTFPort();
            Ligne ligne = port.rechercherLigneSTFParNum(Integer.parseInt(numLigne));
            List<Ligne> list = new ArrayList<Ligne>();
            if (ligne != null) {
                request.setAttribute("message", "Résultat de votre recherche :");
                list.add(ligne);
            } else {
                request.setAttribute("message", "Aucune ligne trouvée !");
            }
            request.setAttribute("listelignes", list);
        } catch (NumberFormatException e) {
            request.setAttribute("listelignes", new ArrayList<Ligne>());
            request.setAttribute("message", "Numéro de la ligne doit d'être numérique");
        }
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

    private List<Reduction> retournerAbonnementsSTR() {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();
        List<Object> listResult = port.afficherListeReductions();
        List<Reduction> list = new ArrayList<Reduction>();
        for (Object o : listResult) {
            Reduction r = (Reduction) o;
            list.add(r);
        }
        return list;
    }

    protected void lignesSTR(HttpServletRequest request, HttpServletResponse response) {
        webservice.WebServiceSTR service = new webservice.WebServiceSTR();
        webservice.WebServicesSTR port = service.getWebServicesSTRPort();
        port.invokeLigne();
        java.util.List<Object> result = port.listeLignesSTR();
        Collection<LigneSTR> coll = (Collection) result;
        request.setAttribute("collectionLignes", coll);
        request.setAttribute("message", "Lignes STR");
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

    protected void doActionAfficherGestionAbonnementSTRClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("client");
        Long idclient = Long.valueOf(c);

        Client client = sessionCommercial.RechercherClientParId(idclient);

        String message = "Abonnements du client N°" + client.getNumClient() + ", " + client.getPrenom() + " " + client.getNom();
        request.setAttribute("message", message);
        request.setAttribute("client", client);
    }

    protected void doActionAjouterAbonnementSTR(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void doActionAfficherGestionAbonnementSTFClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("client");
        Long idclient = Long.valueOf(c);

        Client client = sessionCommercial.RechercherClientParId(idclient);

        String message = "Abonnements du client N°" + client.getNumClient() + ", " + client.getPrenom() + " " + client.getNom();
        request.setAttribute("message", message);
        request.setAttribute("client", client);
    }

    protected void doActionAjouterAbonnementSTF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    private void trajet(String arretD, String arretF) {

    }

    protected void doActionAjouterReponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message;

        List<Question> questions = sessionPersonne.RetournerQuestion();
        for (Question q : questions) {
            String pId = request.getParameter(q.getId().toString());
            if (pId != null) {
                QuestionProposition p = sessionPersonne.RechercherPropositionParId(Integer.parseInt(pId));
                sessionPersonne.AjouterReponse(p);
            }

        }

    }
}
