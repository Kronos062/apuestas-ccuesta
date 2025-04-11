/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Apuestas.Apuestas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletApuestas", urlPatterns = {"/ServletApuestas"})
public class ServletApuestas extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        List<Apuestas> apuestas = (List<Apuestas>) session.getAttribute("apuestas");
        if (apuestas == null) {
            apuestas = new ArrayList<>();
            session.setAttribute("apuestas", apuestas);
        }

        if ("add".equals(action)) {
            String nombre = request.getParameter("nombre");
            String equipos = request.getParameter("equipos");
            double dinero = Double.parseDouble(request.getParameter("dinero"));
            String fecha = request.getParameter("fecha");
            String resultado = request.getParameter("resultado");

            Apuestas apuesta = new Apuestas(nombre, equipos, dinero, fecha, resultado);
            apuestas.add(apuesta);
            
            response.sendRedirect(request.getContextPath() + "/listaApuestas.jsp");
        } 
        else if ("delete".equals(action)) {
            int index = Integer.parseInt(request.getParameter("index"));
            if (index >= 0 && index < apuestas.size()) {
                apuestas.remove(index);
            }
            response.sendRedirect(request.getContextPath() + "/listaApuestas.jsp");
        } 
        else if ("modify".equals(action)) {
            int index = Integer.parseInt(request.getParameter("index"));
            if (index >= 0 && index < apuestas.size()) {
                String nombre = request.getParameter("nombre");
                String equipos = request.getParameter("equipos");
                double dinero = Double.parseDouble(request.getParameter("dinero"));
                String fecha = request.getParameter("fecha");
                String resultado = request.getParameter("resultado");

                Apuestas apuesta = apuestas.get(index);
                apuesta.setNombre(nombre);
                apuesta.setEquipos(equipos);
                apuesta.setDinero(dinero);
                apuesta.setFecha(fecha);
                apuesta.setResultado(resultado);
            }
            response.sendRedirect(request.getContextPath() + "/listaApuestas.jsp");
        }
    }
}
