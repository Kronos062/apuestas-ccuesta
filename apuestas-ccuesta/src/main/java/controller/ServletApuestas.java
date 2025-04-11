/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import service.ApuestasService;
import Apuestas.Apuestas;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletApuestas", urlPatterns = {"/ServletApuestas"})
public class ServletApuestas extends HttpServlet {

    private ApuestasService service = new ApuestasService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if(session.getAttribute("apuestas") == null) {
            session.setAttribute("apuestas", service.getAllApuestas());
        }

        switch(action) {
            case "prepareUpdate":
                int index = Integer.parseInt(request.getParameter("index"));
                Apuestas apuesta = service.getApuesta(index);
                
                if(apuesta != null) {
                    request.setAttribute("apuestaEditar", apuesta);
                    request.setAttribute("indiceEditar", index);
                    request.getRequestDispatcher("modificar.jsp").forward(request, response);
                    return;
                }
                break;
                
            case "filter":
                String filtro = request.getParameter("filtroNombre");
                List<Apuestas> filtradas = service.filtrarApuestas(filtro);
                session.setAttribute("apuestasFiltradas", filtradas);
                break;
                
            case "nuevaApuesta":
                request.getRequestDispatcher("formulario.jsp").forward(request, response);
                return;
        }
        
        response.sendRedirect("listaApuestas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        switch(action) {
            case "add":
                Apuestas nueva = new Apuestas(
                    request.getParameter("nombre"),
                    request.getParameter("equipos"),
                    Double.parseDouble(request.getParameter("resultado")),
                    request.getParameter("fecha"),
                    Double.parseDouble(request.getParameter("dinero"))
                );
                service.addApuesta(nueva);
                break;
                
            case "delete":
                int indexDelete = Integer.parseInt(request.getParameter("index"));
                service.deleteApuesta(indexDelete);
                break;
                
            case "update":
                int indexUpdate = Integer.parseInt(request.getParameter("index"));
                Apuestas modificada = new Apuestas(
                    request.getParameter("nombre"),
                    request.getParameter("equipos"),
                    Double.parseDouble(request.getParameter("resultado")),
                    request.getParameter("fecha"),
                    Double.parseDouble(request.getParameter("dinero"))
                );
                service.modifyApuesta(indexUpdate, modificada);
                break;
        }
        
        session.setAttribute("apuestas", service.getAllApuestas());
        session.removeAttribute("apuestasFiltradas");
        
        response.sendRedirect("listaApuestas.jsp");
    }
}
